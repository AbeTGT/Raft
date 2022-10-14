package me.abetgt.raft;

import java.util.HashMap;

public class RaftVariable {

    // Fixed warning: Warning:(7, 62) Explicit type argument String, String can be replaced with <>
    HashMap<String, String> variableListString = new HashMap<>();

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
