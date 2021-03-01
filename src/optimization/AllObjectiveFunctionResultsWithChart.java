package optimization;

import affection.AffectionResult;
import affection.Threats;
import assessment.GoalExposure;
import chart.ChartCreater;
import chart.SeriesCreater;
import com.google.gson.Gson;
import input.Goal;
import input.GoalsResult;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class AllObjectiveFunctionResultsWithChart {

    public static void main( String[] args ) throws Exception {

        Gson gson = new Gson();
        BufferedReader brg = new BufferedReader(new FileReader("src//jsonFiles//Goals.json"));
        BufferedReader brta = new BufferedReader(new FileReader("src//jsonFiles//Threat_Affected.json"));
        BufferedReader brtrc = new BufferedReader(new FileReader("src//jsonFiles//All_Threat_Risk_Calculations.json"));
        GoalsResult resultg = gson.fromJson(brg, GoalsResult.class);
        AffectionResult resultaf = gson.fromJson(brta, AffectionResult.class);
        AllThreatAssessmentResult resulta = gson.fromJson(brtrc, AllThreatAssessmentResult.class);
        //System.out.println(resulta.getAllThreatAssessments().size());
        System.out.println("All objective functions are calculating..." );
        //data subject
        double[] F1 = new double[resulta.getAllThreatAssessments().size()];
        //data controller
        double[] F2 = new double[resulta.getAllThreatAssessments().size()];

        for (int j = 0; j < resulta.getAllThreatAssessments().size(); j++) {
            int stk_counter = 0;
            for (Stakeholder stk : resulta.getAllThreatAssessments().get(0).getThreatAssessment().get(0).getStakeholder()) {
                // System.out.println(stk.getStakeholderName());
                GoalExposure goal_exposure_object = new GoalExposure();
                goal_exposure_object.setStakeholderName(stk.getStakeholderName());
                double final_risk = 0;
                for (Goal g : resultg.getGoals()) {
                    double goal_risk = 0;
                    int threat_counter = 0;
                    int number_of_affected = 0;
                    assessment.Goal goal_object = new assessment.Goal();
                    goal_object.setGoalName(g.getName());
                    for (Threats t : resultaf.getThreat()) {
                        for (int i = 0; i < t.getAffectedGoals().size(); i++) {
                            if (g.getName().equals(t.getAffectedGoals().get(i).getAffectedGoalName())) {
                                goal_risk = goal_risk + resulta.getAllThreatAssessments().get(j).getThreatAssessment().get(threat_counter).getStakeholder().get(stk_counter).getThreatRisk();
                                number_of_affected = number_of_affected + 1;
                            }

                        }
                        threat_counter++;
                    }
                    if (goal_risk > 0 && number_of_affected > 0) {
                        final_risk += (goal_risk / number_of_affected);
                    }
                }
                if (stk_counter < 1) {
                    BigDecimal bd1 = new BigDecimal(final_risk).setScale(4, RoundingMode.HALF_UP);
                    F1[j] = bd1.doubleValue();
                }
                else {
                    BigDecimal bd2 = new BigDecimal(final_risk).setScale(4, RoundingMode.HALF_UP);
                    F2[j] = bd2.doubleValue();
                }
                stk_counter++;
            }
        }
        //Plot the result
        System.out.println("Be patient! Plotting may take a few minutes..." );
        ChartCreater chart_object = new ChartCreater();
        SeriesCreater sc_obj = new SeriesCreater();
        sc_obj.setX(F1);
        sc_obj.setY(F2);
        chart_object.locallaunch(args);
        //System.out.println("Done!");
    }
}
