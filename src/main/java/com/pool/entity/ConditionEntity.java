package com.pool.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "CONDITIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConditionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONDITION_ID")
    private Long conditionId;

    @Column(name = "RULE_TITLE")
    private String ruleTitle;

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    @Column(name = "CONDITION")
    private String condition;

}
