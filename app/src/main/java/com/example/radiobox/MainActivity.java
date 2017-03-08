package com.example.radiobox;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;

public class MainActivity extends Activity implements OnCheckedChangeListener, OnClickListener, RadioGroup.OnCheckedChangeListener {


    CheckBox cb01, cb02, cb03;
    RadioGroup radioGroup;
    RadioButton rd01, rd02, rd03;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rd01 = (RadioButton) findViewById(R.id.radio0);
        rd02 = (RadioButton) findViewById(R.id.radio1);
        rd03 = (RadioButton) findViewById(R.id.radio2);

        cb01 = (CheckBox) findViewById(R.id.checkBox1);
        cb02 = (CheckBox) findViewById(R.id.checkBox2);
        cb03 = (CheckBox) findViewById(R.id.checkBox3);

        tv = (TextView) findViewById(R.id.textView1);

        cb01.setOnClickListener(this);
        cb02.setOnClickListener(this);
        cb03.setOnClickListener(this);
        cb01.setOnCheckedChangeListener(this);
        cb02.setOnCheckedChangeListener(this);
        cb03.setOnCheckedChangeListener(this);

        radioGroup.setOnCheckedChangeListener(this);
    }

    ArrayList<String> data = new ArrayList<String>();

    @Override
    public void onClick(View v) {

        //v相当于控件对象，所以
        CheckBox cb = (CheckBox) v;
        //获取checkbox里的文本字符串内容
        String text = cb.getText().toString();
        //检查链表
        checkList(text);
        Log.d("Tag", data.toString());
        tv.setText("身份：");
        //将链表对象添加到tx里面,链表遍历
        for (int i = 0; i < data.size(); i++) {
            tv.append(data.get(i));
        }

    }

    private void checkList(String text) {
        //对链表进行遍历
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(text)) {
                data.remove(i);
                return;       //这里return不可少，删除对象时用。
            }
        }
        data.add(text);
    }

//	不能用StringBuffer,只是检查状态的改变---
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (buttonView.getId() == R.id.checkBox1) {
            Toast.makeText(MainActivity.this, "check1 = " + isChecked, Toast.LENGTH_SHORT).show();
        } else if (buttonView.getId() == R.id.checkBox2) {
            Toast.makeText(MainActivity.this, "check2 = " + isChecked, Toast.LENGTH_SHORT).show();

        } else if (buttonView.getId() == R.id.checkBox3) {
            Toast.makeText(MainActivity.this, "check3 = " + isChecked, Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i == rd01.getId()){
            String text = rd01.getText().toString();
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }else if(i == rd02.getId()){
            Toast.makeText(this, "女", Toast.LENGTH_SHORT).show();
        }else if(i == R.id.radio2){
            Toast.makeText(this, "保密", Toast.LENGTH_SHORT).show();
        }
    }
}