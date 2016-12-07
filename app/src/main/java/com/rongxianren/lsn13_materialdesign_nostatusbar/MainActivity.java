package com.rongxianren.lsn13_materialdesign_nostatusbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) toolbar.getLayoutParams();
        System.out.println("--------params.height-1------ = " + params.height);
        int statusBarHeight = getStatusBarHeight();
//        params.height += statusBarHeight;
//        System.out.println("--------params.height------ = " + params.height);
//        toolbar.setLayoutParams(params);
        toolbar.setPadding(toolbar.getPaddingLeft(), toolbar.getPaddingTop() + statusBarHeight, toolbar.getPaddingRight(), 30);

    }

    private int getStatusBarHeight() {
        int height = 0;
        try {
//          Class<?> clazz = Class.forName("com.android.internal.R$dimen");
//          Object obj = clazz.newInstance();
//          String heightStr = clazz.getField("status_bar_height").get(obj).toString();

            height = getResources().getIdentifier("status_bar_height", "dimen", "android");
            height = getResources().getDimensionPixelSize(height);
            System.out.println("-----------statusBarHeight----------- = " + height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return height;
    }
}
