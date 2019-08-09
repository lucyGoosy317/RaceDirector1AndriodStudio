package racedirector1.com;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static racedirector1.com.MainActivity.RaceData;

public class raceOrganizer {

    public HashMap<Integer,Round> rounds;
    //public ArrayList<Heat> heats;
    public HashMap<String,Pilots> pilotGeneralPilotList;
    public ArrayList<Channel> channelListBandA;
    public ArrayList<Channel> channelListBandB;
    public ArrayList<Channel> channelListBandE;
    public ArrayList<Channel> channelListBandF;
    public ArrayList<Channel> channelListBandR;


    //Constructor for raceOrganizer
    public raceOrganizer() {
        rounds = new HashMap<Integer, Round>();
        pilotGeneralPilotList = new HashMap<String, Pilots>();
        channelListBandA = new ArrayList<Channel>();
        channelListBandB = new ArrayList<Channel>();
        channelListBandE = new ArrayList<Channel>();
        channelListBandF = new ArrayList<Channel>();
        channelListBandR = new ArrayList<Channel>();

        //heats = new ArrayList<Heat>();

    }


    //*******************Getters & Setters**********************
    public HashMap<Integer, Round> getRounds() {
        return rounds;
    }

    public void setRounds(HashMap<Integer, Round> rounds) {
        this.rounds = rounds;
    }

   // public ArrayList<Heat> getHeats() {
    //    return heats;
   // }

  //  public void setHeats(ArrayList<Heat> heats) {
   //     this.heats = heats;
   // }

    public HashMap<String, Pilots> getPilotGeneralPilotList() {
        return pilotGeneralPilotList;
    }

    public void setPilotGeneralPilotList(HashMap<String, Pilots> pilotGeneralPilotList) {
        this.pilotGeneralPilotList = pilotGeneralPilotList;
    }

    public ArrayList<Channel> getChannelListBandA() {
        return channelListBandA;
    }

    public void setChannelListBandA(ArrayList<Channel> channelListBandA) {
        this.channelListBandA = channelListBandA;
    }

    public ArrayList<Channel> getChannelListBandB() {
        return channelListBandB;
    }

    public void setChannelListBandB(ArrayList<Channel> channelListBandB) {
        this.channelListBandB = channelListBandB;
    }

    public ArrayList<Channel> getChannelListBandE() {
        return channelListBandE;
    }

    public void setChannelListBandE(ArrayList<Channel> channelListBandE) {
        this.channelListBandE = channelListBandE;
    }

    public ArrayList<Channel> getChannelListBandF() {
        return channelListBandF;
    }

    public void setChannelListBandF(ArrayList<Channel> channelListBandF) {
        this.channelListBandF = channelListBandF;
    }

    public ArrayList<Channel> getChannelListBandR() {
        return channelListBandR;
    }

    public void setChannelListBandR(ArrayList<Channel> channelListBandR) {
        this.channelListBandR = channelListBandR;
    }


    //***************************Class Methods********************************

    //Load channels before app starts from .cvs from
    //res dir
    public void loadChannels() {
        String file = "res/raw/channellist.csv";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                Channel channel = null;

                switch (tokens[0]) {
                    case "A":
                        channel = new Channel(tokens[0], tokens[1], tokens[2]);
                        channelListBandA.add(channel);

                        break;
                    case "B":
                        channel = new Channel(tokens[0], tokens[1], tokens[2]);
                        channelListBandB.add(channel);

                        break;
                    case "E":
                        channel = new Channel(tokens[0], tokens[1], tokens[2]);
                        channelListBandE.add(channel);

                        break;
                    case "F":
                        channel = new Channel(tokens[0], tokens[1], tokens[2]);
                        channelListBandF.add(channel);
                        break;
                    case "R":
                        channel = new Channel(tokens[0], tokens[1], tokens[2]);
                        channelListBandR.add(channel);
                        break;
                    default:
                        System.out.println("No such channel Band");
                        break;


                }


            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //***************************Pilot SetUp*******************************
    //To Create a new pilot from scratch, used in enter Pilots from menu
    public boolean makeNewPilot(String Name, Channel channel) {
        Pilots pilot = new Pilots(Name, channel);
        boolean check = true;
        if (checkIfPilotAlreadyInRace(pilot) == true) {
            System.out.println("adding pilot into race");
            RaceData.pilotGeneralPilotList.put(pilot.getPilotName(),pilot);
            System.out.println(RaceData.pilotGeneralPilotList.toString());
            check = true;
        } else {

            System.out.println(RaceData.pilotGeneralPilotList.toString());
            check = false;
        }
            return check;

    }
    //To check if the pilot is already entered in the race
    public boolean checkIfPilotAlreadyInRace(Pilots pilot){
        boolean check=true;

        if(pilotGeneralPilotList.containsKey(pilot.getPilotName())){
            System.out.println("Pilot already exist in the race");
            check=false;
        }else{
            check=true;
        }
        return check;

    }
    //**********************************************************************

    //***************Configure the Race*********************
    //will take in the amount of rounds the user wants to have and the amount of heats
    //used in ConfigureRace Activity.
    public void configureRace(int heatCount,int roundCount){

        //create the amount of Rounds, might have to come back on that round count
        for(int i=1;i<=roundCount;i++){

            Round newRound=new Round("Round: "+i);
            //fill the Round with amount of desired heats
            for(int l=1;l<=heatCount;l++){
                Heat newHeat= new Heat("Heat:"+l);
                //Fill current round with the amount of heats desired from edit box
                newRound.heat.put(l,newHeat);


            }

            //Create Rounds with filled heat amounts
            rounds.put(i,newRound);
        }
        for(Round item: rounds.values()){
            System.out.println("Printing out an item");
            System.out.println(item);
        }
    }

    //**************Configure the Heats*********************
    //The user will select a pilot from a list and then a heat
    //The user will then put the pilot into the heat desired
    //Pilot will remain in the heat, maybe same screen can be used for changing pilot heats
    public void configureHeat(){

    }


}
