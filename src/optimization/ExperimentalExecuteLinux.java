package optimization;

import affection.AffectionResult;
import com.google.gson.Gson;

import java.time.Instant;

import impact.ThreatImpactAssessmentResult;
import input.Threat;
import input.ThreatResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class only works when you plan to run experimental on linux machine,
 * you just need to replace the "For loops" that have been created for "ExperimentalSubCExecution.java" with "For loops" of this class.
 */
public class ExperimentalExecuteLinux {
    public static void main( String[] args ) throws FileNotFoundException {
        List<List<Double>> List_TC = new ArrayList<>();
        Gson g = new Gson();
        long startTime = Instant.now().toEpochMilli();
        System.out.println("The computation is started! Be patient...");
        BufferedReader brte = new BufferedReader(new InputStreamReader(ExperimentalExecuteLinux.class.getResourceAsStream("/" + "Threat_Existence.json")));
        ThreatExistenceResult rs = g.fromJson(brte, ThreatExistenceResult.class);
        BufferedReader brta = new BufferedReader(new InputStreamReader(ExperimentalExecuteLinux.class.getResourceAsStream("/" + "Threat_Affected.json")));
        AffectionResult as = g.fromJson(brta, AffectionResult.class);
        int d = 0;
        for (ThreatExistence te : rs.getThreatExistence()) {
            List<Double> TC = new ArrayList<>();
            for (int i = 0; i < te.getImplementationStatus().size(); i++) {
                TC.add((1 - te.getImplementationStatus().get(i) / (te.getImplementationStatus().size() / 2)) * as.getThreat().get(d).getObservationWeight());
            }
            List_TC.add(TC);
            d++;
        }
        Gson gson1 = new Gson();
        List<AllThreatAssessment> allTA_List = new ArrayList<>();
        int ID1 = 1;
        BufferedReader brti = new BufferedReader(new InputStreamReader(ExperimentalExecuteLinux.class.getResourceAsStream("/" + "Threat_Impact.json")));
        ThreatImpactAssessmentResult resulttia = gson1.fromJson(brti, ThreatImpactAssessmentResult.class);
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new InputStreamReader(ExperimentalExecuteLinux.class.getResourceAsStream("/" + "Threats.json")));
        ThreatResult result = gson.fromJson(br, ThreatResult.class);
        int ID = 0;
        for (int i0 = 0; i0 < 10; i0++) {
            for (int i1 = 0; i1 < 10; i1++) {
                for (int i2 = 0; i2 < 10; i2++) {
                    for (int i3 = 0; i3 < 10; i3++) {
                        for (int i4 = 0; i4 < 10; i4++) {
                            for (int i5 = 0; i5 < 10; i5++) {
                                for (int i6 = 0; i6 < 10; i6++) {
                                    for (int i7 = 0; i7 < 10; i7++) {
                                        for (int i8 = 0; i8 < 10; i8++) {
                                            for (int i9 = 0; i9 < 10; i9++) {
                                                double ntc = List_TC.get(0).get(i0) + List_TC.get(1).get(i1) + List_TC.get(2).get(i2) + List_TC.get(3).get(i3) + List_TC.get(4).get(i4) + List_TC.get(5).get(i5) + List_TC.get(6).get(i6) + List_TC.get(7).get(i7) + List_TC.get(8).get(i8) + List_TC.get(9).get(i9);
                                                double ntc_temp[];
                                                ntc_temp = new double[]{List_TC.get(0).get(i0), List_TC.get(1).get(i1), List_TC.get(2).get(i2), List_TC.get(3).get(i3), List_TC.get(4).get(i4), List_TC.get(5).get(i5), List_TC.get(6).get(i6), List_TC.get(7).get(i7), List_TC.get(8).get(i8), List_TC.get(9).get(i9)};
                                                if (ntc > 0) {
                                                    if (result != null) {
                                                        List<ThreatCriticality> TC_LIST = new ArrayList<>();
                                                        int ss = 0;
                                                        for (Threat t : result.getThreat()) {
                                                            ThreatCriticality TC_obj = new ThreatCriticality();
                                                            TC_obj.setThreatname(t.getThreatName());
                                                            TC_obj.setNormalizedCriticality(ntc_temp[ss] / ntc);
                                                            TC_LIST.add(TC_obj);
                                                            ss++;
                                                        }
                                                        ID++;
                                                        AllPossibleThreatCriticality alptc_obj = new AllPossibleThreatCriticality();
                                                        alptc_obj.setThreatCriticality(TC_LIST);
                                                        alptc_obj.setID(ID);
                                                        //..
                                                        AllThreatAssessment allTA_Obj = new AllThreatAssessment();
                                                        int j = 0;
                                                        List<ThreatAssessment> TA_List = new ArrayList<>();
                                                        for (int f = 0; f < alptc_obj.getThreatCriticality().size(); f++) {
                                                            ThreatAssessment TA_Obj = new ThreatAssessment();
                                                            List<Stakeholder> stk_list = new ArrayList<>();
                                                            TA_Obj.setThreatName(alptc_obj.getThreatCriticality().get(f).getThreatname());
                                                            for (int u = 0; u < 2; u++) {
                                                                Stakeholder stk_obj = new Stakeholder();
                                                                stk_obj.setStakeholderName(resulttia.getThreatImpactAssessment().get(j * 2 + u).getStakeholder().get(0).getStakeholderName());
                                                                double h = alptc_obj.getThreatCriticality().get(f).getNormalizedCriticality() * resulttia.getThreatImpactAssessment().get(j * 2 + u).getStakeholder().get(0).getThreatImpactLevel();
                                                                stk_obj.setThreatRisk(h);
                                                                stk_list.add(stk_obj);
                                                            }
                                                            TA_Obj.setStakeholder(stk_list);
                                                            TA_List.add(TA_Obj);
                                                            j++;
                                                        }
                                                        allTA_Obj.setID(ID1);
                                                        allTA_Obj.setThreatAssessment(TA_List);
                                                        allTA_List.add(allTA_Obj);
                                                        ID1++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory();
        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();
        // Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
        //long heapFreeSize = Runtime.getRuntime().freeMemory();
        System.out.println("The current heap size is: " + heapSize / 1048576 + " Megabyte");
        System.out.println("The maximum heap size is: " + heapMaxSize / 1048576 + " Megabyte");
        //System.out.println("The free heap size is: "+ heapFreeSize/1048576+" Megabyte");
        System.out.println("Size of Solution Set equals: " + allTA_List.size());
        long endTime = Instant.now().toEpochMilli();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + timeElapsed);
    }
}