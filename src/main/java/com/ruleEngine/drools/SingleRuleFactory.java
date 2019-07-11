package com.ruleEngine.drools;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;

public class SingleRuleFactory {
    private static RuleBase ruleBase;

    public static RuleBase getRuleBase() {
        return null != ruleBase ? ruleBase : RuleBaseFactory.newRuleBase();
    }
}
