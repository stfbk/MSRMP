package optimization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ThreatAssessment {

    @SerializedName("Threat_name")
    @Expose
    private String threatName;
    @SerializedName("Stakeholder")
    @Expose
    private List<Stakeholder> stakeholder = null;

    public String getThreatName() {
        return threatName;
    }

    public void setThreatName( String threatName ) {
        this.threatName = threatName;
    }

    public List<Stakeholder> getStakeholder() {
        return stakeholder;
    }

    public void setStakeholder( List<Stakeholder> stakeholder ) {
        this.stakeholder = stakeholder;
    }

}