package actions;

import affection.AffectionResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import criticality.CriticalityResult;
import criticality.ThreatCriticality;
import input.ControlResult;
import input.PossibleControl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ThreatCriticalityQuantification {

	public static void main( String[] args) {
		double u = 0;
		List<Double> list_normalized_threat_criticality = new ArrayList<>();
		List<Double> list_normalized_threat_criticality2 = new ArrayList<>();
		List<ThreatCriticality> threat_criticality_list = new ArrayList<>();
		CriticalityResult cr = new CriticalityResult();
		Gson gson = new Gson();
		BufferedReader brtc = null;
		BufferedReader brta = null;
		try {
			brtc = new BufferedReader(new FileReader("src//jsonFiles//Threat_Controls.json"));
			brta = new BufferedReader(new FileReader("src//jsonFiles//Threat_Affected.json"));
			ControlResult resulttc = gson.fromJson(brtc, ControlResult.class);
			AffectionResult resultaf = gson.fromJson(brta, AffectionResult.class);
			if (resulttc != null && resultaf != null) {
				int i = 0;
				for (PossibleControl c : resulttc.getPossibleControls()) {
					//System.out.println(c.getCnotrols().size());
					double x = c.getThreatExistence() * resultaf.getThreat().get(i).getObservationWeight();
					System.out.println("Threat criticality for threat " + c.getThreatName() + " equals: " + x);
					i++;
					list_normalized_threat_criticality.add(x);
					u = u + x;
				}
				// threat criticality calculation loop
				System.out.println("---------------------------------------------------------------\n");
				int s=0;
				for (PossibleControl c : resulttc.getPossibleControls()) {
					double normalized_threat_criticality;
					normalized_threat_criticality = list_normalized_threat_criticality.get(s) / u;
					System.out.printf("Normalized threat criticality for threat " + c.getThreatName() +" equals: %.2f\n", normalized_threat_criticality);
					list_normalized_threat_criticality2.add(normalized_threat_criticality);
					s++;
				}
				for (int f = 0; f < resultaf.getThreat().size(); f++) {
					ThreatCriticality threat_criticality_object = new ThreatCriticality();
					threat_criticality_object.setThreatname(resulttc.getPossibleControls().get(f).getThreatName());
					threat_criticality_object.setNormalizedCriticality(list_normalized_threat_criticality2.get(f));
					threat_criticality_list.add(threat_criticality_object);

				}

			}

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {

			if (brtc != null && brta != null) {
				try {
					brtc.close();
					brta.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		cr.setThreatCriticality(threat_criticality_list);
		Gson gsons = new GsonBuilder().setPrettyPrinting().create();
		String strjson = gsons.toJson(cr);
		FileWriter writer = null;
		try {
			writer = new FileWriter("src//jsonFiles//Threat_Criticality.json");
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
