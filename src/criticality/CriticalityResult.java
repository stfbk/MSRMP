package criticality;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CriticalityResult {

	@SerializedName("ThreatCriticality")
	@Expose
	private List<ThreatCriticality> threatCriticality = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public CriticalityResult() {
	}

	/**
	 *
	 * @param threatCriticality
	 */
	public CriticalityResult( List<ThreatCriticality> threatCriticality) {
		super();
		this.threatCriticality = threatCriticality;
	}

	public List<ThreatCriticality> getThreatCriticality() {
		return threatCriticality;
	}

	public void setThreatCriticality( List<ThreatCriticality> threatCriticality) {
		this.threatCriticality = threatCriticality;
	}

}