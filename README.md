# Multi-Stakeholder Risk Assessment Tool

It is a risk assessment tool that assesses the risk exposure levels in a multi-stakeholder manner for a given system. The tool has a two-fold purpose, (I) Evaluate and quantify risk levels for all involved stakeholders, and (II) Solving the risk minimization problem, which is a multi-objective optimization problem.  
This tool works based on JSON file, all inputs and outputs. Before using the tool, we invite you to read the documentation files (see Documents Section) in order to have a clear view of how this tool works. The documents are the research papers that define the Multi-Stakeholder Risk Minimization Problem and solve this problem.


## Requirements
```
-Java 8 or higher
-Scala SDK V.2.13.2
-JavaFx SDK V.11.0.2 (for plotting the result)
-Gson library V.2.8.6 
```
## How to use
```
1. Clone the project
2. Import project into your desire IDE (our recommendation is IntelliJ IDEA)
3. Define or import input files (i.e., adding the needed JSON files, such as Threats, Goals, etc.)
```
## Description of the tool
The tool is divide into two main phases, **1) Risk evaluation 2) Optimization**

For the first phase, you need to define three JSON files (`Threats`, `Goals`, `Stakeholder`) as input artifacts and three other JSON files as can be considered association actions (`Threat_Impact`, `Threat_Controls`, `Threat_Affected`) , and for the second, you need one additional JSON file which is `Threat_Existence`. 
You can either create the input JSON files manually, according to the existing example in the clone project *(jsonFiles folder)* and its files structures, or automatically. For manually way, you just need knowledge about JSON file structure which you can follow the sample files in *jsonFiles folder*. For automatically, you need to follow the preliminary steps:

**Note:** All classes have mentioned below are defined in the *action folder*.

1. Define Threats: In order to define the list of threats in your system you can run ``ThreatDetermining.java`` class then define number of threats and their name through the console. The resuult stores in the `Threats` JSON file.

2. Define Stakeholders and their impact Criteria: The involved stakeholders in the analysis and their impact criteria can be determined through ``StakeholderDetermining.java`` class and then the result stores in the `Stakeholder` JSON file. For example, a stakeholder can be *Data subject*, and *Social situation, Individual freedom, Health condition and Financial situation* are its impact criteria.

3. Define Protection Goals: The protection goals can be specified through ``GoalDetermining.java`` class and then the result stores in the `Goals` JSON file, for example, *confidentiality, integrity, and availability*.

4. Determine Threat-Protection Goal Association : Through this association, you can specify the relation between threats and goals in other word, each threat affect which protection goals. For example, Unauthorized access threat affects confidentiality and integrity protection goals. Through ``ThreatGoalAssociation.java`` class you can specify this association, and the result stores in the `Threat_Affected` JSON file. 

5. Associate Threat Impacts: According to their impact criteria, the impact level of each threat for all involved stakeholders determines in `Threat_Impact` JSON file. In fact, in this action, the risk analyst assigns an integer value to the aversion level that each stakeholder is considered to have against each threat, according to his/her criteria. Through ``PreferenceImpacting.java`` class you can determine the impact levels.

6. Determine Controls: In this step, you can determine for each threat the potential controls. Through ``ControlDetermining.java`` class you can determine the controls for each threat, and then result stored in the `Threat_Controls` JSON file.

**1) Risk Calculation**

To calculate risk, you need to run ``FinalRiskExposure.java`` class from *action folder*, and the result will be stored in the ``Risk_Exposure_Result`` JSON file. This file contains the risk levels in terms of protection goals for all involved stakeholders. 

**2) Optimization**

For optimization, apart from the input artifacts defined in the preliminary steps, the tool needs one additional input, the `Threat_Existence` JSON file. This JSON file needs to perform optimization where you must define all possible threat existence values for each threat. Hence, you need to define this input within the *jsonFile folder*. You can follow the sample in this folder to create the required input file. 
In order to perform optimization and plot the result, you just need to Run `` RunOptimization.java `` class from the *optimization folder*. Notice that plotting will take time which depends on the size of the threat list. After plotting, you will be asked to specify the minimum risk level for each stakeholder to see the Pareto optimal points, which you need to insert a **Double Value** from (0,1) interval.  


# Documents
This tool is part of following research papers:
1. Multi-Stakeholder Cybersecurity Risk Assessment for Data Protection [SECRYPT 2020](https://www.researchgate.net/profile/Majid_Mollaeefar2/publication/342887924_Multi-Stakeholder_Cybersecurity_Risk_Assessment_for_Data_Protection/links/5f0c0e5aa6fdcc4ca4662b8f/Multi-Stakeholder-Cybersecurity-Risk-Assessment-for-Data-Protection.pdf).
2. Identifying and Quantifying Trade-offs in Multi-Stakeholder Risk Evaluation with Applications to the Data Protection Impact Assessment of the GDPR [Underwriting]
