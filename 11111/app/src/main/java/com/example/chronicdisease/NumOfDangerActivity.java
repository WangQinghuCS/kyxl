package com.example.chronicdisease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chronicdisease.base_elestical.BloodPressure;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NumOfDangerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<String> selected = new ArrayList<>();
    private TextView num_of_factor_txv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_of_danger);
        ListView lv = (ListView) findViewById(R.id.danger_factor_lv);
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
    @Override

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
