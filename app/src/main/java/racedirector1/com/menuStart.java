package racedirector1.com;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class menuStart extends AppCompatActivity {

    ImageButton loadPilotsButton;
    ImageButton enterPilots;
    ImageButton configureButton;
    ImageButton startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_start);
        loadPilotsIn();
        goToConfigure();
        goToEnterPilots();
        goToEnterPilots();
    }

    //load the pilots from a cvs doc on device
    public void loadPilotsIn(){
        loadPilotsButton= (ImageButton)findViewById(R.id.loadpilots);
    }

    //scene Change methods
    //finished
    public void goToEnterPilots(){
        enterPilots=(ImageButton)findViewById(R.id.enterPilots);
        enterPilots.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent sceneChange = new Intent(menuStart.this,EnterPilots.class);
                startActivity(sceneChange);
            }
        });

    }

    //Left off here for configure race 7/23/19 2:28AM
    //Includes to set the amount of rounds and heats desired
    //Will also require to set up heats once the heats are created
    //Heats might need to be a hashmap, we dont want repeat heats
    //Update:Pilot Score Might need an update due to allow saving through each round
    public void goToConfigure(){
        configureButton=(ImageButton)findViewById(R.id.configure);
        configureButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent sceneChange = new Intent(menuStart.this,ConfigureRace.class);
                startActivity(sceneChange);
            }
        });

    }

    //not finished yet
    public void goToStartRace(){
        startButton=(ImageButton)findViewById(R.id.enterPilots);
        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //Intent sceneChange = new Intent(MainActivity.this,menuStart.class);
                //startActivity(sceneChange);
            }
        });


    }



}
