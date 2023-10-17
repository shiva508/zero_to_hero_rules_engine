package com.pool.service;

import com.pool.domine.RuleModel;
import com.pool.entity.RuleEntity;
import com.pool.repository.RuleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService{
    @Autowired
    private RuleRepository ruleRepository;

    @Override
    public RuleEntity save(RuleModel ruleModel) {
        RuleEntity ruleEntity = new RuleEntity();
        BeanUtils.copyProperties(ruleModel,ruleEntity);
        return ruleRepository.save(ruleEntity);
    }

    @Override
    public RuleEntity update(RuleModel ruleModel) {
        RuleEntity ruleEntity = new RuleEntity();
        BeanUtils.copyProperties(ruleModel,ruleEntity);
        return ruleRepository.save(ruleEntity);
    }

    @Override
    public RuleEntity delete(RuleModel ruleModel) {
        return null;
    }

    @Override
    public List<RuleEntity> getAll() {
        return ruleRepository.findAll();
    }
}
