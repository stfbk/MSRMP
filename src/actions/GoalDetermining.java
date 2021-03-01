package actions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import input.Goal;
import input.GoalsResult;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GoalDetermining extends Goal {

	public static void main( String[] args) {
		List<Goal> goalslist = new ArrayList<>();
		List<String> goal_names = new ArrayList<>();
		@SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
		System.out.println("Determine number of your goals:");
		int x = scan.nextInt();
		int d = 0;
		System.out.println("Determine your goals:\n" + scan.nextLine());
		for (int j = 0; j < x; j++) {
			goal_names.add(scan.nextLine());
			d++;
		}
		for (int i = 0; i < d; i++) {

			// Scanner scan = new Scanner(System.in);
			// String y= "g"+i;
			Goal g = new Goal();
			g.setName(goal_names.get(i));
			// g.setName(scan.nextLine());
			g.setId(i + 1);
			goalslist.add(g);
		}

		GoalsResult r = new GoalsResult();
		// r.setGoals(Arrays.asList(g1,g2));
		r.setGoals(goalslist);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String strjson = gson.toJson(r);

		FileWriter writer = null;
		try {
			writer = new FileWriter("src//jsonFiles//Goals.json");
			writer.write(strjson);
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		System.out.println("DONE!");
	}

}
