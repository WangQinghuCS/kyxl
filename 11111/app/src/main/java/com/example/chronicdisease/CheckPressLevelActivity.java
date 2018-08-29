package com.example.chronicdisease;

import android.app.Activity;
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

import java.util.ArrayList;
import java.util.List;

public class CheckPressLevelActivity extends Activity implements AdapterView.OnItemClickListener {
    ArrayList<String> selected = new ArrayList<>();
    //ArrayList<Integer> selected_position = new ArrayList<>();
    private Context context;
    private int num_of_danger;
    private int pressure_level;
    private TextView txtTitle,backHome;
    private ImageView imgReturn,imgGonext;
    private Intent it = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_press_level);
        imgGonext=(ImageView) findViewById(R.id.imgGonext);
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        imgGonext.setOnClickListener(new Gonext());
        imgReturn.setOnClickListener(new imgReturnLis());
        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText("血压等级");
        backHome = findViewById(R.id.backHome);
        backHome.setOnClickListener(new backHomeLis());
        final String[] mItems5 = {"一级","二级","三级"};
        ListView lv = (ListView) findViewById(R.id.pressure_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.pressure_level_item,mItems5);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);

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
    class Gonext implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            it.setClass(CheckPressLevelActivity.this, NumOfDangerActivity.class);
            it.putExtra("pressure_level",pressure_level);
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
    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(CheckPressLevelActivity.this, MainActivity.class);
            startActivity(it);
        }

    }
}
