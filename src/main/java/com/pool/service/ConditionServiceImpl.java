package com.pool.service;

import com.pool.domine.ConditionModel;
import com.pool.entity.ConditionEntity;
import com.pool.repository.ConditionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ConditionServiceImpl implements ConditionService{

    @Autowired
    private ConditionRepository conditionRepository;
    @Override
    public ConditionEntity save(ConditionModel conditionModel) {
        ConditionEntity conditionEntity = new ConditionEntity();
        BeanUtils.copyProperties(conditionModel,conditionEntity);
        return conditionRepository.save(conditionEntity);
    }

    @Override
    public ConditionEntity update(ConditionModel conditionModel) {
        ConditionEntity conditionEntity = new ConditionEntity();
        BeanUtils.copyProperties(conditionModel,conditionEntity);
        return conditionRepository.save(conditionEntity);
    }

    @Override
    public ConditionEntity delete(ConditionModel conditionModel) {

        return null;
    }

    @Override
    public List<ConditionEntity> getAll() {
        return conditionRepository.findAll();
    }
}
