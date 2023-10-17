package com.pool.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "RULES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RULE_ID")
    private Long ruleId;

    @Column(name = "RULE_TITLE")
    private String ruleTitle;

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    @Column(name = "CONDITION")
    private String condition;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "RULE_MODEL_NAME")
    private String ruleModelName;
}
