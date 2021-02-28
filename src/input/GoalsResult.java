package input;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoalsResult {

@SerializedName("Goals")
@Expose
private List<Goal> goals = null;

public List<Goal> getGoals() {
return goals;
}

public void setGoals( List<Goal> goals) {
this.goals = goals;
}

}