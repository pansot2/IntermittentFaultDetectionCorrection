/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.codestructure;

/**
 *
 * @author Panos
 */
public class DependancyInfo implements Comparable<DependancyInfo> {
    private boolean isParam;
    private boolean isField;
    private boolean isMethod;
    private boolean isVariable;
    private String file;
    private String className;
    private String method;
    private String name;
    private int line;
    private Info dependencyInfoNode;
    private Info parent;

    public DependancyInfo() {
        this.isParam = false;
        this.isField = false;
        this.isMethod = false;
        this.isVariable = false;
        this.file = null;
        this.className = null;
        this.method = null;
        this.name = null;
        this.line = -1;
        this.parent = null;
        this.dependencyInfoNode = null;
    }

    public DependancyInfo(boolean isParam, boolean isVariable, boolean isField, boolean isMethod, String file, String className, String method, String name, int line, Info parent, Info dependencyInfoNode) {
        this.isParam = isParam;
        this.isField = isField;
        this.isMethod = isMethod;
        this.isVariable = isVariable;
        this.file = file;
        this.className = className;
        this.method = method;
        this.name = name;
        this.line = line;
        this.parent = parent;
        this.dependencyInfoNode = dependencyInfoNode;
    }

    public boolean isIsParam() {
        return isParam;
    }

    public void setIsParam(boolean isParam) {
        this.isParam = isParam;
    }

    public boolean isIsVariable() {
        return isVariable;
    }

    public void setIsVariable(boolean isVariable) {
        this.isVariable = isVariable;
    }

    public boolean isIsField() {
        return isField;
    }

    public void setIsField(boolean isField) {
        this.isField = isField;
    }

    public boolean isIsMethod() {
        return isMethod;
    }

    public void setIsMethod(boolean isMethod) {
        this.isMethod = isMethod;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public Info getParent() {
        return parent;
    }

    public void setParent(Info parent) {
        this.parent = parent;
    }

    public Info getDependencyInfoNode() {
        return dependencyInfoNode;
    }

    public void setDependencyInfoNode(Info dependencyInfoNode) {
        this.dependencyInfoNode = dependencyInfoNode;
    }

    public void printDependancyInfo() {
        System.out.println("----- DEPENDENCY INFO -----");
        System.out.println("name : " + name + " ,isParam : " + isParam + " ,isMethod : " + isMethod
                + " ,isField : " + isField + " ,isVariable : " + isVariable + " ,file : " + file 
                + " ,className : " + className + " ,method : " + method 
                + " ,line : " + line + " ,dependencyInfoNode : " + dependencyInfoNode.getClassName() + " " + dependencyInfoNode.getLine());
    }
    
    @Override
    public int compareTo(DependancyInfo dependancyInfo2) {
        int equal = 0;
        
        if (this.parent != dependancyInfo2.getParent()) {
            equal = -1;
        }else if (this.isParam != dependancyInfo2.isIsParam()) {
            equal = -1;
        }else if (this.isField != dependancyInfo2.isIsField()) {
            equal = -1;
        }else if (this.isMethod != dependancyInfo2.isIsMethod()) {
            equal = -1;
        }else if (this.className.compareTo(dependancyInfo2.getClassName()) != 0) {
            equal = -1;
        }else if (this.file.compareTo(dependancyInfo2.getFile()) != 0) {
            equal = -1;
        }else if (this.name.compareTo(dependancyInfo2.getName()) != 0) {
            equal = -1;
        }else if (this.method.compareTo(dependancyInfo2.getMethod()) != 0) {
            equal = -1;
        }
        
        return equal;
    }
    
    
}
