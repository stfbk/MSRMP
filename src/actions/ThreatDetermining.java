package actions;

import com.google.gson.Gson;
import input.Threat;
import input.ThreatResult;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThreatDetermining {

	public static void main( String[] args) {

		Gson gson = new Gson();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src//jsonFiles//Threats.json"));
			ThreatResult result = gson.fromJson(br, ThreatResult.class);

			if (result != null) {
				for (Threat t : result.getThreat()) {
					//Do an action 
					System.out.println(t.getThreatName() + " ----->  " + t.getMaliciousAction());
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
