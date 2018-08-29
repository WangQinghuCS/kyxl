package com.example.chronicdisease.base_elestical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chronicdisease.CheckPressLevelActivity;
import com.example.chronicdisease.MainActivity;
import com.example.chronicdisease.MyApp;
import com.example.chronicdisease.R;

public class BaseElestical extends Activity {
    private Button txtBloodPressure,txtBloodSugar,txtBloodFat,txtWeight;
    private TextView txtTitle;
    private TextView backHome,base1,yuhou1;
   // private ImageView backHome;
    //private ImageView imgReturn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.base_elestical);
        setupViewComponent();

    }
    private void setupViewComponent(){

        txtTitle=(TextView)findViewById(R.id.txtTitle);
        backHome=(TextView)findViewById(R.id.home);
        base1=(TextView) findViewById(R.id.base1);
        yuhou1=(TextView) findViewById(R.id.yuhou1);
        //imgReturn=(ImageView)findViewById(R.id.imgReturn);
        //backHome.setImageResource(R.drawable.pic_1);
        //imgReturn.setImageResource(R.drawable.pic_2);

        txtBloodPressure=(Button)findViewById(R.id.txtBloodPressure);
        txtBloodSugar=(Button)findViewById(R.id.txtBloodSugar);
        txtBloodFat=(Button)findViewById(R.id.txtBloodFat);
        txtWeight=(Button)findViewById(R.id.txtWeight);

        txtTitle.setText("基本评估");
        backHome.setOnClickListener(new backHomeLis());
        base1.setOnClickListener(new base1Lis());
        yuhou1.setOnClickListener(new yuhou1Lis());
        //imgReturn.setOnClickListener(new imgReturnLis());
        txtBloodPressure.setOnClickListener(new bloodPressureLis());
        txtBloodSugar.setOnClickListener(new bloodSugarLis());
        txtBloodFat.setOnClickListener(new bloodFatLis());
        txtWeight.setOnClickListener(new weightLis());

    }

    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(BaseElestical.this, MainActivity.class);
            startActivity(it);


        }

    }
    /*class imgReturnLis  implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);

        }
    }
*/
    class bloodPressureLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent bloodpressure=new Intent();
            bloodpressure.setClass(BaseElestical.this,BloodPressure.class);
            startActivity(bloodpressure);

        }

    }
    class bloodSugarLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent=new Intent();
            intent.setClass(BaseElestical.this,Bloodsugar.class);
            startActivity(intent);

        }

    }
    class bloodFatLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent=new Intent();
            intent.setClass(BaseElestical.this,bloodfat_input.class);
            startActivity(intent);

        }

    }
    class weightLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent=new Intent();
            intent.setClass(BaseElestical.this,Whestimate.class);
            startActivity(intent);

        }
    }
    class base1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(BaseElestical.this, BaseElestical.class);
            startActivity(it);
        }

    }
    class yuhou1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(BaseElestical.this, CheckPressLevelActivity.class);
            startActivity(it);
        }

    }
}
