package actors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Preference {

	@SerializedName("Preference_name")
	@Expose
	private String preferenceName;
	@SerializedName("Preference_id")
	@Expose
	private Integer preferenceId;
	@SerializedName("Preference_weight")
	@Expose
	private Double preferenceWeight;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Preference() {
	}

	/**
	 *
	 * @param preferenceId
	 * @param preferenceName
	 * @param preferenceWeight
	 */
	public Preference( String preferenceName, Integer preferenceId, Double preferenceWeight) {
		super();
		this.preferenceName = preferenceName;
		this.preferenceId = preferenceId;
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

	public Double getPreferenceWeight() {
		return preferenceWeight;
	}

	public void setPreferenceWeight( Double preferenceWeight) {
		this.preferenceWeight = preferenceWeight;
	}

}