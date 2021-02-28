package optimization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThreatCriticality {

    @SerializedName("threatname")
    @Expose
    private String threatname;
    @SerializedName("normalized_criticality")
    @Expose
    private Double normalizedCriticality;

    public String getThreatname() {

        return threatname;
    }

    public void setThreatname( String threatname ) {

        this.threatname = threatname;
    }

    public Double getNormalizedCriticality() {

        return normalizedCriticality;
    }

    public void setNormalizedCriticality( Double normalizedCriticality ) {
        this.normalizedCriticality = normalizedCriticality;
    }

}