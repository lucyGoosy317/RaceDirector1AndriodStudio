package racedirector1.com;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import static racedirector1.com.MainActivity.RaceData;

/**
 * @raceOrganizer
 * will organize the race data contents
 */
public class raceOrganizer {

    public HashMap<Integer,Round> rounds;
    public ArrayList<Heat> heats;
    public ArrayList<Pilots> pilotGeneralPilotList;
    public ArrayList<Channel> channelListBandA;
    public ArrayList<Channel> channelListBandB;
    public ArrayList<Channel> channelListBandE;
    public ArrayList<Channel> channelListBandF;
    public ArrayList<Channel> channelListBandR;


    /**
     * Constructor
     */
    public raceOrganizer() {
        rounds = new HashMap<Integer, Round>();
        pilotGeneralPilotList = new ArrayList<Pilots>();
        channelListBandA = new ArrayList<Channel>();
        channelListBandB = new ArrayList<Channel>();
        channelListBandE = new ArrayList<Channel>();
        channelListBandF = new ArrayList<Channel>();
        channelListBandR = new ArrayList<Channel>();
        heats = new ArrayList<Heat>();//used to get the amount of Heats


    }


    //*******************Getters & Setters**********************
    public HashMap<Integer, Round> getRounds() {
        return rounds;
    }

    public void setRounds(HashMap<Integer, Round> rounds) {
        this.rounds = rounds;
    }

    public ArrayList<Heat> getHeats() {
        return heats;
    }

    public void setHeats(ArrayList<Heat> heats) {
        this.heats = heats;
    }

    public ArrayList<Pilots> getPilotGeneralPilotList() {
        return pilotGeneralPilotList;
    }

    public void setPilotGeneralPilotList(ArrayList<Pilots> pilotGeneralPilotList) {
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

    /**
     * @loadChannels Load channels before app starts from .cvs from
     * res dir
     */
    public void loadChannels() {
        String file = "res/raw/channellist.csv";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String line;
        //A try catch to ensure the app does not crash when the file is not found for channels
        try {
            //reading line by line
            while ((line = reader.readLine()) != null) {
                //splitting the line by delimiter , to get each item on the line and place the item into an array
                String[] tokens = line.split(",");
                Channel channel = null;

                //check which band is inside the 0 token to create the correct arraylist
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
    /**
     *
     * @param Name name of pilot passed from user entry
     * @param channel channel of pilot passed from user entry
     * @return check of value to view if the pilot exist inside the ArrayList
     */
    public boolean makeNewPilot(String Name, Channel channel) {
        Pilots pilot = new Pilots(Name, channel);
        boolean check = true;
        //pass the object pilot to method check, to see if the pilot already exist inside the gen pilot arraylist
        if (checkIfPilotAlreadyInRace(pilot) == true) {
            System.out.println("adding pilot into race");
            RaceData.pilotGeneralPilotList.add(pilot);
            //just a check, to see what is loaded into the arraylist in console
            System.out.println(RaceData.pilotGeneralPilotList.toString());
            check = true;
        } else {

            System.out.println(RaceData.pilotGeneralPilotList.toString());
            check = false;
        }
            return check;

    }

    /**
     *
     * @param pilot pilot object which was passed to check if the pilot is inside the arrayList
     * @return return a true or false depending on condition if a pilot exist inside the arrayList
     */
    public boolean checkIfPilotAlreadyInRace(Pilots pilot){
        boolean check=true;


        //linear search for pilots in the already existing list to see if there is a pilot with the same
        //name, slow option but the list will most likely be small.
        for(int x=0;x<pilotGeneralPilotList.size(); x++) {
            if (pilotGeneralPilotList.get(x).getPilotName().equals(pilot.getPilotName())) {
                System.out.println("Pilot already exist in the race");
                check = false;
            } else {
                check = true;
            }
        }
            return check;

    }
    //**********************************************************************

    //***************Configure the Race*********************

    /**
     * @configure will create the heats and rounds, they will both be empty but will be loaded into their
     * correct data containers
     * @param roundCount amount of rounds user entered
     * @param heatCount amount of heats user entered
     */
    public void configureRace(int roundCount,int heatCount){

        //create the amount of Rounds, might have to come back on that round count
        for(int i=1;i<=roundCount;i++) {

            Round newRound = new Round("Round: " + i);
            //put the newly created round into hashmap
            rounds.put(i,newRound);

        }
        //create the amount of heats in the array list, they still need to get loaded into the rounds
            for(int l=1;l<=heatCount;l++){
                Heat newHeat= new Heat("Heat:"+l);


                //add newly created heat into arraylist
                heats.add(newHeat);

            }



        }




    //**************Configure the Heats*********************
    /**
     * @configureHeat will check if the pilot exist inside the heat
     */
    public boolean configureHeat(Pilots inputPilot,int heatIndex){

        boolean check=true;
        //if pilot already exist in the hear
        //conduct another linear search
        for(int i=0;i<heats.get(heatIndex).PilotsInHeat.size();i++){

            if(heats.get(heatIndex).PilotsInHeat.get(i).getPilotName().equals(inputPilot.getPilotName())){

                //"this pilot is already inside this heat";
                check=false;
                break;

            }else{
                //inputPilot.getPilotName()+ " has been added";
                check=true;
            }
        }
        return check;
    }


}
