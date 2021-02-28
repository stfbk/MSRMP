package affection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Threats {

	@SerializedName("threatname")
	@Expose
	private String threatname;
	@SerializedName("AffectedGoals")
	@Expose
	private List<AffectedGoal> affectedGoals = new ArrayList<>();
	@SerializedName("threatid")
	@Expose
	private String threatid;
	@SerializedName("malicious action")
	@Expose
	private String maliciousAction;
	@SerializedName("observation_weight")
	@Expose
	private Double observationWeight;

	public Threats() {
	}
	public Threats( String threatname, List<AffectedGoal> affectedGoals, String threatid, String maliciousAction,
                    Double observationWeight) {
		this.threatname = threatname;
		this.affectedGoals = affectedGoals;
		this.threatid = threatid;
		this.maliciousAction = maliciousAction;
		this.observationWeight = observationWeight;
	}

	public String getThreatname() {
		return threatname;
	}

	public void setThreatname( String threatname) {
		this.threatname = threatname;
	}

	public List<AffectedGoal> getAffectedGoals() {
		return affectedGoals;
	}

	public void setAffectedGoals( List<AffectedGoal> affectedGoals) {
		// this.affectedGoals = affectedGoals;
		for (AffectedGoal ag : affectedGoals) {
			this.affectedGoals.add(new AffectedGoal(ag.getAffectedGoalName()));
		}
	}

	public String getThreatid() {
		return threatid;
	}

	public void setThreatid( String threatid) {
		this.threatid = threatid;
	}

	public String getMaliciousAction() {
		return maliciousAction;
	}

	public void setMaliciousAction( String maliciousAction) {
		this.maliciousAction = maliciousAction;
	}

	public Double getObservationWeight() {
		return observationWeight;
	}

	public void setObservationWeight( Double observationWeight) {
		this.observationWeight = observationWeight;
	}

}