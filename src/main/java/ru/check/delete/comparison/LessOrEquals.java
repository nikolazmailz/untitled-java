package ru.check.delete.comparison;

public class LessOrEquals extends Comparison{

    public static String name = "lessOrEquals";

    public String key;
    public Integer value;
    public Integer currentValue;

    LessOrEquals(String k, Integer v){
        key = k;
        value = v;
    }

    @Override
    public boolean passesCondition() {
        if(currentValue == null) throw new RuntimeException("");
        return value <= currentValue;
    }

    @Override
    public String getKey() {
        return key;
    }

    public void setCurrentValue(Object v) {
        currentValue =  Integer.valueOf(String.valueOf(v));
    }
}
