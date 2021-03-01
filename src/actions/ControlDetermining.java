package actions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import input.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1) To use this class, you must have identified the threats.
 * 2) This class identifies controls and threat existence for each threat. 
 * 
 */
public class ControlDetermining {

	public static void main( String[] args) {
		@SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
		List<Control> control_list = new ArrayList<>();
		Control control_object = new Control();
		List<PossibleControl> possible_control_list = new ArrayList<>();
		
		Gson gson = new Gson();
		BufferedReader brt = null;
		try {
			brt = new BufferedReader(new FileReader("src//jsonFiles//Threats.json"));
			ThreatResult result = gson.fromJson(brt, ThreatResult.class);
			int c = 1;
			if (result != null) {
				for (Threat t : result.getThreat()) {
					// Do an action
					System.out.println(
							"Please identify possible controls for the threats: " + c + ") " 
					+ t.getThreatName()+"\r" +"And how many controls does it have?\n");
					int d = scan.nextInt();
					scan.nextLine();
					int x=0;
					for (int i = 0; i < d ; i++) {
						if(x>0) {
							System.out.println("Please determine the next control");
						}
						control_object.setControlName(scan.nextLine());
						System.out.println("Please assign the implementation status of "+ control_object.getControlName());
						double st=scan.nextDouble();
						control_object.setImplementationStatus(st);
						control_list.add(control_object);
						scan.nextLine();
						control_object = new Control();
						x++;
					}
						PossibleControl possible_control_object = new PossibleControl();
						possible_control_object.setThreatName(t.getThreatName());
						possible_control_object.setCnotrols(control_list);
						//threat existence calculation
						double w=0;
						for (int j = 0; j < control_list.size(); j++) {
							w=w+ possible_control_object.getCnotrols().get(j).getImplementationStatus();
						}
						w= w/control_list.size();
						possible_control_object.setThreatExistence(1-w);
						possible_control_list.add(possible_control_object);
						control_list = new ArrayList<Control>();
						c++;
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			if (brt != null) {
				try {
					brt.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		ControlResult control_result = new ControlResult();
		control_result.setPossibleControls(possible_control_list);
		Gson gs = new GsonBuilder().setPrettyPrinting().create();
		String strjson = gs.toJson(control_result);
		FileWriter writer = null;
		try {
			writer = new FileWriter("src//jsonFiles//Threat_Controls.json");
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
