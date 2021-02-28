package optimization;

import java.util.Scanner;

public class RunOptimization {
    public static void main( String[] args) throws Exception {

        //The class will create a java class (ExecuteThreatCriticalityClass) that help to create all possible TCs
        CreateThreatCriticalityClass.main(args);
        //All possible threat criticalities will create
        ExecuteThreatCriticalityClass.main(args);
        //Calculate all threat risk exposures for stakeholders
        AllThreatRiskCalculation.main(args);
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to do? Plot All Objective Functions or skip and get Pareto Solutions: Yes/No? ");
        String d = scan.next();
        scan.nextLine();
        if (d.equals("Yes")||d.equals("y")||d.equals("yes")) {
            //Calculates risks based on goal exposures for stakeholders and Plot the Risk Levels
            AllObjectiveFunctionResultsWithChart.main(args);
        }
        System.out.println("Now you can get Pareto Solutions... \n");
        //Calculates Pareto Points
        ParetoSolution.main(args);
    }

}
