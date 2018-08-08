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

public class CheckTOActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<String> selected = new ArrayList<>();
    //ArrayList<Integer> selected_position = new ArrayList<>();
    private TextView num_of_TODTxv;
    private Context context;
    private ListView lv;
    private Button go_diabetes;
    private boolean TOD;
    private Intent it = new Intent();
    private int pressure_level;
    private int num_of_danger;

    public boolean isTOD() {
        return TOD;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_to);
        final String[] mItems2 = {"左心室肥厚","动脉壁增厚","血清肌酐轻度升高","微量白蛋白尿",
                "早发心血管疾病家族史","腹型肥胖或肥胖",};
        lv = (ListView) findViewById(R.id.TOD_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.check_tod_item,mItems2);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setOnItemClickListener(this);
        num_of_TODTxv = findViewById(R.id.num_of_TODTxv);  //must below the setContentView
        num_of_TODTxv.setText(selected.size() + "");
        go_diabetes=findViewById(R.id.go_diabetes);
        Intent get=getIntent();
        pressure_level=get.getIntExtra("pressure_level",0);
        num_of_danger=get.getIntExtra("num_of_danger",0);
        it.setClass(this, CheckDiabetesActivity.class);

        go_diabetes.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                it.putExtra("pressure_level", pressure_level);
                it.putExtra("num_of_danger", num_of_danger);
                it.putExtra("TOD", TOD);
                startActivity(it);
            }
        });
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        num_of_TODTxv = findViewById(R.id.num_of_TODTxv);
        TextView txv = (TextView) view;
        String item = txv.getText().toString();
        if (selected.contains(item)) {
            selected.remove(item);
        } else {
            selected.add(item);
        }
        if (selected.size() > 0) {
            num_of_TODTxv.setText(selected.size() + "");
            TOD = true;
        }
        else {
            num_of_TODTxv.setText("0");
            TOD = false;
        }
    }

}
