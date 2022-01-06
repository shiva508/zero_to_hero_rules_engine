package com.pool.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pool.domine.Branch;

@Component
public class StudentpoolDroolsService {
	@Autowired
	private KieContainer kieContainer;

	public Branch executeDroolsRules(Branch branch) {
		KieSession kieSession = null;
		try {
			kieSession = kieContainer.newKieSession("dlsnrRuleVerificationSession");
			kieSession.insert(branch);
			kieSession.fireAllRules();
		} catch (Exception e) {
		} finally {
			if (kieSession != null) {
				kieSession.dispose();
			}
		}

		return branch;
	}
}
