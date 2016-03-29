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

import java.util.HashMap;

/**
 *
 * @author Panagiotis Sotiropoulos
 */
public class CacheCollection {
    private static CacheCollection cachec = new CacheCollection();
    private HashMap<String, Cache> cacheInstances;

    private CacheCollection() {
        cacheInstances = new HashMap<String, Cache>(); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheCollection","CacheCollection","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheCollection.java","30",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
    }
    
    public static synchronized CacheCollection getCacheCollection() {
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheCollection","getCacheCollection","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheCollection.java","34",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        return cachec;}
    }
    
    public synchronized Cache getCacheInstance(String name) {
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheCollection","getCacheInstance","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheCollection.java","38",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        return (this.cacheInstances.get(name));}
    }
    
    public synchronized void addCacheInstance(String name, Cache cache) {
        this.cacheInstances.put(name, cache); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheCollection","addCacheInstance","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheCollection.java","42",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
    }
    
    public synchronized void removeCacheInstance(String name) {
        this.cacheInstances.remove(name); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheCollection","removeCacheInstance","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheCollection.java","46",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
    }
    
    public synchronized boolean existsCacheInstance(String name) {
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"CacheCollection","existsCacheInstance","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\CacheCollection.java","50",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        return(this.cacheInstances.containsKey(name));}
    }
}
