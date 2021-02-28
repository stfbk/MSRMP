package input;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ThreatResult {

	@SerializedName("Threat")
	@Expose
	private List<Threat> threat = null;

	public List<Threat> getThreat() {
		return threat;
	}

	public void setThreat( List<Threat> threatList) {
		this.threat = threatList;
	}

}