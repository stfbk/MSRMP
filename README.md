# Multi-Stakeholder Risk Minimization Problem (MSRMP)

## Description of the Project
Multi-Stakeholder Risk Minimization Problem

You can either create JSON files manually (according to the existing example and its files structures) or automatically through running the defined classes as follows:

**Note:** All executable classes are defined in the *action folder*.

1. Define Threats: In order to define the list of threats in your system you can run following java class then define number of threats and their name through the console. 

```Java
Run ThreatDetermining.java 
```
2. Define Stakeholders and their impact Criteria: The involved stakeholders in the analysis and their impact criteria define in the Stakeholder JSON file. For example, a stakeholder can be *Data subject*, and *Social situation, Individual freedom, Health condition and Financial situation* are its impact criteria.
```Java
Run StakeholderDetermining.java 
```
4. Define Protection Goals: The protection goals specify in the Goal JSON file, for example, *confidentiality, integrity, and availability*.
```Java
Run GoalDetermining.java 
```
5. Define Threat-Protection Goal Association: Through this action, you can specify the association between threats and goals in other word, each threat affect which protection goals. For example, Unauthorized access affects confidentiality and integrity protection goals.
```Java
Run ThreatGoalAssociation.java 
```
6. Define Threat Impacts: According to their impact criteria, the impact level of each threat for all involved stakeholders determines in Threat_Impact JSON file. In fact, in this action, the risk analyst assigns an integer value to the aversion level that each stakeholder is considered to have against each threat, according to his/her criteria.
```Java
Run PreferenceImpacting.java 
```

# How to use
1. Clone the project
2. Add the relevant Json files (Threats, Stakeholders, Goals, Threat_Impact, Threat_Controls, Threat_Affected) as 
