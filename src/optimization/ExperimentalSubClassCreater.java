package optimization;

import affection.AffectionResult;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Please note that this class is created to perform experimental test, and it should be run before "ExperimentalSubExecution.java"
 * To run it, you need to provide the requested JSON files then it results to recreate "ExperimentalSubExecution.java"
 * according your configuration in JSON files.
 */

public class ExperimentalSubClassCreater {

    public static void main( String[] args) throws Exception {
        List<List<Double>> List_TC = new ArrayList<>();
        Gson gson = new Gson();
        BufferedReader brte = new BufferedReader(new FileReader("src//jsonFiles//Threat_Existence.json"));
        ThreatExistenceResult rs = gson.fromJson(brte, ThreatExistenceResult.class);
        BufferedReader brta = new BufferedReader(new FileReader("src//jsonFiles//Threat_Affected.json"));
        AffectionResult as = gson.fromJson(brta, AffectionResult.class);
        int d = 0;
        for (ThreatExistence te : rs.getThreatExistence()) {
            List<Double> TC = new ArrayList<>();
            for (int i = 0; i < te.getImplementationStatus().size(); i++) {
                TC.add((1 - te.getImplementationStatus().get(i) / (te.getImplementationStatus().size() / 2)) * as.getThreat().get(d).getObservationWeight());
            }
            List_TC.add(TC);
            d++;
        }
        File sourceFile = new File("src/optimization/ExperimentalSubExecution.java");
        String start ="package optimization;\n" +
                "\n" +
                "import affection.AffectionResult;\n" +
                "import com.google.gson.Gson;\n" +
                "import java.time.Instant;\n" +
                "import impact.ThreatImpactAssessmentResult;\n" +
                "import input.Threat;\n" +
                "import input.ThreatResult;\n" +
                "import java.io.*;\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.List;" +
                "public class ExperimentalSubExecution\n" +
                "{\n" +
                "  public static void main (String[]args) throws FileNotFoundException \n" +
                "  {\n";
        String list= " List<List<Double>> List_TC = new ArrayList<>();\n" +
                "        Gson g = new Gson();\n" +
                "        long startTime = Instant.now().toEpochMilli();\n" +
                "        System.out.println(\"The computation is started! Be patient...\");"+
                "        BufferedReader brte = new BufferedReader(new FileReader(\"src//jsonFiles//Threat_Existence.json\"));\n" +
                "        ThreatExistenceResult rs = g.fromJson(brte, ThreatExistenceResult.class);\n" +
                "        BufferedReader brta = new BufferedReader(new FileReader(\"src//jsonFiles//Threat_Affected.json\"));\n" +
                "        AffectionResult as = g.fromJson(brta, AffectionResult.class);\n" +
                "        int d= 0;\n" +
                "            for (ThreatExistence te : rs.getThreatExistence()) {\n" +
                "                List<Double> TC = new ArrayList<>();\n" +
                "                for (int i = 0; i < te.getImplementationStatus().size(); i++) {\n" +
                "                    TC.add((1 - te.getImplementationStatus().get(i) / (te.getImplementationStatus().size() / 2)) * as.getThreat().get(d).getObservationWeight());\n" +
                "                }\n" +
                "                List_TC.add(TC);\n" +
                "                d++;\n" +
                "        }";
        String p1="      Gson gson1 = new Gson();\n" +
                "        List<AllThreatAssessment> allTA_List = new ArrayList<>();\n" +
                "        int ID1 = 1;\n" +
                "        BufferedReader brti = new BufferedReader(new FileReader(\"src//jsonFiles//Threat_Impact.json\"));\n" +
                "        ThreatImpactAssessmentResult resulttia = gson1.fromJson(brti, ThreatImpactAssessmentResult.class);\n" +
                "        Gson gson = new Gson();\n" +
                "        BufferedReader br = new BufferedReader(new FileReader(\"src//jsonFiles//Threats.json\"));\n" +
                "        ThreatResult result = gson.fromJson(br, ThreatResult.class);\n" +
                "        int ID = 0;";
        String p2= "if (ntc > 0) {\n" +
                "                                        if (result != null) {\n" +
                "                                            List<ThreatCriticality> TC_LIST = new ArrayList<>();\n" +
                "                                            int ss = 0;\n" +
                "                                            for (Threat t : result.getThreat()) {\n" +
                "                                                ThreatCriticality TC_obj = new ThreatCriticality();\n" +
                "                                                TC_obj.setThreatname(t.getThreatName());\n" +
                "                                                TC_obj.setNormalizedCriticality(ntc_temp[ss] / ntc);\n" +
                "                                                TC_LIST.add(TC_obj);\n" +
                "                                                ss++;\n" +
                "                                            }\n" +
                "                                            ID++;\n" +
                "                                            AllPossibleThreatCriticality alptc_obj = new AllPossibleThreatCriticality();\n" +
                "                                            alptc_obj.setThreatCriticality(TC_LIST);\n" +
                "                                            alptc_obj.setID(ID);\n" +
                "                                             //..\n" +
                "                                                    AllThreatAssessment allTA_Obj = new AllThreatAssessment();\n" +
                "                                                    int j = 0;\n" +
                "                                                    List<ThreatAssessment> TA_List = new ArrayList<>();\n" +
                "                                                    for (int f = 0; f < alptc_obj.getThreatCriticality().size(); f++) {\n" +
                "                                                        ThreatAssessment TA_Obj = new ThreatAssessment();\n" +
                "                                                        List<Stakeholder> stk_list = new ArrayList<>();\n" +
                "                                                        TA_Obj.setThreatName(alptc_obj.getThreatCriticality().get(f).getThreatname());\n" +
                "                                                        for (int u=0; u<2;u++)   {\n" +
                "                                                            Stakeholder stk_obj = new Stakeholder();\n" +
                "                                                            stk_obj.setStakeholderName(resulttia.getThreatImpactAssessment().get(j*2+u).getStakeholder().get(0).getStakeholderName());\n" +
                "                                                            double h = alptc_obj.getThreatCriticality().get(f).getNormalizedCriticality() * resulttia.getThreatImpactAssessment().get(j*2+u).getStakeholder().get(0).getThreatImpactLevel();\n" +
                "                                                            stk_obj.setThreatRisk(h);\n" +
                "                                                            stk_list.add(stk_obj);\n" +
                "                                                        }\n" +
                "                                                        TA_Obj.setStakeholder(stk_list);\n" +
                "                                                        TA_List.add(TA_Obj);\n" +
                "                                                        j++;\n" +
                "                                                    }\n" +
                "                                                    allTA_Obj.setID(ID1);\n" +
                "                                                    allTA_Obj.setThreatAssessment(TA_List);\n" +
                "                                                    allTA_List.add(allTA_Obj);\n" +
                "                                                    ID1++;" +
                "       }\n" + "}";
        String p3= "      // Get current size of heap in bytes\n" +
                "        long heapSize = Runtime.getRuntime().totalMemory();\n" +
                "        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.\n" +
                "        long heapMaxSize = Runtime.getRuntime().maxMemory();\n" +
                "        // Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.\n" +
                "        //long heapFreeSize = Runtime.getRuntime().freeMemory();\n" +
                "        System.out.println(\"The current heap size is: \"+heapSize/1048576+\" Megabyte\");\n" +
                "        System.out.println(\"The maximum heap size is: \"+ heapMaxSize/1048576 +\" Megabyte\");\n" +
                "        //System.out.println(\"The free heap size is: \"+ heapFreeSize/1048576+\" Megabyte\");\n" +
                "        System.out.println(\"Size of Solution Set equals: \" + allTA_List.size());\n" +
                "        long endTime = Instant.now().toEpochMilli();\n" +
                "        long timeElapsed = endTime - startTime;\n" +
                "        System.out.println(\"Execution time in milliseconds: \" + timeElapsed);";

        int size_list = List_TC.size();
        int x=0;
        StringBuilder st= new StringBuilder();
        StringBuilder pp = new StringBuilder("double ntc=");
        String nn= "double ntc_temp [];";
        StringBuilder nn1= new StringBuilder("ntc_temp = new double []{");
        for (int j=0; j< size_list; j++) {
            String ff = "for (int i" + x + " = 0; i" + x + " <" + List_TC.get(j).size() + "; i" + x + "++) {\n";
            st.append(ff);
            if (j<1) {
                String gh = "List_TC.get(" + j + ").get(i" + x + ")";
                pp.append(gh);
                nn1.append(gh);
            } else {
                String gh = "List_TC.get(" + j + ").get(i" + x + ")";
                pp.append("+").append(gh);
                nn1.append(",").append(gh);
            }

            x++;
            // write the source code into the source file
        }
        String nn2 = "};";
        String tt=pp+";";
        StringBuilder bb= new StringBuilder();
        for (int j=0; j< size_list; j++) {
            bb.append("}\n");
        }
        String sourceCode = start+list+p1+st+tt+nn+nn1+nn2+p2+bb+p3+"}\n}";
        //     System.out.print(sourceCode);
        FileWriter writer = new FileWriter(sourceFile);
        writer.write(sourceCode);
        writer.close();



    }
}
