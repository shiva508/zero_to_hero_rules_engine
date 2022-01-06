package com.pool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pool.domine.Branch;
import com.pool.service.StudentpoolDroolsService;

@RestController
public class RulesController {

	@Autowired
	private StudentpoolDroolsService studentpoolDroolsService;

	@PostMapping("executeReles")
	public Branch executeRules(@RequestBody Branch branch) {
		return studentpoolDroolsService.executeDroolsRules(branch);
	}
}
