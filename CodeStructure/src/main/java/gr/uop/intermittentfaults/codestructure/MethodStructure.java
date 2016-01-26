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
public class MethodStructure implements FieldParamMethodStructure,Comparable<MethodStructure>{
    private String methodName;
    private String methodReturnType;
    private ArrayList<Info> methodInfo;
    private ArrayList<ParameterStructure> parameters;
    private ArrayList<BlockStructure> blocks;
    private ClassStructure parent;

    public MethodStructure() {
        this.methodName = null;
        this.methodInfo = new ArrayList<>();
        this.parameters = new ArrayList<>();
        this.parent = null;
        this.blocks = new ArrayList<>();
    }

    public MethodStructure(String methodName, ArrayList<Info> methodInfo, ArrayList<ParameterStructure> parameters, ClassStructure parent, ArrayList<BlockStructure> blocks) {
        this.methodName = methodName;
        this.methodInfo = methodInfo;
        this.parameters = parameters;
        this.parent = parent;
        this.blocks = blocks;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodReturnType() {
        return methodReturnType;
    }

    public void setMethodReturnType(String methodReturnType) {
        this.methodReturnType = methodReturnType;
    }

    public ArrayList<Info> getMethodInfo() {
        return methodInfo;
    }

    public void setMethodInfo(ArrayList<Info> methodInfo) {
        this.methodInfo = methodInfo;
    }
    
    public void addMethodInfo(Info methodInfo) {
        this.methodInfo.add(methodInfo);
        methodInfo.setParent(this);
    }

    public void removeMethodInfo(Info methodInfo) {
        this.methodInfo.remove(methodInfo);
    }

    public ArrayList<ParameterStructure> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<ParameterStructure> parameters) {
        this.parameters = parameters;
    }
    
    public void addParameterStructure(ParameterStructure parameterStructure) {
        this.parameters.add(parameterStructure);
        parameterStructure.setParent(this);
    }

    public void removeParameterStructure(ParameterStructure parameterStructure) {
        this.parameters.remove(parameterStructure);
    }

    public ArrayList<BlockStructure> getBlock() {
        return blocks;
    }

    public void setBlock(ArrayList<BlockStructure> blocks) {
        this.blocks = blocks;
    }
    
    public void addBlockStructure(BlockStructure blockStructure) {
        this.blocks.add(blockStructure);
        blockStructure.setMethodParent(this);
    }

    public void removeBlockStructure(BlockStructure blockStructure) {
        this.blocks.remove(blockStructure);
    }

    public ClassStructure getParent() {
        return parent;
    }

    public void setParent(ClassStructure parent) {
        this.parent = parent;
    }

    public void printMethodStructure() {
        System.out.println("----- METHOD STRUCTURE -----");
        System.out.println("Method " + methodName);
        System.out.println("Method Return Type " + methodReturnType);
        System.out.println("METHOD INFO : ");
        for (Info info : methodInfo) {
            info.printInfo();
        }
        System.out.println("PARAMETER STRUCTURE : ");
        for (ParameterStructure parameter : parameters) {
            parameter.printParameterStructure();
        }
        System.out.println("BLOCK STRUCTURE : ");
        for (BlockStructure block : blocks) {
            block.printBlockStructure();
        }

    }
    
    @Override
    public int compareTo(MethodStructure mStructure2) {
        int equal = 0;

        if (this.parent != mStructure2.getParent()) {
            equal = -1;
        }else if (!this.methodInfo.equals(mStructure2.getMethodInfo())) {
            equal = -1;
        }else if (this.methodName.compareTo(mStructure2.getMethodName()) != 0) {
            equal = -1;
        }
        
        return equal;
    }
    
}
