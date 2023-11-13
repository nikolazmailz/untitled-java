package ru.check.delete.comparison;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MatchHelper {

    @JsonProperty("match")
    public List<Comparison> matches;

}
