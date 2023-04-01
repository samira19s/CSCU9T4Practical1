package com.stir.cscu9t4practical1;


public class CycleEntry extends Entry {// extends other class as entry
    private String Terrain;// using of methods
    private String Tempo;// methods are been used
    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String Terrain , String Tempo) {
        super(n, d, m, y, h, min, s, dist);
        this.Terrain=Terrain;
        this.Tempo=Tempo;
    }
    public String getTerrain(){
        if (Terrain.equals("asphalt"))
            return Terrain;
        else
            return Terrain;
    }
    public String getTempo(){
        if (Tempo.equals("moderate"))
            return Tempo;
        else
            return Tempo;// if may be false or true it will return the same value
    }
    @Override// returning a string
    public String getEntry() {
        String result = getName()+" cycled "+getDistance()+" km in "+getHour()+":"+getMin()+":"+getSec()+" on "+getDay()+
                "/" +getMonth()+"/"+getYear()+" on "+getTerrain()+" at "+getTempo()+" tempo\n";
        return result;
    }



}