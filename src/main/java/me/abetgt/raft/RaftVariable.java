package me.abetgt.raft;

import java.util.HashMap;

public class RaftVariable {

    HashMap<String, String> variableListString = new HashMap<String, String>();

    public RaftVariable(){}

    public void createVariable(String variableName){
        variableListString.put(variableName, "");
    }

    public String getStringVariable(String variableName){
        String getVar = variableListString.get(variableName);
        if (getVar != null){
            return getVar;
        }
        return "";
    }
}