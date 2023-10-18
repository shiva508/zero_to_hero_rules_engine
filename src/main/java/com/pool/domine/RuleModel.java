package com.pool.domine;

import com.pool.entity.RuleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleModel implements Serializable {
    private Long ruleId;
    private String ruleTitle;
    private String propertyName;
    private String condition;
    private String value;
    private String ruleModelName;


    public RuleModel(String ruleTitle, String propertyName, String condition, String value, String ruleModelName) {
        this.ruleTitle = ruleTitle;
        this.propertyName = propertyName;
        this.condition = condition;
        this.value = value;
        this.ruleModelName = ruleModelName;
    }

    public RuleModel(RuleEntity ruleEntity){
        this.ruleTitle = ruleEntity.getRuleTitle();
        this.propertyName = ruleEntity.getPropertyName();
        this.condition = ruleEntity.getCondition();
        this.value = ruleEntity.getValue();
        this.ruleModelName = ruleEntity.getRuleModelName();
    }
}
