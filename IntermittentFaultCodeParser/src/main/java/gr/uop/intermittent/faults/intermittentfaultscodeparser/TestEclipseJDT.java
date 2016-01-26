/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittent.faults.intermittentfaultscodeparser;


import gr.uop.intermittentfaults.codestructure.ClassStructure;
import gr.uop.intermittentfaults.codestructure.FileStructure;
import gr.uop.intermittentfaults.codestructure.FilesToParse;
import gr.uop.intermittentfaults.codestructure.Utils;
import java.io.IOException;

/**
 *
 * @author Panos
 */
public class TestEclipseJDT {

    private int count = 0;
    private int count2 = 1;
    private HelloClass hello;

    public TestEclipseJDT() {
        count = 1;
        count2 = count + 2;
        hello = new HelloClass();
    }

    public static void main(String[] args) throws IOException {
    /*    File dirs = new File(".");
        String dirPath;
        dirPath = dirs.getCanonicalPath() + File.separator + "src" + File.separator;
        ParseFilesInDir(dirPath);
           */ 
        
        insertFilesManually();
    }
            
    public static void insertFilesManually() throws IOException{
        FilesToParse ftp = new FilesToParse();
        
        FileStructure fs3 = new FileStructure();
        fs3.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\BlockStructure.java");
        fs3.setFileName("BlockStructure.java");
        ClassStructure cs3 = new ClassStructure();
        cs3.setClassName("BlockStructure");
        fs3.addClassStructure(cs3);
        ftp.addFileStructure(fs3);
        
        FileStructure fs4 = new FileStructure();
        fs4.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\ClassStructure.java");
        fs4.setFileName("ClassStructure.java");
        ClassStructure cs4 = new ClassStructure();
        cs4.setClassName("ClassStructure");
        fs4.addClassStructure(cs4);
        ftp.addFileStructure(fs4);
        
        FileStructure fs5 = new FileStructure();
        fs5.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\DependancyInfo.java");
        fs5.setFileName("DependancyInfo.java");
        ClassStructure cs5 = new ClassStructure();
        cs5.setClassName("DependancyInfo");
        fs5.addClassStructure(cs5);
        ftp.addFileStructure(fs5);
        
        FileStructure fs6 = new FileStructure();
        fs6.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\FieldParamMethodStructure.java");
        fs6.setFileName("FieldParamMethodStructure.java");
        ClassStructure cs6 = new ClassStructure();
        cs6.setClassName("FieldParamMethodStructure");
        fs6.addClassStructure(cs6);
        ftp.addFileStructure(fs6);
        
        FileStructure fs7 = new FileStructure();
        fs7.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\FieldStructure.java");
        fs7.setFileName("FieldStructure.java");
        ClassStructure cs7 = new ClassStructure();
        cs7.setClassName("FieldStructure");
        fs7.addClassStructure(cs7);
        ftp.addFileStructure(fs7);
        
        FileStructure fs8 = new FileStructure();
        fs8.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\FileStructure.java");
        fs8.setFileName("FileStructure.java");
        ClassStructure cs8 = new ClassStructure();
        cs8.setClassName("FileStructure");
        fs8.addClassStructure(cs8);
        ftp.addFileStructure(fs8);
        
        FileStructure fs9 = new FileStructure();
        fs9.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\FilesToParse.java");
        fs9.setFileName("FilesToParse.java");
        ClassStructure cs9 = new ClassStructure();
        cs9.setClassName("FilesToParse");
        fs9.addClassStructure(cs9);
        ftp.addFileStructure(fs9);
        
        FileStructure fs10 = new FileStructure();
        fs10.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\Info.java");
        fs10.setFileName("Info.java");
        ClassStructure cs10 = new ClassStructure();
        cs10.setClassName("Info");
        fs10.addClassStructure(cs10);
        ftp.addFileStructure(fs10);
        
        FileStructure fs11 = new FileStructure();
        fs11.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\MethodStructure.java");
        fs11.setFileName("MethodStructure.java");
        ClassStructure cs11 = new ClassStructure();
        cs11.setClassName("MethodStructure");
        fs11.addClassStructure(cs11);
        ftp.addFileStructure(fs11);
        
        FileStructure fs12 = new FileStructure();
        fs12.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\ParameterStructure.java");
        fs12.setFileName("ParameterStructure.java");
        ClassStructure cs12 = new ClassStructure();
        cs12.setClassName("ParameterStructure");
        fs12.addClassStructure(cs12);
        ftp.addFileStructure(fs12);
        
        FileStructure fs13 = new FileStructure();
        fs13.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\SearchCodeStructure.java");
        fs13.setFileName("SearchCodeStructure.java");
        ClassStructure cs13 = new ClassStructure();
        cs13.setClassName("SearchCodeStructure");
        fs13.addClassStructure(cs13);
        ftp.addFileStructure(fs13);
        
        FileStructure fs14 = new FileStructure();
        fs14.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\CodeStructure\\src\\main\\java\\gr\\uop\\intermittentfaults\\codestructure\\VariableStructure.java");
        fs14.setFileName("VariableStructure.java");
        ClassStructure cs14 = new ClassStructure();
        cs14.setClassName("VariableStructure");
        fs14.addClassStructure(cs14);
        ftp.addFileStructure(fs14);
        
        FileStructure fs = new FileStructure();
        fs.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\IntermittentFaultCodeParser\\src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultscodeparser\\HelloClass.java");
        fs.setFileName("HelloClass.java");
        ClassStructure cs = new ClassStructure();
        cs.setClassName("HelloClass");
        fs.addClassStructure(cs);
        ftp.addFileStructure(fs);
        
        FileStructure fs2 = new FileStructure();
        fs2.setFilePath("C:\\Users\\Panos\\Documents\\NetBeansProjects\\IntermittentFaultCodeParser\\src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultscodeparser\\TestEclipseJDT.java");
        fs2.setFileName("TestEclipseJDT.java");
        ClassStructure cs2 = new ClassStructure();
        cs2.setClassName("TestEclipseJDT");
        fs2.addClassStructure(cs2);
        ftp.addFileStructure(fs2);
        
        ParsingWithEclipseJDT.myFS = ftp.getFiles();
        
         for (FileStructure f : ParsingWithEclipseJDT.myFS) {
            String filePath = f.getFilePath();
            System.out.println("File Name : " + f.getFileName());
            System.out.println("File Path " + filePath);
            ParsingWithEclipseJDT.parseForMethods(ParsingWithEclipseJDT.readFileToString(filePath),f.getClasses().get(0),f);
        }
         
        for (FileStructure f : ParsingWithEclipseJDT.myFS) {
            String filePath = f.getFilePath();
            System.out.println("File Name : " + f.getFileName());
            System.out.println("File Path " + filePath);
            ParsingWithEclipseJDT.parse(ParsingWithEclipseJDT.readFileToString(filePath),f.getClasses().get(0),f);
            f.printLineDictionary();
        }
        
        Utils.insertDependencies(ftp);
        
         for (FileStructure f : ParsingWithEclipseJDT.myFS) {
            f.printLineDictionary();
        }
         
        ftp.printFilesToParse();
        
    }

}
