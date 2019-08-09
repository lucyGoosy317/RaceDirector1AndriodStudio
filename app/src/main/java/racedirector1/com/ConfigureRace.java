package racedirector1.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfigureRace extends AppCompatActivity {

    //need to link buttons inside on create
    public EditText roundCount;
    public EditText heatCount;
    public Button getRdHtAmount;
    public Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure_race);
        configureRace();
        goToHeatConfigure();
    }

    public void configureRace(){
        getRdHtAmount=(Button)findViewById(R.id.getRdHtbutton);
        roundCount=(EditText)findViewById(R.id.enterRounds);
        heatCount=(EditText)findViewById(R.id.enterHeats);
        //Grab both values
        getRdHtAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //convert the roundCount to int && heatCount to pass to method
                int rndCount=Integer.parseInt(roundCount.getText().toString());
                int htCount=Integer.parseInt(heatCount.getText().toString());
                MainActivity.RaceData.configureRace(rndCount,htCount);
            }
        });



    }


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
