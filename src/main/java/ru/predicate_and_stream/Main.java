package ru.predicate_and_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Group> groups = new ArrayList<>();

        groups.add(new Group("asd", "desc"));
        groups.add(new Group("xasd", "desc1"));
        groups.add(new Group("xa2d", "desc2"));

        User user = new User("username", 22, groups);


        List<Group> groups2 = new ArrayList<>();

        groups2.add(new Group("asd", "desc"));
        groups2.add(new Group("asd", "desc1"));
        groups2.add(new Group("a2d", "desc2"));

        User user2 = new User("username2", 22, groups2);


        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

        executeSort(users);

    }

    public static void executeSort(List<User> list){

        Predicate<Group> groupPredicate = g -> !g.getName().startsWith("x");

        List<User> l2 = list.stream().filter(u -> u.getGroups().stream().anyMatch(groupPredicate)).toList();

        System.out.println(l2);

    }

}


class User {

    private String username;
    private Integer age;
    private List<Group> groups;

    public User(String username, Integer age, List<Group> groups) {
        this.username = username;
        this.age = age;
        this.groups = groups;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

}

class Group {
    private String name;
    private String description;

    public Group(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}