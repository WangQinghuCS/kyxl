package com.example.chronicdisease.base_elestical;

import com.example.chronicdisease.MainActivity;
import com.example.chronicdisease.MyApp;
import com.example.chronicdisease.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Whestimate extends Activity {
    private TextView txtTitle;
    private ImageView backHome;
    private ImageView imgReturn;

    private EditText edtWpt, edtHpt;
    private TextView txtHP;
    private LinearLayout linearLayout;
    private Button btnText,btnText2,btnCancel;
    private String bmiResult = null;
    private float weit =0;
    private float heit =0;
    private float point =0;
    private TextView txtPrompt;

    public void setBmiResult(String bmiResult){
        this.bmiResult=bmiResult;
    }
    public String getBmiResult(){
        return bmiResult;
    }
    public void setWeitght(float weit){
        this.weit=weit;
    }
    public float getWeight(){
        return weit;
    }
    public void setHeight(float heit){
        this.heit=heit;
    }
    public float getHeight(){
        return heit;
    }
    public void setPoint(float point){
        this.point=point;
    }
    public float getPoint(){
        return point;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.whestimate);

        txtTitle=(TextView)findViewById(R.id.txtTitle);
        backHome=(ImageView)findViewById(R.id.backHome);
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        backHome.setImageResource(R.drawable.pic_1);
        imgReturn.setImageResource(R.drawable.pic_2);
        edtWpt = (EditText) findViewById(R.id.edtWpt);
        edtHpt = (EditText) findViewById(R.id.edtHpt);
        txtHP = (TextView) findViewById(R.id.txtHP);
        txtPrompt=(TextView)findViewById(R.id.txtPrompt);
        btnText=(Button)findViewById(R.id.btnTest);
        btnText2=(Button)findViewById(R.id.btnTest2);
        btnCancel=(Button)findViewById(R.id.btnCancel);
        linearLayout=(LinearLayout)findViewById(R.id.linerLayout2);

        txtTitle.setText("身高指数");
        backHome.setOnClickListener(new backHomeLis());
        imgReturn.setOnClickListener(new imgReturnLis());

        btnText.setOnClickListener(new btnTextLis());
        btnText2.setOnClickListener(new btnText2Lis());
        btnCancel.setOnClickListener(new btnCancel());

    }
    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(Whestimate.this, MainActivity.class);
            startActivity(it);
            finish();
        }

    }
    class imgReturnLis  implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);

        }
    }
    class btnTextLis implements OnClickListener{

        public void onClick(View v) {
            // TODO Auto-generated method stub

            String weight = edtWpt.getText().toString();
            String height = edtHpt.getText().toString();
            if(weight.length()==0||height.length()==0){
                Toast.makeText(Whestimate.this, "请正确输入身高和体重",
                        Toast.LENGTH_LONG).show();
            }
            else{
                weit = Float.parseFloat(weight);
                heit = Float.parseFloat(height);
                if (weit <30 || heit <60||weit>300||heit>300) {
                    Toast.makeText(Whestimate.this, "抱歉，您输入的数据不在常规范围内,请检查数据是否有误",
                            Toast.LENGTH_LONG).show();
                }
                else {

                    heit = heit / 100;
                    point = weit / heit / heit;
                    point = (float) ((int) (point * 10)) / 10;

                    bmiJugde(point);
                    txtHP.setText("体重指数为" + "  " + point + "\n"
                            + "体重指数类别为:" + bmiResult+"\n"+"\n");
                    txtPrompt.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.VISIBLE);

                }}

        }

    }
    class btnText2Lis implements OnClickListener{

        public void onClick(View v) {
            // TODO Auto-generated method stub

            Intent it=new Intent();
            it.setClass(Whestimate.this,DangerBmi.class);
            Bundle bundle =new Bundle();
            bundle.putFloat("point", point);
            it.putExtras(bundle);
            startActivity(it);

        }

    }
    class btnCancel implements OnClickListener{

        public void onClick(View v) {
            // TODO Auto-generated method stub
            finish();
        }

    }

    public String bmiJugde(float point) {
        if (point < 18.5f) {
            bmiResult = "体重过低";
        } else if (point < 23.9f) {
            bmiResult= "体重正常";
        } else if (point < 27.9f) {
            bmiResult = "超重";
        } else {
            bmiResult = "肥胖";
        }
        return bmiResult;
    }
}

