package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {// to used for another entry
    private int Repetition;// the method is private
    private int Recovery;// private methods
    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int r,  int v) {
        super(n, d, m, y, h, min, s, dist);
        Repetition=r;
        Recovery=v;
    }

    public int getRepetitions(){
        if (Repetition==4)
            return Repetition;
        else
            return Repetition;// returning
    }
    public int getRecovery(){

        if (Recovery==2)
            return Recovery;
        else
            return Recovery;
    }

    @Override//returning a string
    public String getEntry() {
        String result = getName()+"Sprinted"+getRepetitions()+"x"+getDistance()+"m in"+getHour()+":"+getMin()+":"+getSec()+"With"+getRecovery()+"minutes of recovry on"+getDay()+"/"+getMonth()+"/"+getYear();

        return result;// returning result
    }
}