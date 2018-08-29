package com.example.chronicdisease;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Feedback extends Activity {

    private TextView feedback;
    private ImageView imgReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        feedback = findViewById(R.id.feedbackTxt);
        feedback.setText("如有意见可以通过邮箱1456909695@qq.com与我们联系");
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        imgReturn.setOnClickListener(new imgReturnLis());
    }
    class imgReturnLis  implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
    }
}
