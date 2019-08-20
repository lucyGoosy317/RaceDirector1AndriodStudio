package racedirector1.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * @EnterPilots Allows the user to create a pilot
 */
public class EnterPilots extends AppCompatActivity {

    Spinner channelListView;
    ArrayList<Channel> channelList;
    RadioButton BandA;
    RadioButton BandB;
    RadioButton BandE;
    RadioButton BandF;
    RadioButton BandR;
    EditText pilotName;
    Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pilots);

        bandAClicked();
        bandBClicked();
        bandEClicked();
        bandFClicked();
        bandRClicked();
        enterPilotClicked();


    }

    /**
     * @BandXClicked is to allow the radio button display what is inside the spinner(combodropdown box)
     */
    public void bandAClicked() {
        BandA = (RadioButton) findViewById(R.id.bandA);
        BandA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channelList = MainActivity.RaceData.getChannelListBandA();
                channelListView = (Spinner) findViewById(R.id.channelListView);
                ArrayAdapter<Channel> adapter = new ArrayAdapter<Channel>(EnterPilots.this, android.R.layout.simple_spinner_item, channelList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                channelListView.setAdapter(adapter);
            }
        });


    }

    public void bandBClicked() {

        BandB = (RadioButton) findViewById(R.id.bandB);
        BandB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channelList = MainActivity.RaceData.getChannelListBandB();
                channelListView = (Spinner) findViewById(R.id.channelListView);
                ArrayAdapter<Channel> adapter = new ArrayAdapter<Channel>(EnterPilots.this, android.R.layout.simple_spinner_item, channelList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                channelListView.setAdapter(adapter);
            }
        });

    }

    public void bandEClicked() {

        BandE = (RadioButton) findViewById(R.id.bandE);
        BandE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channelList = MainActivity.RaceData.getChannelListBandE();
                channelListView = (Spinner) findViewById(R.id.channelListView);
                ArrayAdapter<Channel> adapter = new ArrayAdapter<Channel>(EnterPilots.this, android.R.layout.simple_spinner_item, channelList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                channelListView.setAdapter(adapter);
            }
        });
    }

    public void bandFClicked() {

        BandF = (RadioButton) findViewById(R.id.bandF);
        BandF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channelList = MainActivity.RaceData.getChannelListBandF();
                channelListView = (Spinner) findViewById(R.id.channelListView);
                ArrayAdapter<Channel> adapter = new ArrayAdapter<Channel>(EnterPilots.this, android.R.layout.simple_spinner_item, channelList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                channelListView.setAdapter(adapter);
            }
        });
    }

    public void bandRClicked() {

        BandR = (RadioButton) findViewById(R.id.bandR);
        BandR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channelList = MainActivity.RaceData.getChannelListBandR();
                channelListView = (Spinner) findViewById(R.id.channelListView);
                ArrayAdapter<Channel> adapter = new ArrayAdapter<Channel>(EnterPilots.this, android.R.layout.simple_spinner_item, channelList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                channelListView.setAdapter(adapter);

            }
        });
    }

    /**
     * @enterPilotClicked allows the user to click the enter button, which grabs the channel and pilot name
     */
    public void enterPilotClicked() {
        enterButton = (Button) findViewById(R.id.enterButton);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //try/catch to check if a channel is selected
                try {
                    Channel channel = (Channel) channelListView.getSelectedItem();
                    pilotName = (EditText) findViewById(R.id.enterPilotName);
                    String pilot = (String) pilotName.getText().toString();
                    //check to see if the user enter name, could use a text watcher, but this is easier to read
                    if(!pilot.isEmpty()) {
                        boolean check = MainActivity.RaceData.makeNewPilot(pilot, channel);
                        if (check == true) {
                            System.out.println("Pilot Name: " + pilot + " Channel:" + channel.toString());
                            Toast.makeText(EnterPilots.this, pilot + " has been added", Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(EnterPilots.this, pilot + " is already in the race ", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        //if no name has been enters for the pilot display message
                        Toast.makeText(EnterPilots.this,"Enter a name for this pilot", Toast.LENGTH_SHORT).show();

                    }
                } catch (NullPointerException e) {
                    //if the user enter a name but did not select a channel, display this message
                    Toast.makeText(EnterPilots.this, "Please select a Channel", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }
}
