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
 * ,
 *
 * @author Panos
 */
public class AddFileLinesForRecuersiveReplay {

    public static void addLines(File file, List<Integer> additionalLines, List<Integer> additionalLinesToBeginWith, List<Integer> excludeLines, String className, String methodName, String classPath) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        classPath = classPath.replaceAll("\\\\", "\\\\\\\\");
        int i = 0;
        for (int line : additionalLines) {
            if (!excludeLines.contains(line)) {
                String lineString = lines.get(line - 1).trim();
                if (lines.get(line - 1).contains("if") || lines.get(line - 1).contains("while")) {
                    lines.set(line - 1, " if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore(\"\", new Object[]{GlobalParams.globalCountGetAndIncrement(),\"" + className + "\",\"" + methodName + "\",\"" + classPath + "\",\"" + line + "\",Thread.currentThread().getName()}, \"intermittentFaultsReplayGroup\", \"statement_1\", new String[]{\"StoreDBMetric\",\"serialCount\",\"className\",\"methodName\",\"classPath\",\"line\",\"thread\"},\"default\"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}" + lines.get(line - 1));
                }
                
                if (lines.get(line - 1).length() != 0 && !lines.get(line - 1).contains("return") && !lines.get(line - 1).contains("if") && !lines.get(line - 1).contains("while") && !lines.get(line - 1).contains("*/") && lineString.compareTo("{") != 0 && lineString.compareTo("}") != 0) {
                    lines.set(line - 1, lines.get(line - 1) + " if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore(\"\", new Object[]{GlobalParams.globalCountGetAndIncrement(),\"" + className + "\",\"" + methodName + "\",\"" + classPath + "\",\"" + line + "\",Thread.currentThread().getName()}, \"intermittentFaultsReplayGroup\", \"statement_1\", new String[]{\"StoreDBMetric\",\"serialCount\",\"className\",\"methodName\",\"classPath\",\"line\",\"thread\"},\"default\"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}");
                }

                if (lines.get(line - 1).contains("return")) {
                    lines.set(line - 1, " { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore(\"\", new Object[]{GlobalParams.globalCountGetAndIncrement(),\"" + className + "\",\"" + methodName + "\",\"" + classPath + "\",\"" + line + "\",Thread.currentThread().getName()}, \"intermittentFaultsReplayGroup\", \"statement_1\", new String[]{\"StoreDBMetric\",\"serialCount\",\"className\",\"methodName\",\"classPath\",\"line\",\"thread\"},\"default\"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}" + lines.get(line - 1) + "}");
                }
            }
        }

        for (int line : additionalLinesToBeginWith) {
            lines.set(line - 1, " { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}" + lines.get(line - 1) + "}");
        }

        Files.write(file.toPath(), lines);
    }
}
