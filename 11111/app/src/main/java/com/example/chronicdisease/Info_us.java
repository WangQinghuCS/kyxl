package com.example.chronicdisease;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Info_us extends Activity {

    private TextView info_usTxt;
    private ImageView imgReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_us);
        info_usTxt = findViewById(R.id.info_usTxt);
        info_usTxt.setText("本软件由南京理工大学计算机学院制作");
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
