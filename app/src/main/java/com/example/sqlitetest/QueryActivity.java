package com.example.sqlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sqlitetest.bean.Student;
import com.example.sqlitetest.util.ToastUtil;

import java.util.List;

public class QueryActivity extends AppCompatActivity {

    private EditText etName;
    private SQLiteOH sqLiteOH;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        etName = findViewById(R.id.et_name);
        sqLiteOH = new SQLiteOH(this);
        tvResult = findViewById(R.id.tvResult);
    }

    public void query(View view) {
        String name = etName.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            List<Student> students= sqLiteOH.queryAllFromDb();
            showData(students);
            return;
        }
        List<Student> students= sqLiteOH.queryFromDbByName(name);
        showData(students);
    }

    public void showData(List<Student> students){
//        String result = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (Student stu: students) {
            stringBuilder.append("姓名:");
            stringBuilder.append(stu.getName());
            stringBuilder.append("学号:");
            stringBuilder.append(stu.getNumber());
            stringBuilder.append("性别:");
            stringBuilder.append(stu.getGender());
            stringBuilder.append("分数:");
            stringBuilder.append(stu.getScore()+"\n");
//            result += "姓名:"+stu.getName()+"学号:"+stu.getNumber()+"性别:"+stu.getGender()+"分数:"+stu.getScore()+"\n";
        }
//        tvResult.setText(result);
        if(TextUtils.isEmpty(stringBuilder)){
            ToastUtil.toastShort(this,"查询失败");
        }else {
            ToastUtil.toastShort(this,"查询成功");
        tvResult.setText(stringBuilder.toString());
        }
    }
}