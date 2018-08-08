package com.example.chronicdisease;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chronicdisease.base_elestical.BloodPressure;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NumOfDangerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<String> selected = new ArrayList<>();
    //ArrayList<Integer> selected_position = new ArrayList<>();
    private TextView num_of_factor_txv;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_of_danger);
        final String[] mItems1 = {"男性>55岁","女性＞65岁","吸烟","血脂异常",
                "早发心血管疾病家族史","腹型肥胖或肥胖",
                "缺乏体力活动","高敏C反应蛋白≥3mg/L或C反应蛋白≥10mg/L"};
        ListView lv = (ListView) findViewById(R.id.danger_factor_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.num_of_danger_item,mItems1);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setOnItemClickListener(this);
        Intent it = getIntent();
        boolean danger_flag = it.getBooleanExtra("dangerflag", false);
        //Toast.makeText(NumOfDangerActivity.this,danger_flag+"", Toast.LENGTH_SHORT).show();
        if (danger_flag) {
            selected.add("高血压");
        }
        num_of_factor_txv = findViewById(R.id.num_of_factorTxv);  //must below the setContentView
        num_of_factor_txv.setText(selected.size() + "");
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        num_of_factor_txv = findViewById(R.id.num_of_factorTxv);
        TextView txv = (TextView) view;
        //todo change the color of selected items
        String item = txv.getText().toString();
        if (selected.contains(item)) {
            selected.remove(item);
        } else {
            selected.add(item);
        }
        if (selected.size() > 0)
            num_of_factor_txv.setText(selected.size() + "");
        else
            num_of_factor_txv.setText("0");
    }
}
