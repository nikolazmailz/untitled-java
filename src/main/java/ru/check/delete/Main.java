package ru.check.delete;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.check.delete.comparison.Comparison;
//import ru.check.delete.comparison.ComparisonFactory;
import ru.check.delete.comparison.ComparisonFactory;
import ru.check.delete.comparison.Composite;
import ru.check.delete.comparison.Match;
import ru.check.delete.comparison.MatchHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
        String json = getStringJson("./json/json2.json");

//        Composite composite = objectMapper.readValue(json, Composite.class);
//        System.out.println(composite);

        MatchHelper match  = objectMapper.readValue(getStringJson("./json/json.json"), MatchHelper.class);
        System.out.println(match);

        JsonNode jsonNode = objectMapper.readTree(json);
        JsonNode filter = jsonNode.get("filter");

        System.out.println(filter);

        List<Comparison> comparisonList = new LinkedList<>();

        Map<String, String> m2 = new LinkedHashMap<>();
        m2.put("sad", "asd");

        for (int i = 0; i < filter.size(); i++) {
            Map.Entry<String, JsonNode> e = filter.get(i).fields().next();
            System.out.println(e.getKey());
            System.out.println(e.getValue());

            comparisonList.add(ComparisonFactory.create(
                    e.getKey(), e.getValue().get("key").asText(), e.getValue().get("value")
            ));
        }

        System.out.println(comparisonList);

        Map<String, String> m = new HashMap<>();
        m.put("category", "60");
        m.put("scoring", "300");


        Stack<String> stack = new Stack<>();

        comparisonList.iterator();

//       for (Comparison c : comparisonList) {
//           c.setCurrentValue(m.get(c.getKey()));
//       }

        for (Comparison c : comparisonList) {
            System.out.println(c.passesCondition());
        }

        System.out.println(comparisonList);

    }


    public static String getStringJson(String path) {
        StringBuilder json = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream(path)),
                            StandardCharsets.UTF_8));
            String str;
            while ((str = in.readLine()) != null)
                json.append(str);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Caught exception reading resource " + "/json/json.json ", e);
        }
        return json.toString();
    }

}
