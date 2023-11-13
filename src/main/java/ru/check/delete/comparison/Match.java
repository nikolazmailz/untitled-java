package ru.check.delete.comparison;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonProperty("match")
public class Match extends Comparison {

    public String name = "match";

    @JsonIgnore
    public String currentValue = null;

//    Match(String k, String v) {
//        key = k;
//        value = v;
//    }


    @Override
    public boolean passesCondition() {
        if (currentValue == null) throw new RuntimeException("");
        return Objects.equals(value, currentValue);
    }

    public void setCurrentValue(Object v) {
        currentValue = (String) v;
    }
}
