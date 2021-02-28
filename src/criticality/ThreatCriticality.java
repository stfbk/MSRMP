package criticality;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThreatCriticality {

	@SerializedName("threatname")
	@Expose
	private String threatname;
	@SerializedName("threat_existence")
	@Expose
	private Double threatExistence;
	@SerializedName("normalized_criticality")
	@Expose
	private Double normalizedCriticality;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ThreatCriticality() {
	}

	/**
	 *
	 * @param threatExistence
	 * @param normalizedCriticality
	 * @param threatname
	 */
	public ThreatCriticality( String threatname, Double threatExistence, Double normalizedCriticality) {
		super();
		this.threatname = threatname;
		this.threatExistence = threatExistence;
		this.normalizedCriticality = normalizedCriticality;
	}

	public String getThreatname() {
		return threatname;
	}

	public void setThreatname( String threatname) {
		this.threatname = threatname;
	}

	public Double getThreatExistence() {
		return threatExistence;
	}

	public void setThreatExistence( Double threatExistence) {
		this.threatExistence = threatExistence;
	}

	public Double getNormalizedCriticality() {
		return normalizedCriticality;
	}

	public void setNormalizedCriticality( Double normalizedCriticality) {
		this.normalizedCriticality = normalizedCriticality;
	}

}