package optimization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllThreatAssessmentResult {

    @SerializedName("AllThreatAssessments")
    @Expose
    private List<AllThreatAssessment> allThreatAssessments = null;

    public List<AllThreatAssessment> getAllThreatAssessments() {
        return allThreatAssessments;
    }

    public void setAllThreatAssessments( List<AllThreatAssessment> allThreatAssessments ) {
        this.allThreatAssessments = allThreatAssessments;
    }

}