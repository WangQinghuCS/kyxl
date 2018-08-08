package com.example.chronicdisease;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chronicdisease.base_elestical.BloodPressure;

import org.w3c.dom.Text;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class CheckDiabetesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<String> selected = new ArrayList<>();
    //ArrayList<Integer> selected_position = new ArrayList<>();
    private TextView num_of_diabetesTxv;
    private Context context;
    private ListView lv;
    private Button go_ACC;
    private int pressure_level;
    private int num_of_danger;
    private boolean TOD;
    private boolean Diabetes;
    private Intent it = new Intent();

    public boolean isDiabetes() {
        return Diabetes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_diabetes);
        final String[] mItems3 = {"空腹血糖≥7.0mmol/L","餐后血糖≥11.1mmol/L"};
        lv = (ListView) findViewById(R.id.diabetes_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.check_diabetes_item,mItems3);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setOnItemClickListener(this);
        num_of_diabetesTxv = findViewById(R.id.num_of_diabetesTxv);  //must below the setContentView
        num_of_diabetesTxv.setText(selected.size() + "");
        go_ACC=findViewById(R.id.go_ACC);
        Intent get=getIntent();
        pressure_level=get.getIntExtra("pressure_level",0);
        num_of_danger=get.getIntExtra("num_of_danger",0);
        TOD=get.getBooleanExtra("TOD",false);
        it.setClass(this, CheckACCActivity.class);
        go_ACC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                it.putExtra("pressure_level", pressure_level);
                it.putExtra("num_of_danger", num_of_danger);
                it.putExtra("TOD", TOD);
                it.putExtra("Diabetes", Diabetes);
                startActivity(it);
            }
        });
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        num_of_diabetesTxv = findViewById(R.id.num_of_diabetesTxv);
        TextView txv = (TextView) view;
        String item = txv.getText().toString();
        if (selected.contains(item)) {
            selected.remove(item);
        } else {
            selected.add(item);
        }
        if (selected.size() > 0) {
            num_of_diabetesTxv.setText(selected.size() + "");
            Diabetes = true;
        }
        else {
            num_of_diabetesTxv.setText("0");
            Diabetes = false;
        }
    }

}
