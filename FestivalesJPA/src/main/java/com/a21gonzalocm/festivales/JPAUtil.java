package com.a21gonzalocm.festivales;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static volatile EntityManagerFactory emfInstance;

    private JPAUtil() {}

    public static EntityManagerFactory get() {
        if (emfInstance == null) {
            synchronized (JPAUtil.class) {
                if (emfInstance == null) {
                    emfInstance = Persistence.createEntityManagerFactory("festivales");
                }
            }
        }
        return emfInstance;
    }
}
