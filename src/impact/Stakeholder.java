package impact;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Stakeholder {

	@SerializedName("Stakeholder_name")
	@Expose
	private String stakeholderName;
	@SerializedName("Stakeholder_preferences")
	@Expose
	private List<StakeholderPreference> stakeholderPreferences = new ArrayList<>();
	@SerializedName("Threat_Impact_level")
	@Expose
	private Double threatImpactLevel;

	public Stakeholder() {
	}

	public Stakeholder( String stakeholderName, List<StakeholderPreference> stakeholderPreferences,
                        Double threatImpactLevel) {
		super();
		this.stakeholderName = stakeholderName;
		this.stakeholderPreferences = stakeholderPreferences;
		this.threatImpactLevel = threatImpactLevel;
	}

	public String getStakeholderName() {
		return stakeholderName;
	}

	public void setStakeholderName( String stakeholderName) {
		this.stakeholderName = stakeholderName;
	}

	public List<StakeholderPreference> getStakeholderPreferences() {
		return stakeholderPreferences;
	}

	public void setStakeholderPreferences( List<StakeholderPreference> stakeholderPreferences) {
		// this.stakeholderPreferences = stakeholderPreferences;
		for (StakeholderPreference sp : stakeholderPreferences) {
			this.stakeholderPreferences.add(new StakeholderPreference(sp.getPreferenceName(), sp.getPreferenceId(),
					sp.getPreferenceImpact(), sp.getPreferenceWeight()));

		}
	}

	public Double getThreatImpactLevel() {
		return threatImpactLevel;
	}

	public void setThreatImpactLevel( Double threatImpactLevel) {
		this.threatImpactLevel = threatImpactLevel;
	}

}