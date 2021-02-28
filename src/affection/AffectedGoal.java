package affection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AffectedGoal {

	@SerializedName("name")
	@Expose
	private String name;

	public AffectedGoal() {
	}

	public AffectedGoal( String name) {
		this.name = name;
	}

	public String getAffectedGoalName() {
		return name;
	}

	public void setAffectedGoalName( String name) {
		this.name = name;
	}


}