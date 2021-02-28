package optimization;

import affection.AffectionResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import input.Threat;
import input.ThreatResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;public class ExecuteThreatCriticalityClass
{
  public static void main (String[]args) throws FileNotFoundException 
  {
 List<List<Double>> List_TC = new ArrayList<>();
        Gson g = new Gson();
        BufferedReader brte = null;
        BufferedReader brta = null;
        brte = new BufferedReader(new FileReader("Threat_Existence.json"));
        ThreatExistenceResult rs = g.fromJson(brte, ThreatExistenceResult.class);
        brta = new BufferedReader(new FileReader("Threat_Affected.json"));
        AffectionResult as = g.fromJson(brta, AffectionResult.class);
        int d= 0;
        if (brte!= null && brta!= null) {
            for (ThreatExistence te : rs.getThreatExistence()) {
                List<Double> TC = new ArrayList<Double>();
                for (int i = 0; i < te.getImplementationStatus().size(); i++) {
                    TC.add((1 - te.getImplementationStatus().get(i) / (te.getImplementationStatus().size() / 2)) * as.getThreat().get(d).getObservationWeight());
                }
                List_TC.add(TC);
                d++;
            }
        }    Gson gson = new Gson();
       BufferedReader br = null;
       br = new BufferedReader(new FileReader("Threats.json"));
       ThreatResult result = gson.fromJson(br, ThreatResult.class);
       List<AllPossibleThreatCriticality> alptc = new ArrayList<>();
       AllPossibleTCResult alpResult= new AllPossibleTCResult();
int ID=0;for (int i0 = 0; i0 <10; i0++) {
for (int i1 = 0; i1 <20; i1++) {
for (int i2 = 0; i2 <8; i2++) {
for (int i3 = 0; i3 <6; i3++) {
for (int i4 = 0; i4 <6; i4++) {
double ntc=List_TC.get(0).get(i0)+List_TC.get(1).get(i1)+List_TC.get(2).get(i2)+List_TC.get(3).get(i3)+List_TC.get(4).get(i4);double ntc_temp [] = null;ntc_temp = new double []{List_TC.get(0).get(i0),List_TC.get(1).get(i1),List_TC.get(2).get(i2),List_TC.get(3).get(i3),List_TC.get(4).get(i4)};if (ntc>0) {
if (result != null) {
           List<ThreatCriticality> TC_LIST = new ArrayList<>();
           int ss=0;
           for (Threat t : result.getThreat()){
               ThreatCriticality TC_obj = new ThreatCriticality();
               TC_obj.setThreatname(t.getThreatName());
               TC_obj.setNormalizedCriticality(ntc_temp[ss]/ ntc);
               TC_LIST.add(TC_obj);
               ss++;
           }
ID++;
           AllPossibleThreatCriticality alptc_obj = new AllPossibleThreatCriticality();
           alptc_obj.setThreatCriticality(TC_LIST);
           alptc_obj.setID(ID);
           alptc.add(alptc_obj);
       }
}}
}
}
}
}
alpResult.setAllPossibleThreatCriticality(alptc);
       Gson gsons = new GsonBuilder().setPrettyPrinting().create();
       String strjson = gsons.toJson(alpResult);
       FileWriter writer = null;
       try {
           writer = new FileWriter("All_Possible_Threat_Criticalities.json");
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
       }}
}