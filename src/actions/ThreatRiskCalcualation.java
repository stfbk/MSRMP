package actions;

import assessment.Stakeholder;
import assessment.ThreatAssessment;
import assessment.ThreatAssessmentResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import criticality.CriticalityResult;
import criticality.ThreatCriticality;
import impact.ThreatImpactAssessment;
import impact.ThreatImpactAssessmentResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * To use this class, you must already have calculated (1) Threat criticality
 * and (2) Threat impact This class calculates RISK for each threat which needs
 * for the next step to calculate goal risk exposure
 * 
 * @author MajidMollaeefar
 *
 */

public class ThreatRiskCalcualation {

	public static void main( String[] args) {
		List<Stakeholder> stk_list = new ArrayList<>();
		List<ThreatAssessment> ta_list = new ArrayList<>();
		ThreatAssessmentResult tar_object = new ThreatAssessmentResult();

		Gson gson = new Gson();
		BufferedReader brtc = null;
		BufferedReader brti = null;
		try {
			brtc = new BufferedReader(new FileReader("src//jsonFiles//Threat_Criticality.json"));
			brti = new BufferedReader(new FileReader("src//jsonFiles//Threat_Impact.json"));
			CriticalityResult resulttc = gson.fromJson(brtc, CriticalityResult.class);
			ThreatImpactAssessmentResult resulttia = gson.fromJson(brti, ThreatImpactAssessmentResult.class);
			int i = 0;
				for (ThreatCriticality c : resulttc.getThreatCriticality()) {
					ThreatAssessment ta_object = new ThreatAssessment();
					ta_object.setThreatName(c.getThreatname());
					for (ThreatImpactAssessment tia : resulttia.getThreatImpactAssessment()) {
						if (tia.getThreatName().equals(resulttc.getThreatCriticality().get(i).getThreatname())) {
							//System.out.println(resulttia.getThreatImpactAssessment().size());
							Stakeholder stk_object = new Stakeholder();
							stk_object.setStakeholderName(tia.getStakeholder().get(0).getStakeholderName());
							// threat risk calculation ---> threat criticality multiply threat impact
							double d = resulttc.getThreatCriticality().get(i).getNormalizedCriticality()
									* tia.getStakeholder().get(0).getThreatImpactLevel();
							stk_object.setThreatRisk(d);
							stk_list.add(stk_object);
							//d = 0;
						}

					}
					ta_object.setStakeholder(stk_list);
					ta_list.add(ta_object);
					stk_list.clear();
					i++;
				}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			if (brtc != null && brti != null) {
				try {
					brtc.close();
					brti.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		tar_object.setThreatAssessment(ta_list);
		Gson gsons = new GsonBuilder().setPrettyPrinting().create();
		String strjson = gsons.toJson(tar_object);
		FileWriter writer = null;
		try {
			writer = new FileWriter("src//jsonFiles//Threat_Risk_Calculation.json");
			writer.write(strjson);
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		//System.out.println("DONE!");

	}

}
