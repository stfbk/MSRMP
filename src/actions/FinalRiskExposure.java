package actions;

//import actions.ThreatRiskCalcualation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//import actions.GoalRiskExposure;

public class FinalRiskExposure {
	public static void main( String[] args) {
		ThreatRiskCalcualation.main(args);
		GoalRiskExposure.main(args);
	
	}

	@SerializedName("function_result")
	@Expose
	private List<Double> funtion_list;

	public FinalRiskExposure() {
	}

	public FinalRiskExposure( List<Double> funtion_list) {
		super();
		this.funtion_list = funtion_list;
	}

	public List<Double> getFuntionlist() {
		return funtion_list;
	}

	public void setFuntionlist( List<Double> funtion_list) {
		this.funtion_list = funtion_list;
	}

}
