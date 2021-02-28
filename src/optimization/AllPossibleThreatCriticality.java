package optimization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllPossibleThreatCriticality {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("ThreatCriticality")
    @Expose
    private List<ThreatCriticality> threatCriticality = null;

    public Integer getID() {
        return iD;
    }

    public void setID( Integer iD ) {
        this.iD = iD;
    }

    public List<ThreatCriticality> getThreatCriticality() {

        return threatCriticality;
    }

    public void setThreatCriticality( List<ThreatCriticality> threatCriticality ) {
        this.threatCriticality = threatCriticality;
    }

}