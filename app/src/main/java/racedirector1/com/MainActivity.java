package racedirector1.com;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public Button startButton;
    Typeface raceNumbersFont;
    public static raceOrganizer RaceData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //load our main layout
        setContentView(R.layout.activity_main);

        RaceData=new raceOrganizer();
        //load the channels to be used to assign channels to pilots
        RaceData.loadChannels();
        //create the instant of button, link xml to java code
        //startButton=(Button) findViewById(R.id.startButton);
        //Chnage the font of the button
        //raceNumbersFont=Typeface.createFromAsset(getAssets(),"fonts/RACINGNUMBERS.TTF");
        //startButton.setTypeface(raceNumbersFont);
        goToMenuStart();


    }

    public void goToMenuStart(){
        startButton=(Button) findViewById(R.id.startButton);
        raceNumbersFont=Typeface.createFromAsset(getAssets(),"fonts/RACINGNUMBERS.TTF");
        startButton.setTypeface(raceNumbersFont);
        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent sceneChange = new Intent(MainActivity.this,menuStart.class);
                startActivity(sceneChange);
            }
        });



    }


}

