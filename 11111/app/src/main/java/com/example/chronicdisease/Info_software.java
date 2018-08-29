package com.example.chronicdisease;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.*;

import com.example.chronicdisease.base_elestical.BaseElestical;

import org.w3c.dom.Text;

public class Info_software extends Activity {

    private TextView info_softwareTxt;
    private ImageView imgReturn;
    private TextView backHome,base1,yuhou1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_software);
        info_softwareTxt = findViewById(R.id.info_softwareTxt);
        backHome = (TextView) findViewById(R.id.backHome);
        base1=(TextView) findViewById(R.id.base1);
        yuhou1=(TextView) findViewById(R.id.yuhou1);
        info_softwareTxt.setText("目前本程序安卓单机版仅提供慢性病基本评估功能，可反映个人基本健康状况，但不针对患者个人，不识别患者个人信息，也不记录输入数据和评估结果，不泄露个人隐私。");
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
            it.setClass(Info_software.this, MainActivity.class);
            startActivity(it);


        }

    }
    class base1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(Info_software.this, BaseElestical.class);
            startActivity(it);
        }

    }
    class yuhou1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(Info_software.this, CheckPressLevelActivity.class);
            startActivity(it);
        }

    }
}
