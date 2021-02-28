package impact;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StakeholderPreference {

	@SerializedName("Preference_name")
	@Expose
	private String preferenceName;
	@SerializedName("Preference_id")
	@Expose
	private Integer preferenceId;
	@SerializedName("Preference_impact")
	@Expose
	private Integer preferenceImpact;
	@SerializedName("Preference_weight")
	@Expose
	private Double preferenceWeight;


	public StakeholderPreference() {
	}

	public StakeholderPreference( String preferenceName, Integer preferenceId, Integer preferenceImpact,
                                  Double preferenceWeight) {
		super();
		this.preferenceName = preferenceName;
		this.preferenceId = preferenceId;
		this.preferenceImpact = preferenceImpact;
		this.preferenceWeight = preferenceWeight;
	}

	public String getPreferenceName() {
		return preferenceName;
	}

	public void setPreferenceName( String preferenceName) {
		this.preferenceName = preferenceName;
	}

	public Integer getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId( Integer preferenceId) {
		this.preferenceId = preferenceId;
	}

	public Integer getPreferenceImpact() {
		return preferenceImpact;
	}

	public void setPreferenceImpact( Integer preferenceImpact) {
		this.preferenceImpact = preferenceImpact;
	}

	public Double getPreferenceWeight() {
		return preferenceWeight;
	}

	public void setPreferenceWeight( Double preferenceWeight) {
		this.preferenceWeight = preferenceWeight;
	}

}