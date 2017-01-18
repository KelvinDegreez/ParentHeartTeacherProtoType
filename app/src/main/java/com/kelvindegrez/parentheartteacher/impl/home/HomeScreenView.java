package com.kelvindegrez.parentheartteacher.impl.home;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.kelvindegrez.parentheartteacher.R;
import com.kelvindegrez.parentheartteacher.dagger2.MainApp;
import com.kelvindegrez.parentheartteacher.mvp.home.HomePresenter;
import com.kelvindegrez.parentheartteacher.mvp.home.HomeView;
import com.kelvindegrez.parentheartteacher.objects.Rating;
import com.kelvindegrez.parentheartteacher.objects.Subject;
import com.kelvindegrez.parentheartteacher.objects.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeScreenView extends AppCompatActivity implements HomeView {

    HomePresenter presenter;
    TeacherRecyclerViewAdapter adapter;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_view);
        if(presenter == null){
            setPresenter(MainApp.getDaggerComponent().provideHomePresenter());
        }
        ButterKnife.bind(this);

        List<Teacher> teacherList = new ArrayList<>();
        for(int i=0; i<firstNameList.size(); i++){
            teacherList.add(createRandomTeacher());
        }

        Map<Rating, Integer> ratings = new HashMap<>();
        ratings.put(Rating.Flexibility, 5);
        ratings.put(Rating.Rate, 5);
        ratings.put(Rating.Communication, 5);
        ratings.put(Rating.Effectiviness, 5);
        teacherList.add(new Teacher(
                "Sarah",
                "Lagman",
                29,
                "(301)-555-555",
                "sarah.is.best@sheisawesome.com",
                100,
                Arrays.asList(Subject.Science, Subject.Music),
                ratings,
                Arrays.asList(
                        "Lagman is the best teacher ever!",
                        "I really felt like I could learn again",
                        "She made me feel comfortable and really taught me",
                        "10/10 Would ALWAYS RECOMMEND WHY IS HERE RATE SO LOW???")
        ));


        adapter = new TeacherRecyclerViewAdapter(teacherList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setPresenter(HomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public HomePresenter getPresenter() {
        return presenter;
    }

    private Teacher createRandomTeacher(){
        Random r = new Random();

        List<Subject> subjects = new ArrayList<>();
        subjects.add(Subject.values()[r.nextInt(Subject.values().length-1)]);

        Map<Rating, Integer> ratings = new HashMap<>();
        ratings.put(Rating.Flexibility, r.nextInt(5));
        ratings.put(Rating.Rate, r.nextInt(5));
        ratings.put(Rating.Communication, r.nextInt(5));
        ratings.put(Rating.Effectiviness, r.nextInt(5));




        Teacher teacher = new Teacher(
                firstNameList.get(r.nextInt(firstNameList.size())),
                lastNameList.get(r.nextInt(lastNameList.size())),
                r.nextInt(50)+20,
                "("+r.nextInt(9)+r.nextInt(9)+r.nextInt(9)+")"+"555-5555",
                "",
                20 + (120 - 20) * r.nextDouble(),
                subjects,
                ratings,
                null);



        List<String> reviews = Arrays.asList(
                teacher.getLastName()+" was "+ (r.nextBoolean() ? " amazing!" : " awful!"),
                teacher.getLastName()+" makes me want to "+ (r.nextBoolean() ? " learn!" : " give up..."),
                teacher.getLastName()+" communication was "+ (r.nextBoolean() ? " on point!" : " lackluster"),
                "I would "+(r.nextBoolean() ? " absolutely recommend " : " stay away from ")+teacher.getLastName()
        );

        teacher.setEmail(teacher.getFirstName()+"."+teacher.getLastName()+"@pht.com");
        teacher.setReviews(reviews);

        return teacher;
    }

    List<String> firstNameList = Arrays.asList(
            "John",
            "Mary",
            "Susan",
            "Peter",
            "Tiffany",
            "Kelvin"
    );

    List<String> lastNameList = Arrays.asList(
            "Smith",
            "Anderson",
            "DeSilva",
            "Lee",
            "Dewberry",
            "Colin"

    );
    
}
