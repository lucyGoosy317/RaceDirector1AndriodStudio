package racedirector1.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heat_configure);
        goBackToMenuStart();
        viewPilotHeatWithComboBoxSpinner();
        addPilotToHeat();
        seePilotsInRace();
    }


    //finished button will take the user back to the main menu
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

    //Set the pilots inside the race selectable left off here 8/11
    public void seePilotsInRace(){
        allPilotsInRace=MainActivity.RaceData.getPilotGeneralPilotList();
        pilots=(Spinner)findViewById(R.id.PilotListSpinner);
        ArrayAdapter<Pilots> adapterPilots = new ArrayAdapter<Pilots>(HeatConfigure.this, android.R.layout.simple_spinner_item, allPilotsInRace);
        adapterPilots.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pilots.setAdapter(adapterPilots);

    }



    public void viewPilotHeatWithComboBoxSpinner(){
        HeatList=MainActivity.RaceData.getHeats();
        heatSelector = (Spinner) findViewById(R.id.heatComboBox);
        ArrayAdapter<Heat> adapter = new ArrayAdapter<Heat>(HeatConfigure.this, android.R.layout.simple_spinner_item, HeatList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heatSelector.setAdapter(adapter);
        //When the user selects the heat, does not work correctly and crashes the app
        //heatSelector.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
            //    Heat selectedHeat=(Heat)heatSelector.getSelectedItem();
            //    PilotListInHeat=selectedHeat.getPilotsInHeat();
             //   ArrayAdapter<Pilots> gridViewArrayAdapter = new ArrayAdapter<Pilots>
             //           (HeatConfigure.this,android.R.layout.simple_list_item_1, PilotListInHeat);

               // pilotHeatViewer.setAdapter(gridViewArrayAdapter);
            //}
        //});

    }



    // grab and add pilot to a heat from selected combo boxes
    public void addPilotToHeat(){

        addPilot=(Button)findViewById(R.id.addPilotToHeatButton);

        addPilot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pilo
                //Heat selectedHeat=(Heat)heatSelector.getSelectedItem();
                //PilotList=selectedHeat.getPilotsInHeat();
                //ArrayAdapter<Pilots> gridViewArrayAdapter = new ArrayAdapter<Pilots>
                 //       (HeatConfigure.this,android.R.layout.simple_list_item_1, PilotList);

               // pilotHeatViewer.setAdapter(gridViewArrayAdapter);
            }
        });

    }






}


