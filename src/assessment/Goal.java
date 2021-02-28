package assessment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Goal {

	@SerializedName("Goal_name")
	@Expose
	private String goalName;
	@SerializedName("Risk_exposure")
	@Expose
	private Double riskExposure;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Goal() {
	}

	/**
	 *
	 * @param goalName
	 * @param riskExposure
	 */
	public Goal( String goalName, Double riskExposure) {
		super();
		this.goalName = goalName;
		this.riskExposure = riskExposure;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName( String goalName) {
		this.goalName = goalName;
	}

	public Double getRiskExposure() {
		return riskExposure;
	}

	public void setRiskExposure( Double riskExposure) {
		this.riskExposure = riskExposure;
	}

}