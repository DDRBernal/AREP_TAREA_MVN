package edu.escuelaing.arem.cache;

import java.util.HashMap;

public class Cache {

    private static HashMap<String, String> cacheMap ;
    private static Cache cache;

    /**
     * Metodo que retorna la instacia cache si existe, sino crea una unica instancia antes de retornarlo
     * @return Cache cache
     */
    public static Cache getCache() {
        if (cache == null) {
            cacheMap  = new HashMap<>();
            cache = new Cache();
        }
        return cache;
    }

    /**
     * Metodo que retorna el hash de cache
     * @return HashMap cacheMap
     */
    public static HashMap<String, String> getCacheMap() {
            return cacheMap;
    }

}
