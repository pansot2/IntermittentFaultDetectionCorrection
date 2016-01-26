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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author Panagiotis Sotiropoulos
 */
public class CacheApi {
    
    private final static Object cacheApi = new Object();
    
    public static synchronized Map<String,ArrayList<Object>> getCache(String group)
    {
        Map<String,ArrayList<Object>> cacheObjectList = new HashMap<>();
        HashSet<CacheObject> objectsCache = CacheCollection.getCacheCollection().getCacheInstance(group).getCache();
        
        for (CacheObject mObject : objectsCache) {
            System.out.println("mObject.getCacheObject() " + mObject.getCacheObject());
             System.out.println("mObject.getCacheObject() " + mObject.getName());
            List list = Collections.synchronizedList(new ArrayList<Object>(mObject.getCacheObject()));
            Iterator<Object> iob = list.iterator();
            ArrayList<Object> metricValues = new ArrayList<>();
            int listSize = list.size();
            System.out.println("list " + listSize);
            while (iob.hasNext()) {
                metricValues.add(iob.next().toString());
            }
            cacheObjectList.put(mObject.getName(), metricValues);
            }
        
        return cacheObjectList;
    }
    
    public static synchronized String printCache(String group) {
        String output = "";
        Map<String, ArrayList<Object>> cache;
        Set<String> metricNames;
        Collection<ArrayList<Object>> metricValues;
        cache = getCache(group);
        metricNames = cache.keySet();
        metricValues = cache.values();
        
        System.out.println("metricNames.size()" + metricNames.size());
        System.out.println("metricValues.size()" + metricValues.size());

        Iterator<String> iob = metricNames.iterator();
        Iterator<ArrayList<Object>> iobv = metricValues.iterator();
        while (iob.hasNext()) {
            output += "<br>Metric Parameter Name : " + iob.next() + "</br>\n";
            if (iobv.hasNext()) {
                ArrayList<Object> values = iobv.next();
                System.out.println("values() " + values.size());
                for (Object value : values) {
                    output += "<br>Value : " + value.toString() + "</br>\n";
                }
            }
        }
        
        return output;
    }
    
    public static void cleanCache(String group)
    {
        CacheCollection.getCacheCollection().getCacheInstance(group).getCache().clear();
    }
}
