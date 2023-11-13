package ru.check.delete.comparison;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.util.ArrayList;
import java.util.List;

public class ComparisonFactory {

    public static Comparison create(String nameComparison, String key, Object value) {
        Comparison comparison = null;
        switch (nameComparison) {
            case "match" -> comparison = new Match(key, ((TextNode) value).textValue());
            case "matchers" -> comparison = new Matchers(key, createMatchers((JsonNode) value));
            case "lessOrEquals" -> comparison = new LessOrEquals(key, ((TextNode) value).asInt());
            default -> {
            }
        }

        return comparison;
    }

    private static List<String> createMatchers(JsonNode value) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < value.size(); i++) {
            list.add(value.get(i).asText());
        }
        return list;
    }
}
