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

import java.util.ArrayList;
import java.util.List;

public class CheckPressLevelActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<String> selected = new ArrayList<>();
    //ArrayList<Integer> selected_position = new ArrayList<>();
    private Context context;
    private Button go_num_of_danger;
    private int num_of_danger;
    private int pressure_level;
    private Intent it = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_press_level);
        final String[] mItems5 = {"一级","二级","三级"};
        ListView lv = (ListView) findViewById(R.id.pressure_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.pressure_level_item,mItems5);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);
        go_num_of_danger=findViewById(R.id.go_num_of_danger);
        it.setClass(this, CheckTOActivity.class);
        go_num_of_danger.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                it.putExtra("pressure_level",pressure_level);
                startActivity(it);
            }
        });
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView txv = (TextView) view;
        String item = txv.getText().toString();
        if(item=="一级")
            pressure_level=1;
        else if (item == "二级")
            pressure_level=2;
        else pressure_level=3;
    }
}
