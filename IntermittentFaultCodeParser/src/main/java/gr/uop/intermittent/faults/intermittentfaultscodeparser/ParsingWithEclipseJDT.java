/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittent.faults.intermittentfaultscodeparser;

import gr.uop.intermittentfaults.codestructure.BlockStructure;
import gr.uop.intermittentfaults.codestructure.ClassStructure;
import gr.uop.intermittentfaults.codestructure.DependancyInfo;
import gr.uop.intermittentfaults.codestructure.FieldStructure;
import gr.uop.intermittentfaults.codestructure.FileStructure;
import gr.uop.intermittentfaults.codestructure.FilesToParse;
import gr.uop.intermittentfaults.codestructure.Info;
import gr.uop.intermittentfaults.codestructure.MethodStructure;
import gr.uop.intermittentfaults.codestructure.ParameterStructure;
import gr.uop.intermittentfaults.codestructure.SearchCodeStructure;
import gr.uop.intermittentfaults.codestructure.Utils;
import gr.uop.intermittentfaults.codestructure.VariableStructure;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

/**
 *
 * @author Panos
 */
public class ParsingWithEclipseJDT {

    public static ArrayList<FileStructure> myFS = null;
    private static int firstMethodLine;

     public static void parseForMethods(String str, final ClassStructure cs, final FileStructure fStr) {
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(str.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

        cu.accept(new ASTVisitor() {

            public boolean visit(FieldDeclaration node) {
                String name = node.fragments().get(0).toString().split("=")[0];
                String type = node.getType().toString();
                FieldStructure fs = new FieldStructure();
                fs.setFieldName(name);
                fs.setFieldType(type);
                Info info = new Info();
                info.setClassName(cs.getClassName());
                info.setFile(cs.getParent().getFileName());
                info.setLine(cu.getLineNumber(node.getStartPosition()));
                fStr.addInfoInLineDictionary(cu.getLineNumber(node.getStartPosition()), info);
                fs.addFieldInfo(info);
                cs.addFieldStructure(fs);
                System.out.println("Field declaration '" + name + "' with type " + type + " at line "
                        + cu.getLineNumber(node.getStartPosition()));
                return true;
            }
            
            public boolean visit(MethodDeclaration node) {
                if (node.getName().getIdentifier() != null) {
                    try {
                        System.out.println("Declaration of method : " + node.getName() + " with paremeters " + Arrays.toString(node.parameters().toString().split(",")) + " at line "
                                + cu.getLineNumber(node.getStartPosition()) + " is constructor " + node.isConstructor());
                        MethodStructure ms = new MethodStructure();
                        ms.setMethodName(node.getName().getIdentifier());
                        if (!node.isConstructor())
                            ms.setMethodReturnType(node.getReturnType2().toString());
                        Info info = new Info();
                        info.setClassName(cs.getClassName());
                        info.setFile(cs.getParent().getFileName());
                        firstMethodLine = cu.getLineNumber(node.getStartPosition());
                        int methodLines = ParsingWithEclipseJDT.countMethodLines(cs.getParent().getFilePath());
                        info.setLine(firstMethodLine);
                        info.setStructureLength(methodLines);
                        fStr.addInfoInLineDictionary(cu.getLineNumber(node .getStartPosition()), info);
                        ms.addMethodInfo(info);
                        
                        Object[] params = node.parameters().toArray();
                        Set<String> parameterNames = new HashSet();
                        for (Object s : params) {
                            String param = s.toString();
                            ParameterStructure ps = new ParameterStructure();
                            String[] parts = param.split(" ");
                            ps.setParameterName(parts[parts.length-1]);
                            ps.setParameterType(parts[parts.length-2]);
                            Info info2 = new Info();
                            info2.setClassName(cs.getClassName());
                            info2.setFile(cs.getParent().getFileName());
                            info2.setLine(cu.getLineNumber(node.getStartPosition()));
                            fStr.addInfoInLineDictionary(cu.getLineNumber(node.getStartPosition()), info2);
                            ps.addParameterInfo(info2);
                            ms.addParameterStructure(ps);
                            parameterNames.add(ps.getParameterName());
                        }
                        
                        BlockStructure bs =  new BlockStructure();
                        bs.setBlockNum(0);
                        bs.setMethodParent(ms);
                        Info info3 = new Info();
                        info3.setClassName(cs.getClassName());
                        info3.setFile(cs.getParent().getFileName());
                        info3.setLine(cu.getLineNumber(node.getStartPosition()));
                        bs.addBlockInfo(info3);
                        bs.setVariables(new ArrayList<VariableStructure>());
                        ms.addBlockStructure(bs);
                        cs.addMethodStructure(ms);
                    } catch (IOException ex) {
                        Logger.getLogger(ParsingWithEclipseJDT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return true;
            }
        });

    }
     
    public static void parse(String str, final ClassStructure cs, final FileStructure fStr) {
        int count = 0;
        int c = count + 10;
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(str.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

        cu.accept(new ASTVisitor() {

            Set names = new HashSet();
            int blockCount = 0;

            public boolean visit(FieldDeclaration node) {
                String name = node.fragments().get(0).toString().split("=")[0];
                names.add(name);
                return true;
            }

            public boolean visit(MethodDeclaration node) {
                if (node.getName().getIdentifier() != null) {
                    Info msInfo = SearchCodeStructure.searchMethod( node.getName().toString(), cs);
                   
                    Object[] params = node.parameters().toArray();
                    Set<String> parameterNames = new HashSet();
                    for (Object s : params) {
                        String param = s.toString();
                        String[] parts = param.split(" ");
                        parameterNames.add(parts[parts.length-1]);
                    }
                    
                    Block block = node.getBody();
                    Map<Integer, Set> variableNames = new HashMap();
                    blockIterate(block, cu, names, 0, variableNames, parameterNames, ((MethodStructure)msInfo.getParent()).getBlock().get(0), cs, fStr);
                }
                return true;
            }
        });

    }

    private static void blockIterate(final Block block, final CompilationUnit cu, final Set fieldNames, final int blockNum, final Map<Integer, Set> variableNames, final Set<String> parameterNames, final BlockStructure bs, final ClassStructure cs, final FileStructure fStr) {
        List<Statement> statements = block.statements();
       // System.out.println("Statements : " + statements.toString());
        
        Set variables = new HashSet();
        variableNames.put(blockNum, variables);
        
        for (Statement s : statements) {
            
            if(s.toString().startsWith("if") || s.toString().startsWith("while") || s.toString().startsWith("for") || s.toString().startsWith("try")) {
                s.accept(new ASTVisitor() { 
                    public boolean visit(Block node) {
                        if (node != null) {
                          //  System.out.println("Block " + node.toString());
                            int blockNumber = blockNum + 1;
                            BlockStructure bs2 =  new BlockStructure();
                            bs2.setBlockNum(blockNum);
                            bs2.setBlockParent(bs);
                            bs2.setVariables(new ArrayList<VariableStructure>());
                            Info info = new Info();
                            info.setLine(cu.getLineNumber(node.getStartPosition()));
                            info.setClassName(cs.getClassName());
                            bs2.addBlockInfo(info);
                            bs.addChildBlockStructure(bs2);
                            blockIterate(node, cu, fieldNames, blockNumber,variableNames,parameterNames,bs2,cs, fStr);

                            for (int i=blockNumber; i<variableNames.size(); i++)
                                variableNames.remove(i);
                        }
                        return false;
                    }
                });
            }else {
                s.accept(new ASTVisitor() { 

                    public boolean visit(VariableDeclarationStatement node) {
                        String name = node.fragments().get(0).toString().split("=")[0];
                        String type = node.getType().toString();
                        variableNames.get(blockNum).add(name);
                        System.out.println("Declaration of variable '" + name + "' at line"
                                + cu.getLineNumber(node.getStartPosition()) + cs.getClassName()); 
                        VariableStructure vs = new VariableStructure();
                        vs.setBlockParent(bs);
                        Info info = new Info();
                        info.setClassName(cs.getClassName());
                        info.setLine(cu.getLineNumber(node.getStartPosition()));
                        fStr.addInfoInLineDictionary(cu.getLineNumber(node.getStartPosition()), info);
                        vs.addVariableInfo(info);
                        vs.setVariableName(name);
                        vs.setVariableType(type);
                        bs.addVariableStructure(vs);
                        return false; 
                    }

                    public boolean visit(SimpleName node) {
                        if (searchVariable(variableNames,node.getIdentifier())!=-1 || searchField(fieldNames,node.getIdentifier()) || searchParameter(parameterNames,node.getIdentifier())) {
                            System.out.println("Usage of variable/field/parameter '" + node.getIdentifier() + "' at line "
                                    + cu.getLineNumber(node.getStartPosition()) + cs.getClassName());

                            Info info = SearchCodeStructure.searchFieldOrVariable(node.getIdentifier(), bs);
                            Info infoNew = new Info();
                            infoNew.setClassName(cs.getClassName());
                            infoNew.setFile(cs.getParent().getFileName());
                            infoNew.setLine(cu.getLineNumber(node.getStartPosition()));
                            fStr.addInfoInLineDictionary(cu.getLineNumber(node.getStartPosition()), infoNew);
                            if(info.getParent() instanceof FieldStructure) {
                                ((FieldStructure)info.getParent()).addFieldInfo(infoNew);
                            }else if(info.getParent() instanceof VariableStructure) {
                                ((VariableStructure)info.getParent()).addVariableInfo(infoNew);
                            }else if(info.getParent() instanceof ParameterStructure) {
                                ((ParameterStructure)info.getParent()).addParameterInfo(infoNew);
                            }
                        }
                        return false;
                    }

                    public boolean visit(MethodInvocation node) {
                        System.out.println("MethodInvocation: " + node.getName() + " at line "
                                + cu.getLineNumber(node.getStartPosition()) + " with arguments " + node.arguments()+ cs.getClassName());
                        
                        Expression expression = node.getExpression();

                        ClassStructure classStructure = null;
                        Info info = new Info();
                        if (expression != null) {
                            String className = "";
                            info = SearchCodeStructure.searchFieldOrVariable(expression.toString(), bs);
                            if (info!=null) {
                                if(info.getParent() instanceof FieldStructure) {
                                    className = ((FieldStructure)info.getParent()).getFieldType();
                                }else if(info.getParent() instanceof VariableStructure) {
                                    className = ((VariableStructure)info.getParent()).getVariableType();
                                }else if(info.getParent() instanceof ParameterStructure) {
                                    className = ((ParameterStructure)info.getParent()).getParameterType();
                                }
                                classStructure = SearchCodeStructure.searchClass(className, myFS);
                            }
                            System.out.println("Expr: " + expression.toString());
                        }else {
                            classStructure = cs;
                        }

                        Info info2 = SearchCodeStructure.searchMethod(node.getName().getIdentifier(), classStructure);

                        if (info2 == null) {
                            info2 = SearchCodeStructure.searchMethodInAllFiles(node.getName().getIdentifier(), myFS);
                        }
                        
                        Info infoNew = new Info();
                        if (info2 != null) {
                            infoNew.setClassName(cs.getClassName());
                            infoNew.setFile(cs.getParent().getFileName());
                            infoNew.setLine(cu.getLineNumber(node.getStartPosition()));
                            fStr.addInfoInLineDictionary(cu.getLineNumber(node.getStartPosition()), infoNew);
                            ((MethodStructure)info2.getParent()).addMethodInfo(infoNew);
                        }
                        
                        for (Object param : node.arguments()) {
                            info = SearchCodeStructure.searchFieldOrVariable(param.toString(), bs);
                            Info infoNew2 = new Info();
                            infoNew2.setClassName(cs.getClassName());
                            infoNew2.setFile(cs.getParent().getFileName());
                            infoNew2.setLine(cu.getLineNumber(node.getStartPosition()));
                            fStr.addInfoInLineDictionary(cu.getLineNumber(node.getStartPosition()), infoNew2);
                            if (info != null) {
                                if(info.getParent() instanceof FieldStructure) {
                                    ((FieldStructure)info.getParent()).addFieldInfo(infoNew2);
                                    DependancyInfo dependancyOn = new DependancyInfo();
                                    dependancyOn.setDependencyInfoNode(info);
                                    dependancyOn.setIsField(true);
                                    dependancyOn.setName(param.toString());
                                    infoNew.addDependancyInfo(dependancyOn);
                                }else if(info.getParent() instanceof VariableStructure) {
                                    ((VariableStructure)info.getParent()).addVariableInfo(infoNew2);
                                    DependancyInfo dependancyOn = new DependancyInfo();
                                    dependancyOn.setDependencyInfoNode(info);
                                    dependancyOn.setIsVariable(true);
                                    dependancyOn.setName(param.toString());
                                    infoNew.addDependancyInfo(dependancyOn);
                                }else if(info.getParent() instanceof ParameterStructure) {
                                    ((ParameterStructure)info.getParent()).addParameterInfo(infoNew2);
                                    DependancyInfo dependancyOn = new DependancyInfo();
                                    dependancyOn.setDependencyInfoNode(info);
                                    dependancyOn.setIsParam(true);
                                    dependancyOn.setName(param.toString());
                                    infoNew.addDependancyInfo(dependancyOn);
                                }
                            }
                        }

                        return false;
                    }

                    public boolean visit(Block node) {
                        if (node != null) {
                          //  System.out.println("Block " + node.toString());
                            int blockNumber = blockNum + 1;
                            BlockStructure bs2 =  new BlockStructure();
                            bs2.setBlockNum(blockNum);
                            bs2.setBlockParent(bs);
                            bs2.setVariables(new ArrayList<VariableStructure>());
                            Info info = new Info();
                            info.setLine(cu.getLineNumber(node.getStartPosition()));
                            info.setClassName(cs.getClassName());
                            bs2.addBlockInfo(info);
                            bs.addChildBlockStructure(bs2);
                            blockIterate(node, cu, fieldNames, blockNumber,variableNames,parameterNames,bs2,cs,fStr);

                            for (int i=blockNumber; i<variableNames.size(); i++)
                                variableNames.remove(i);
                        }
                        return false;
                    }
                });
            }
        }
    }
    
    private static int searchVariable(Map<Integer, Set> variableNames, String variable) {
        int blockSize = variableNames.size();
        
      //  System.out.println("BlockSize " + blockSize);
        
        for (int i=blockSize-1; i>=0; i--) {
      //      System.out.println("all " + variableNames.get(i).toString());
            Set temp = variableNames.get(i);
            for (Object s : temp) {
                if (s.toString().matches(variable)) {
                    System.out.println("Found in block : " + i);
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    private static boolean searchField(Set fieldNames, String variable) {
        boolean found = false;
     //    System.out.println("all Fields " + fieldNames.toString());
        for (Object s : fieldNames) {
            if (s.toString().matches(variable)) {
            //    System.out.println("Found field ... ");
                found = true;
            }
        }
        
        return found;
    }
    
    
    private static boolean searchParameter(Set<String> parameterNames, String variable) {
        boolean found = false;
     //    System.out.println("all Fields " + fieldNames.toString());
        for (String s : parameterNames) {
            if (s.matches(variable)) {
                System.out.println("Found parameter ... ");
                found = true;
            }
        }
        
        return found;
    }

    //read file content into a string
    public static String readFileToString(String filePath) throws IOException {
        StringBuilder fileData = new StringBuilder(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        char[] buf = new char[10];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }

        reader.close();

        return fileData.toString();
    }

    //loop directory to get file list
    public static void ParseFilesInDir(String path) throws IOException {
        HelloClass h = new HelloClass();
        h.sayHello();
        File root = new File(path);
        File[] files = root.listFiles();
        String filePath = null;

        for (File f : files) {
            filePath = f.getAbsolutePath();
            if (f.isFile()) {
                System.out.println("Class : " + f.getName());
                System.out.println("filePath " + filePath);
           //     parse(readFileToString(filePath));
            } else if (f.isDirectory()) {
                ParseFilesInDir(filePath);
            }
        }
    }
    
    static int countCharPosition(String str, char mychar, int count) {
            if (str.length() == 0)
                return count;

            for (int i = 0; i < str.length(); i ++) {
                if (str.charAt(i) == mychar) {
                    count++;
                }
            }

            return count;
    }
    
    public static int countMethodLines(String filePath) throws IOException {
        int linesNum = 0;
        int charsCount_1 = 0;
        int charsCount_2 = 0;
        
        File file = new File(filePath);
        List<String> lines = Files.readAllLines(file.toPath());
        int line = firstMethodLine;
        
        while (charsCount_1!=charsCount_2 || charsCount_1==0 || charsCount_2==0) {
            charsCount_1 = countCharPosition(lines.get(line-1), '{', charsCount_1);
            charsCount_2 = countCharPosition(lines.get(line-1), '}', charsCount_2);
            line++;
            if(charsCount_1==0)
                firstMethodLine++;
            else
                linesNum++;
        }
        
        return linesNum;
    }

}
