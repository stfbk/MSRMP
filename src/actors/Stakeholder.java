package actors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Stakeholder {

	@SerializedName("Stakeholder_name")
	@Expose
	private String stakeholderName;
	@SerializedName("Preferences")
	@Expose
	private List<Preference> preferences = new ArrayList<>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Stakeholder() {
	}

	/**
	 *
	 * @param preferences
	 * @param stakeholderName
	 */
	public Stakeholder( String stakeholderName, List<Preference> preferences) {
		super();
		this.stakeholderName = stakeholderName;
		this.preferences = preferences;
	}

	public String getStakeholderName() {
		return stakeholderName;
	}

	public void setStakeholderName( String stakeholderName) {
		this.stakeholderName = stakeholderName;
	}

	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences( List<Preference> preferences) {
		// this.preferences = preferences;
		for (Preference pr : preferences) {
			this.preferences
					.add(new Preference(pr.getPreferenceName(), pr.getPreferenceId(), pr.getPreferenceWeight()));
		}
	}

}