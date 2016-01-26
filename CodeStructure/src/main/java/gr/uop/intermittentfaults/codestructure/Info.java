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
public class Info implements Comparable<Info> {
    private String file;
    private String className;
    private int line;
    private int structureLength;
    private ArrayList<DependancyInfo> dependentOn;
    private ArrayList<DependancyInfo> dependancyOf;
    private FieldParamMethodStructure parent;

    public Info() {
        this.file = null;
        this.className = null;
        this.line = -1;
        this.structureLength = -1;
        this.dependentOn = new ArrayList<>();
        this.dependancyOf = new ArrayList<>();
        this.parent = null;
    }

    public Info(String file, String className, int line, ArrayList<DependancyInfo> dependentOn, ArrayList<DependancyInfo> dependancyOf, FieldParamMethodStructure parent, int structureLength) {
        this.file = file;
        this.className = className;
        this.line = line;
        this.structureLength = structureLength;
        this.dependentOn = dependentOn;
        this.dependancyOf = dependancyOf;
        this.parent = parent;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getStructureLength() {
        return structureLength;
    }

    public void setStructureLength(int structureLength) {
        this.structureLength = structureLength;
    }

    public ArrayList<DependancyInfo> getDependancyInfo() {
        return dependentOn;
    }

    public void setDependancyInfo(ArrayList<DependancyInfo> dependentOn) {
        this.dependentOn = dependentOn;
    }
    
    public void addDependancyInfo(DependancyInfo dependentOn) {
        this.dependentOn.add(dependentOn);
        dependentOn.setParent(this);
    }
    
    public void removeDependancyInfo(DependancyInfo dependentOn) {
        this.dependentOn.remove(dependentOn);
    }

    public ArrayList<DependancyInfo> getDependancyOf() {
        return dependancyOf;
    }

    public void setDependancyOf(ArrayList<DependancyInfo> dependancyOf) {
        this.dependancyOf = dependancyOf;
    }
    
    public void addDependancyOf(DependancyInfo dependancyOf) {
        this.dependancyOf.add(dependancyOf);
        dependancyOf.setParent(this);
    }
    
    public void removeDependancyOf(DependancyInfo dependancyOf) {
        this.dependancyOf.remove(dependancyOf);
    }

    public FieldParamMethodStructure getParent() {
        return parent;
    }

    public void setParent(FieldParamMethodStructure parent) {
        this.parent = parent;
    } 
    
    public void printInfo() {
        System.out.println("----- INFO -----");
        System.out.println("File : " + this.file + " ,ClassName : " + this.className + " ,line : " + this.line);
        System.out.println("DEPENDS ON : ");
        for (DependancyInfo dependancy : dependentOn) {
            dependancy.printDependancyInfo();
        }
        System.out.println("DEPENDANCY OF : ");
        for (DependancyInfo dependancy : dependancyOf) {
            dependancy.printDependancyInfo();
        }
    }
    
    @Override
    public int compareTo(Info fInfo2) {
        int equal = 0;

        if (this.parent != fInfo2.getParent()) {
            equal = -1;
        }else if (this.line != fInfo2.getLine()) {
            equal = -1;
        }else if (this.className.compareTo(fInfo2.getClassName()) != 0) {
            equal = -1;
        }else if (this.file.compareTo(fInfo2.getFile()) != 0) {
            equal = -1;
        }
        
        return equal;
    }
}
