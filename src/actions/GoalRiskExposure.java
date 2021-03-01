package actions;

import actors.Stakeholder;
import actors.StakeholderResult;
import affection.AffectionResult;
import affection.Threats;
import assessment.GoalExposure;
import assessment.GoalRiskAssessment;
import assessment.GoalRiskAssessmentResult;
import assessment.ThreatAssessmentResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import input.Goal;
import input.GoalsResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * To use this class, the user must already have determined (1) Goals (2) Stakeholders (3) Affected goals, and also he must have calculated the risk of threats. 
 * In this class, the final risk exposure calculates for each stakeholder in terms of goal risk exposure.
 * 
 * @author MajidMollaeefar
 *
 */
public class GoalRiskExposure {

	public static void main( String[] args) {

		List<GoalExposure> goal_exposure_list = new ArrayList<>();
		List<assessment.Goal> goal_list = new ArrayList<>();
		GoalRiskAssessment gra_object = new GoalRiskAssessment();
		List<GoalRiskAssessment> gra_list = new ArrayList<>();
		GoalRiskAssessmentResult graresult_object = new GoalRiskAssessmentResult();
		Gson gson = new Gson();
		BufferedReader brta;
		BufferedReader brtrc;
		BufferedReader brg;
		BufferedReader brstk;

		try {
			brg = new BufferedReader(new FileReader("src//jsonFiles//Goals.json"));
			brta = new BufferedReader(new FileReader("src//jsonFiles//Threat_Affected.json"));
			brtrc = new BufferedReader(new FileReader("src//jsonFiles//Threat_Risk_Calculation.json"));
			brstk = new BufferedReader(new FileReader("src//jsonFiles//Stakeholder.json"));

			ThreatAssessmentResult results = gson.fromJson(brtrc, ThreatAssessmentResult.class);
			GoalsResult resultg = gson.fromJson(brg, GoalsResult.class);
			AffectionResult resultaf = gson.fromJson(brta, AffectionResult.class);
			StakeholderResult resultstk = gson.fromJson(brstk, StakeholderResult.class);
			int stk_counter = 0;
			for (Stakeholder stk : resultstk.getStakeholder()) {
				GoalExposure goal_exposure_object = new GoalExposure();
				goal_exposure_object.setStakeholderName(stk.getStakeholderName());
				for (Goal g : resultg.getGoals()) {
					double goal_risk = 0;
					int threat_counter = 0;
					int number_of_affected = 0;
					assessment.Goal goal_object = new assessment.Goal();
					goal_object.setGoalName(g.getName());
					for (Threats t : resultaf.getThreat()) {
						for (int i = 0; i < t.getAffectedGoals().size(); i++) {
//							Goal affected_goals = new Goal();
//							affected_goals.setName(t.getAffectedGoals().get(i).getAffectedGoalName());
							if (g.getName().equals(t.getAffectedGoals().get(i).getAffectedGoalName())) {
								goal_risk = goal_risk + results.getThreatAssessment().get(threat_counter)
										.getStakeholder().get(stk_counter).getThreatRisk();
								number_of_affected = number_of_affected + 1;
							}

						}
						threat_counter++;

					}
					if (goal_risk >0 && number_of_affected>0) {				
					goal_object.setRiskExposure(goal_risk / number_of_affected);
					goal_list.add(goal_object);
					}
				}
				goal_exposure_object.setGoals(goal_list);
				goal_exposure_list.add(goal_exposure_object);

				goal_list.clear();
				stk_counter++;
			}
			gra_object.setGoalExposure(goal_exposure_list);
			gra_list.add(gra_object);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		graresult_object.setGoalRiskAssessment(gra_list);
		Gson gsons = new GsonBuilder().setPrettyPrinting().create();
		String strjson = gsons.toJson(graresult_object);
		FileWriter writer = null;
		try {
			writer = new FileWriter("src//jsonFiles//Risk_Exposure_Result.json");
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
