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

import com.example.chronicdisease.base_elestical.BaseElestical;
import com.example.chronicdisease.base_elestical.BloodPressure;

import org.w3c.dom.Text;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class CheckTOActivity extends Activity implements AdapterView.OnItemClickListener {
    ArrayList<String> selected = new ArrayList<>();
    //ArrayList<Integer> selected_position = new ArrayList<>();
    private TextView num_of_TODTxv;
    private Context context;
    private ListView lv;
    private TextView txtTitle,backHome,base1,yuhou1;
    private ImageView imgReturn,imgGonext;
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
        imgGonext=(ImageView) findViewById(R.id.imgGonext);
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        base1=(TextView) findViewById(R.id.base1);
        yuhou1=(TextView) findViewById(R.id.yuhou1);
        imgGonext.setOnClickListener(new Gonext());
        imgReturn.setOnClickListener(new imgReturnLis());
        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText("TOD");
        backHome = findViewById(R.id.backHome);
        backHome.setOnClickListener(new backHomeLis());
        base1.setOnClickListener(new base1Lis());
        yuhou1.setOnClickListener(new yuhou1Lis());
        final String[] mItems2 = {"左心室肥厚","动脉壁增厚","血清肌酐轻度升高","微量白蛋白尿",
                "早发心血管疾病家族史","腹型肥胖或肥胖",};
        lv = (ListView) findViewById(R.id.TOD_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.check_tod_item,mItems2);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setOnItemClickListener(this);
        num_of_TODTxv = findViewById(R.id.num_of_TODTxv);  //must below the setContentView
        num_of_TODTxv.setText(selected.size() + "");
        Intent get=getIntent();
        pressure_level=get.getIntExtra("pressure_level",0);
        num_of_danger=get.getIntExtra("num_of_danger",0);
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
    class Gonext implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            it.setClass(CheckTOActivity.this, CheckDiabetesActivity.class);
            it.putExtra("pressure_level", pressure_level);
            it.putExtra("num_of_danger", num_of_danger);
            it.putExtra("TOD", TOD);
            startActivity(it);
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
            it.setClass(CheckTOActivity.this, MainActivity.class);
            startActivity(it);
        }

    }
    class base1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(CheckTOActivity.this, BaseElestical.class);
            startActivity(it);
        }

    }
    class yuhou1Lis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(CheckTOActivity.this, CheckPressLevelActivity.class);
            startActivity(it);
        }

    }
}
