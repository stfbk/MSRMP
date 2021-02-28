
package input;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PossibleControl {

	@SerializedName("threat_name")
	@Expose
	private String threatName;
	@SerializedName("controls")
	@Expose
	private List<Control> controls = new ArrayList<>();
	@SerializedName("threat_existence")
	@Expose
	private Double threatExistence;
	/**
	 * No args constructor for use in serialization
	 *
	 */
	public PossibleControl() {
	}

	public PossibleControl( String threatName, List<Control> controls, Double threatExistence) {
		super();
		this.threatName = threatName;
		this.controls = controls;
		this.threatExistence= threatExistence;
	}

	public String getThreatName() {
		return threatName;
	}

	public void setThreatName( String threatName) {
		this.threatName = threatName;
	}

	public List<Control> getCnotrols() {
		return controls;
	}

	public void setCnotrols( List<Control> controls) {
		//this.controls = controls;
		for (Control cnt: controls) {
			this.controls.add(new Control(cnt.getControlName(), cnt.getImplementationStatus()));
			
		}
	}
	public Double getThreatExistence() {
		return threatExistence;
		}

		public void setThreatExistence( Double threatExistence) {
		this.threatExistence = threatExistence;
		}

}