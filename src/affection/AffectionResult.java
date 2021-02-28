package affection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AffectionResult {

@SerializedName("Threats")
@Expose
private List<Threats> threat = null;


public AffectionResult() {
}

public AffectionResult( List<Threats> threat) {
this.threat = threat;
}

public List<Threats> getThreat() {
return threat;
}

public void setThreat( List<Threats> threat) {
this.threat = threat;
}

}