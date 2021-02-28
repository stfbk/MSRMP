package actors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StakeholderResult {

	@SerializedName("Stakeholder")
	@Expose
	private List<Stakeholder> stakeholder = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public StakeholderResult() {
	}

	/**
	 *
	 * @param stakeholder
	 */
	public StakeholderResult( List<Stakeholder> stakeholder) {
		super();
		this.stakeholder = stakeholder;
	}

	public List<Stakeholder> getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder( List<Stakeholder> stakeholder) {
		this.stakeholder = stakeholder;
	}

}