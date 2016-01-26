/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.codestructure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Panos
 */
public class Utils {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
    
    public static void insertDependencies(FilesToParse ftp) throws IOException {
        
        ArrayList<FileStructure> filesArray = ftp.getFiles();
        for (FileStructure fstr : filesArray) {
            String filePath = fstr.getFilePath();
            File file = new File(filePath);
            List<String> lines = Files.readAllLines(file.toPath());
            Map<Integer,ArrayList<Info>> lineDictionary = fstr.getLineDictionary();
            
            Map<Integer, ArrayList<Info>> treeMap = new TreeMap<Integer, ArrayList<Info>>(
	    new Comparator<Integer>() {
                @Override
		public int compare(Integer o1, Integer o2) {
		    return o1.compareTo(o2);
		}
            });
	    treeMap.putAll(lineDictionary);

            for (Map.Entry<Integer, ArrayList<Info>> entry : treeMap.entrySet()) {
                ArrayList<Info> dependancyInfos = new ArrayList<>();
                Info dependent = null;
                
                int line = entry.getKey();
                if (line==58)
                for (Info info : entry.getValue()){
                    String name = "";
                    if(info.getParent() instanceof FieldStructure) {
                        name = ((FieldStructure)info.getParent()).getFieldName();
                    }else if(info.getParent() instanceof VariableStructure) {
                        name = ((VariableStructure)info.getParent()).getVariableName();
                    }else if(info.getParent() instanceof ParameterStructure) {
                        name = ((ParameterStructure)info.getParent()).getParameterName();
                    }else if(info.getParent() instanceof MethodStructure) {
                        name = ((MethodStructure)info.getParent()).getMethodName();
                    }
                    
                    String lineString = lines.get(line-1);
                    if (lineString.contains("=")) {
                        int equalIndex = lineString.indexOf("=");
                        int index = lineString.indexOf(name);
                        
                        int deletedCount = 0;
                        while (index>=0) {
                            if ((index<=0) || (!alphabet.contains(Character.toString(lineString.charAt(index-1)))) ) {
                                if ((index>=lineString.length()-1) || (!alphabet.contains(Character.toString(lineString.charAt(index+name.length())))) ) {
                                    if (index + deletedCount < equalIndex)
                                        dependent = info;
                                    else
                                        dependancyInfos.add(info);
                                    }
                            }

                            lineString=lineString.substring(index+name.length()-1);
                            deletedCount = deletedCount + index+name.length()-1;
                            index = lineString.indexOf(name);
                        }
                        
                    }
                }
                
                if (dependent != null) {
                    for(Info info : dependancyInfos) {
                        if (info != null) {
                            if(info.getParent() instanceof FieldStructure) {
                                DependancyInfo dependancyOn = new DependancyInfo();
                                dependancyOn.setDependencyInfoNode(info);
                                dependancyOn.setIsField(true);
                                dependancyOn.setName(((FieldStructure)info.getParent()).getFieldName());
                                dependent.addDependancyInfo(dependancyOn);
                            }else if(info.getParent() instanceof VariableStructure) {
                                DependancyInfo dependancyOn = new DependancyInfo();
                                dependancyOn.setDependencyInfoNode(info);
                                dependancyOn.setIsVariable(true);
                                dependancyOn.setName(((VariableStructure)info.getParent()).getVariableName());
                                dependent.addDependancyInfo(dependancyOn);
                            }else if(info.getParent() instanceof ParameterStructure) {
                                DependancyInfo dependancyOn = new DependancyInfo();
                                dependancyOn.setDependencyInfoNode(info);
                                dependancyOn.setIsParam(true);
                                dependancyOn.setName(((ParameterStructure)info.getParent()).getParameterName());
                                dependent.addDependancyInfo(dependancyOn);
                            }else if(info.getParent() instanceof MethodStructure) {
                                DependancyInfo dependancyOn = new DependancyInfo();
                                dependancyOn.setDependencyInfoNode(info);
                                dependancyOn.setIsMethod(true);
                                dependancyOn.setName(((MethodStructure)info.getParent()).getMethodName());
                                dependent.addDependancyInfo(dependancyOn);
                            }

                            if(dependent.getParent() instanceof FieldStructure) {
                                DependancyInfo dependancyOf = new DependancyInfo();
                                dependancyOf.setDependencyInfoNode(dependent);
                                dependancyOf.setIsField(true);
                                dependancyOf.setName(((FieldStructure)dependent.getParent()).getFieldName());
                                info.addDependancyOf(dependancyOf);
                            }else if(dependent.getParent() instanceof VariableStructure) {
                                DependancyInfo dependancyOf = new DependancyInfo();
                                dependancyOf.setDependencyInfoNode(dependent);
                                dependancyOf.setIsVariable(true);
                                dependancyOf.setName(((VariableStructure)dependent.getParent()).getVariableName());
                                info.addDependancyOf(dependancyOf);
                            }else if(dependent.getParent() instanceof ParameterStructure) {
                                DependancyInfo dependancyOf = new DependancyInfo();
                                dependancyOf.setDependencyInfoNode(dependent);
                                dependancyOf.setIsParam(true);
                                dependancyOf.setName(((ParameterStructure)dependent.getParent()).getParameterName());
                                info.addDependancyOf(dependancyOf);
                            }else if(info.getParent() instanceof MethodStructure) {
                                DependancyInfo dependancyOn = new DependancyInfo();
                                dependancyOn.setDependencyInfoNode(info);
                                dependancyOn.setIsMethod(true);
                                dependancyOn.setName(((MethodStructure)info.getParent()).getMethodName());
                                dependent.addDependancyInfo(dependancyOn);
                            }
                            
                        }
                    }
                }
            }
            
            
        }
    }
}
