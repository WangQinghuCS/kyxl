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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DangerBmi extends Activity {
    private TextView txtTitle;
    private TextView backHome;
    //private Button imgReturn;

    private RadioGroup radGSex;
    private RadioButton radMale,radFemale;
    private EditText edtWaistline;
    private Button btnWaistline,btnReturn;
    private TextView txtWaistline;
    private float boundaryLow=0,boundaryHigh=0;
    private float wl;
    private float point;
    private String dangerResult;

    public void setBoundaryLow(float boundaryLow){
        this.boundaryLow=boundaryLow;
    }
    public float getBoundaryLow(){
        return boundaryLow;
    }
    public void setBoundaryHigh(float boundaryHigh){
        this.boundaryHigh=boundaryHigh;
    }
    public float getBoundaryHigh(){
        return boundaryHigh;
    }
    public void setWl(float wl){
        this.wl=wl;
    }
    public float getWl(){
        return wl;
    }
    public void setPoint(float point){
        this.point=point;
    }
    public float getPoint(){
        return point;
    }
    public void setDangerResult(String dangerResult){
        this.dangerResult=dangerResult;
    }
    public String getDangerResult(){
        return dangerResult;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.dangerbmi);

        Intent it=getIntent();
        Bundle bundle=it.getExtras();
        point=bundle.getFloat("point");

        setupViewComponent();
    }
    private void setupViewComponent(){

        txtTitle=(TextView)findViewById(R.id.txtTitle);
        backHome=(TextView) findViewById(R.id.backHome);
       //imgReturn=(ImageView)findViewById(R.id.imgReturn);
       // backHome.setImageResource(R.drawable.pic_1);
       // imgReturn.setImageResource(R.drawable.pic_2);
        radGSex=(RadioGroup)findViewById(R.id.radGSex);
        radMale=(RadioButton)findViewById(R.id.radMale);
        radFemale=(RadioButton)findViewById(R.id.radFemale);
        edtWaistline=(EditText)findViewById(R.id.edtWaistline);
        btnWaistline=(Button)findViewById(R.id.btnWaistline);
        btnReturn=(Button)findViewById(R.id.btnReturn);
        txtWaistline=(TextView)findViewById(R.id.txtWaistline);

        txtTitle.setText("危险评估");
        backHome.setOnClickListener(new backHomeLis());
       // imgReturn.setOnClickListener(new imgReturnLis());

        radGSex.setOnCheckedChangeListener( new radGSexChangeLis());
        btnWaistline.setOnClickListener(new btnWaistlineLis());
        btnReturn.setOnClickListener(new btnReturnLis());

    }
    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(DangerBmi.this, MainActivity.class);
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
    class radGSexChangeLis implements RadioGroup.OnCheckedChangeListener{

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // TODO Auto-generated method stub
            if(checkedId==R.id.radMale){
                boundaryLow=85;
                boundaryHigh=95;
            }
            else
            {
                boundaryLow=80;
                boundaryHigh=90;
            }

        }


    }
    class btnWaistlineLis implements OnClickListener{

        public void onClick(View v) {
            // TODO Auto-generated method stub
            String strwl=edtWaistline.getText().toString();
            if(strwl.length()==0){
                Toast.makeText(DangerBmi.this, "请输入腰围", Toast.LENGTH_SHORT).show();
            }
            else{
                wl=Float.parseFloat(strwl);
                if(wl<20||wl>120){
                    Toast.makeText(DangerBmi.this, "抱歉，您输入的数据不在常规范围内,请检查数据是否有误", Toast.LENGTH_SHORT).show();
                }

                else{

                    dangerJudge(point,wl);
                    txtWaistline.setText("您的肥胖与高血压、糖尿病、血脂异常的危险关系为："+'\t'+dangerResult);
                }
            }

        }
    }
    class btnReturnLis implements OnClickListener{

        public void onClick(View v) {
            // TODO Auto-generated method stub
            finish();

        }

    }
    public String dangerJudge(float point,float wl){
        if(point<18.5f){
            dangerResult="无危险";
        }else if(point<23.9f){
            if(wl<boundaryLow){
                dangerResult="无危险";
            }else if(wl<boundaryHigh){
                dangerResult="危险增加";
            }else{
                dangerResult="高危";
            }
        }else if(point<27.9f){
            if(wl<boundaryLow){
                dangerResult="危险增加";
            }else if(wl<boundaryHigh){
                dangerResult="高危";
            }else{
                dangerResult="极高危";
            }
        }else {
            if(wl<boundaryLow){
                dangerResult="高危";
            }else if(wl<boundaryHigh){
                dangerResult="极高危";
            }else{
                dangerResult="极高危";
            }
        }
        return dangerResult;
    }
}
