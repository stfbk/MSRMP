package actions;

import actors.Stakeholder;
import actors.StakeholderResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import impact.StakeholderPreference;
import impact.ThreatImpactAssessment;
import impact.ThreatImpactAssessmentResult;
import input.Threat;
import input.ThreatResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * To use this class, you must already have determined your stakeholders and their preferences.
 * In this class the user assigns the impact level of each preference then it calculates the impact level for each threat from the stakeholders' perspective
 * Finally, the calculated IMPACT for each threat is going to use for calculation of RISK exposure which we need for the next step.  
 * 
 */

public class PreferenceImpacting {

	public static void main( String[] args) throws NullPointerException {
		List<impact.Stakeholder> stakeholder_list = new ArrayList<>();
		List<ThreatImpactAssessment> threat_impact_assessment_list = new ArrayList<>();
		int ff=0;
		Gson gson = new Gson();
		BufferedReader brs = null;
		BufferedReader brt = null;
		try {
			brs = new BufferedReader(new FileReader("src//jsonFiles//Stakeholder.json"));
			brt = new BufferedReader(new FileReader("src//jsonFiles//Threats.json"));
			ThreatResult resultt = gson.fromJson(brt, ThreatResult.class);
			StakeholderResult results = gson.fromJson(brs, StakeholderResult.class);
			if (results != null && resultt != null) {
				for (Threat t : resultt.getThreat()) {
					for (Stakeholder s : results.getStakeholder()) {
						
						double total_preference_weight=0;
						for (int h = 0; h < results.getStakeholder().get(ff).getPreferences().size(); h++) {
							total_preference_weight=total_preference_weight+results.getStakeholder().get(ff).getPreferences().get(h).getPreferenceWeight();
						}
						//Maximum of impact for a threat in a situation all preferences are catastrophic 
						total_preference_weight= total_preference_weight*4;
						ff++;
						double threat_impact_level=0;
						List<StakeholderPreference> stk_prelist = new ArrayList<>();
						int p;
						p = s.getPreferences().size();
						//System.out.println(p);
						// System.out.println(s.getStakeholderName() + "---"+ t.getThreatName());
						for (int i = 0; i < p; i++) {
							@SuppressWarnings("resource")
                            Scanner scan = new Scanner(System.in);

							System.out.println("Please assign an impact level for the "
									+ s.getPreferences().get(i).getPreferenceName() + " preference for the "
									+ t.getThreatName() + " threat" + "\nfrom the point of view of the "
									+ s.getStakeholderName() + ":\n");
							int d = -1;
							d = scan.nextInt();
							while (d < 0 | d > 4) {
								System.out.println("The given impact value is not correct, please choose an Intiger number between 0 to 4.");
								d = scan.nextInt();
							} // end of while loop
							
							StakeholderPreference stk_pre = new StakeholderPreference();
							stk_pre.setPreferenceName(s.getPreferences().get(i).getPreferenceName());
							stk_pre.setPreferenceImpact(d);
							stk_pre.setPreferenceId(i+1);
							stk_pre.setPreferenceWeight(s.getPreferences().get(i).getPreferenceWeight());
							threat_impact_level=threat_impact_level+(d*s.getPreferences().get(i).getPreferenceWeight());
							stk_prelist.add(stk_pre);
						} // end of preference loop
							impact.Stakeholder stk1 = new impact.Stakeholder();
							stk1.setStakeholderName(s.getStakeholderName());
							stk1.setStakeholderPreferences(stk_prelist);
							stk1.setThreatImpactLevel(threat_impact_level/total_preference_weight);
							stakeholder_list.add(stk1);
							//stk_prelist = new ArrayList<>();
							ThreatImpactAssessment threat_impact_assessment_list_objcet = new ThreatImpactAssessment();
							threat_impact_assessment_list_objcet.setThreatName(t.getThreatName());
							threat_impact_assessment_list_objcet.setStakeholder(stakeholder_list);
							threat_impact_assessment_list.add(threat_impact_assessment_list_objcet);
							stakeholder_list = new ArrayList<>();
							
					} // end of stakeholder loop
							ff=0;		
				} // end of threat loop
				
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			if (brs != null | brt != null) {
				try {
					brs.close();
					brt.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		ThreatImpactAssessmentResult tiass_result = new ThreatImpactAssessmentResult();
		tiass_result.setThreatImpactAssessment(threat_impact_assessment_list);
		Gson gs = new GsonBuilder().setPrettyPrinting().create();
		String strjson = gs.toJson(tiass_result);
		FileWriter writer = null;
		try {
			writer = new FileWriter("src//jsonFiles//Threat_Impact.json");
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
		System.out.println("DONE!");
	}
}
