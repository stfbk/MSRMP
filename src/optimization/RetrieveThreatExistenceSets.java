package optimization;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RetrieveThreatExistenceSets {
// To Retrieve under which Threat Existence combinations the solutions has been obtained.
    public static void main (String[] args ) throws FileNotFoundException {
        //Pareto Solution IDs must be insert in the following ArrayList
        List<Integer> Solution_IDs = new ArrayList<>(Arrays.asList(9292,15029, 27137,27454,27868, 33191));
        //List<Integer> Solution_IDs = new ArrayList<>(Arrays.asList(3, 14, 19, 25, 43, 45));
        List<List<Double>> List_TC = new ArrayList<>();
        List<List<Double>> FinalList = new ArrayList<>();
        Gson g = new Gson();
        BufferedReader brte = new BufferedReader(new FileReader("src//jsonFiles//Threat_Existence.json"));
        ThreatExistenceResult rs = g.fromJson(brte, ThreatExistenceResult.class);
        for (ThreatExistence te : rs.getThreatExistence()) {
            List_TC.add(te.getImplementationStatus());
        }
        int x = 0;
        int y = 0;
        for (int i0 = 0; i0 < 10; i0++) {
            for (int i1 = 0; i1 < 20; i1++) {
                for (int i2 = 0; i2 < 8; i2++) {
                    for (int i3 = 0; i3 < 6; i3++) {
                        for (int i4 = 0; i4 < 6; i4++) {
                            x++;
                            if (y<Solution_IDs.size() ) {
                                if (Solution_IDs.get(y) == x) {
                                    List<Double> List1 = new ArrayList<>();
                                    List1.add(List_TC.get(0).get(i0));
                                    List1.add(List_TC.get(1).get(i1));
                                    List1.add(List_TC.get(2).get(i2));
                                    List1.add(List_TC.get(3).get(i3));
                                    List1.add(List_TC.get(4).get(i4));
                                    FinalList.add(List1);
                                    y++;
                                }
                            }
                            else break;
                        }
                    }
                }
            }
        }
        System.out.println("----The Solutions have Obtained by the following Threat Existence Combinations----");
        for (int i=0; i< FinalList.size(); i++){
            System.out.println(FinalList.get(i));
            System.out.println("-------------");
        }
    }
}
