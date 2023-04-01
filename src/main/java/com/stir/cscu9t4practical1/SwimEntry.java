package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {// created for another class call entry
    private String where;// the method are privates
    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist , String w) {
        super(n, d, m, y, h, min, s, dist);
        where=w;// here w is initializing as where
    }

    public String getWhere() {// methods
        if (where.equals("pool"))// if loop is used
            return "in a" + where;
        else// if else
            return where;// returning value will be executed
    }

    public String getEntry(){
        String result = getName()+"Swam"+getDistance()+"km in"+getHour()+":"+getMin()+":"+getSec()+"on"+getDay()+
                "/" +getMonth()+":"+getYear()+"at"+getWhere()+"\n";
        return result;// returning value
    }

}