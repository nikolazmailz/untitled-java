package ru.check.delete.comparison;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Comparison {

    @JsonProperty("key")
    public String key;
    @JsonProperty("value")
    public Object value;

    public boolean passesCondition(){
        return false;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey(){
        return key;
    }

    public void setValue(Object v){
        value = v;
    }

    public Object getValue() {
        return value;
    }
}
