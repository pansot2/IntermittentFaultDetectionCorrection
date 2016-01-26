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
public class SearchCodeStructure {
    public static Info searchFieldOrVariable(String name, BlockStructure bs) {
        Info info = null;
        
        // Search current block for existent variables
        ArrayList<VariableStructure> variables = bs.getVariables();
        for (VariableStructure vs : variables) {
            if(vs.getVariableName().compareTo(name)==0) {
                info = vs.getVariableInfo().get(0);
                return info;
            }
        }
        
        while(bs.getBlockParent()!=null){
            bs = bs.getBlockParent();
            
            variables = bs.getVariables();
            for (VariableStructure vs : variables) {
                if(vs.getVariableName().compareTo(name)==0) {
                    info = vs.getVariableInfo().get(0);
                    return info;
                }
            }
        }
        
        MethodStructure ms = null;
        if (bs.getMethodParent()!=null) {
            ms = bs.getMethodParent();
            
            ArrayList<ParameterStructure> parameters = ms.getParameters();
            for (ParameterStructure ps : parameters) {
                if(ps.getParameterName().compareTo(name)==0) {
                    info = ps.getParameterInfo().get(0);
                    return info;
                }
            }
        }
        
        ArrayList<FieldStructure> fields = ms.getParent().getFields();
        
        if (fields != null) {
            for (FieldStructure fs : fields) {
                if(fs.getFieldName().compareTo(name)==0) {
                    info = fs.getFieldInfo().get(0);
                    return info;
                }
            }
        }
        
        return info;
    }
    
    
    public static ClassStructure searchClass(String className, ArrayList<FileStructure> fileStructures) {
        ClassStructure classStructure = null;
        
        if (fileStructures != null) {
            for (FileStructure fstr : fileStructures) {
                if(fstr.getClasses().get(0).getClassName().compareTo(className)==0) {
                    classStructure = fstr.getClasses().get(0);
                    return classStructure;
                }
            }
        }
        
        return classStructure;
    }
    
    
    public static Info searchMethod(String name, ClassStructure cs ) {
        Info info = null;
        
        if (cs!=null) {
            ArrayList<MethodStructure> mStructures = cs.getMethods();
            
            for (MethodStructure ms : mStructures) {
                if(ms.getMethodName().compareTo(name)==0) {
                    info = ms.getMethodInfo().get(0);
                    return info;
                }
            }
        }
        
        return info;
    }
    
    public static Info searchMethodInAllFiles(String name, ArrayList<FileStructure> fileStructures) {
        Info info = null;
         
        if (fileStructures != null) {
            for (FileStructure fstr : fileStructures) {
                info = searchMethod(name, fstr.getClasses().get(0));
                if(info != null) 
                    return info;
            }
        }
        
        return info;
    }
}
