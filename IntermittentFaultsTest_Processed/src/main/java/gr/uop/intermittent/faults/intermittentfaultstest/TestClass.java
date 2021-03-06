/*
 * Copyleft 2015 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gr.uop.intermittent.faults.intermittentfaultstest; import org.jboss.metrics.javase.automatedmetricsjavaseapi.JbossAutomatedJavaSeMetricsDbStore; import gr.uop.intermittentfaults.intermmittentfaultsutils.GlobalParams;

import gr.uop.intermittent.faults.utils.CacheStore;

/**
 *
 * @author Panagiotis Sotiropoulos
 */
public class TestClass {

    private int count = 0;
    private  int count2 = 0;
    
    private final static Object countlock = new Object();
    private final static Object count2lock = new Object();
    
    public void countMethod() throws Exception {

        for (int i=0; i<10; i++) { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"TestClass","countMethod","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\TestClass.java","35",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
            synchronized(countlock) { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"TestClass","countMethod","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\TestClass.java","36",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
                count += 1; if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"TestClass","countMethod","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\TestClass.java","37",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
            }
            CacheStore.cacheStore(this,count,"count","myTestGroup");  if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"TestClass","countMethod","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\TestClass.java","39",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}

       /*     synchronized(count2lock) { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"TestClass","countMethod","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\TestClass.java","41",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
                count2 += 2; if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"TestClass","countMethod","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\TestClass.java","42",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
            }
            CacheStore.cacheStore(this,count2,"count2","myTestGroup"); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"TestClass","countMethod","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\TestClass.java","44",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
            */
        }
                if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"TestClass","countMethod","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\intermittentfaultstest\\TestClass.java","47",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
    } 

}
