package com.ruleEngine.drools;

import lombok.Data;

import java.util.UUID;
@Data
public class EntityRule {
    private String username;
    private boolean account;
    private int addtime;
    private double currentmoney;
    private double totailaddmoney;

    public void getSerialnumber(String username, double currentmoney) {
        System.out.println("Account：" + username + " Balance：￥" + currentmoney);
        System.out.println("Serial Number：" + UUID.randomUUID().toString());
    }

}
