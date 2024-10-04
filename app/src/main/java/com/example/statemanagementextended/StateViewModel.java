package com.example.statemanagementextended;

import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel {
    private int number = 0;
    private boolean checkBox = false;
    private boolean switch1 = false;

    public int getNumber(){
        return number;
    }
    public void incrementNumber(){
        number++;
    }
    public boolean getCheckBox(){
        return checkBox;
    }
    public void setCheckBox(boolean checkBox){
        this.checkBox = checkBox;
    }
    public boolean getSwitch(){
        return switch1;
    }
    public void setSwitch(boolean switch1) {
        this.switch1 = switch1;
    }
}
