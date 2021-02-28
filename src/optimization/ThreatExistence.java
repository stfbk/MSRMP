package optimization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ThreatExistence {

    @SerializedName("threatname")
    @Expose
    private String threatname;
    @SerializedName("ImplementationStatus")
    @Expose
    private List<Double> implementationStatus = null;

    public String getThreatname() {
        return threatname;
    }

    public void setThreatname( String threatname ) {
        this.threatname = threatname;
    }

    public List<Double> getImplementationStatus() {
        return implementationStatus;
    }

    public void setImplementationStatus( List<Double> implementationStatus ) {
        this.implementationStatus = implementationStatus;
    }

}