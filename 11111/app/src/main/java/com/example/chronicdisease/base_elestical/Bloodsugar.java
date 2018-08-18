package com.example.chronicdisease.base_elestical;

import com.example.chronicdisease.MainActivity;
import com.example.chronicdisease.MyApp;
import com.example.chronicdisease.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Bloodsugar extends Activity {
    private Button btnSubmit56;
    private ImageView imaReturn;
    private EditText edtBMP,edtATH;
    private TextView result,txtTitle,imaBack_home;
    private float BMP,ATH;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.bloodsugar);
        btnSubmit56=(Button)findViewById(R.id.suagribtn1);
        edtBMP=(EditText)findViewById(R.id.sugareditText1);
        edtATH=(EditText)findViewById(R.id.sugareditText2);
        result=(TextView)findViewById(R.id.sugarresult1);
        imaBack_home=(TextView) findViewById(R.id.backHome);
        //imaBack_home.setImageResource(R.drawable.pic_1);
        imaReturn =(ImageView)findViewById(R.id.imgReturn);
        imaReturn.setImageResource(R.drawable.gonext);
        txtTitle=(TextView)findViewById(R.id.txtTitle);
        txtTitle.setText("血糖检测");
        btnSubmit56.setOnClickListener(btnSubmitOnClick);
        imaBack_home.setOnClickListener(new backHomeLis());
        imaReturn.setOnClickListener(new imgReturnLis());

    }
    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(Bloodsugar.this, MainActivity.class);
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
    private Button.OnClickListener btnSubmitOnClick=new Button.OnClickListener()
    {

        public void onClick(View arg0)
        {
            if(edtBMP.getText().toString().length()==0&&edtATH.getText().toString().length()==0)
            {
                Toast.makeText(Bloodsugar.this, "请至少输入一项指标", Toast.LENGTH_LONG).show();
            }
            else
            {
                if(edtBMP.getText().toString().length()==0||edtATH.getText().toString().length()==0)
                {
                    AlertDialog.Builder altDialog=new AlertDialog.Builder(Bloodsugar.this);
                    altDialog.setTitle("消息提示");
                    altDialog.setMessage("您输入了一项指标，是否继续？");
                    altDialog.setIcon(android.R.drawable.ic_dialog_info);
                    altDialog.setCancelable(false);

                    altDialog.setPositiveButton("是", new DialogInterface.OnClickListener()
                    {

                        public void onClick(DialogInterface arg0, int arg1)
                        {
                            if (edtBMP.getText().toString().length()==0&&edtATH.getText().toString().length()!=0)
                            {
                                ATH=Float.parseFloat(edtATH.getText().toString());
                                if (ATH<0f||ATH>20f)
                                    Toast.makeText(Bloodsugar.this, "输入的数值过于离谱！", Toast.LENGTH_LONG).show();
                                else if (ATH<7.8f)
                                    result.setText("正常范围！");
                                else if (ATH<11.1f)
                                    result.setText("IGT糖耐量降低！");
                                else
                                    result.setText("您患有糖尿病！");
                            }
                            else
                            {
                                BMP=Float.parseFloat(edtBMP.getText().toString());
                                if (BMP<0f||BMP>20f)
                                    result.setText("您输入的数值过于离谱！");
                                else if (BMP<6.1f)
                                    result.setText("正常范围！");
                                else if (BMP<7.0f)
                                    result.setText("IFG空腹血糖受损！");
                                else
                                    result.setText("您患有糖尿病！");
                            }
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
                else if (edtBMP.getText().toString().length()!=0&&edtATH.getText().toString().length()!=0)
                {
                    BMP=Float.parseFloat(edtBMP.getText().toString());
                    ATH=Float.parseFloat(edtATH.getText().toString());
                    if (ATH<0f||ATH>20f||BMP<0f||BMP>20f)
                        Toast.makeText(Bloodsugar.this, "输入的数值过于离谱！", Toast.LENGTH_LONG).show();
                    if (BMP>=7.0f||ATH>=11.1f)
                        result.setText("您患有糖尿病！");
                    else if  ((BMP>=6.1f&&BMP<=7.0f)&&(ATH>=7.8f&&ATH<=11.1f))
                        result.setText("空腹血糖受损与糖耐量降低并存！");
                    else if ((BMP<6.1f)&&(ATH>=7.8f&&ATH<=11.1f))
                        result.setText("IGT糖耐压降低！");
                    else if ((BMP>=6.1f&&BMP<=7.0f)&&(ATH<7.8f))
                        result.setText("IFG空腹血糖受损！");
                    else if ((BMP<6.1f)&&(ATH<7.8f))
                        result.setText("正常范围！");
                    else
                        result.setText("输入数值错误！");
                }
            };
        };
    };
};
