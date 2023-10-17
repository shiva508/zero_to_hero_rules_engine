package com.pool.service;

import com.pool.domine.RuleModel;
import com.pool.entity.RuleEntity;
import org.springframework.stereotype.Component;

import java.util.List;


public interface RuleService {
    public RuleEntity save(RuleModel ruleModel);

    public RuleEntity update(RuleModel ruleModel);

    public RuleEntity delete(RuleModel ruleModel);

    public List<RuleEntity> getAll();
}
