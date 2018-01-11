package com.example.rummenigged.viewmodelteste;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.graphics.Color;

/**
 * Created by rummenigged on 11/01/18.
 */

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> r = new MutableLiveData<>();
    private MutableLiveData<Integer> g = new MutableLiveData<>();
    private MutableLiveData<Integer> b = new MutableLiveData<>();

    public LiveData<Integer> getR() {
        return r;
    }

    public void setR(int r) {
        this.r.setValue(r);
    }

    public LiveData<Integer> getG() {
        return g;
    }

    public void setG(int g) {
        this.g.setValue(g);
    }

    public LiveData<Integer> getB() {
        return b;
    }

    public void setB(int b) {
        this.b.setValue(b);
    }

    public int getColor(){
        if (this.r.getValue() != null && this.g.getValue() != null && this.b.getValue() != null){
            return Color.rgb(this.r.getValue(), this.g.getValue(), this.b.getValue());
        }
        return Color.rgb(0,0,0);
    }
}
