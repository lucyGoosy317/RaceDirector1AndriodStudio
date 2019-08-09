package racedirector1.com;

public class Channel {

    public String channelBand;
    public String channelFreq;
    public String channelNumber;


    public Channel(String channelBand,String channelNumber, String channelFreq) {
        this.channelBand=channelBand;
        this.channelFreq=channelFreq;
        this.channelNumber=channelNumber;
    }

    public String getChannelBand() {
        return channelBand;
    }

    public void setChannelBand(String channelBand) {
        this.channelBand = channelBand;
    }

    public String getChannelFreq() {
        return channelFreq;
    }

    public void setChannelFreq(String channelFreq) {
        this.channelFreq = channelFreq;
    }

    public String getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(String channelNumber) {
        this.channelNumber = channelNumber;
    }


    public String toString() {
        String ret=channelBand+channelNumber+" "+channelFreq;


        return ret;
    }


}
