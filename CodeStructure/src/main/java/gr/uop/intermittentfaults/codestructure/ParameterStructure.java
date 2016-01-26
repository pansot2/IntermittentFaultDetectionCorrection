/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.codestructure;

import java.util.ArrayList;

/**
 *
 * @author Panos
 */
public class ParameterStructure implements FieldParamMethodStructure,Comparable<ParameterStructure>{
    private String parameterName;
    private String parameterType;
    private ArrayList<Info> parameterInfo;
    private MethodStructure parent;

    public ParameterStructure() {
        this.parameterName = null;
        this.parameterInfo = new ArrayList<>();
        this.parent = null;
    }

    public ParameterStructure(String parameterName, ArrayList<Info> parameterInfo, MethodStructure parent) {
        this.parameterName = parameterName;
        this.parameterInfo = parameterInfo;
        this.parent = parent;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public ArrayList<Info> getParameterInfo() {
        return parameterInfo;
    }

    public void setParameterInfo(ArrayList<Info> parameterInfo) {
        this.parameterInfo = parameterInfo;
    }
    
    public void addParameterInfo(Info parameterInfo) {
        this.parameterInfo.add(parameterInfo);
        parameterInfo.setParent(this);
    }

    public void removeParameterInfo(Info parameterInfo) {
        this.parameterInfo.remove(parameterInfo);
    }

    public MethodStructure getParent() {
        return parent;
    }

    public void setParent(MethodStructure parent) {
        this.parent = parent;
    }
    
    public void printParameterStructure() {
        System.out.println("----- PARAMETER STRUCTURE -----");
        System.out.println("Parameter " + parameterName);
        System.out.println("Parameter Type " + parameterType);
        System.out.println("PARAMETER INFO : ");
        for (Info info : parameterInfo) {
            info.printInfo();
        }
    }
    
    @Override
    public int compareTo(ParameterStructure pStructure2) {
        int equal = 0;

        if (this.parent != pStructure2.getParent()) {
            equal = -1;
        }else if (!this.parameterInfo.equals(pStructure2.getParameterInfo())) {
            equal = -1;
        }else if (this.parameterName.compareTo(pStructure2.getParameterName()) != 0) {
            equal = -1;
        }
        
        return equal;
    }
}
