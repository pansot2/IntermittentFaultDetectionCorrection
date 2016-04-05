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

import gr.uop.intermittentfaults.intermmittentfaultsutils.GlobalParams;

/**
 *
 * @author Panagiotis Sotiropoulos
 */
public class Store {

    public static void CacheStore(Object target, Object value, String objectName, Cache cacheInstance) throws IllegalArgumentException, IllegalAccessException, InterruptedException {
        String name = objectName + "_" + target;
        CacheObject mo;
        mo = cacheInstance.searchObject(name);      
        if (mo != null) {
            mo.addCacheObjectValue(value);
            GlobalParams.setCompareValue((int)GlobalParams.getCompareValue()+1); 
        } else {
          //  Thread.sleep(10);
            CacheObject newMo = new CacheObject();
            newMo.addCacheObjectValue(value); 
            newMo.setName(name);
            cacheInstance.addCacheObject(newMo); 
            GlobalParams.setCompareValue(1);
        }
    }

}