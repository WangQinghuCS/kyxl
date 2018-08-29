package com.example.chronicdisease;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.*;

import com.example.chronicdisease.base_elestical.BaseElestical;

public class Info_us extends Activity {

    private TextView info_usTxt;
    private ImageView imgReturn;
    private TextView backHome,base1,yuhou1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_us);
        info_usTxt = findViewById(R.id.info_usTxt);
        backHome = (TextView) findViewById(R.id.backHome);
        base1=(TextView) findViewById(R.id.base1);
        yuhou1=(TextView) findViewById(R.id.yuhou1);
        info_usTxt.setText("本软件由南京理工大学计算机学院制作");
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        imgReturn.setOnClickListener(new imgReturnLis());
        backHome.setOnClickListener(new backHomeLis());
        base1.setOnClickListener(new base1Lis());
        yuhou1.setOnClickListener(new yuhou1Lis());
    }
    class imgReturnLis  implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
    }
    class backHomeLis implements View.OnClickListener {

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it = new Intent();
            it.setClass(Info_us.this, MainActivity.class);
            startActivity(it);


        }

    }
    class base1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(Info_us.this, BaseElestical.class);
            startActivity(it);
        }

    }
    class yuhou1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(Info_us.this, CheckPressLevelActivity.class);
            startActivity(it);
        }

    }
}
