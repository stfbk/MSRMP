package optimization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ThreatExistenceResult {

    @SerializedName("ThreatExistence")
    @Expose
    private List<ThreatExistence> threatExistence = null;

    public List<ThreatExistence> getThreatExistence() {
        return threatExistence;
    }

    public void setThreatExistence( List<ThreatExistence> threatExistence ) {
        this.threatExistence = threatExistence;
    }

}