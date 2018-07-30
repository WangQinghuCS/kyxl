package com.example.chronicdisease.base_elestical;

import com.example.chronicdisease.MainActivity;
import com.example.chronicdisease.MyApp;
import com.example.chronicdisease.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class bloodfat_input extends Activity
{
    private Button btnSubmit;
    private ImageView imaBack_home,imaReturn;
    private EditText edtTC,edtLDL_C,edtHDL_C,edtTG;
    private TextView txtTitle,txtTC,txtLDL_C,txtHDL_C,txtTG;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.bloodfat_input);
        btnSubmit=(Button)findViewById(R.id.button1);
        edtTC=(EditText)findViewById(R.id.editText1);
        edtLDL_C=(EditText)findViewById(R.id.editText2);
        edtHDL_C=(EditText)findViewById(R.id.editText3);
        edtTG=(EditText)findViewById(R.id.editText4);
        txtTitle=(TextView)findViewById(R.id.txtTitle);
        imaBack_home=(ImageView)findViewById(R.id.backHome);
        imaBack_home.setImageResource(R.drawable.pic_1);
        imaReturn=(ImageView)findViewById(R.id.imgReturn);
        imaReturn.setImageResource(R.drawable.pic_2);
        txtTitle.setText("输入指标");
        imaBack_home.setOnClickListener(new backHomeLis());
        imaReturn.setOnClickListener(new imgReturnLis());
        btnSubmit.setOnClickListener(btnSubmitOnClick);

    }
    public boolean Judge(Editable e,String s,float low,float high)
    {
        if(e.toString().length()!=0)
        {
            if(Float.parseFloat(e.toString())<low || Float.parseFloat(e.toString())>high)
            {
                Toast.makeText(bloodfat_input.this, s+"指标大小必须在"+String.valueOf(low)+"~"+String.valueOf(high)+"之间", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }
    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(bloodfat_input.this, MainActivity.class);
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
    private Button.OnClickListener btnSubmitOnClick=new Button.OnClickListener() {

        public void onClick(View arg0){
            // TODO Auto-generated method stub
            if(edtTC.getText().toString().length()==0&&edtLDL_C.getText().toString().length()==0&&edtHDL_C.getText().toString().length()==0&&edtTG.getText().toString().length()==0)
            {
                Toast.makeText(bloodfat_input.this, "请至少输入一项指标", Toast.LENGTH_LONG).show();
            }

            else{
                if(Judge(edtTC.getText(),"胆固醇",0,15)&&Judge(edtLDL_C.getText(),"低密度脂蛋白胆固醇",0,20)&&Judge(edtHDL_C.getText(),"高密度脂蛋白胆固醇",0,15)&&Judge(edtTG.getText(),"甘油三酯",0,10))
                {
                    if(edtTC.getText().toString().length()==0||edtLDL_C.getText().toString().length()==0||edtHDL_C.getText().toString().length()==0||edtTG.getText().toString().length()==0)
                    {
                        AlertDialog.Builder altDialog=new AlertDialog.Builder(bloodfat_input.this);
                        altDialog.setTitle("消息提示");
                        altDialog.setMessage("您还有未输入的指标，继续则只能进行局部测评，是否继续？");
                        altDialog.setIcon(android.R.drawable.ic_dialog_info);
                        altDialog.setCancelable(false);

                        altDialog.setPositiveButton("是", new DialogInterface.OnClickListener()
                        {

                            public void onClick(DialogInterface arg0, int arg1)
                            {
                                // TODO Auto-generated method stub
                                String s1=edtTC.getText().toString();
                                String s2=edtLDL_C.getText().toString();
                                String s3=edtHDL_C.getText().toString();
                                String s4=edtTG.getText().toString();
                                Intent it=new Intent();
                                it.putExtra("TC",s1);
                                it.putExtra("LDL_C",s2);
                                it.putExtra("HDL_C",s3);
                                it.putExtra("TG", s4);
                                it.setClass(bloodfat_input.this, bloodfat_assess.class);
                                startActivity(it);

                            }
                        });
                        altDialog.setNegativeButton("否",new DialogInterface.OnClickListener()
                        {

                            public void onClick(DialogInterface arg0, int arg1)
                            {
                                // TODO Auto-generated method stub

                            }
                        });
                        altDialog.show();

                    }
                    else
                    {
                        String s1=edtTC.getText().toString();
                        String s2=edtLDL_C.getText().toString();
                        String s3=edtHDL_C.getText().toString();
                        String s4=edtTG.getText().toString();
                        Intent it=new Intent();
                        it.putExtra("TC",s1);
                        it.putExtra("LDL_C",s2);
                        it.putExtra("HDL_C",s3);
                        it.putExtra("TG", s4);
                        it.setClass(bloodfat_input.this, bloodfat_assess.class);
                        startActivity(it);

                    }
                }
            }
        };
    };
}
