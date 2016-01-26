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
public class ClassStructure implements Comparable<ClassStructure> {

    private String className;
    private ArrayList<FieldStructure> fields;
    private ArrayList<MethodStructure> methods;
    private FileStructure parent;

    public ClassStructure() {
        this.className = null;
        this.fields = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.parent = null;
    }
    
    public ClassStructure(String className, ArrayList<FieldStructure> fields, ArrayList<MethodStructure> methods, FileStructure parent) {
        this.className = className;
        this.fields = fields;
        this.methods = methods;
        this.parent = parent;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    public ArrayList<FieldStructure> getFields() {
        return fields;
    }

    public void setFields(ArrayList<FieldStructure> fields) {
        this.fields = fields;
    }

    public ArrayList<MethodStructure> getMethods() {
        return methods;
    }

    public void setMethods(ArrayList<MethodStructure> methods) {
        this.methods = methods;
    }

    public FileStructure getParent() {
        return parent;
    }

    public void setParent(FileStructure parent) {
        this.parent = parent;
    }
    
    public void addFieldStructure(FieldStructure fStructure) {
        this.fields.add(fStructure);
    }
    
    public void removeFieldStructure(FieldStructure fStructure) {
        this.fields.remove(fStructure);
        fStructure.setParent(this);
    }
    
    public void addMethodStructure(MethodStructure mStructure) {
        this.methods.add(mStructure);
        mStructure.setParent(this);
    }
    
    public void removeMethodStructure(MethodStructure mStructure) {
        this.methods.remove(mStructure);
    }
    
    public void printClassStructure() {
        System.out.println("----- CLASS STRUCTURE -----");
        System.out.println("Class name : " + className);
        System.out.println("FIELDSTRUCTURES : ");
        for (FieldStructure myField : fields) {
            myField.printFieldStructure();
        }
        
        System.out.println("METHODSTRUCTURES : ");
        for (MethodStructure myMethod : methods) {
            myMethod.printMethodStructure();
        }
    }
    
    @Override
    public int compareTo(ClassStructure cStructure2) {
        int equal = 0;

        if (this.parent != cStructure2.getParent()) {
            equal = -1;
        }else if (this.className.compareTo(cStructure2.getClassName()) != 0) {
            equal = -1;
        }

        return equal;
    }
}
