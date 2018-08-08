package com.example.chronicdisease.settings;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chronicdisease.MainActivity;
import com.example.chronicdisease.MyApp;
import com.example.chronicdisease.R;
//test
public class Settings extends Activity {
    private TextView txtTitle;
    private TextView setting_version;
    private ImageView backHome;
    private ImageView imgReturn;
    private RelativeLayout relate_about_us;
    AlertDialog ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.setting);
        setupViewComponent();
    }
    private void setupViewComponent(){
        txtTitle=(TextView)findViewById(R.id.txtTitle);
        backHome=(ImageView)findViewById(R.id.backHome);
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        relate_about_us=(RelativeLayout)findViewById(R.id.relate_about_us);
        setting_version=(TextView)findViewById(R.id.setting_version);

        txtTitle.setText("设置");
        backHome.setOnClickListener(new backHomeLis());
        imgReturn.setOnClickListener(new imgReturnLis());
        relate_about_us.setOnClickListener(new aboutListener());
    }
    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(Settings.this, MainActivity.class);
            startActivity(it);

        }

    }
    class imgReturnLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
    }
    class aboutListener implements View.OnClickListener{

        public void onClick(View arg0) {
            Builder builder=new AlertDialog.Builder(Settings.this);
            builder.setTitle("关于")
                    .setMessage("慢性病评估软件安卓单机版"+"\n"
                            +"  由 南京理工大学计算机学院 制作")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface arg0, int arg1) {
                            ad.dismiss();
                        }
                    });
            ad=builder.create();
            ad.show();

        }

    }
}

