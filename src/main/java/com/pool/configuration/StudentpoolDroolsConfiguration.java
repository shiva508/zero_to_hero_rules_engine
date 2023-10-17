package com.pool.configuration;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentpoolDroolsConfiguration {
	@Bean(name = "kieContainer")
	public KieContainer kieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}

	@Bean(name = "dynamicKieContainer")
	public KieContainer dynamicKieContainer() {

		return KieServices.Factory.get().getKieClasspathContainer();
	}
}
