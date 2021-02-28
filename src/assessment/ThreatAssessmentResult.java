package assessment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ThreatAssessmentResult {

	@SerializedName("ThreatAssessment")
	@Expose
	private List<ThreatAssessment> threatAssessment = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ThreatAssessmentResult() {
	}

	/**
	 *
	 * @param threatAssessment
	 */
	public ThreatAssessmentResult( List<ThreatAssessment> threatAssessment) {
		super();
		this.threatAssessment = threatAssessment;
	}

	public List<ThreatAssessment> getThreatAssessment() {
		return threatAssessment;
	}

	public void setThreatAssessment( List<ThreatAssessment> threatAssessment) {
		this.threatAssessment = threatAssessment;
	}

}