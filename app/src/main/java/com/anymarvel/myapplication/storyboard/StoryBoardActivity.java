package com.anymarvel.myapplication.storyboard;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.anymarvel.myapplication.R;



public class StoryBoardActivity extends Activity implements View.OnClickListener {
    LadderLayout manhua;
    LadderLayout story;
    LadderLayout postcards;
    LadderLayout diagram;
    FrameLayout home_bottom;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ladderlayout);
        manhua = findViewById(R.id.ldder1);
        story = findViewById(R.id.ldder2);
        postcards = findViewById(R.id.ldder3);
        diagram = findViewById(R.id.ldder4);
        home_bottom = findViewById(R.id.home_bottom);
        manhua.setOnClickListener(this);
        story.setOnClickListener(this);
        postcards.setOnClickListener(this);
        diagram.setOnClickListener(this);
        home_bottom.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ldder1:

                break;
            case R.id.ldder2:

                break;
            case R.id.ldder3:

                break;
            case R.id.ldder4:

                break;
            case R.id.home_bottom:

                break;
            default:
                break;
        }
    }
}
