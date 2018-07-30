package com.example.chronicdisease.base_elestical;

import com.example.chronicdisease.MainActivity;
import com.example.chronicdisease.MyApp;
import com.example.chronicdisease.R;
import com.example.chronicdisease.base_elestical.bloodfat_input.backHomeLis;
import com.example.chronicdisease.base_elestical.bloodfat_input.imgReturnLis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class bloodfat_assess extends Activity
{
    private Button btnReturn;
    private ImageView imaBack_home,imaReturn;
    private TextView txtresult1;
    private TextView txtresult2;
    private TextView txtresult3;
    private TextView txtresult4;
    private TextView txtresult5;
    private TextView txtresult6;
    private TextView txtTitle;
    private float TC_f,LDL_C_f,HDL_C_f,TG_f;
    private String TC_Assess,LDL_C_Assess,HDL_C_Assess,TG_Assess;
    public void setTC_f(float f)
    {
        TC_f=f;
    }
    public float getTC_f()
    {
        return TC_f;
    }
    public void setLDL_C_f(float f)
    {
        LDL_C_f=f;
    }
    public float getLDL_C_f()
    {
        return LDL_C_f;
    }
    public void setHDL_C_f(float f)
    {
        HDL_C_f=f;
    }
    public float getHDL_C_f()
    {
        return HDL_C_f;
    }
    public void setTG_f(float f)
    {
        TG_f=f;
    }
    public float getTG_f()
    {
        return TG_f;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.bloodfat_assess);
        txtresult1=(TextView)findViewById(R.id.textView1);
        txtresult2=(TextView)findViewById(R.id.textView2);
        txtresult3=(TextView)findViewById(R.id.textView3);
        txtresult4=(TextView)findViewById(R.id.textView4);
        txtresult5=(TextView)findViewById(R.id.textView5);
        txtresult6=(TextView)findViewById(R.id.textView6);
        imaBack_home=(ImageView)findViewById(R.id.backHome);
        imaBack_home.setImageResource(R.drawable.pic_1);
        imaReturn=(ImageView)findViewById(R.id.imgReturn);
        imaReturn.setImageResource(R.drawable.pic_2);
        txtTitle=(TextView)findViewById(R.id.txtTitle);
        txtTitle.setText("检测结果");
        imaBack_home.setOnClickListener(new backHomeLis());
        imaReturn.setOnClickListener(new imgReturnLis());
        Intent it=getIntent();
        int count = 0;//用于统计正常指标的个数
        int count1 = 0;
        if(it.getStringExtra("TC").length()!=0)
        {
            setTC_f(Float.parseFloat(it.getStringExtra("TC")));
            float tc=getTC_f();

            if(tc<5.20f){
                txtresult2.setText("1.胆固醇正常");
                count++;
            }
            if(tc>=5.20f && tc<=6.20f)
            {
                txtresult2.setText("1.胆固醇边缘升高");
            }
            if(tc>6.20f)
            {
                txtresult2.setText("1.胆固醇异常");
                count1++;
            }
        }
        else
        {
            txtresult2.setText("1.胆固醇指标未输入");
        }
        if(it.getStringExtra("LDL_C").length()!=0)
        {
            setLDL_C_f(Float.parseFloat(it.getStringExtra("LDL_C")));
            float ldl_c=getLDL_C_f();

            if(ldl_c<3.12f)
            {
                txtresult3.setText("2.低密度脂蛋白胆固醇正常");
                count++;
            }
            if(ldl_c>=3.12f&&ldl_c<4.14f)
            {
                txtresult3.setText("2.低密度脂蛋白胆固醇边缘升高");
            }
            if(ldl_c>=4.14f)
            {
                txtresult3.setText("2.低密度脂蛋白胆固醇异常");
                count1++;
            }
        }
        else
        {
            txtresult3.setText("2.低密度脂蛋白胆固醇指标未输入");
        }
        if(it.getStringExtra("HDL_C").length()!=0)
        {
            setHDL_C_f(Float.parseFloat(it.getStringExtra("HDL_C")));
            float hdl_c=getHDL_C_f();

            if(hdl_c>=1.04f){
                txtresult4.setText("3.高密度脂蛋白胆固醇正常");
                count++;
            }else{
                txtresult4.setText("3.高密度脂蛋白胆固醇异常");
                count1++;
            }
        }
        else
        {
            txtresult4.setText("3.高密度脂蛋白胆固醇指标未输入");
        }
        if(it.getStringExtra("TG").length()!=0)
        {
            setTG_f(Float.parseFloat(it.getStringExtra("TG")));
            float tg=getTG_f();

            if(tg<1.65f)
            {
                txtresult5.setText("4.甘油三酯正常");
                count++;
            }
            if(tg>=1.65f&&tg<=2.19f)
            {
                txtresult5.setText("4.甘油三酯边缘升高");
            }
            if(tg>2.19f)
            {
                txtresult5.setText("4.甘油三酯异常");
                count1++;
            }
        }
        else
        {
            txtresult5.setText("4.甘油三酯指标未输入");
        }
        if(count==4)
        {
            txtresult6.setText("恭喜您，你的四项指标均正常！");
        }
        if(count1>0)
        {
            txtresult6.setText("您有"+count1+"项指标异常!");
        }
    }
    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(bloodfat_assess.this, MainActivity.class);
            startActivity(it);
        }
    }
    class imgReturnLis  implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);

        }
    }
}

