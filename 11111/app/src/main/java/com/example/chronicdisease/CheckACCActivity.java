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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chronicdisease.base_elestical.BloodPressure;

import org.w3c.dom.Text;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class CheckACCActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<String> selected = new ArrayList<>();
    //ArrayList<Integer> selected_position = new ArrayList<>();
    private TextView num_of_ACCTxv;
    private Context context;
    private ListView lv;
    private TextView txtTitle;
    private ImageView imgReturn,imgGonext;
    private int pressure_level;
    private int num_of_danger;
    private boolean TOD;
    private boolean Diabetes;
    private boolean ACC;
    private Intent it = new Intent();
    public boolean isACC() {
        return ACC;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_acc);
        imgGonext=(ImageView) findViewById(R.id.imgGonext);
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        imgGonext.setOnClickListener(new Gonext());
        imgReturn.setOnClickListener(new imgReturnLis());
        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText("ACC");
        final String[] mItems4 = {"脑血管疾病","心脏疾病","肾脏疾病","外周血管疾病",
                "视网膜病变"};
        lv = (ListView) findViewById(R.id.ACC_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.check_acc_item,mItems4);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setOnItemClickListener(this);
        num_of_ACCTxv = findViewById(R.id.num_of_ACCTxv);  //must below the setContentView
        num_of_ACCTxv.setText(selected.size() + "");
        Intent get=getIntent();
        pressure_level=get.getIntExtra("pressure_level",0);
        num_of_danger=get.getIntExtra("num_of_danger",0);
        TOD=get.getBooleanExtra("TOD",false);
        Diabetes = get.getBooleanExtra("Diabetes",false);
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        num_of_ACCTxv = findViewById(R.id.num_of_ACCTxv);
        TextView txv = (TextView) view;
        String item = txv.getText().toString();
        if (selected.contains(item)) {
            selected.remove(item);
        } else {
            selected.add(item);
        }
        if (selected.size() > 0) {
            num_of_ACCTxv.setText(selected.size() + "");
            ACC = true;
        }
        else{
            num_of_ACCTxv.setText("0");
            ACC=false;
        }

    }
    class Gonext implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            it.setClass(CheckACCActivity.this, ShowResultActivity.class);
            it.putExtra("pressure_level", pressure_level);
            it.putExtra("num_of_danger", num_of_danger);
            it.putExtra("TOD", TOD);
            it.putExtra("Diabetes", Diabetes);
            it.putExtra("ACC", ACC);
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
