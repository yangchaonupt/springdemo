package com.ruleEngine.drools;

import java.io.IOException;

/**
 * 首先要分析自己的业务逻辑，根据业务而制定出不同的规则，这里我们假设有3个规则。
 * 对于新开户的手机用户送20元话费。
 * 在2014年10月到12期间充值的用户，不论金额多少充值满3次就赠送5元话费。
 * 当月充值金额达到100以上，每达到一次赠送话费10元。
 */
public class DroolsTest {
    public static void main(String[] args) throws IOException {
        RuleEngine engineImpl = new RuleEngineImpl();
        engineImpl.init();
        final EntityRule entityRule = new EntityRule();
        entityRule.setCurrentMoney(350d);
        entityRule.setUserName("Candy");
        entityRule.setAccount(true);
        entityRule.setTotalAddMoney(350d);
        entityRule.setAddTime(7);
        engineImpl.execute(entityRule);
    }
}
