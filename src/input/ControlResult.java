package input;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ControlResult {

	@SerializedName("PossibleControls")
	@Expose
	private List<PossibleControl> possibleControls = new ArrayList<>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ControlResult() {
	}

	/**
	 *
	 * @param possibleControls
	 */
	public ControlResult( List<PossibleControl> possibleControls) {
		super();
		this.possibleControls = possibleControls;
	}

	public List<PossibleControl> getPossibleControls() {
		return possibleControls;
	}

	public void setPossibleControls( List<PossibleControl> possibleControls) {
//this.possibleControls = possibleControls;
		for (PossibleControl pc : possibleControls) {
			this.possibleControls.add(new PossibleControl(pc.getThreatName(), pc.getCnotrols(), pc.getThreatExistence()));

		}
	}

}