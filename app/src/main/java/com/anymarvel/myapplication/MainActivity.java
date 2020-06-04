package com.anymarvel.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anymarvel.myapplication.storyboard.StoryBoardActivity;


public class MainActivity extends Activity {
    Button button;
    Button myImageText;
    Button storyboardLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.ui_test);
        myImageText = findViewById(R.id.myImageText);
        storyboardLayout=findViewById(R.id.storyboard);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UIActivity.class);
                startActivity(intent);
            }
        });
        myImageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyImageTextActivity.class);
                startActivity(intent);
            }
        });
        storyboardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StoryBoardActivity.class);
                startActivity(intent);
            }
        });
    }
}
