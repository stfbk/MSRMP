package impact;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ThreatImpactAssessmentResult {

	@SerializedName("ThreatImpactAssessment")
	@Expose
	private List<ThreatImpactAssessment> threatImpactAssessment = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ThreatImpactAssessmentResult() {
	}

	/**
	 *
	 * @param threatImpactAssessment
	 */
	public ThreatImpactAssessmentResult( List<ThreatImpactAssessment> threatImpactAssessment) {
		super();
		this.threatImpactAssessment = threatImpactAssessment;
	}

	public List<ThreatImpactAssessment> getThreatImpactAssessment() {
		return threatImpactAssessment;
	}

	public void setThreatImpactAssessment( List<ThreatImpactAssessment> threatImpactAssessment) {
		this.threatImpactAssessment = threatImpactAssessment;
			
		
	}

}