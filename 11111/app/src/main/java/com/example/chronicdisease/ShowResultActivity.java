package com.example.chronicdisease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowResultActivity extends AppCompatActivity {
    private int pressure_level;
    private int num_of_danger;
    private boolean TOD;
    private boolean Diabetes;
    private boolean ACC;
    private TextView pressure_level_resultTXV,num_of_danger_resultTxv,
            tod_resultTxv,diabetes_resultTxv,ACC_resultTxv,danger_levelTxv;
    private final String DangerLevel[] = {"低危", "中危", "高危", "很高危"};
    private int result_index;
    private TextView txtTitle;
    private ImageView imgReturn,imgGonext;
    private Intent it =  new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        imgGonext=(ImageView) findViewById(R.id.imgGonext);
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        imgGonext.setOnClickListener(new Gonext());
        imgReturn.setOnClickListener(new imgReturnLis());
        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText("结果");
        Intent get=getIntent();
        pressure_level=get.getIntExtra("pressure_level",0);
        num_of_danger=get.getIntExtra("num_of_danger",0);
        TOD=get.getBooleanExtra("TOD",false);
        Diabetes = get.getBooleanExtra("Diabetes",false);
        ACC = get.getBooleanExtra("ACC", ACC);
        pressure_level_resultTXV = findViewById(R.id.pressure_level_resultTxv);
        num_of_danger_resultTxv = findViewById(R.id.num_of_danger_resultTxv);
        tod_resultTxv = findViewById(R.id.tod_resultTxv);
        diabetes_resultTxv = findViewById(R.id.diabetes_resultTxv);
        ACC_resultTxv = findViewById(R.id.ACC_resultTxv);
        danger_levelTxv = findViewById(R.id.danger_levelTxv);
        //set text
        pressure_level_resultTXV.setText("血压等级为:" + pressure_level);
        num_of_danger_resultTxv.setText("危险因素个数为:" + num_of_danger);
        tod_resultTxv.setText("是否存在靶细胞损害:" + TOD);
        diabetes_resultTxv.setText("是否有糖尿病:" + Diabetes);
        ACC_resultTxv.setText("是否存在并发临床情况:" + ACC);
        //show danger_level
        if(ACC) result_index=3;
        else if(num_of_danger==0){
            switch (pressure_level) {
                case 1:result_index=0;
                break;
                case 2:result_index=1;
                break;
                case 3:result_index=2;
                break;
            }
        }
        else if (num_of_danger == 1 || num_of_danger == 2) {
            switch (pressure_level) {
                case 1:result_index=1;
                    break;
                case 2:result_index=1;
                    break;
                case 3:result_index=3;
                    break;
            }
        }
        else if(num_of_danger>=3||TOD||Diabetes){
            switch (pressure_level) {
                case 1:result_index=2;
                    break;
                case 2:result_index=2;
                    break;
                case 3:result_index=3;
                    break;
            }
        }
        danger_levelTxv.setText("危险等级为:"+DangerLevel[result_index]);


    }
    class Gonext implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            it.setClass(ShowResultActivity.this,CheckManageActivity.class);
            it.putExtra("level", result_index);
            Log.d("result_index",Integer.toString(result_index));
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
