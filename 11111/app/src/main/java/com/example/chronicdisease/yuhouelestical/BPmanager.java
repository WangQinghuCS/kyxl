package com.example.chronicdisease.yuhouelestical;

import java.util.ArrayList;
import com.example.chronicdisease.MainActivity;
import com.example.chronicdisease.MyApp;
import com.example.chronicdisease.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

public class BPmanager extends Activity implements Runnable{
    private TextView txt01,txt02,txt03,txt04,txt05;
    private TextView txtTitle;
    private ImageView backHome;
    private ImageView imgReturn;
    private String Strlk=null;
    private int count1=0,count2=0,count3=0,count4=0;
    private int xueya=1;
    private static final int DIALOG_1 = 1;
    private static final int DIALOG_2 = 2;
    private static final int DIALOG_3 = 3;
    private static final int DIALOG_4 = 4;
    private static final int DIALOG_5 = 5;
    final String[] mItems1 = {"男性>55岁","女性＞65岁","吸烟","血脂异常",
            "早发心血管疾病家族史","腹型肥胖或肥胖",
            "缺乏体力活动","高敏C反应蛋白≥3mg/L或C反应蛋白≥10mg/L"};
    final String[] mItems2 = {"左心室肥厚","动脉壁增厚","血清肌酐轻度升高","微量白蛋白尿",
            "早发心血管疾病家族史","腹型肥胖或肥胖",};
    final String[] mItems3 = {"空腹血糖≥7.0mmol/L","餐后血糖≥11.1mmol/L"};
    final String[] mItems4 = {"脑血管疾病","心脏疾病","肾脏疾病","外周血管疾病",
            "视网膜病变"};
    final String[] mItems5 = {"血压正常","一级","二级","三级"};
    ArrayList <Integer>MultiChoiceID1 = new ArrayList <Integer>();
    ArrayList <Integer>MultiChoiceID2 = new ArrayList <Integer>();
    ArrayList <Integer>MultiChoiceID3 = new ArrayList <Integer>();
    ArrayList <Integer>MultiChoiceID4 = new ArrayList <Integer>();
    ArrayList <Integer>MultiChoiceID5 = new ArrayList <Integer>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.activity_lkbp);
        backHome=(ImageView)findViewById(R.id.backHome);
        imgReturn=(ImageView)findViewById(R.id.imgReturn);
        txtTitle=(TextView)findViewById(R.id.txtTitle);
        TextView Txt01 = (TextView)findViewById(R.id.Txt01);
        TextView Txt02 = (TextView)findViewById(R.id.Txt02);
        TextView Txt03 = (TextView)findViewById(R.id.Txt03);
        TextView Txt04 = (TextView)findViewById(R.id.Txt04);
        TextView Txt05 = (TextView)findViewById(R.id.Txt05);
        Button btn01=(Button)findViewById(R.id.btn01);
        backHome.setOnClickListener(new backHomeLis());
        imgReturn.setOnClickListener(new imgReturnLis());
        btn01.setOnClickListener(new btn01lis());
        Txt01.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CreatDialog1(DIALOG_1);
            }

        });
        Txt02.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CreatDialog2(DIALOG_2);
            }
        });
        Txt03.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CreatDialog3(DIALOG_3);
            }
        });
        Txt04.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CreatDialog4(DIALOG_4);
            }
        });
        Txt05.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CreatDialog5(DIALOG_5);
            }
        });

        txtTitle.setText("血压评估");

    }
    class btn01lis implements OnClickListener {
        public void onClick(View v) {
            // TODO Auto-generated method stub
            LK( count1, count2,count3, count4);
            TextView txt06=(TextView)findViewById(R.id.txt06);
            txt06.setText("评估结果为"+Strlk);
        }
    }


    public void CreatDialog1(int dialog1) {
        // TODO Auto-generated method stub
        AlertDialog.Builder builder1 = new AlertDialog.Builder(BPmanager.this);

        MultiChoiceID1.clear();
        count1=0;
        builder1.setIcon(R.drawable.ic_launcher_background    //这里改了一个图回头记得补上
        );
        builder1.setTitle("心血管疾病的危险因素");
        builder1.setMultiChoiceItems(mItems1,
                new boolean[]{false, false, false, false, false, false, false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton,
                                        boolean isChecked) {
                        if(isChecked) {
                            MultiChoiceID1.add(whichButton);
                            count1+=1;
                        }else {
                            MultiChoiceID1.remove(whichButton);
                        }
                    }
                });
        builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String str1="";
                int size = MultiChoiceID1.size();
                for (int i = 0 ;i < size; i++) {
                    str1+= mItems1[MultiChoiceID1.get(i)] + "  ";
                }
                TextView txt01=(TextView)findViewById(R.id.txt01);
                txt01.setText("您选择的是"+str1);
                ImageView ima01=(ImageView)findViewById(R.id.ima01);
                ima01.setVisibility(View.VISIBLE);
            }

        });
        builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder1.create().show();

    }

    public void CreatDialog2(int dialog2) {
        // TODO Auto-generated method stub
        AlertDialog.Builder builder2 = new AlertDialog.Builder(BPmanager.this);

        MultiChoiceID2.clear();
        count2=0;
        builder2.setIcon(R.drawable.ic_launcher_background   //这里改了一个图回头记得补上
        );
        builder2.setTitle("靶器官损害");
        builder2.setMultiChoiceItems(mItems2,
                new boolean[]{false, false, false, false, false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton,
                                        boolean isChecked) {
                        if(isChecked) {
                            MultiChoiceID2.add(whichButton);
                            count2+=1;
                        }else {
                            MultiChoiceID2.remove(whichButton);
                        }
                    }
                });
        builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String str2 = "";
                int size = MultiChoiceID2.size();
                for (int i = 0 ;i < size; i++) {
                    str2+= mItems2[MultiChoiceID2.get(i)] + "  ";
                }
                TextView txt02=(TextView)findViewById(R.id.txt02);
                txt02.setText("您选择的是"+str2);
                ImageView ima02=(ImageView)findViewById(R.id.ima02);
                ima02.setVisibility(View.VISIBLE);
            }
        });
        builder2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder2.create().show();
    }

    public void CreatDialog3(int dialog3) {
        // TODO Auto-generated method stub
        AlertDialog.Builder builder3 = new AlertDialog.Builder(BPmanager.this);

        MultiChoiceID3.clear();
        count3=0;
        builder3.setIcon(R.drawable.ic_launcher_background   //这里改了一个图回头记得补上
        );
        builder3.setTitle("糖尿病");
        builder3.setMultiChoiceItems(mItems3,
                new boolean[]{false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton,
                                        boolean isChecked) {
                        if(isChecked) {
                            MultiChoiceID3.add(whichButton);
                            count3+=1;
                        }else {
                            MultiChoiceID3.remove(whichButton);
                        }
                    }
                });
        builder3.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String str3 = "";
                int size = MultiChoiceID3.size();
                for (int i = 0 ;i < size; i++) {
                    str3+= mItems3[MultiChoiceID3.get(i)] + "  ";
                }
                TextView txt03=(TextView)findViewById(R.id.txt03);
                txt03.setText("您选择的是"+str3);
                ImageView ima03=(ImageView)findViewById(R.id.ima03);
                ima03.setVisibility(View.VISIBLE);
            }
        });
        builder3.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder3.create().show();
    }

    public void CreatDialog4(int dialog4) {
        // TODO Auto-generated method stub
        AlertDialog.Builder builder4 = new AlertDialog.Builder(BPmanager.this);

        MultiChoiceID4.clear();
        count4=0;
        builder4.setIcon(R.drawable.ic_launcher_background //这里改了一个图回头记得补上
        );
        builder4.setTitle("并存的临床情况");
        builder4.setMultiChoiceItems(mItems4,
                new boolean[]{false, false, false, false,false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton,
                                        boolean isChecked) {
                        if(isChecked) {
                            MultiChoiceID4.add(whichButton);
                            count4+=1;
                        }else {
                            MultiChoiceID4.remove(whichButton);
                        }
                    }
                });
        builder4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String str4 = "";
                int size = MultiChoiceID4.size();
                for (int i = 0 ;i < size; i++) {
                    str4+= mItems4[MultiChoiceID4.get(i)] + "  ";
                }
                TextView txt04=(TextView)findViewById(R.id.txt04);
                txt04.setText("您选择的是"+str4);
                ImageView ima04=(ImageView)findViewById(R.id.ima04);
                ima04.setVisibility(View.VISIBLE);
            }
        });
        builder4.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder4.create().show();
    }


    public void CreatDialog5(int dialog5) {
        // TODO Auto-generated method stub
        AlertDialog.Builder builder5 = new AlertDialog.Builder(BPmanager.this);


        MultiChoiceID5.clear();
        xueya=1;
        builder5.setIcon(R.drawable.ic_launcher_background   //这里改了一个图回头记得补上
        );
        builder5.setTitle("血压等级");
        builder5.setMultiChoiceItems(mItems5,
                new boolean[]{false, false, false, false, false, false, false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton,
                                        boolean isChecked) {
                        if(isChecked) {
                            MultiChoiceID5.add(whichButton);
                            xueya+=whichButton;
                        }else {
                            MultiChoiceID5.remove(whichButton);
                        }
                    }
                });
        builder5.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String str1="";
                int size = MultiChoiceID5.size();
                for (int i = 0 ;i < size; i++) {
                    str1+= mItems5[MultiChoiceID5.get(i)] + "  ";
                }
                TextView txt05=(TextView)findViewById(R.id.txt05);
                txt05.setText("您选择的是"+str1);
            }

        });
        builder5.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder5.create().show();

    }

    private void showDialog(String str) {
        new AlertDialog.Builder(BPmanager.this)
                .setMessage(str)
                .show();
    }

    public void run() {
        // TODO Auto-generated method stub

    }

    public String LK(int count1,int count2,int count3,int count4){
        if(count1==0&&count2==0&&count3==0&&count4==0&&xueya==1){
            Strlk="完全正常";
        }
        else if(count4>0){
            Strlk="很高危";
        }
        else if(count2>0||count3>0||count1>2){
            if(xueya==3){
                Strlk="很高危";
            }
            else
                Strlk="高危";
        }
        else if(count1==1||count1==2){
            if(xueya==3){
                Strlk="很高危";
            }
            else
                Strlk="中危";
        }
        else if(count1==0){
            switch(xueya){
                case 1:Strlk="低危";
                    break;
                case 2:Strlk="中危";
                    break;
                default:Strlk="高危";
                    break;
            }
        }
        return Strlk;
    }

    class backHomeLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent it=new Intent();
            it.setClass(BPmanager.this, MainActivity.class);
            startActivity(it);
        }
    }
    class imgReturnLis implements View.OnClickListener{

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
    }
}

