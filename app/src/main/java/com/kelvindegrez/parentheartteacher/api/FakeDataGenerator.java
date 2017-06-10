package com.kelvindegrez.parentheartteacher.api;

import com.kelvindegrez.parentheartteacher.objects.Rating;
import com.kelvindegrez.parentheartteacher.objects.Subject;
import com.kelvindegrez.parentheartteacher.objects.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class FakeDataGenerator {

    private static Random ran = new Random();

    private Map<String, Teacher> apiTeacherMap = new HashMap<>();

    public void FakeDataGenerator(){
        generateFakeData();
    }

    //========== Fake Api Calls

    public DataResult<List<Teacher>> getTeachers(){
        List<Teacher> teachers = new ArrayList<>(apiTeacherMap.values());
        return new DataResult<List<Teacher>>(DataResult.HttpCode.SUCCESS, "Success", teachers);
    }


    //========== Fake Data Generation

    private void generateFakeData(){

    }


    //========== Fake Objects Generation

    private int identifier =-1;
    private String generateFakeId(){
        identifier++;
        return identifier+"";
    }

    private Teacher generateTeacher(){
        String firstName = ranListItem(firstNameList);
        String lastName = ranListItem(lastNameList);

        return new String(
                generateFakeId(),
                firstName,
                lastName,
                ranAge(),
                ranPhoneNumber(),
                firstName+"."+lastName+"@pht.com",
                ranAmount(),
                ranListItems(Arrays.asList(Subject.values(), 2)),
                Map<Rating, Integer>
                List<String> reviews
    }

    private Map<Rating, String> generateRating


    private Teacher createRandomTeacher(){


        List<Subject> subjects = new ArrayList<>();
        subjects.add(Subject.values()[ran.nextInt(Subject.values().length-1)]);

        Map<Rating, Integer> ratings = new HashMap<>();
        ratings.put(Rating.Flexibility, ran.nextInt(5));
        ratings.put(Rating.Rate, ran.nextInt(5));
        ratings.put(Rating.Communication, ran.nextInt(5));
        ratings.put(Rating.Effectiviness, ran.nextInt(5));


        Teacher teacher = new Teacher(
                firstNameList.get(ran.nextInt(firstNameList.size())),
                lastNameList.get(ran.nextInt(lastNameList.size())),
                ran.nextInt(50)+20,
                ,
                "",
                20 + (120 - 20) * ran.nextDouble(),
                subjects,
                ratings,
                null);



        List<String> reviews = Arrays.asList(
                teacher.getLastName()+" was "+ (ran.nextBoolean() ? " amazing!" : " awful!"),
                teacher.getLastName()+" makes me want to "+ (ran.nextBoolean() ? " learn!" : " give up..."),
                teacher.getLastName()+" communication was "+ (ran.nextBoolean() ? " on point!" : " lackluster"),
                "I would "+(ran.nextBoolean() ? " absolutely recommend " : " stay away from ")+teacher.getLastName()
        );

        teacher.setEmail(teacher.getFirstName()+"."+teacher.getLastName()+"@pht.com");
        teacher.setReviews(reviews);

        return teacher;
    }




    //======== Fake List Data


    private List<String> firstNameList = Arrays.asList(
            "John",
            "Mary",
            "Susan",
            "Peter",
            "Tiffany",
            "Kelvin"
    );

    private List<String> lastNameList = Arrays.asList(
            "Smith",
            "Anderson",
            "DeSilva",
            "Lee",
            "Dewberry",
            "Colin"
    );


    //======= Helper items

    private static <T> T ranListItem(List<T> list) {
        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return list.get(ran.nextInt(list.size() - 1));
        }
    }

    private static <T> List<T> ranListItems(List<T> list, int numberOfItems) {
        if(numberOfItems >= list.size()){
            return list;
        }
        List<T> copy = new LinkedList<T>(list);
        Collections.shuffle(copy);
        return copy.subList(0, numberOfItems);
    }

    private static int ranAge(){
        return ran.nextInt(32)+18;
    }

    private static String ranPhoneNumber(){
        return "("+ran.nextInt(9)+ran.nextInt(9)+ran.nextInt(9)+")"+"555-5555";
    }

    private static Double ranAmount(){
        return ran.nextInt(75)+25+(ran.nextInt(99)/100.0);
    }
}
