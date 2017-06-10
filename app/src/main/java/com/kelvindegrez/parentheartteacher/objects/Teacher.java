package com.kelvindegrez.parentheartteacher.objects;


import java.util.List;
import java.util.Map;

public class Teacher {

    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String email;
    private double experience;
    private double sessionRate;
    private List<Subject> subjectExpertise;
    private Map<Rating, Integer> ratings;
    private List<String> reviews;

    public Teacher(){

    }

    public Teacher(
            String id,
            String firstName,
            String lastName,
            int age,
            String phoneNumber,
            String email,
            double yearsOfExperience
            double sessionRate,
            List<Subject> subjectExpertise,
            Map<Rating, Integer> ratings,
            List<String> reviews){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sessionRate = sessionRate;
        this.subjectExpertise = subjectExpertise;
        this.ratings = ratings;
        this.reviews = reviews;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSessionRate() {
        return sessionRate;
    }

    public void setSessionRate(double sessionRate) {
        this.sessionRate = sessionRate;
    }

    public List<Subject> getSubjectExpertise() {
        return subjectExpertise;
    }

    public void setSubjectExpertise(List<Subject> subjectExpertise) {
        this.subjectExpertise = subjectExpertise;
    }

    public Map<Rating, Integer> getRatings() {
        return ratings;
    }

    public void setRatings(Map<Rating, Integer> ratings) {
        this.ratings = ratings;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }
}