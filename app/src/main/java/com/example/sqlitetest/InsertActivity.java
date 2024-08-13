package com.example.sqlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.sqlitetest.bean.Student;
import com.example.sqlitetest.util.ToastUtil;

public class InsertActivity extends AppCompatActivity {

    private EditText etName,etNumber,etScore;
    private RadioButton rbMan,rbWoman;

    private SQLiteOH sqLiteOH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        initView();
        sqLiteOH = new SQLiteOH(this);
    }

    private void initView() {
        etName = findViewById(R.id.et_name);
        etNumber = findViewById(R.id.et_number);
        etScore = findViewById(R.id.et_score);
        rbMan = findViewById(R.id.rb_man);
        rbWoman = findViewById(R.id.rb_woman);
    }

    public void insert(View view) {
        String name = etName.getText().toString().trim();
        String number = etNumber.getText().toString().trim();
        String score = etScore.getText().toString().trim();
        String gender = "";

        if(rbMan.isChecked()){
            gender = "男";
        }
        if(rbWoman.isChecked()){
            gender = "女";
        }

        Student student = new Student();
        student.setName(name);
        student.setNumber(number);
        student.setGender(gender);
        student.setScore(score);

        long rowId = sqLiteOH.insertData(student);
        if(rowId != -1){
//            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
            ToastUtil.toastShort(this,"添加成功");
        }else {
//            Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
            ToastUtil.toastShort(this,"添加失败");
        }
    }
}