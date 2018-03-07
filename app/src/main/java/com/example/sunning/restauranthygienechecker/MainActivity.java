package com.example.sunning.restauranthygienechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runnable runnable=new Runnable(){//新建一个线程
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                intent.setAction("com.iStudy.Study.Main");
                startActivity(intent);
                finish();
            }
        };

        Handler handler = new Handler();
        handler.postDelayed(runnable, 1500);
    }
}
