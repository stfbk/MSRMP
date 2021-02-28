package actions;

import affection.AffectedGoal;
import affection.AffectionResult;
import affection.Threats;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import input.Goal;
import input.GoalsResult;
import input.Threat;
import input.ThreatResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1) To use this class, you must already have determined your threats and goals
 * 2) This class calculates affection goals and observation values for each threat
 * 3) The result will be a JSON file ----> "Threat_Affected"
 *
 *
 */
public class ThreatGoalAssociation extends Threats {

	public static void main( String[] args) {

		List<AffectedGoal> affectedgoals = new ArrayList<>();
		List<Threats> threat_list = new ArrayList<>();
		String str = "x";
		Gson gsont = new Gson();
		Gson gsong = new Gson();
		BufferedReader brt;
		BufferedReader brg;
		AffectionResult tr1 = new AffectionResult();
		int number_of_affection=0;
		//int total_number_possible_affection=0;

		try {
			brt = new BufferedReader(new FileReader("Threats.json"));
			brg = new BufferedReader(new FileReader("Goals.json"));
			ThreatResult resultt = gsont.fromJson(brt, ThreatResult.class);
			GoalsResult resultg = gsong.fromJson(brg, GoalsResult.class);
		//	total_number_possible_affection=resultt.getThreat().size()*resultg.getGoals().size();
			//System.out.println(total_number_possible_affection);
			if (resultt != null) {
				int threatcounter = 1;
				for (Threat t : resultt.getThreat()) {
					Threats t1 = new Threats();

					System.out.println(
							"Please determine the possible infected goals for each threat (Write x if the goal impacts on the threat) \n"
									+ "Threat: " + threatcounter + ". " + t.getThreatName());
					if (resultg != null) {
						int goalcounter = 1;
						for (Goal g : resultg.getGoals()) {

							AffectedGoal g1 = new AffectedGoal();
							System.out.println(goalcounter + ") " + g.getName());

							@SuppressWarnings("resource")
                            Scanner scan = new Scanner(System.in);
							if (scan.nextLine().equals(str)) {

								g1.setAffectedGoalName(g.getName());
								//g1.setId(g.getId());
								System.out.println("YES");
								affectedgoals.add(g1);

							}
							goalcounter++;
						}
						number_of_affection= number_of_affection+ affectedgoals.size();
						t1.setThreatname(t.getThreatName());
						t1.setAffectedGoals(affectedgoals);
						t1.setThreatid(t.getThreatId());
						t1.setMaliciousAction(t.getMaliciousAction());

					}

					threat_list.add(t1);
					affectedgoals.clear();
					// affectedgoals = new ArrayList<>();
				}
				threatcounter++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//System.out.println(threat_list.get(0).getAffectedGoals().size());
		//observation weight calculation for each threat
		List<Threats> threat_list_2 = new ArrayList<>();
		for (int i = 0; i < threat_list.size(); i++) {
			double observation_weight;
			Threats t2 = new Threats();
			//observation_weight= 1-(((double) number_of_affection-threat_list.get(i).getAffectedGoals().size())/ (double) total_number_possible_affection);
			observation_weight= ((double)threat_list.get(i).getAffectedGoals().size())/ number_of_affection;
			t2.setThreatname(threat_list.get(i).getThreatname());
			t2.setAffectedGoals(threat_list.get(i).getAffectedGoals());
			t2.setThreatid(threat_list.get(i).getThreatid());
			t2.setMaliciousAction(threat_list.get(i).getMaliciousAction());
			t2.setObservationWeight(observation_weight);
			threat_list_2.add(t2);
		}

		tr1.setThreat(threat_list_2);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String strjson = gson.toJson(tr1);
		FileWriter writer = null;
		try {
			writer = new FileWriter("Threat_Affected.json");
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
