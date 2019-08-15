package racedirector1.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 *  ConfigureRace will allow the user to enter the amount of rounds and Heats
 *  The Rounds and Heats will be created. Although not loaded with no data in either yet
 */

public class ConfigureRace extends AppCompatActivity {

    //Objects needed for items on scene
    public EditText roundCount;
    public EditText heatCount;
    public Button getRdHtAmount;
    public Button nextButton;

    /**
     *
     * @param savedInstanceState, Create the methods to be used inside scene
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure_race);
        configureRace();
        goToHeatConfigure();
    }

    /**
     * @ConfigureRace, will take in values of rounds and heats user enters
     * and then the enter button will listen to be clicked and take values to raceOrganizer method
     * configureRace which will create the rounds and heats. It will place values into an arraylist
     */
    public void configureRace(){
        getRdHtAmount=(Button)findViewById(R.id.getRdHtbutton);
        roundCount=(EditText)findViewById(R.id.enterRounds);
        heatCount=(EditText)findViewById(R.id.enterHeats);
        //With the button object, use a listener to hear the user click the button, to grab both values from entered amount
        getRdHtAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //check to see if the user entered a number for the conversion
                try {
                    //convert the roundCount to int && heatCount to pass to method
                int rndCount=Integer.parseInt(roundCount.getText().toString());
                int htCount=Integer.parseInt(heatCount.getText().toString());
                    //Only allow the user to enter a number greater than 0 for rounds and heats
                    if (rndCount > 0 && htCount > 0) {
                        MainActivity.RaceData.configureRace(rndCount, htCount);
                        //disable button to not allow user to enter any more rounds or heats, even if back is pressed, left off here
                        getRdHtAmount.setClickable(false);
                        Toast.makeText(ConfigureRace.this,"Race of "+rndCount +" rounds, with " +htCount +" heats, created", Toast.LENGTH_SHORT).show();
                        //Otherwise tell them to enter a number greater than 0
                    } else {
                        Toast.makeText(ConfigureRace.this, "Please enter a values greater than zero", Toast.LENGTH_SHORT).show();
                    }
                    //If the user did not enter a number then show the message to the user
                }catch(NumberFormatException ex){
                    Toast.makeText(ConfigureRace.this, "Please enter numerical values", Toast.LENGTH_SHORT).show();

                }


            }
        });



    }


    /**
     * @goToHeatConfigure, will change the scene to HeatConfigure, which will allow the user to place pilots into heats
     *
     */
    public void goToHeatConfigure(){
        nextButton=(Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent sceneChange = new Intent(ConfigureRace.this,HeatConfigure.class);
                startActivity(sceneChange);
            }
        });

    }

}
