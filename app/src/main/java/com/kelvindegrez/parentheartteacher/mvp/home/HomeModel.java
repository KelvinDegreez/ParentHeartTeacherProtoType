package com.kelvindegrez.parentheartteacher.mvp.home;


import com.kelvindegrez.parentheartteacher.mvp.MvpModel;
import com.kelvindegrez.parentheartteacher.objects.Teacher;

import java.util.List;

public interface HomeModel extends MvpModel<HomePresenter> {

    List<Teacher> getTeacherList();
}
