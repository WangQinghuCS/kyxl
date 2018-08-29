package com.example.chronicdisease;

import android.app.Activity;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import com.example.chronicdisease.base_elestical.BaseElestical;

public class CheckManageActivity extends Activity {
    private int result;
    private int level;
    private TextView txtTitle,txtComplete,backHome,base1,yuhou1;
    private ImageView imgReturn;
    private TextView textView10,textView11,textView12,textView13,textView14,textView15,
            textView16,textView17,textView18,textView19,textView1A,textView1B,textView1C,textView1D;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent get = getIntent();
        setContentView(R.layout.activity_show_manage);
        txtTitle = findViewById(R.id.txtTitle);
        txtComplete = findViewById(R.id.txtComplete);
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        txtComplete.setOnClickListener(new backHomeLis());
        imgReturn.setOnClickListener(new imgReturnLis());
        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText("管理");
        backHome = findViewById(R.id.backHome);
        backHome=(TextView) findViewById(R.id.backHome);
        base1=(TextView) findViewById(R.id.base1);
        yuhou1=(TextView) findViewById(R.id.yuhou1);
        backHome.setOnClickListener(new backHomeLis());
        base1.setOnClickListener(new base1Lis());
        yuhou1.setOnClickListener(new yuhou1Lis());
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);
        textView14 = findViewById(R.id.textView14);
        textView15 = findViewById(R.id.textView15);
        textView16 = findViewById(R.id.textView16);
        textView17 = findViewById(R.id.textView17);
        textView18 = findViewById(R.id.textView18);
        textView19 = findViewById(R.id.textView19);
        textView1A = findViewById(R.id.textView1A);
        textView1B = findViewById(R.id.textView1B);
        textView1C = findViewById(R.id.textView1C);
        textView1D = findViewById(R.id.textView1D);

        result = get.getIntExtra("level",10);
        Log.d("level",Integer.toString(result));
        if(result==0)
        {
            level = 0;
        } else if(result ==1)
        {
            level =1;
        }else if (result ==2 || result==3){
            level =2;
        }

        if (level==0)
        {
           textView10.setText(R.string.first_level);
            textView11.setText(R.string.A_1);
            textView12.setText(R.string.B);
            textView13.setText(R.string.C_1);
            textView14.setText(R.string.D);
            textView15.setText(R.string.E_1);
            textView16.setText(R.string.F_1);
            textView17.setText(R.string.G_1);
            textView18.setText(R.string.H_1);
            textView19.setText(R.string.I_1);
            textView1A.setText(R.string.L_1);
            textView1B.setText(R.string.M_1);
            textView1C.setText(R.string.N_1);
           textView1D.setText("");
        }   else

        if (level==1)
        {
            textView10.setText(R.string.second_level);
            textView11.setText(R.string.A_2);
            textView12.setText(R.string.B);
            textView13.setText(R.string.C_2);
            textView14.setText(R.string.D);
            textView15.setText(R.string.E_2);
            textView16.setText(R.string.F_2);
            textView17.setText(R.string.G_2);
            textView18.setText(R.string.H_2);
            textView19.setText(R.string.I_2);
            textView1A.setText(R.string.L_2);
            textView1B.setText(R.string.M_2);
            textView1C.setText(R.string.N_2);
            textView1D.setText(R.string.O_2);
        }   else

        if (level ==2)
        {
            textView10.setText(R.string.third_level);
            textView11.setText(R.string.A_3);
            textView12.setText(R.string.B);
            textView13.setText(R.string.C_2);
            textView14.setText(R.string.D);
            textView15.setText(R.string.E_3);
            textView16.setText(R.string.F_2);
            textView17.setText(R.string.G_2);
            textView18.setText(R.string.H_3);
            textView19.setText(R.string.I_3);
            textView1A.setText(R.string.L_3);
            textView1B.setText(R.string.H_3);
            textView1C.setText(R.string.N_3);
            textView1D.setText(R.string.O_3);
        }  else

        {
            textView10.setText("app error");
        }

    }
    class imgReturnLis  implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);

        }
    }
    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(CheckManageActivity.this, MainActivity.class);
            startActivity(it);
        }

    }
    class base1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(CheckManageActivity.this, BaseElestical.class);
            startActivity(it);
        }

    }
    class yuhou1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(CheckManageActivity.this, CheckPressLevelActivity.class);
            startActivity(it);
        }

    }
}
