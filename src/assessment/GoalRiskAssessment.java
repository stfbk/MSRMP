package assessment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GoalRiskAssessment {

	@SerializedName("GoalExposure")
	@Expose
	private List<GoalExposure> goalExposure = new ArrayList<>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public GoalRiskAssessment() {
	}

	/**
	 *
	 * @param goalExposure
	 */
	public GoalRiskAssessment( List<GoalExposure> goalExposure) {
		super();
		this.goalExposure = goalExposure;
	}

	public List<GoalExposure> getGoalExposure() {
		return goalExposure;
	}

	public void setGoalExposure( List<GoalExposure> goalExposure) {
		//this.goalExposure = goalExposure;
		for (GoalExposure ge : goalExposure) {
			this.goalExposure.add(new GoalExposure(ge.getStakeholderName(),ge.getGoals()));
		}
	}

}