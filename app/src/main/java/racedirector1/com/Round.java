package racedirector1.com;

import java.util.HashMap;

public class Round {

    public HashMap<Integer,Heat> heat;
    public String roundName;


    //************Constructor*******************
    public Round(String roundName) {
        this.roundName=roundName;
        heat= new HashMap<Integer, Heat>();

    }

    //*************Getters & Setters**********

    public HashMap<Integer, Heat> getHeat() {
        return heat;
    }

    public void setHeat(HashMap<Integer, Heat> heat) {
        this.heat = heat;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    //**************methods**********************
    //public void addHeats(Heat newHeat) {
      //  heat.add(newHeat);
    //}
    //public void removeHeat(Heat oldHeat) {
      //  heat.remove(oldHeat);
    //}

    //might have a problem with using the loop but go with it
    public void createNewHeat(String numberOfHeats) {
        int numOfHeats=Integer.parseInt(numberOfHeats);
        int heatCount=1;
        //Heat fillInHeat=null;
        for(int i=1;i<numOfHeats;i++) {
            Heat newHeat=new Heat("Heat:"+heatCount);
            heatCount++;
            //heat.add(newHeat);
            heat.put(i,newHeat);


        }
    }


    //*************toString**********************
    public String toString() {
        String ret="";
        for(int i=0;i<heat.size();i++) {
            ret+=roundName+"\n"+heat.toString()+"\n"+"************************************"+"\n";
        }
        return ret;
    }
}
