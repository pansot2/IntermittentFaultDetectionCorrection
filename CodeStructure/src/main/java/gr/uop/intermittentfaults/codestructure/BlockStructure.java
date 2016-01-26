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
public class BlockStructure implements FieldParamMethodStructure,Comparable<BlockStructure>{
    private int blockNum;
    private ArrayList<Info> blockInfo;
    private ArrayList<VariableStructure> variables;
    private ArrayList<BlockStructure> childBlocks;
    private BlockStructure blockParent;
    private MethodStructure methodParent;

    public BlockStructure() {
        this.blockNum = 0;
        this.blockInfo = new ArrayList<>();
        this.variables = new ArrayList<>();
        this.blockParent = null;
        this.methodParent = null;
        this.childBlocks = new ArrayList<>();
    }

    public BlockStructure(ArrayList<BlockStructure>  childBlocks, int blockNum, String blockName, ArrayList<Info> blockInfo, ArrayList<VariableStructure> variables, BlockStructure blockParent, MethodStructure methodParent) {
        this.blockNum = blockNum;
        this.blockInfo = blockInfo;
        this.variables = variables;
        this.blockParent = blockParent;
        this.methodParent = null;
        this.childBlocks = childBlocks;
    }

    public int getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(int blockNum) {
        this.blockNum = blockNum;
    }

    public ArrayList<Info> getBlockInfo() {
        return blockInfo;
    }

    public ArrayList<BlockStructure> getChildBlocks() {
        return childBlocks;
    }

    public void setChildBlocks(ArrayList<BlockStructure> childBlocks) {
        this.childBlocks = childBlocks;
    }
    
    public void addChildBlockStructure(BlockStructure childBlockStructure) {
        this.childBlocks.add(childBlockStructure);
        childBlockStructure.setBlockParent(this);
    }

    public void removeChildBlockStructure(BlockStructure childBlockStructure) {
        this.childBlocks.remove(childBlockStructure);
    }

    public void setBlockInfo(ArrayList<Info> blockInfo) {
        this.blockInfo = blockInfo;
    }
    
    public void addBlockInfo(Info blockInfo) {
        this.blockInfo.add(blockInfo);
        blockInfo.setParent(this);
    }

    public void removeBlockInfo(Info blockInfo) {
        this.blockInfo.remove(blockInfo);
    }

    public ArrayList<VariableStructure> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<VariableStructure> variables) {
        this.variables = variables;
    }
    
    public void addVariableStructure(VariableStructure variableStructure) {
        this.variables.add(variableStructure);
        variableStructure.setBlockParent(this);
    }

    public void removeVariableStructure(VariableStructure variableStructure) {
        this.variables.remove(variableStructure);
    }
    
    public MethodStructure getMethodParent() {
        return methodParent;
    }
    
    public BlockStructure getBlockParent() {
        return blockParent;
    }

    public void setBlockParent(BlockStructure blockParent) {
        this.blockParent = blockParent;
    }
    
    public void setMethodParent(MethodStructure methodParent) {
        this.methodParent = methodParent;
    }

    public void printBlockStructure() {
        System.out.println("----- BLOCK STRUCTURE -----");
        System.out.println("BLOCK NUM : " + this.blockNum);
        System.out.println("BLOCK INFO : ");
        for (Info info : blockInfo) {
            info.printInfo();
        }
        
        System.out.println("VARIABLE STRUCTURE : ");
        for (VariableStructure variable : variables) {
            variable.printVariableStructure();
        }
        
        System.out.println("CHILD BLOCK STRUCTURE : ");
        for (BlockStructure block : childBlocks) {
            block.printBlockStructure();
        }
    }
    
    @Override
    public int compareTo(BlockStructure mStructure2) {
        int equal = 0;

        if (this.methodParent != mStructure2.getMethodParent()) {
            equal = -1;
        }else if (this.blockParent != mStructure2.getBlockParent()) {
            equal = -1;
        }else if (!this.blockInfo.equals(mStructure2.getBlockInfo())) {
            equal = -1;
        }else if (this.blockNum != mStructure2.getBlockNum()) {
            equal = -1;
        }
        
        return equal;
    }
    
}
