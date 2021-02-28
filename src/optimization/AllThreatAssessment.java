package optimization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllThreatAssessment {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("ThreatAssessment")
    @Expose
    private List<ThreatAssessment> threatAssessment = null;

    public Integer getID() {

        return iD;
    }

    public void setID( Integer iD ) {

        this.iD = iD;
    }

    public List<ThreatAssessment> getThreatAssessment() {
        return threatAssessment;
    }

    public void setThreatAssessment( List<ThreatAssessment> threatAssessment ) {
        this.threatAssessment = threatAssessment;
    }

}