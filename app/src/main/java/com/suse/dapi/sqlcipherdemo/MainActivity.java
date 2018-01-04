package com.suse.dapi.sqlcipherdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.activeandroid.Model;
import com.activeandroid.query.From;
import com.activeandroid.query.Select;
import com.activeandroid.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_fun1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNew();
            }
        });

        findViewById(R.id.btn_fun2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findAll();
            }
        });
        messageTextView = (TextView) findViewById(R.id.tv_message);
    }

    private void findAll() {
        List<User> models = new Select().from(User.class).execute();
        String result = "";
        for(User u : models){
            result += u.getName() + "  " + u.getNumber() +" /n ";
        }
        messageTextView.setText(result);
    }

    private void addNew() {
        User user = new User();
        user.setName("dapi");
        user.setNumber(String.valueOf(System.currentTimeMillis()));
        user.save();
        messageTextView.setText("添加成功");
    }

}
