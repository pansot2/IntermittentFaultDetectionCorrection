/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.appendfilelines;

import static gr.uop.intermittent.faults.intermittentfaultscodeparser.ParsingWithEclipseJDT.parse;
import static gr.uop.intermittent.faults.intermittentfaultscodeparser.ParsingWithEclipseJDT.parseForMethods;
import static gr.uop.intermittent.faults.intermittentfaultscodeparser.ParsingWithEclipseJDT.readFileToString;
import gr.uop.intermittent.faults.intermittentfaultstest.Test;
import static gr.uop.intermittentfaults.appendfilelines.Main2.codeDirectory;
import gr.uop.intermittentfaults.codestructure.ClassStructure;
import gr.uop.intermittentfaults.codestructure.FileStructure;
import gr.uop.intermittentfaults.codestructure.FilesToParse;
import gr.uop.intermittentfaults.codestructure.Info;
import gr.uop.intermittentfaults.codestructure.MethodStructure;
import gr.uop.intermittentfaults.codestructure.Utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jboss.metrics.jbossautomatedmetricslibrary.MetricsCache;

/**
 *
 * @author Panos
 */
public class Main {
    
    static ArrayList<FileStructure> myFS = null;
    
    static String codeDirectory = "F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        insertFilesManually();
        
         // Add lines in the code for Record Phase
        for(FileStructure  fs : myFS) {
            String filePath = fs.getFilePath();
            System.out.println("FilePath : " + filePath);
            File file = new File(filePath);
            AddImport.addLines(file, "import org.jboss.metrics.javase.automatedmetricsjavaseapi.JbossAutomatedJavaSeMetricsDbStore;");
            AddImport.addLines(file, "import gr.uop.intermittentfaults.intermmittentfaultsutils.GlobalParams;");
            
            for(ClassStructure cs : fs.getClasses()) {
                String className = cs.getClassName();
                for(MethodStructure ms : cs.getMethods()) {
                    String methodName = ms.getMethodName();
                    Info info = ms.getMethodInfo().get(0);
                    int line = info.getLine();
                    int methodLength = info.getStructureLength();
                    List<Integer> additionalLines = new ArrayList<>();
                    for(int i=line+1; i<line+methodLength-1; i++){
                        additionalLines.add(i);
                    }
                    
                    List<Integer> excludeLines = new ArrayList<>();
                    if (filePath.compareTo(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\Test.java")==0 && methodName.compareTo("test")==0) {
                        excludeLines.add(87);
                    }
                    
                    if (filePath.compareTo(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\TestThreads.java")==0 && methodName.compareTo("getT")==0) {
                        excludeLines.add(68);
                    }
                    
                    AddFileLines.addLines(file, additionalLines, excludeLines, className, methodName, filePath);
                }
            }
        }

        Runtime.getRuntime().exec("cmd /c start C:\\Users\\Panos\\Documents\\NetBeansProjects\\appendFileLines\\src\\main\\java\\gr\\uop\\intermittentfaults\\appendfilelines\\runCompile.bat");
        Thread.sleep(10000);
           MetricsCache cache = Test.test(args);
     //   if (cache!=null) {
     //           System.out.println("Cache : " );
    //            cache.printMetricObjects();
     //       }
       
        Runtime.getRuntime().exec("cmd /c start C:\\Users\\Panos\\Documents\\NetBeansProjects\\appendFileLines\\src\\main\\java\\gr\\uop\\intermittentfaults\\appendfilelines\\runReset.bat");

    }
    
    public static void insertFilesManually() throws IOException{
        FilesToParse ftp = new FilesToParse();
        
        FileStructure fs2 = new FileStructure();
        fs2.setFilePath(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\Test.java");
        fs2.setFileName("Test.java");
        ClassStructure cs2 = new ClassStructure();
        cs2.setClassName("Test");
        fs2.addClassStructure(cs2);
        ftp.addFileStructure(fs2);
        
        FileStructure fs3 = new FileStructure();
        fs3.setFilePath(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Store.java");
        fs3.setFileName("Store.java");
        ClassStructure cs3 = new ClassStructure();
        cs3.setClassName("Store");
        fs3.addClassStructure(cs3);
        ftp.addFileStructure(fs3);
        
        FileStructure fs4 = new FileStructure();
        fs4.setFilePath(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheStore.java");
        fs4.setFileName("CacheStore.java");
        ClassStructure cs4 = new ClassStructure();
        cs4.setClassName("CacheStore");
        fs4.addClassStructure(cs4);
        ftp.addFileStructure(fs4);
        
        FileStructure fs5 = new FileStructure();
        fs5.setFilePath(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java");
        fs5.setFileName("CacheObject.java");
        ClassStructure cs5 = new ClassStructure();
        cs5.setClassName("CacheObject");
        fs5.addClassStructure(cs5);
        ftp.addFileStructure(fs5);
        
        FileStructure fs6 = new FileStructure();
        fs6.setFilePath(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheCollection.java");
        fs6.setFileName("CacheCollection.java");
        ClassStructure cs6 = new ClassStructure();
        cs6.setClassName("CacheCollection");
        fs6.addClassStructure(cs6);
        ftp.addFileStructure(fs6);
        
        FileStructure fs7 = new FileStructure();
        fs7.setFilePath(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheApi.java");
        fs7.setFileName("CacheApi.java");
        ClassStructure cs7 = new ClassStructure();
        cs7.setClassName("CacheApi");
        fs7.addClassStructure(cs7);
        ftp.addFileStructure(fs7);
        
        FileStructure fs8 = new FileStructure();
        fs8.setFilePath(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java");
        fs8.setFileName("Cache.java");
        ClassStructure cs8 = new ClassStructure();
        cs8.setClassName("Cache");
        fs8.addClassStructure(cs8);
        ftp.addFileStructure(fs8);
        
    /*    FileStructure fs9 = new FileStructure();
        fs9.setFilePath(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\Test.java");
        fs9.setFileName("Test.java");
        ClassStructure cs9 = new ClassStructure();
        cs9.setClassName("Test");
        fs9.addClassStructure(cs9);
        ftp.addFileStructure(fs9); */
        
        FileStructure fs10 = new FileStructure();
        fs10.setFilePath(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\TestClass.java");
        fs10.setFileName("TestClass.java");
        ClassStructure cs10 = new ClassStructure();
        cs10.setClassName("TestClass");
        fs10.addClassStructure(cs10);
        ftp.addFileStructure(fs10);
        
        FileStructure fs11 = new FileStructure();
        fs11.setFilePath(codeDirectory + "src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\TestThreads.java");
        fs11.setFileName("TestThreads.java");
        ClassStructure cs11 = new ClassStructure();
        cs11.setClassName("TestThreads");
        fs11.addClassStructure(cs11);
        ftp.addFileStructure(fs11);
        
        myFS = ftp.getFiles();
        
         for (FileStructure f : myFS) {
            String filePath = f.getFilePath();
            System.out.println("File Name : " + f.getFileName());
            System.out.println("File Path " + filePath);
            parseForMethods(readFileToString(filePath),f.getClasses().get(0),f);
        }
         
        for (FileStructure f : myFS) {
            String filePath = f.getFilePath();
            System.out.println("File Name : " + f.getFileName());
            System.out.println("File Path " + filePath);
            parse(readFileToString(filePath),f.getClasses().get(0),f);
            f.printLineDictionary();
        }
        
        Utils.insertDependencies(ftp);
        
         for (FileStructure f : myFS) {
            f.printLineDictionary();
        }
         
        ftp.printFilesToParse();
        
    }
}
