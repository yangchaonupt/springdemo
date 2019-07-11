package com.ruleEngine.drools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.drools.RuleBase;
import org.drools.StatefulSession;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.rule.Package;
import org.drools.spi.Activation;

public class RuleEngineImpl implements RuleEngine {
    private RuleBase ruleBase;
    @Override
    public void init() {
        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm:ss");
        ruleBase =SingleRuleFactory.getRuleBase();
        try {
            PackageBuilder backageBuilder = getPackageBuilderFile();
            ruleBase.addPackages(backageBuilder.getPackages());
        } catch (DroolsParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void refresh() {
        ruleBase = SingleRuleFactory.getRuleBase();
        Package[] packages = ruleBase.getPackages();
        for(Package items :packages){
            ruleBase.removePackage(items.getName());
        }
        init();
    }
    @Override
    public void execute(final EntityRule entityRule) {
        if(null == ruleBase.getPackages() || 0 == ruleBase.getPackages().length) {
            return;
        }
        StatefulSession statefulSession = ruleBase.newStatefulSession();
        statefulSession.insert(entityRule);
        statefulSession.fireAllRules(new org.drools.spi.AgendaFilter() {
            @Override
            public boolean accept(Activation activation) {
                return !activation.getRule().getName().
                        contains("_test");
            }
        });
        statefulSession.dispose();
    }
    private PackageBuilder getPackageBuilderFile()throws Exception {
        List<String> drlFilePath = getRuleFile();
        List<Reader> readers = loadRuleFile(drlFilePath);
        PackageBuilder backageBuilder = new PackageBuilder();
        for (Reader r : readers) {
            backageBuilder.addPackageFromDrl(r);
        }
        if(backageBuilder.hasErrors()) {
            throw new Exception(backageBuilder.getErrors().toString());
        }
        return backageBuilder;
    }
    private List<Reader> loadRuleFile(List<String> drlFilePath)throws FileNotFoundException {
        if (null == drlFilePath || 0 == drlFilePath.size()) {
            return null;
        }
        List<Reader> readers = new ArrayList<Reader>();
        for (String ruleFilePath : drlFilePath) {
            readers.add(new FileReader(new File(ruleFilePath)));
        }
        return readers;
    }
    private List<String> getRuleFile(){
        List<String> drlFilePath = new ArrayList<String>();
        String path="                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             C:\\self\\springdemo\\src\\main\\resources\\rules\\drools_rule.drl";
        drlFilePath.add(path);
        return drlFilePath;
    }
}
