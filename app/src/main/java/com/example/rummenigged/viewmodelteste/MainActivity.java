package com.example.rummenigged.viewmodelteste;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private ImageView ivAndroid;
    private SeekBar seekBarR;
    private SeekBar seekBarG;
    private SeekBar seekBarB;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Observer<Integer> colorChangeObserver = integer -> ivAndroid.setColorFilter(viewModel.getColor());

        viewModel.getR().observe(this, colorChangeObserver);
        viewModel.getG().observe(this, colorChangeObserver);
        viewModel.getB().observe(this, colorChangeObserver);
    }

    private void setUI(){
        ivAndroid = findViewById(R.id.iv_android);
        seekBarR = findViewById(R.id.seekBarR);
        seekBarG = findViewById(R.id.seekBarG);
        seekBarB = findViewById(R.id.seekBarB);

        seekBarR.setOnSeekBarChangeListener(this);
        seekBarG.setOnSeekBarChangeListener(this);
        seekBarB.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()){
            case R.id.seekBarR:
                Log.d("MainActivity","R = " + i * 10);
                viewModel.setR(i * 10);
            break;

            case R.id.seekBarG:
                Log.d("MainActivity","G = " + i * 10);
                viewModel.setG(i * 10);
            break;

            case R.id.seekBarB:
                Log.d("MainActivity","B = " + i * 10);
                viewModel.setB(i * 10);
            break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
