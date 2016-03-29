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

import java.util.HashSet;
import java.util.Iterator;
import org.jboss.logging.Logger;


/**
 *
 * @author Panagiotis Sotiropoulos
 */
public class Cache {

    private HashSet<CacheObject> cache;
    private static final Logger logger = Logger.getLogger(Cache.class);

    public Cache() {
        cache = new HashSet(); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","Cache","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","34",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
    }

    /**
     * @return the metricCache
     */
    public synchronized HashSet<CacheObject> getCache() {
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","getCache","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","41",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        return cache;}
    }

    public synchronized boolean addCacheObject(CacheObject cacheObject) {
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","addCacheObject","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","45",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        return (this.getCache().add(cacheObject));}
    }

    public synchronized void removeCacheObject(CacheObject cacheObject) {
        this.getCache().remove(cacheObject); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","removeCacheObject","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","49",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
    }

    public synchronized CacheObject searchObject(String name) {
        for (CacheObject mObject : getCache()) { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","searchObject","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","53",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
 if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","searchObject","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","54",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}            if (mObject.getName().compareTo(name) == 0) {
 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","searchObject","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","55",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}                return mObject;}
            }
        }

 { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","searchObject","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","59",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}        return null;}
    }

    public synchronized void printObjects() {
        logger.info("Logging metric objects ..."); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","printObjects","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","63",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
        for (CacheObject mObject : getCache()) { if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","printObjects","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","64",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
            logger.info("Name : " + mObject.getName()); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","printObjects","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","65",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
            Iterator<Object> iob = mObject.getCacheObject().iterator(); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","printObjects","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","66",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}

 if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","printObjects","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","68",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}            while (iob.hasNext()) {
                logger.info("Value : " + iob.next().toString()); if (GlobalParams.getGlobalCount().get() < GlobalParams.getCountUntil()) try {JbossAutomatedJavaSeMetricsDbStore.metricsDbStore("", new Object[]{GlobalParams.globalCountGetAndIncrement(),"Cache","printObjects","F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Cache.java","69",Thread.currentThread().getName()}, "intermittentFaultsReplayGroup", "statement_1", new String[]{"StoreDBMetric","serialCount","className","methodName","classPath","line","thread"},"default"); GlobalParams.SetDone(); GlobalParams.AddBlockPoints();} catch (Exception ex2) {ex2.printStackTrace();}
            }
        }
    }

}
