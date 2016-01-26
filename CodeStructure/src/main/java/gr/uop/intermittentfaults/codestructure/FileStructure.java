/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.codestructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Panos
 */
public class FileStructure implements Comparable<FileStructure> {

    private ArrayList<ClassStructure> classes;
    private String fileName;
    private String filePath;
    private Map<Integer,ArrayList<Info>> lineDictionary;
    private FilesToParse parent;

    public FileStructure() {
        this.classes = new  ArrayList<>();
        this.fileName = null;
        this.filePath = null;
        this.parent = null;
        this.lineDictionary = new HashMap<>();
    }

    public FileStructure(ArrayList<ClassStructure> classes, String fileName, String filePath, FilesToParse parent, Map<Integer,ArrayList<Info>> lineDictionary) {
        this.classes = classes;
        this.fileName = fileName;
        this.filePath = filePath;
        this.parent = parent;
        this.lineDictionary = lineDictionary;
    }

    public ArrayList<ClassStructure> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<ClassStructure> classes) {
        this.classes = classes;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public FilesToParse getParent() {
        return parent;
    }

    public void setParent(FilesToParse parent) {
        this.parent = parent;
    }

    public void addClassStructure(ClassStructure cStructure) {
        this.classes.add(cStructure);
        cStructure.setParent(this);
    }

    public void removeClassStructure(ClassStructure cStructure) {
        this.classes.remove(cStructure);
    }

    public Map<Integer, ArrayList<Info>> getLineDictionary() {
        return lineDictionary;
    }

    public void setLineDictionary(Map<Integer, ArrayList<Info>> lineDictionary) {
        this.lineDictionary = lineDictionary;
    }
    
    public void addInfoInLineDictionary(int line, Info info) {
        ArrayList<Info> infoArray = this.lineDictionary.get(line);
        if (infoArray == null) {
            infoArray = new ArrayList<>();
            infoArray.add(info);
            this.lineDictionary.put(line, infoArray);
        }else {
            infoArray.add(info);
        }
    }

    public void printFileStructure() {
        System.out.println("----- FILE STRUCTURE -----");
        System.out.println("CLASSTRUCTURES : ");
        for (ClassStructure myClass : classes) {
            System.out.println("File " + fileName + " , Path : " + filePath);
            myClass.printClassStructure();
        }
    }
    
    public void printLineDictionary(){
        System.out.println("LINE DICTIONARY OF FILE " + fileName);
        
        Map<Integer, ArrayList<Info>> treeMap = new TreeMap<Integer, ArrayList<Info>>(
	    new Comparator<Integer>() {
                @Override
		public int compare(Integer o1, Integer o2) {
		    return o1.compareTo(o2);
		}
            });
	treeMap.putAll(this.lineDictionary);
        
        for (Map.Entry<Integer, ArrayList<Info>> entry : treeMap.entrySet()) {
            System.out.println("line : " + entry.getKey());
            ArrayList<Info> infoArray = entry.getValue();
            for (Info info : infoArray) {
                if(info.getParent() instanceof FieldStructure) {
                    System.out.println(((FieldStructure)info.getParent()).getFieldName());
                }else if(info.getParent() instanceof VariableStructure) {
                    System.out.println(((VariableStructure)info.getParent()).getVariableName());
                }else if(info.getParent() instanceof ParameterStructure) {
                    System.out.println(((ParameterStructure)info.getParent()).getParameterName());
                }else if(info.getParent() instanceof MethodStructure) {
                    System.out.println(((MethodStructure)info.getParent()).getMethodName());
                }
                
            }
            
            
        }
    }

    @Override
    public int compareTo(FileStructure fStructure2) {
        int equal = 0;

        if (this.fileName.compareTo(fStructure2.getFileName()) != 0) {
            equal = -1;
        }else if (this.filePath.compareTo(fStructure2.getFilePath()) != 0) {
            equal = -1;
        }else if (this.parent != fStructure2.getParent()) {
            equal = -1;
        }

        return equal;
    }
}
