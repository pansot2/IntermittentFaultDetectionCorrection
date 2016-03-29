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
package gr.uop.intermittent.faults.utils; import org.jboss.metrics.javase.automatedmetricsjavaseapi.JbossAutomatedJavaSeMetricsDbStore; import gr.uop.intermittentfaults.intermmittentfaultsutils.GlobalParams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Panagiotis Sotiropoulos
 */
public class CacheObject {

    private List<Object> cacheObject;
    private String name;

    public CacheObject() {
        cacheObject = Collections.synchronizedList(new ArrayList<Object>()); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","CacheObject","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","36",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
    }

    public synchronized List<Object> getCacheObject() {
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","getCacheObject","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","40",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        return cacheObject;}
    }

    public synchronized void setCacheObject(ArrayList<Object> cacheObject) {
        this.cacheObject = cacheObject; if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","setCacheObject","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","44",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
    }

    public synchronized String getName() {
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","getName","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","48",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        return name;}
    }

    public synchronized void setName(String name) {
        this.name = name; if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","setName","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","52",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
    }
    
    public synchronized void addCacheObjectValue(Object value) {
        cacheObject.add(value); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","addCacheObjectValue","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","56",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
    }
    
    public synchronized void addCacheObjectValue(Object value, boolean doubleValue) {
 if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","addCacheObjectValue","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","60",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        if (doubleValue) {
            cacheObject.add(Double.parseDouble(value.toString())); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","addCacheObjectValue","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","61",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
        }else { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","addCacheObjectValue","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","62",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
            cacheObject.add(value); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","addCacheObjectValue","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","63",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
        }
    }

    @Override
    public int hashCode() {
        int hash = 3; if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","hashCode","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","69",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","hashCode","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","70",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        return hash;}
    }

    @Override
    public boolean equals(Object obj) {
 if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","equals","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","75",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        if (obj == null) {
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","equals","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","76",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}            return false;}
        }
 if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","equals","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","78",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        if (this.name == null)
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","equals","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","79",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}            return false;}
         if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","equals","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","80",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
 if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","equals","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","81",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        if (getClass() != obj.getClass()) {
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","equals","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","82",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}            return false;}
        }
        final CacheObject other = (CacheObject) obj; if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","equals","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","84",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
 if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","equals","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","85",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        if (this.name.compareTo(other.name)!=0) {
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","equals","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","86",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}            return false;}
        }
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheObject","equals","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheObject.java","88",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        return true;}
    }
    
    

}
