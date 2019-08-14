package racedirector1.com;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    raceOrganizer race= new raceOrganizer();
    int rndCount;
    int heatCount;
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("racedirector1.com", appContext.getPackageName());
    }

    @Test
    public void testConfigureRace(){
        rndCount=3;
        heatCount=3;
        race.configureRace(rndCount,heatCount);
        //Works correctly


    }

    @Test
    public void testMakePilot(){
        String name="lucy";
        Channel channel=new Channel("Band A","A7","3353");
        race.makeNewPilot(name,channel);
    }




}
