/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.appendfilelines;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 *,
 * @author Panos
 */
public class AddFileLines {
    public static void addLines(File file, List<Integer> additionalLines, String className, String methodName, String classPath) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        classPath = classPath.replaceAll("\\\\", "\\\\\\\\");
        int i=0;
        for (int line : additionalLines)
            if (lines.get(line-1).length()!=0 && !lines.get(line-1).contains("return") && !lines.get(line-1).contains("if") && !lines.get(line-1).contains("while") && !lines.get(line-1).contains("*/"))
                lines.set(line-1, lines.get(line-1) + " try {JbossAutomatedJavaSeMetricsSyncDbStore.metricsDbStore(\"\", new Object[]{GlobalParams.globalCountGetAndIncrement(),\"" + className + "\",\"" + methodName + "\",\"" + classPath + "\",\"" + line + "\",Thread.currentThread().getName()}, \"intermittentFaultsGroup\", \"statement_1\", new String[]{\"StoreDBMetric\",\"serialCount\",\"className\",\"methodName\",\"classPath\",\"line\",\"thread\"},\"default\");} catch (Exception ex) {ex.printStackTrace();}");
        Files.write(file.toPath(), lines);
    }
}
