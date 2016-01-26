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
package gr.uop.intermittent.faults.utils;

import java.util.HashMap;

/**
 *
 * @author Panagiotis Sotiropoulos
 */
public class CacheCollection {
    private static CacheCollection cachec = new CacheCollection();
    private HashMap<String, Cache> cacheInstances;

    private CacheCollection() {
        cacheInstances = new HashMap<String, Cache>();
    }
    
    public static synchronized CacheCollection getCacheCollection() {
        return cachec;
    }
    
    public synchronized Cache getCacheInstance(String name) {
        return (this.cacheInstances.get(name));
    }
    
    public synchronized void addCacheInstance(String name, Cache cache) {
        this.cacheInstances.put(name, cache);
    }
    
    public synchronized void removeCacheInstance(String name) {
        this.cacheInstances.remove(name);
    }
    
    public synchronized boolean existsCacheInstance(String name) {
        return(this.cacheInstances.containsKey(name));
    }
}
