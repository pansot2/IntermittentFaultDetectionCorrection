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
        cacheObject = Collections.synchronizedList(new ArrayList<Object>());
    }

    public synchronized List<Object> getCacheObject() {
        return cacheObject;
    }

    public synchronized void setCacheObject(ArrayList<Object> cacheObject) {
        this.cacheObject = cacheObject;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }
    
    public synchronized void addCacheObjectValue(Object value) {
        cacheObject.add(value);
    }
    
    public synchronized void addCacheObjectValue(Object value, boolean doubleValue) {
        if (doubleValue) {
            cacheObject.add(Double.parseDouble(value.toString()));
        }else {
            cacheObject.add(value);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.name == null)
            return false;
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CacheObject other = (CacheObject) obj;
        if (this.name.compareTo(other.name)!=0) {
            return false;
        }
        return true;
    }
    
    

}
