package assessment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GoalRiskAssessmentResult {

	@SerializedName("GoalRiskAssessment")
	@Expose
	private List<GoalRiskAssessment> goalRiskAssessment = new ArrayList<>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public GoalRiskAssessmentResult() {
	}

	/**
	 *
	 * @param goalRiskAssessment
	 */
	public GoalRiskAssessmentResult( List<GoalRiskAssessment> goalRiskAssessment) {
		super();
		this.goalRiskAssessment = goalRiskAssessment;
	}

	public List<GoalRiskAssessment> getGoalRiskAssessment() {
		return goalRiskAssessment;
	}

	public void setGoalRiskAssessment( List<GoalRiskAssessment> goalRiskAssessment) {
		//this.goalRiskAssessment = goalRiskAssessment;
		for (GoalRiskAssessment gra : goalRiskAssessment) {
			this.goalRiskAssessment.add(new GoalRiskAssessment(gra.getGoalExposure()));
		}
	}

}