package com.ruleEngine.drools;

public interface RuleEngine {
    public void init();
    public void refresh();
    public void execute(final EntityRule entityRule);
}
