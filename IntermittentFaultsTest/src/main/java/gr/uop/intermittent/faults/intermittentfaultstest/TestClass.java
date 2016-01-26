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
package gr.uop.intermittent.faults.intermittentfaultstest;

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

        for (int i=0; i<10; i++) {
            synchronized(countlock) {
                count += 1;
            }
            CacheStore.cacheStore(this,count,"count","myTestGroup"); 

       /*     synchronized(count2lock) {
                count2 += 2;
            }
            CacheStore.cacheStore(this,count2,"count2","myTestGroup");
            */
        }
               
    } 

}
