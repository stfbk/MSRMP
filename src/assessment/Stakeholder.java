package assessment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stakeholder {

	@SerializedName("Stakeholder_name")
	@Expose
	private String stakeholderName;
	@SerializedName("Threat_Risk")
	@Expose
	private Double threatRisk;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Stakeholder() {
	}

	/**
	 *
	 * @param stakeholderName
	 * @param threatRisk
	 */
	public Stakeholder( String stakeholderName, Double threatRisk) {
		super();
		this.stakeholderName = stakeholderName;
		this.threatRisk = threatRisk;
	}

	public String getStakeholderName() {
		return stakeholderName;
	}

	public void setStakeholderName( String stakeholderName) {
		this.stakeholderName = stakeholderName;
	}

	public Double getThreatRisk() {
		return threatRisk;
	}

	public void setThreatRisk( Double threatRisk) {
		this.threatRisk = threatRisk;
	}

}