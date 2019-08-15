package racedirector1.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * @HeatConfigure
 * This class will allow users to configure the heats. Pilots will be able to choosen and then the heat,
 * from that point the user will then click add, to add the pilot to the heat
 */
public class HeatConfigure extends AppCompatActivity {

    public Button finishedButton;
    public Button addPilot;
    public Button removePilot;
    public Spinner heatSelector;
    public GridView pilotHeatViewer;
    public ArrayList<Heat> HeatList;
    public ArrayList<Pilots> PilotListInHeat;
    public ArrayList<Pilots> allPilotsInRace;
    public Spinner pilots;
    public int selectedPostion;
    ArrayAdapter<Pilots> gridViewArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heat_configure);
        goBackToMenuStart();

        addPilotToHeat();
        seePilotsInRace();
        viewPilotHeatWithComboBoxSpinner();
        changeViewInsideHeat();
    }


    /**
     * @goBackToMenuStart finished button will take the user back to the main menu
     *
     */
    public void goBackToMenuStart() {
        finishedButton = (Button) findViewById(R.id.FinishedButton);
        //raceNumbersFont=Typeface.createFromAsset(getAssets(),"fonts/RACINGNUMBERS.TTF");
        //startButton.setTypeface(raceNumbersFont);
        finishedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sceneChange = new Intent(HeatConfigure.this, menuStart.class);
                startActivity(sceneChange);
            }
        });


    }


    /**
     * @seePilotsInRace
     * Set the pilots inside the race to be selectable
     */
    public void seePilotsInRace(){
        allPilotsInRace=MainActivity.RaceData.getPilotGeneralPilotList();
        pilots=(Spinner)findViewById(R.id.PilotListSpinner);
        ArrayAdapter<Pilots> adapterPilots = new ArrayAdapter<Pilots>(HeatConfigure.this, android.R.layout.simple_spinner_item, allPilotsInRace);
        adapterPilots.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pilots.setAdapter(adapterPilots);


    }


    /**
     * @viewPilotHeatWithComboBoxSpinner
     * Will give the amount of heats inside race
     */
    public void viewPilotHeatWithComboBoxSpinner(){
        HeatList=MainActivity.RaceData.getHeats();
        heatSelector = (Spinner) findViewById(R.id.heatComboBox);
        ArrayAdapter<Heat> adapter = new ArrayAdapter<Heat>(getApplicationContext(), android.R.layout.simple_spinner_item, HeatList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heatSelector.setAdapter(adapter);



    }




    /**
     * @addPilotToHeat
     *add pilot to a heat from selected combo boxes, still needs a check/stop for existing pilots in gen list or remove pilots
     *from gen list, as to not create duplicate pilots inside heats
     */
    public void addPilotToHeat(){

        addPilot=(Button)findViewById(R.id.addPilotToHeatButton);

        addPilot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Pilots tempPilot=(Pilots)pilots.getSelectedItem();

              MainActivity.RaceData.getHeats().get(heatSelector.getSelectedItemPosition()).addPilotsToHeat(tempPilot);
              //update the gridView with newly added pilot inside array, from current selected heat
              ArrayAdapter<Pilots> gridViewArrayAdapter = new ArrayAdapter<Pilots>
                        (HeatConfigure.this, android.R.layout.simple_list_item_1, PilotListInHeat);

                pilotHeatViewer.setAdapter(gridViewArrayAdapter);


            }
        });


    }

    /**
     * @removePilot
     * remove a pilot from heat, left of here 6:11 AM 8/15/2019
     * TODO: update adding pilots with checker of exiting pilots HeatConfigure
     * TODO: create removePilot from gridview selection and readd pilot object into pilot gen list, ensure no duplicates
     *
     */
    public void removePilot(){


    }


    /**
     * @changeViewInsideHeat
     * Once the user selects a heat the gridView will reflect the current pilots inside heat array
     *
     */
    public void changeViewInsideHeat(){
        //When the user selects the heat
        pilotHeatViewer=(GridView) findViewById(R.id.pilotGridView);
        heatSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    PilotListInHeat = MainActivity.RaceData.heats.get(position).getPilotsInHeat();
                    selectedPostion=position;
                    //Heat selectedHeat = (Heat) heatSelector.getSelectedItem();
                    //PilotListInHeat = selectedHeat.getPilotsInHeat();
                    //pilotHeatViewer=(GridView) findViewById(R.id.pilotGridView);
                    ArrayAdapter<Pilots> gridViewArrayAdapter = new ArrayAdapter<Pilots>
                            (HeatConfigure.this, android.R.layout.simple_list_item_1, PilotListInHeat);

                    pilotHeatViewer.setAdapter(gridViewArrayAdapter);
                    System.out.println(pilotHeatViewer.toString());
                    //Pilots tempPilot= (Pilots)pilotHeatViewer.getSelectedItem();

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }




        });


    }





}


