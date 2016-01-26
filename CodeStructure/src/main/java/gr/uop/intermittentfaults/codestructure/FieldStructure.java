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
public class FieldStructure implements FieldParamMethodStructure,Comparable<FieldStructure> {
    private String fieldName;
    private String fieldType;
    private ArrayList<Info> fieldInfo;
    private ClassStructure parent;

    public FieldStructure() {
        this.fieldName = null;
        this.fieldInfo = new ArrayList<>();
        this.parent = null;
    }

    public FieldStructure(String fieldName, ArrayList<Info> fieldInfo, ClassStructure parent) {
        this.fieldName = fieldName;
        this.fieldInfo = fieldInfo;
        this.parent = parent;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public ArrayList<Info> getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(ArrayList<Info> fieldInfo) {
        this.fieldInfo = fieldInfo;
    }
    
    public void addFieldInfo(Info fieldInfo) {
        this.fieldInfo.add(fieldInfo);
        fieldInfo.setParent(this);
    }

    public void removeFieldInfo(Info fieldInfo) {
        this.fieldInfo.remove(fieldInfo);
    }

    public ClassStructure getParent() {
        return parent;
    }

    public void setParent(ClassStructure parent) {
        this.parent = parent;
    }
    
    public void printFieldStructure() {
        System.out.println("----- FIELD STRUCTURE -----");
        System.out.println("Field " + fieldName);
        System.out.println("Field Tyoe " + fieldType);
        System.out.println("FIELD INFO : ");
        for (Info info : fieldInfo) {
            info.printInfo();
        }
    }
    
    @Override
    public int compareTo(FieldStructure fStructure2) {
        int equal = 0;

        if (this.parent != fStructure2.getParent()) {
            equal = -1;
        }else if (!this.fieldInfo.equals(fStructure2.getFieldInfo())) {
            equal = -1;
        }else if (this.fieldName.compareTo(fStructure2.getFieldName()) != 0) {
            equal = -1;
        }else if (this.fieldType.compareTo(fStructure2.getFieldType()) != 0) {
            equal = -1;
        }
        
        return equal;
    }
}
