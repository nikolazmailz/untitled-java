package ru.check.delete.comparison;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ComparisonHelper {

    @JsonProperty("filter")
    public List<Comparison> matches;
}
