package optimization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import impact.ThreatImpactAssessment;
import impact.ThreatImpactAssessmentResult;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * To use this class, you must already have calculated (1) All Threat criticalities & (2) Threat impact.
 * This class calculates all threat risk exposures for different stakeholders (data subject & data controller)
 * @author MajidMollaeefar
 */
public class AllThreatRiskCalculation {

    public static void main( String[] args) throws Exception {
        List<AllThreatAssessment> allTA_List = new ArrayList<>();
        int ID=1;
        Gson gson = new Gson();
        BufferedReader brtc = new BufferedReader(new FileReader( "src//jsonFiles//All_Possible_Threat_Criticalities.json"));
        BufferedReader brti = new BufferedReader(new FileReader("src//jsonFiles//Threat_Impact.json"));
        AllPossibleTCResult aptc_result = gson.fromJson(brtc, AllPossibleTCResult.class);
        ThreatImpactAssessmentResult resulttia = gson.fromJson(brti, ThreatImpactAssessmentResult.class);
       // if (brtc != null && brti != null) {
            for (AllPossibleThreatCriticality c : aptc_result.getAllPossibleThreatCriticality()) {
                AllThreatAssessment allTA_Obj= new AllThreatAssessment();
                // System.out.println(c.getThreatCriticality().size());
                int j = 0;
                List<ThreatAssessment> TA_List = new ArrayList<>();
                for (int i = 0; i < c.getThreatCriticality().size(); i++) {
                    ThreatAssessment TA_Obj = new ThreatAssessment();
                    List<Stakeholder> stk_list = new ArrayList<>();
                    TA_Obj.setThreatName(c.getThreatCriticality().get(i).getThreatname());
                   // System.out.println(c.getThreatCriticality().get(i).getThreatname());
                        for (ThreatImpactAssessment tia : resulttia.getThreatImpactAssessment()) {
                      //      System.out.println(tia.getThreatName());
                            if (tia.getThreatName().equals(c.getThreatCriticality().get(j).getThreatname())) {
                                Stakeholder stk_obj = new Stakeholder();
                                stk_obj.setStakeholderName(tia.getStakeholder().get(0).getStakeholderName());
                                double d = c.getThreatCriticality().get(i).getNormalizedCriticality() * tia.getStakeholder().get(0).getThreatImpactLevel();
                                stk_obj.setThreatRisk(d);
                                //d = 0;
                                stk_list.add(stk_obj);
                            }
                        }
                     TA_Obj.setStakeholder(stk_list);
                     TA_List.add(TA_Obj);
                     j++;
                }
                allTA_Obj.setID(ID);
                allTA_Obj.setThreatAssessment(TA_List);
                allTA_List.add(allTA_Obj);
                ID++;
            }
        //}
        AllThreatAssessmentResult allTA_result= new AllThreatAssessmentResult();
        allTA_result.setAllThreatAssessments(allTA_List);
        Gson gsons = new GsonBuilder().setPrettyPrinting().create();
        String strjson = gsons.toJson(allTA_result);
        FileWriter writer;
        writer = new FileWriter("src//jsonFiles//All_Threat_Risk_Calculations.json");
        writer.write(strjson);
        writer.flush();
        writer.close();
    }
}
