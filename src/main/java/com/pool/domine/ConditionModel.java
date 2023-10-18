package com.pool.domine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConditionModel implements Serializable {
    private Long conditionId;
    private String ruleTitle;
    private String propertyName;
    private String condition;
}
