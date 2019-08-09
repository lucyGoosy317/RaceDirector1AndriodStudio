package racedirector1.com;

import java.util.HashMap;

public class Pilots {

    public String pilotName;
    public Channel pilotChannel;
    public int pilotPlace;
    public int currentScore;
    //will change once score class is created
    public HashMap<Integer,Integer> pilotsScore;// Round num will be key && Value will be the score amount
    public int Total;


    //**************Constructor**************
    public Pilots(String pilotName, Channel pilotChannel) {
        this.pilotName = pilotName;
        this.pilotChannel = pilotChannel;
        //place holder for each round of scores
        pilotsScore = new HashMap<Integer, Integer>();
        //can be used to add all scores of pilot and stored
        pilotPlace = 0;
        currentScore = 0;
        Total = 0;
    }

    //***********getters & setters**************


    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public Channel getPilotChannel() {
        return pilotChannel;
    }

    public void setPilotChannel(Channel pilotChannel) {
        this.pilotChannel = pilotChannel;
    }

    public int getPilotPlace() {
        return pilotPlace;
    }

    public void setPilotPlace(int pilotPlace) {
        this.pilotPlace = pilotPlace;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public HashMap<Integer, Integer> getPilotsScore() {
        return pilotsScore;
    }

    public void setPilotsScore(HashMap<Integer, Integer> pilotsScore) {
        this.pilotsScore = pilotsScore;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }



    //************toString*******************

    public String toString() {
        String ret=pilotName+" "+pilotChannel.toString()+"\n";



        return ret;
    }




}
