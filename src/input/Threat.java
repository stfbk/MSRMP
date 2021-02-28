package input;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Threat {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("malicious action")
	@Expose
	private String maliciousAction;
	
	public Threat() {
		
	}
	public Threat( String name, String id, String maliciousAction) {
		this.name = name;
		this.id = id;
		this.maliciousAction = maliciousAction;
	}

	

	public String getThreatName() {
		return name;
	}

	public void setThreatName( String name) {
		this.name = name;
	}

	public String getThreatId() {
		return id;
	}

	public void setThreatId( String id) {
		this.id = id;
	}

	public String getMaliciousAction() {
		return maliciousAction;
	}

	public void setMaliciousAction( String maliciousAction) {
		this.maliciousAction = maliciousAction;
	}

}