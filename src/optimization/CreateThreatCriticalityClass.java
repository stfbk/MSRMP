package optimization;

import affection.AffectionResult;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateThreatCriticalityClass {

   public static void main( String[] args) throws Exception {

       List<List<Double>> List_TC = new ArrayList<>();
       Gson gson = new Gson();
       BufferedReader brte;
       BufferedReader brta;
       brte = new BufferedReader(new FileReader("Threat_Existence.json"));
       ThreatExistenceResult rs = gson.fromJson(brte, ThreatExistenceResult.class);
       brta = new BufferedReader(new FileReader("Threat_Affected.json"));
       AffectionResult as = gson.fromJson(brta, AffectionResult.class);
       int d= 0;
       //if (brte!= null && brta!= null) {
           for (ThreatExistence te : rs.getThreatExistence()) {
               List<Double> TC = new ArrayList<>();
               for (int i = 0; i < te.getImplementationStatus().size(); i++) {
                   TC.add((1 - te.getImplementationStatus().get(i) / (te.getImplementationStatus().size() / 2)) * as.getThreat().get(d).getObservationWeight());
               }
               List_TC.add(TC);
               d++;
           }
       // }
       // create an empty source file
        File sourceFile = new File("src/optimization/ExecuteThreatCriticalityClass.java");
       // generate the source code, using the source filename as the class name
        //Start
       String start ="package optimization;\n" +
               "\n" +
               "import affection.AffectionResult;\n" +
               "import com.google.gson.Gson;\n" +
               "import com.google.gson.GsonBuilder;\n" +
               "import input.Threat;\n" +
               "import input.ThreatResult;\n" +
               "import java.io.*;\n" +
               "import java.util.ArrayList;\n" +
               "import java.util.List;" +
               "public class ExecuteThreatCriticalityClass\n" +
               "{\n" +
               "  public static void main (String[]args) throws FileNotFoundException \n" +
               "  {\n";
       String list= " List<List<Double>> List_TC = new ArrayList<>();\n" +
               "        Gson g = new Gson();\n" +
               "        BufferedReader brte = null;\n" +
               "        BufferedReader brta = null;\n" +
               "        brte = new BufferedReader(new FileReader(\"Threat_Existence.json\"));\n" +
               "        ThreatExistenceResult rs = g.fromJson(brte, ThreatExistenceResult.class);\n" +
               "        brta = new BufferedReader(new FileReader(\"Threat_Affected.json\"));\n" +
               "        AffectionResult as = g.fromJson(brta, AffectionResult.class);\n" +
               "        int d= 0;\n" +
               "        if (brte!= null && brta!= null) {\n" +
               "            for (ThreatExistence te : rs.getThreatExistence()) {\n" +
               "                List<Double> TC = new ArrayList<Double>();\n" +
               "                for (int i = 0; i < te.getImplementationStatus().size(); i++) {\n" +
               "                    TC.add((1 - te.getImplementationStatus().get(i) / (te.getImplementationStatus().size() / 2)) * as.getThreat().get(d).getObservationWeight());\n" +
               "                }\n" +
               "                List_TC.add(TC);\n" +
               "                d++;\n" +
               "            }\n" +
               "        }";
        //
       String p1="    Gson gson = new Gson();\n" +
               "       BufferedReader br = null;\n" +
               "       br = new BufferedReader(new FileReader(\"Threats.json\"));\n" +
               "       ThreatResult result = gson.fromJson(br, ThreatResult.class);\n" +
               "       List<AllPossibleThreatCriticality> alptc = new ArrayList<>();\n" +
               "       AllPossibleTCResult alpResult= new AllPossibleTCResult();\n"+ "int ID=0;";

       //1
        String p2= "if (ntc>0) {\n"+
                "if (result != null) {\n" +
                "           List<ThreatCriticality> TC_LIST = new ArrayList<>();\n" +
                "           int ss=0;\n" +
                "           for (Threat t : result.getThreat()){\n" +
                "               ThreatCriticality TC_obj = new ThreatCriticality();\n" +
                "               TC_obj.setThreatname(t.getThreatName());\n" +
                "               TC_obj.setNormalizedCriticality(ntc_temp[ss]/ ntc);\n" +
                "               TC_LIST.add(TC_obj);\n" +
                "               ss++;\n" +
                "           }\n" + "ID++;\n"+
                "           AllPossibleThreatCriticality alptc_obj = new AllPossibleThreatCriticality();\n" +
                "           alptc_obj.setThreatCriticality(TC_LIST);\n" +
                "           alptc_obj.setID(ID);\n" +
                "           alptc.add(alptc_obj);\n" +
                "       }\n" + "}";

       //2
       String p3="alpResult.setAllPossibleThreatCriticality(alptc);\n" +
               "       Gson gsons = new GsonBuilder().setPrettyPrinting().create();\n" +
               "       String strjson = gsons.toJson(alpResult);\n" +
               "       FileWriter writer = null;\n" +
               "       try {\n" +
               "           writer = new FileWriter(\"All_Possible_Threat_Criticalities.json\");\n" +
               "           writer.write(strjson);\n" +
               "       } catch (IOException e) {\n" +
               "\n" +
               "           e.printStackTrace();\n" +
               "       } finally {\n" +
               "           if (writer != null) {\n" +
               "               try {\n" +
               "                   writer.flush();\n" +
               "                   writer.close();\n" +
               "               } catch (IOException e) {\n" +
               "\n" +
               "                   e.printStackTrace();\n" +
               "               }\n" +
               "           }\n" +
               "       }";

       //3
       int size_list = List_TC.size();
       int x=0;
       int rr=0;
       String st="";
       String pp = "double ntc=";
//       String hh = "/ntc[rr]";
//       String yy="";
       String nn= "double ntc_temp [] = null;";
       String nn1= "ntc_temp = new double []{";
       for (int j=0; j< size_list; j++) {
           String ff = "for (int i" + x + " = 0; i" + x + " <" + List_TC.get(j).size() + "; i" + x + "++) {\n";
           st = st + ff;
           if (j<1) {
               String gh = "List_TC.get(" + j + ").get(i" + x + ")";
               pp = pp + gh;
               nn1 = nn1+ gh;
           } else {
               String gh = "List_TC.get(" + j + ").get(i" + x + ")";
               pp = pp +"+"+ gh;
               nn1 = nn1+"," +gh;
           }

           x++;
           // write the source code into the source file
       }
       String nn2 = "};";
       String tt=pp+";";
       String bb="";
       for (int j=0; j< size_list; j++) {
            bb=bb+"}\n";
       }
       String sourceCode = start+list+p1+st+tt+nn+nn1+nn2+p2+bb+p3+"}\n}";
  //     System.out.print(sourceCode);
           FileWriter writer = new FileWriter(sourceFile);
           writer.write(sourceCode);
           writer.close();

   }
} 