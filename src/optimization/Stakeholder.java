package optimization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stakeholder {

    @SerializedName("Stakeholder_name")
    @Expose
    private String stakeholderName;
    @SerializedName("Threat_Risk")
    @Expose
    private Double threatRisk;

    public String getStakeholderName() {

        return stakeholderName;
    }

    public void setStakeholderName( String stakeholderName ) {
        this.stakeholderName = stakeholderName;
    }

    public Double getThreatRisk() {

        return threatRisk;
    }

    public void setThreatRisk( Double threatRisk ) {

        this.threatRisk = threatRisk;
    }

}