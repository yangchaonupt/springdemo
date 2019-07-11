package com.ruleEngine.drools;

import lombok.Data;

import java.util.UUID;

@Data
public class EntityRule {
    private String userName;
    private boolean account;
    private int addTime;
    private double currentMoney;
    private double totalAddMoney;

    public void getSerialnumber(String username, double currentmoney) {
        System.out.println("Account：" + username + " Balance：￥" + currentmoney);
        System.out.println("Serial Number：" + UUID.randomUUID().toString());
    }

}
