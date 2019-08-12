package racedirector1.com;

import java.util.ArrayList;

public class Heat {
    public ArrayList<Pilots> PilotsInHeat; // pilot name is the key and Pilots object is the value
    public String heatName;




    //*********Constructor********************

    public Heat(String heatName) {
        this.heatName=heatName;
        PilotsInHeat= new ArrayList<Pilots>();

    }


    //**************Getters & Setters***************

    public ArrayList<Pilots> getPilotsInHeat() {
        return PilotsInHeat;
    }

    public void setPilotsInHeat(ArrayList<Pilots> pilotsInHeat) {
        PilotsInHeat = pilotsInHeat;
    }

    public String getHeatName() {
        return heatName;
    }

    public void setHeatName(String heatName) {
        this.heatName = heatName;
    }

    //**************Methods*********************
    //will add a pilot into a heat
    public void addPilotsToHeat(Pilots heatPilot) {

    }

    //will remove a pilot from a heat
    public void removePilotsFromHeat(Pilots heatPilot) {


    }

    public String returnPilotsOfHeat() {
        String ret=heatName+":"+"\n";
        for(int i=0;i<PilotsInHeat.size();i++) {
            ret+=PilotsInHeat.get(i)+ " Scores :";
            for(int l=0;l<PilotsInHeat.get(i).pilotsScore.size();l++) {
                ret+=PilotsInHeat.get(i).pilotsScore.get(l)+",";
            }
            ret+="\n";

        }

        return ret;
    }


    public String toString() {
        String ret;
        ret=heatName;

        return ret;
    }

}
