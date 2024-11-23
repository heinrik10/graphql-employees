package br.com.otavio.graphql.model;

import java.util.List;

import br.com.otavio.graphql.enums.Gender;

public class Person {
    private String id;
    private String name;
    private Integer age;
    private Gender gender;
    private List<Person> friends;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public List<Person> getFriends() {
        return friends;
    }
    public void setFriends(List<Person> friends) {
        this.friends = friends;
    } 
}