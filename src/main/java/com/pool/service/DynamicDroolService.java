package com.pool.service;

import com.pool.domine.Branch;
import com.pool.domine.RuleModel;
import com.pool.domine.RuleResult;
import com.pool.repository.RuleRepository;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class DynamicDroolService {

    @Autowired
    private RuleRepository ruleRepository;

    public RuleResult dynamicDroolProcessor(Branch branch){
        RuleResult ruleResult = new RuleResult();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = ResourceFactory.newClassPathResource("rools/route.drl").getInputStream();
            List<RuleModel> ruleModels = List.of(new RuleModel("Hyderabad to Suryapet", "branchName", "==", "HYD",Branch.class.getName()));
            ObjectDataCompiler rulesDataCompiler = new ObjectDataCompiler();
            var branchRule = rulesDataCompiler.compile(ruleModels,inputStream);
            stringBuilder.append(branchRule);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        KieSession kieSession = kieSessionBuilder(stringBuilder.toString());
        kieSession.insert(branch);
        kieSession.getGlobals().set("ruleResult", ruleResult);
        kieSession.fireAllRules();
        return ruleResult;
    }

    public KieSession kieSessionBuilder(String drl){
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        Results results = kieHelper.verify();
        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> errorMessages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            errorMessages.forEach(message -> {
                System.out.println(message.getText());
            });
            throw new RuntimeException("Drl has issue");
        }
        return kieHelper.build().newKieSession();
    }
}
