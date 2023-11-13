package ru.check.delete.comparison;

import java.util.List;

public class Matchers extends Comparison {

    public static String name = "matchers";

    public String key;
    public List<String> value;
    public String currentValue;
    public Boolean passesCondition = null;

    Matchers(String k, List<String> v) {
        key = k;
        value = v;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    private void setPassesCondition() {
        if(currentValue == null) throw new RuntimeException("");
        this.passesCondition = value.contains(currentValue);
    }


    @Override
    public boolean passesCondition() {
        if (passesCondition == null) setPassesCondition();
        return passesCondition;
    }

    public void setCurrentValue(Object v) {
        currentValue = (String) v;
    }
}
