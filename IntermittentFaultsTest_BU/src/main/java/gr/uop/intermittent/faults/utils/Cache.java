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
        cache = new HashSet();
    }

    /**
     * @return the metricCache
     */
    public synchronized HashSet<CacheObject> getCache() {
        return cache;
    }

    public synchronized boolean addCacheObject(CacheObject cacheObject) {
        return (this.getCache().add(cacheObject));
    }

    public synchronized void removeCacheObject(CacheObject cacheObject) {
        this.getCache().remove(cacheObject);
    }

    public synchronized CacheObject searchObject(String name) {
        for (CacheObject mObject : getCache()) {
            if (mObject.getName().compareTo(name) == 0) {
                return mObject;
            }
        }

        return null;
    }

    public synchronized void printObjects() {
        logger.info("Logging metric objects ...");
        for (CacheObject mObject : getCache()) {
            logger.info("Name : " + mObject.getName());
            Iterator<Object> iob = mObject.getCacheObject().iterator();

            while (iob.hasNext()) {
                logger.info("Value : " + iob.next().toString());
            }
        }
    }

}
