package gr.uop.intermittent.faults.utils;

/**
 *
 * @author Panagiotis Sotiropoulos
 */
public class CacheStore {
    public static void cacheStore(Object instance, Object value, String metricName, String metricGroup) throws Exception {
        Cache cacheInstance;
        cacheInstance = CacheCollection.getCacheCollection().getCacheInstance(metricGroup);
        if (cacheInstance == null) {
            cacheInstance = new Cache();
            CacheCollection.getCacheCollection().addCacheInstance(metricGroup, cacheInstance);
        }
        Store.CacheStore(instance, value, metricName, cacheInstance);
    }
}
