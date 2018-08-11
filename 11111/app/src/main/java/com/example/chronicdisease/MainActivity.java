package com.example.chronicdisease;

import java.util.ArrayList;
import java.util.List;

import com.example.chronicdisease.base_elestical.BaseElestical;
//import com.example.chronicdisease.health_manager.HealthManager;
//import com.example.chronicdisease.personinfo.PersonInfo;
//import com.example.chronicdisease.question.Question;
import com.example.chronicdisease.yuhouelestical.YuhouElestical;
import com.example.chronicdisease.settings.Settings;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private long mExitTime=0;
    private View view;
    private ImageView imgBackHome;
    private TextView txtTitle;
    private ImageView imgreturn;
    private LinearLayout baseElestical,yuhouElestical,healthManager,question,personInfo,settings;
    //This is a test Tag for Git
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.getInstance().addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        view = this.getLayoutInflater().inflate(R.layout.home_page, null);
        setContentView(view);
        setupViewComponent();
    }
    private void setupViewComponent(){
        imgBackHome=(ImageView) findViewById(R.id.backHome);
        txtTitle=(TextView)findViewById(R.id.txtTitle);
        imgreturn=(ImageView)findViewById(R.id.imgReturn);
        baseElestical=(LinearLayout)findViewById(R.id.baseElestical);
        yuhouElestical=(LinearLayout)findViewById(R.id.yuhouElestical);
        healthManager=(LinearLayout)findViewById(R.id.healthManager);
        question=(LinearLayout)findViewById(R.id.question);
        personInfo=(LinearLayout)findViewById(R.id.personInfo);
        settings=(LinearLayout)findViewById(R.id.settings);


        imgBackHome.setVisibility(View.GONE);
        txtTitle.setText("首页");
        imgreturn.setBackgroundResource(R.drawable.down);     //改了图片记得改一下
        imgreturn.setOnClickListener(new imgloginLis());


        baseElestical.setOnClickListener( new BaseElesticalLis());
        yuhouElestical.setOnClickListener(new YuhouElesticalLis());
        healthManager.setOnClickListener(new HealthManagerLis());
        question.setOnClickListener(new QuestionLis());
        personInfo.setOnClickListener(new PersonInfoLis());
        settings.setOnClickListener(new SettingsLis());
    }
    class imgloginLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub

        }

    }

    class BaseElesticalLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it1=new Intent();
            it1.setClass(MainActivity.this, BaseElestical.class);
            startActivity(it1);
            overridePendingTransition(R.anim.main_enter, R.anim.main_exit);

        }

    }
    class YuhouElesticalLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it2=new Intent();
            it2.setClass(MainActivity.this, CheckPressLevelActivity.class);
            startActivity(it2);
            overridePendingTransition(R.anim.main_enter, R.anim.main_exit);
        }

    }
    class HealthManagerLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it3=new Intent();
           // it3.setClass(MainActivity.this, HealthManager.class);
            startActivity(it3);
            overridePendingTransition(R.anim.main_enter, R.anim.main_exit);
        }

    }
    class QuestionLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it4=new Intent();
          //  it4.setClass(MainActivity.this, Question.class);
            startActivity(it4);
            overridePendingTransition(R.anim.main_enter, R.anim.main_exit);
        }

    }
    class PersonInfoLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it5=new Intent();
           // it5.setClass(MainActivity.this, PersonInfo.class);
            startActivity(it5);
            overridePendingTransition(R.anim.main_enter, R.anim.main_exit);
        }

    }
    class SettingsLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it6=new Intent();
            it6.setClass(MainActivity.this,Settings.class);
            startActivity(it6);
            overridePendingTransition(R.anim.main_enter, R.anim.main_exit);
        }

    }

    //实现按两次返回键退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            }else{
                MyApp.getInstance().exit();
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }
}

