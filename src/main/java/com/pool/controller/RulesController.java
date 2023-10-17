package com.pool.controller;

import com.pool.domine.RuleModel;
import com.pool.domine.RuleResult;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pool.domine.Branch;
import com.pool.domine.Person;
import com.pool.service.StudentpoolDroolsService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@RestController
public class RulesController {

	@Autowired
	private StudentpoolDroolsService studentpoolDroolsService;

	@PostMapping("executeReles")
	public Branch executeRules(@RequestBody Branch branch) {

		return studentpoolDroolsService.executeDroolsRules(branch);
	}
	
	@PostMapping("/executepersonrule")
	public Person executePersonRules(@RequestBody Person person) {
		return studentpoolDroolsService.executePersonDroolsService(person);
	}

	@GetMapping("/dadaddad")
	public String getDrlFile(){
		var data = ResourceFactory.newClassPathResource("rools/dhilsuknagar.drl");

		try {
		var out = data.getInputStream().readAllBytes();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return getDrlNew();
	}

	public String getDrlNew(){
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
		RuleResult ruleResult = new RuleResult();
		Branch branch = new Branch();
		branch.setBranchName("HYD");
		kieSession.insert(branch);
		kieSession.getGlobals().set("ruleResult", ruleResult);
		kieSession.fireAllRules();
		System.out.println("OOOOOOOOOO: "+ruleResult.getOutPut());
		return stringBuilder.toString();
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
