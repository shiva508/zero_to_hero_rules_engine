package com.pool.domine;

import org.kie.api.command.Command;

import java.io.Serializable;

public class RuleResult implements Serializable {
    private String outPut;

    public RuleResult() {
    }

    public String getOutPut() {
        return outPut;
    }

    public void setOutPut(String outPut) {
        this.outPut = outPut;
    }
}
