package assessment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GoalExposure {

	@SerializedName("Stakeholder_name")
	@Expose
	private String stakeholderName;
	@SerializedName("Goals")
	@Expose
	private List<Goal> goals = new ArrayList<>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public GoalExposure() {
	}

	/**
	 *
	 * @param stakeholderName
	 * @param goals
	 */
	public GoalExposure( String stakeholderName, List<Goal> goals) {
		super();
		this.stakeholderName = stakeholderName;
		this.goals = goals;
	}

	public String getStakeholderName() {
		return stakeholderName;
	}

	public void setStakeholderName( String stakeholderName) {
		this.stakeholderName = stakeholderName;
	}

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals( List<Goal> goals) {
		//this.goals = goals;
		for (Goal g : goals) {
			this.goals.add(new Goal(g.getGoalName(),g.getRiskExposure()));
		}
	}

}