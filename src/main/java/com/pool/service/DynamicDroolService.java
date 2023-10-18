package com.pool.service;

import com.pool.configuration.DroolConfiguration;
import com.pool.domine.Branch;
import com.pool.domine.RuleModel;
import com.pool.domine.RuleResult;
import com.pool.repository.RuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.builder.Message;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class DynamicDroolService {

    @Autowired
    private RuleRepository ruleRepository;
    @Autowired
    private RuleService ruleService;
    @Autowired
    private DroolConfiguration droolConfiguration;

    public RuleResult dynamicDroolProcessor(Branch branch){
        var ruleResult = new RuleResult();
        var stringBuilder = new StringBuilder();
        try {
            var inputStream = ResourceFactory.newClassPathResource(droolConfiguration.getTemplate()).getInputStream();
            var ruleModels = ruleService.getAll().stream().map(RuleModel::new).toList();
            var rulesDataCompiler = new ObjectDataCompiler();
            var branchRule = rulesDataCompiler.compile(ruleModels,inputStream);
            stringBuilder.append(branchRule);
        } catch (IOException e) {
            log.error("Error {}",e.getMessage());
            throw new RuntimeException(e);
        }
        var kieSession = kieSessionBuilder(stringBuilder.toString());
        kieSession.insert(branch);
        kieSession.getGlobals().set(droolConfiguration.getDroolDomineName(), ruleResult);
        kieSession.fireAllRules();
        return ruleResult;
    }

    public KieSession kieSessionBuilder(String drl){
        var kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        var results = kieHelper.verify();
        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            var errorMessages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            errorMessages.forEach(message -> System.out.println(message.getText()));
            throw new RuntimeException("Drl has issue");
        }
        return kieHelper.build().newKieSession();
    }
}
