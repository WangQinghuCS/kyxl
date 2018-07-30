package com.example.chronicdisease.yuhouelestical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chronicdisease.MainActivity;
import com.example.chronicdisease.MyApp;
import com.example.chronicdisease.R;
public class YuhouElestical extends Activity {
    private TextView txtTitle;
    private Button  txtBPL;
    private ImageView backHome;
    private ImageView imgReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.yuhou_elestical);
        setupViewComponent();
    }
    private void setupViewComponent(){
        txtTitle=(TextView)findViewById(R.id.txtTitle);
        backHome=(ImageView)findViewById(R.id.backHome);
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        txtBPL=(Button)findViewById(R.id.txtBPL);
        txtTitle.setText("预后评估");
        backHome.setOnClickListener(new backHomeLis());
        imgReturn.setOnClickListener(new imgReturnLis());
        txtBPL.setOnClickListener(new txtBPL());

    }
    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(YuhouElestical.this, MainActivity.class);
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

    class txtBPL implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent BPL=new Intent();
            BPL.setClass(YuhouElestical.this,BPmanager.class);
            startActivity(BPL);
        }

    }
}
