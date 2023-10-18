package com.pool.service.condition;

import com.pool.domine.ConditionModel;
import com.pool.domine.RuleModel;
import com.pool.entity.ConditionEntity;
import com.pool.entity.RuleEntity;

import java.util.List;

public interface ConditionService {
    public ConditionEntity save(ConditionModel conditionModel);

    public ConditionEntity update(ConditionModel conditionModel);

    public ConditionEntity delete(ConditionModel conditionModel);

    public List<ConditionEntity> getAll();
}
