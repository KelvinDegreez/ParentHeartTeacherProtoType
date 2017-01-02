package com.kelvindegrez.parentheartteacher.objects;


import java.util.List;
import java.util.Map;

public class Teacher {

    String firstName;
    String lastName;
    int age;
    String phoneNumber;
    String email;
    double sesesionRate;
    List<Subject> subjectExpertise;
    Map<Rating, Integer> ratings;
    List<String> reviews;
}