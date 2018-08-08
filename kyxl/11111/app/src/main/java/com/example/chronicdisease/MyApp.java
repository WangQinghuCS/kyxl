package com.example.chronicdisease;

import java.util.LinkedList;
import java.util.List;
import android.app.Activity;
import android.app.Application;

public class MyApp extends Application {
    //MyApp的实例
    private static MyApp instance;
    //所有Activity的list
    private List<Activity> activityList=new LinkedList<Activity>();

    private MyApp(){

    }

    //得到MyApp的实例
    public static MyApp getInstance(){
        if(instance==null){
            instance=new MyApp();
        }
        return instance;
    }

    //添加Activity到list中
    public void addActivity(Activity activity){
        activityList.add(activity);
    }

    //退出时结束所有的Activity
    public void exit(){

        for(Activity activity:activityList){
            activity.finish();
        }
        System.exit(0);
    }
}
