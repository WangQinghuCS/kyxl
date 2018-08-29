package com.example.chronicdisease;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.*;

import com.example.chronicdisease.base_elestical.BaseElestical;

public class Feedback extends Activity {

    private TextView feedback;
    private ImageView imgReturn;
    private TextView backHome,base1,yuhou1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        backHome = (TextView) findViewById(R.id.backHome);
        base1=(TextView) findViewById(R.id.base1);
        yuhou1=(TextView) findViewById(R.id.yuhou1);
        feedback = findViewById(R.id.feedbackTxt);
        feedback.setText("如有意见可以通过邮箱1456909695@qq.com与我们联系");
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
            it.setClass(Feedback.this, MainActivity.class);
            startActivity(it);


        }

    }
    class base1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(Feedback.this, BaseElestical.class);
            startActivity(it);
        }

    }
    class yuhou1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(Feedback.this, CheckPressLevelActivity.class);
            startActivity(it);
        }

    }
}
