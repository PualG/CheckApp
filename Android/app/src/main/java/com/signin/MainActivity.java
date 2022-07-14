package com.signin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.signin.beans.Record;
import com.signin.dao.RecordDAO;
import com.signin.util.Location;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private TextView tv_time;
    private EditText edit_name;
    private EditText edit_temp;
    private EditText edit_location;
    private RadioButton radio_tempnormal;
    private RadioButton radio_tempnormal1;
    private EditText adit_temp1;
    private RadioButton radio_tempnormal2;
    private RadioButton radio_tempnormal3;
    private RadioButton radio_tempnormal4;
    private RadioButton radio_tempnormal5;
    private RadioButton radio_tempnormal6;
    private RadioButton radio_tempnormal61;
    private RadioButton radio_tempnormal62;
    private RadioButton radio_tempnormal63;
    private RadioButton radio_tempnormal7;
    private RadioButton radio_tempnormal72;
    private RadioButton radio_tempnormal71;
    private RadioButton radio_tempnormal8;
    private RadioButton radio_tempnormal81;
    private RadioButton radio_tempnormal82;
    private EditText adit_temp2;
    private EditText adit_temp3;
    private EditText adit_temp4;
    private EditText adit_temp5;
    private EditText adit_temp6;
    private EditText adit_temp7;
    private EditText adit_temp8;
    private EditText adit_temp9;

    private CheckBox check_agree;
    private CheckBox check_agree1;
    private CheckBox check_agree2;
    private CheckBox check_agree3;
    private CheckBox check_agree4;
    private List<CheckBox> checkBoxList = new ArrayList<CheckBox>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_time = findViewById(R.id.tv_time);
        EditText edit_name = findViewById(R.id.edit_name);
        EditText edit_temp = findViewById(R.id.edit_temp);
        EditText edit_temp1 = (EditText) findViewById(R.id.edit_temp1);
        EditText edit_temp2 = (EditText) findViewById(R.id.edit_temp2);
        EditText edit_temp3 = (EditText) findViewById(R.id.edit_temp3);
        EditText edit_temp4 = (EditText) findViewById(R.id.edit_temp4);
        EditText edit_temp5 = (EditText) findViewById(R.id.edit_temp5);
        EditText edit_temp6 = (EditText) findViewById(R.id.edit_temp6);
        EditText edit_temp7 = (EditText) findViewById(R.id.edit_temp7);
        //EditText edit_temp8 = (EditText) findViewById(R.id.edit_temp8);
        //EditText edit_temp9 = (EditText) findViewById(R.id.edit_temp9);

        edit_location = findViewById(R.id.edit_location);
        radio_tempnormal = findViewById(R.id.radio_tempnormal);
        radio_tempnormal1 = findViewById(R.id.radio_tempnormal1);
        radio_tempnormal2 = findViewById(R.id.radio_tempnormal2);
        radio_tempnormal3 = findViewById(R.id.radio_tempnormal3);
        radio_tempnormal4 = findViewById(R.id.radio_tempnormal4);
        radio_tempnormal5 = findViewById(R.id.radio_tempnormal5);
        radio_tempnormal6 = findViewById(R.id.radio_tempnormal6);
        radio_tempnormal61 = findViewById(R.id.radio_tempnormal61);
        radio_tempnormal62 = findViewById(R.id.radio_tempnormal62);
        radio_tempnormal63 = findViewById(R.id.radio_tempnormal63);
        radio_tempnormal7 = findViewById(R.id.radio_tempnormal7);
        radio_tempnormal71 = findViewById(R.id.radio_tempnormal71);
        radio_tempnormal72 = findViewById(R.id.radio_tempnormal72);
        radio_tempnormal8 = findViewById(R.id.radio_tempnormal8);
        radio_tempnormal81 = findViewById(R.id.radio_tempnormal81);
        radio_tempnormal82 = findViewById(R.id.radio_tempnormal82);

        check_agree1 = findViewById(R.id.check_agree1);
        check_agree = findViewById(R.id.check_agree);
        check_agree2 = findViewById(R.id.check_agree2);
        check_agree3 = findViewById(R.id.check_agree3);
        check_agree4 = findViewById(R.id.check_agree4);

        checkBoxList.add(check_agree1);
        checkBoxList.add(check_agree2);
        checkBoxList.add(check_agree3);
        checkBoxList.add(check_agree4);

        check_agree1.setOnCheckedChangeListener(this);
        check_agree2.setOnCheckedChangeListener(this);
        check_agree3.setOnCheckedChangeListener(this);
        check_agree4.setOnCheckedChangeListener(this);
        Button btn_getlocation = findViewById(R.id.btn_getlocation);
        btn_getlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_location.setText(Location.getAddress(MainActivity.this));
            }
        });

        Button btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String date_time = tv_time.getText().toString();
                        String name = edit_name.getText().toString();
                        String temp = "正常";
                        if (!radio_tempnormal.isChecked()) {
                            temp = "有发热，体温为：" + edit_temp.getText();
                        }

                        String temp1 = "无";
                        if (!radio_tempnormal1.isChecked()) {
                            temp1 = "有，症状为：" + edit_temp1.getText();
                        }

                        String temp2 = "没有";
                        if (!radio_tempnormal2.isChecked()) {
                            temp2 = "有，接触情况为：" + edit_temp2.getText();
                        }

                        String temp3 = "没有";
                        if (!radio_tempnormal3.isChecked()) {
                            temp3 = "有，接触情况为：" + edit_temp3.getText();
                        }

                        String temp4 = "无";
                        if (!radio_tempnormal4.isChecked()) {
                            temp4 = "有" ;
                        }

                        String temp5 = "我现在在广东省广州市内（非学校内）";
                        if ((!radio_tempnormal5.isChecked())&&(radio_tempnormal6.isChecked())&&(!radio_tempnormal61.isChecked())&&(!radio_tempnormal62.isChecked())&&(!radio_tempnormal63.isChecked())){
                            temp5 = "我现在在广东省广州市内（学校内）" ;
                        }else if ((!radio_tempnormal5.isChecked())&&(!radio_tempnormal6.isChecked())&&(radio_tempnormal61.isChecked())&&(!radio_tempnormal62.isChecked())&&(!radio_tempnormal63.isChecked())) {
                                temp5 = "我现在在广东省内,具体是（写到地级市）"+ edit_temp5.getText();
                            }else if ((!radio_tempnormal5.isChecked())&&(!radio_tempnormal6.isChecked())&&(!radio_tempnormal61.isChecked())&&(radio_tempnormal62.isChecked())&&(!radio_tempnormal63.isChecked())) {
                                    temp5 = "我现在在广东省外,具体是（写到地级市）"+ edit_temp6.getText();
                                }else if ((!radio_tempnormal5.isChecked())&&(!radio_tempnormal6.isChecked())&&(!radio_tempnormal61.isChecked())&&(!radio_tempnormal62.isChecked())&&(radio_tempnormal63.isChecked())) {
                                        temp5 = "我于今天回到工作地（花都），车次/航班/客车车牌为："+ edit_temp7.getText();
                                    }



                        String temp6 = "绿码";
                        if ((!radio_tempnormal7.isChecked())&&(radio_tempnormal71.isChecked())&&(!radio_tempnormal72.isChecked())){
                            temp6 = "绿码带星" ;
                        }else {
                            if ((!radio_tempnormal7.isChecked())&&(!radio_tempnormal71.isChecked())&&(radio_tempnormal72.isChecked())) {
                                temp6 = "黄码";
                            }else {
                                if ((!radio_tempnormal7.isChecked())&&(!radio_tempnormal71.isChecked())&&(!radio_tempnormal72.isChecked())) {
                                    temp6 = "红码";
                                }}}

                       StringBuffer sb = new StringBuffer();
                       //遍历集合中的checkBox,判断是否选择，获取选中的文本
                       for (CheckBox checkbox : checkBoxList) {
                           if (checkbox.isChecked()){
                               sb.append(checkbox.getText().toString() + " ");
                           }
                       }
                        String temp9 = sb.toString();

                        String temp7 = "正常区域";
                        if ((!radio_tempnormal8.isChecked())&&(radio_tempnormal81.isChecked())&&(!radio_tempnormal82.isChecked())){
                            temp7 = "在封控区" ;
                        }else {
                            if ((!radio_tempnormal8.isChecked())&&(!radio_tempnormal81.isChecked())&&(radio_tempnormal82.isChecked())) {
                                temp7 = "在管控区";
                            }else {
                                if ((!radio_tempnormal8.isChecked())&&(!radio_tempnormal81.isChecked())&&(!radio_tempnormal82.isChecked())) {
                                    temp7 = "在防范区";
                                }}}

                        String temp8 = edit_temp4.getText().toString();
                        String location = edit_location.getText().toString();
                        Record record = new Record(date_time, name, temp, temp1, temp2, temp3, temp4, temp8, temp5,location, temp6,temp9, temp7);
                        RecordDAO recordDAO = new RecordDAO();
                        try {
                            Message msg = new Message();
                            int result = recordDAO.insert(record);
                            if (result > 0) {
                                msg.what = 1;
                            } else {
                                msg.what = 2;
                            }
                            handler.sendMessage(msg);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        //每秒更新一次时间
        new Timer().schedule(new TimerTask() {
            public void run() {
                Message msg = new Message();
                msg.what = 0;
                handler.sendMessage(msg);
            }
        }, 0, 1000);

        //获取定位权限
        Location.getLocationPermissions(MainActivity.this);
    }

    //刷新UI
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    tv_time.setText(simpleDateFormat.format(new Date()));
                    break;
                case 1:
                    Toast.makeText(MainActivity.this, "提交成功！", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(MainActivity.this, "提交失败！", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    });

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.check_agree1:
                if (check_agree1.isChecked() &&check_agree2.isChecked()){
                    check_agree3.setChecked(false);
                    check_agree4.setChecked(false);
                }
                else if (check_agree1.isChecked() &&check_agree3.isChecked()){
                    check_agree2.setChecked(false);
                    check_agree4.setChecked(false);
                }
                else if (check_agree1.isChecked() &&check_agree4.isChecked()){
                    check_agree3.setChecked(false);
                    check_agree2.setChecked(false);
                }
                break;
            case R.id.check_agree2:
                if (check_agree2.isChecked() &&check_agree3.isChecked()){
                    check_agree1.setChecked(false);
                    check_agree4.setChecked(false);
                }
                else if (check_agree2.isChecked() &&check_agree1.isChecked()){
                    check_agree3.setChecked(false);
                    check_agree4.setChecked(false);
                }
                else if (check_agree2.isChecked() &&check_agree4.isChecked()){
                    check_agree1.setChecked(false);
                    check_agree3.setChecked(false);
                }
                break;
            case R.id.check_agree4:
                if (check_agree4.isChecked() &&check_agree1.isChecked()){
                    check_agree2.setChecked(false);
                    check_agree3.setChecked(false);
                }
                else if (check_agree4.isChecked() &&check_agree2.isChecked()){
                    check_agree1.setChecked(false);
                    check_agree3.setChecked(false);
                }
                else if (check_agree4.isChecked() &&check_agree3.isChecked()){
                    check_agree1.setChecked(false);
                    check_agree2.setChecked(false);
                }
                break;
            case R.id.check_agree3:
                if (check_agree3.isChecked() &&check_agree1.isChecked()){
                    check_agree4.setChecked(false);
                    check_agree2.setChecked(false);
                }
                else if (check_agree3.isChecked() &&check_agree2.isChecked()){
                    check_agree1.setChecked(false);
                    check_agree4.setChecked(false);
                }
                else if (check_agree3.isChecked() &&check_agree4.isChecked()){
                    check_agree1.setChecked(false);
                    check_agree2.setChecked(false);
                }
                break;
            default:
                break;
        }
    }
}