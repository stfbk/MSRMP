package impact;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ThreatImpactAssessment {

	@SerializedName("threat_name")
	@Expose
	private String threatName;
	@SerializedName("Stakeholder")
	@Expose
	private List<Stakeholder> stakeholder = new ArrayList<>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ThreatImpactAssessment() {
	}

	/**
	 *
	 * @param threatName
	 * @param stakeholder
	 */
	public ThreatImpactAssessment( String threatName, List<Stakeholder> stakeholder) {
		super();
		this.threatName = threatName;
		this.stakeholder = stakeholder;
	}

	public String getThreatName() {
		return threatName;
	}

	public void setThreatName( String threatName) {
		this.threatName = threatName;
	}

	public List<Stakeholder> getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder( List<Stakeholder> stakeholder) {
		//this.stakeholder = stakeholder;
		for (Stakeholder stk : stakeholder) {
			this.stakeholder.add(new Stakeholder(stk.getStakeholderName(),stk.getStakeholderPreferences(),stk.getThreatImpactLevel()));
					
		}
	}

}