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

public class baseManage extends Activity {
    private TextView txtTitle;
    private TextView backHome,base1,yuhou1;

    // private ImageView backHome;
    private ImageView imgReturn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.base_manage);
        setupViewComponent();

    }

    private void setupViewComponent() {

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        backHome = (TextView) findViewById(R.id.backHome);
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        base1=(TextView) findViewById(R.id.base1);
        yuhou1=(TextView) findViewById(R.id.yuhou1);
        //backHome.setImageResource(R.drawable.pic_1);
        //imgReturn.setImageResource(R.drawable.pic_2);



        txtTitle.setText("常规管理");

        imgReturn.setOnClickListener(new imgReturnLis());
        backHome.setOnClickListener(new backHomeLis());
        base1.setOnClickListener(new base1Lis());
        yuhou1.setOnClickListener(new yuhou1Lis());
    }

    class backHomeLis implements View.OnClickListener {

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it = new Intent();
            it.setClass(baseManage.this, MainActivity.class);
            startActivity(it);


        }

    }
    class base1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(baseManage.this, BaseElestical.class);
            startActivity(it);
        }

    }
    class yuhou1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(baseManage.this, CheckPressLevelActivity.class);
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

    class imgReturnLis implements View.OnClickListener {

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);

        }
    }
}


