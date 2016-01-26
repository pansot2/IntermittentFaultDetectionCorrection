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
public class VariableStructure implements FieldParamMethodStructure,Comparable<VariableStructure>{
    private String variableName;
    private String variableType;
    private ArrayList<Info> variableInfo;
    private BlockStructure blockParent;
    private MethodStructure methodParent;


    public VariableStructure() {
        this.variableName = null;
        this.variableInfo = new ArrayList<>();
        this.blockParent = null;
        this.methodParent = null;
    }

    public VariableStructure(String variableName, ArrayList<Info> variableInfo, BlockStructure blockParent, MethodStructure methodParent) {
        this.variableName = variableName;
        this.variableInfo = variableInfo;
        this.blockParent = blockParent;
        this.methodParent = methodParent;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    public ArrayList<Info> getVariableInfo() {
        return variableInfo;
    }

    public void setVariableInfo(ArrayList<Info> variableInfo) {
        this.variableInfo = variableInfo;
    }
    
    public void addVariableInfo(Info variableInfo) {
        this.variableInfo.add(variableInfo);
        variableInfo.setParent(this);
    }

    public void removeVariableInfo(Info variableInfo) {
        this.variableInfo.remove(variableInfo);
    }

    public BlockStructure getBlockParent() {
        return blockParent;
    }

    public void setBlockParent(BlockStructure blockParent) {
        this.blockParent = blockParent;
    }
    
    public MethodStructure getMethodParent() {
        return methodParent;
    }

    public void setMethodParent(MethodStructure methodParent) {
        this.methodParent = methodParent;
    }
    
    public void printVariableStructure() {
        System.out.println("----- VARIABLE STRUCTURE -----");
        System.out.println("Variable " + variableName);
        System.out.println("Variable Type " + variableType);
        System.out.println("VARIABLE INFO : ");
        for (Info info : variableInfo) {
            info.printInfo();
        }

    }
    
    @Override
    public int compareTo(VariableStructure pStructure2) {
        int equal = 0;

        if (this.methodParent != pStructure2.getMethodParent()) {
            equal = -1;
        }else if (this.blockParent != pStructure2.getBlockParent()) {
            equal = -1;
        }else if (!this.variableInfo.equals(pStructure2.getVariableInfo())) {
            equal = -1;
        }else if (this.variableName.compareTo(pStructure2.getVariableName()) != 0) {
            equal = -1;
        }else if (this.variableType.compareTo(pStructure2.getVariableType()) != 0) {
            equal = -1;
        }
        
        return equal;
    }
}
