package com.bjb.speaker.activity;

import android.view.View;
import android.widget.Button;

import com.bjb.speaker.R;
import com.bjb.speaker.view.IndicatorView;
import com.bjb.speaker.view.Xcircleindicator;

public class TestActivity extends BaseActivity implements View.OnClickListener{
    private Button bt1,bt2,bt3;
    private IndicatorView indicatorView;
    private Xcircleindicator xcircleindicator;

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_test);
    }

    @Override
    public void initViews() {
        bt1= (Button) findViewById(R.id.button);
        bt2= (Button) findViewById(R.id.button2);
        bt3= (Button) findViewById(R.id.button3);
        indicatorView= (IndicatorView) findViewById(R.id.test_indicator);
        xcircleindicator= (Xcircleindicator) findViewById(R.id.test_Xcircleindicator);
    }

    @Override
    public void initData() {
        xcircleindicator.initData(5, 0);
        xcircleindicator.setCurrentPage(0);
    }

    @Override
    public void initEvent() {
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                xcircleindicator.setCurrentPage(1);
                break;
            case R.id.button2:
                xcircleindicator.setCurrentPage(2);
                break;
            case R.id.button3:
                xcircleindicator.setCurrentPage(3);
                break;
        }
    }
}
