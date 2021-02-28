package input;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Control {

	@SerializedName("control_name")
	@Expose
	private String controlName;
	@SerializedName("implementation_status")
	@Expose
	private Double implementationStatus;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Control() {
	}

	/**
	*
	* @param implementationStatus
	* @param controlName
	*/
	public Control( String controlName, Double implementationStatus) {
	super();
	this.controlName = controlName;
	this.implementationStatus = implementationStatus;
	}

	public String getControlName() {
		return controlName;
	}

	public void setControlName( String controlName) {
		this.controlName = controlName;
	}

	public Double getImplementationStatus() {
		return implementationStatus;
	}

	public void setImplementationStatus( Double implementationStatus) {
		this.implementationStatus = implementationStatus;
	}
	

}