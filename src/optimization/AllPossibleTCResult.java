package optimization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllPossibleTCResult {

    @SerializedName("AllPossibleThreatCriticality")
    @Expose
    private List<AllPossibleThreatCriticality> allPossibleThreatCriticality = null;

    public List<AllPossibleThreatCriticality> getAllPossibleThreatCriticality() {

        return allPossibleThreatCriticality;
    }

    public void setAllPossibleThreatCriticality( List<AllPossibleThreatCriticality> allPossibleThreatCriticality ) {
        this.allPossibleThreatCriticality = allPossibleThreatCriticality;
    }

}