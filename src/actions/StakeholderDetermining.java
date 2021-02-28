package actions;

import actors.Preference;
import actors.Stakeholder;
import actors.StakeholderResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
*	In this class, you determine your stakeholders and their preferences 
*/
public class StakeholderDetermining {

	public static void main( String[] args) {

		List<Stakeholder> stakeholder = new ArrayList<Stakeholder>();
		List<Stakeholder> stakeholder1 = new ArrayList<Stakeholder>();
		List<String> stakeholder_names = new ArrayList<String>();
		List<Preference> preference = new ArrayList<Preference>();
		// Preference pr= new Preference();
		Stakeholder stk = new Stakeholder();
		StakeholderResult sr = new StakeholderResult();
		@SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
		System.out.println("Determine the number of your stakeholders: ");
		int x = scan.nextInt();
		int d = 0;
		System.out.println("Datermine your stakeholders \n" + scan.nextLine());
		for (int j = 0; j < x; j++) {
			stakeholder_names.add(scan.nextLine());
			d++;
		}
		for (int i = 0; i < d; i++) {

			stk.setStakeholderName(stakeholder_names.get(i));
			stakeholder.add(stk);
		}
		int p = 0;
		for (int i = 0; i < d; i++) {
			System.out.println("Please determine the number of preference for the " + stakeholder_names.get(i));
			p = scan.nextInt();
			System.out.println("Please determine the preferences \n" + scan.nextLine());
			for (int j = 0; j < p; j++) {
				String prf = scan.nextLine();
				System.out.println("Please assign a weight to the "+prf+"\n");
				double w= scan.nextDouble();
				Preference pr = new Preference();
				pr.setPreferenceName(prf);
				pr.setPreferenceId(j + 1);
				pr.setPreferenceWeight(w);
				preference.add(pr);
				System.out.println("Please determine the next preferences \n"+ scan.nextLine());

			}
			Stakeholder stk1 = new Stakeholder();
			stk1.setStakeholderName(stakeholder_names.get(i));
			stk1.setPreferences(preference);
			stakeholder1.add(stk1);
			System.out.println("DONE for the " + stakeholder_names.get(i) + "\n");
			preference.clear();
			p = 0;
		}

		sr.setStakeholder(stakeholder1);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String strjson = gson.toJson(sr);
		FileWriter writer = null;
		try {
			writer = new FileWriter("Stakeholder.json");
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
