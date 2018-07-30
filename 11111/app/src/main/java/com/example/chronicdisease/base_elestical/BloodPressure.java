package com.example.chronicdisease.base_elestical;

import com.example.chronicdisease.MainActivity;
import com.example.chronicdisease.MyApp;
import com.example.chronicdisease.NumOfDangerActivity;
import com.example.chronicdisease.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BloodPressure extends Activity {
    private EditText edtSBP, edtDBP;
    private TextView txtSBP,txtDBP,txtType,txtTitle;
    private String strtype;
    private ImageView backHome;
    private ImageView imgReturn;
    private Button btnSubmit,pressure_continue;
    private boolean order=false;
    private boolean danger_flag=false;
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.activity_bloodpressure);
        backHome=(ImageView)findViewById(R.id.backHome);
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        backHome.setImageResource(R.drawable.pic_1);
        imgReturn.setImageResource(R.drawable.pic_2);
        edtSBP = (EditText) findViewById(R.id.edtSBP);
        edtDBP = (EditText) findViewById(R.id.edtDBP);
        txtSBP=(TextView)findViewById(R.id.txtSBP);
        txtDBP=(TextView)findViewById(R.id.txtDBP);
        txtType=(TextView)findViewById(R.id.txtType);
        txtTitle=(TextView)findViewById(R.id.txtTitle);
        txtTitle.setText("血压评估");
        backHome.setOnClickListener(new backHomeLis());
        imgReturn.setOnClickListener(new imgReturnLis());
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        pressure_continue = (Button) findViewById(R.id.pressure_continue);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String sbp1 = edtSBP.getText().toString();
                String dbp1 = edtDBP.getText().toString();

                Pattern p = Pattern.compile("[0-9]*");
                Matcher m = p.matcher(sbp1);
                Matcher n = p.matcher(dbp1);
                if (m.matches()&&n.matches()){

                int sbpint=sbp1.length();
                int dbpint=dbp1.length();
                String strsbp=getString(R.string.promptSBP);
                String strdbp=getString(R.string.promptDBP);
                strtype=getString(R.string.promptType);
                if ((sbpint==0)|| (dbpint==0)) {

                    Toast.makeText(BloodPressure.this,
                            getString(R.string.promptInput),
                            Toast.LENGTH_LONG).show();

                }
                else {
                    //float sbp=Float.parseFloat(sbp1);
                    //float dbp=Float.parseFloat(dbp1);
                    int sbp=Integer.parseInt(sbp1);
                    int dbp=Integer.parseInt(dbp1);

                    if(sbp<30||sbp>260||dbp<30||dbp>260){
                        Toast.makeText(BloodPressure.this,
                                "抱歉，您输入的数据并不在常规范围内",
                                Toast.LENGTH_LONG).show();
                    }else{  /*
								if(sbp<=120&&dbp<=80)
									strtype+="  "+getString(R.string.regularPressure);
								if((sbp>120&&sbp<=139)||(dbp>80&&dbp<=89))
									strtype+="  "+getString(R.string.regularHighWorth);
								if((sbp>=140&&sbp<=159)||(dbp>=90&&dbp<=99))
									strtype+="  "+getString(R.string.fhypertension);
								if((sbp>=160&&sbp<=179)||(dbp>=100&&dbp<=109))
									strtype+="  "+getString(R.string.shypertension);
								if((sbp>=180)||(dbp>=110))
									strtype+="  "+getString(R.string.thypertension);
								*/

                        if((sbp>=180)||(dbp>=110)) {
                            strtype += "  " + getString(R.string.thypertension);
                            danger_flag = true;
                        }
                        else if((sbp>=160&&sbp<=179)||(dbp>=100&&dbp<=109)) {
                            strtype += "  " + getString(R.string.shypertension);
                            danger_flag = true;
                        }
                        else if((sbp>=140&&sbp<=159)||(dbp>=90&&dbp<=99)) {
                            strtype += "  " + getString(R.string.fhypertension);
                            danger_flag = true;
                        }
                        else if((sbp>120&&sbp<=139)||(dbp>80&&dbp<=89))
                            strtype+="  "+getString(R.string.regularHighWorth);
                        else if(sbp<=120&&dbp<=80)
                            strtype+="  "+getString(R.string.regularPressure);

                        if(sbp>=140&&dbp<90)
                            strtype+="  "+getString(R.string.sbpHypertension);
                        txtSBP.setText(strsbp+"  "+sbp);
                        txtDBP.setText(strdbp+"  "+dbp);
                        txtType.setText(strtype+"。 点击继续明确有无其他心血管疾病危险因素");

                    }}
                    order=true;
            }
            else{
                    Toast.makeText(BloodPressure.this,
                            getString(R.string.promptInput),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        final Intent it = new Intent();
        it.setClass(this, NumOfDangerActivity.class);
        pressure_continue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                if (order == true) {
                    order = false;
                    it.putExtra("dangerflag", danger_flag); 
                    startActivity(it);
                    danger_flag=false;
                }
                else{
                    Toast.makeText(BloodPressure.this,"请先测试血压", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(BloodPressure.this, MainActivity.class);
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
