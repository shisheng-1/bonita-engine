/*******************************************************************************
 * Copyright (C) 2015 BonitaSoft S.A.
 * BonitaSoft is a trademark of BonitaSoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * BonitaSoft, 32 rue Gustave Eiffel – 38000 Grenoble
 * or BonitaSoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 *******************************************************************************/
package com.bonitasoft.engine.persistence;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.bonitasoft.engine.persistence.HibernateConfigurationProviderImpl;
import org.bonitasoft.engine.persistence.HibernateResourcesConfigurationProvider;
import org.bonitasoft.engine.services.SPersistenceException;

import com.bonitasoft.manager.Features;
import com.bonitasoft.manager.Manager;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.RootClass;

/**
 * @author Celine Souchet
 * @author Baptiste Mesta
 */
public class HibernateConfigurationProviderExt extends HibernateConfigurationProviderImpl {

    private final Map<String, String> cacheQueries;

    public static final String NO_CACHE_STRATEGY = "none";

    public HibernateConfigurationProviderExt(final Properties properties, final Properties cacheProperties,
            final HibernateResourcesConfigurationProvider hibernateResourcesConfigurationProvider, final Map<String, String> interfaceToClassMapping,
            final List<String> mappingExclusions, final Map<String, String> cacheQueries) throws SPersistenceException {
        super(merge(properties, cacheProperties), hibernateResourcesConfigurationProvider, interfaceToClassMapping, mappingExclusions);
        this.cacheQueries = cacheQueries;
    }

    public HibernateConfigurationProviderExt(final Properties properties,
            final HibernateResourcesConfigurationProvider hibernateResourcesConfigurationProvider, final Map<String, String> interfaceToClassMapping,
            final List<String> mappingExclusions, final Map<String, String> cacheQueries) throws SPersistenceException {
        super(properties, hibernateResourcesConfigurationProvider, interfaceToClassMapping, mappingExclusions);
        this.cacheQueries = cacheQueries;
    }

    private static Properties merge(final Properties normalProperties, final Properties cacheProperties) {
        final String cache1 = cacheProperties.getProperty("hibernate.cache.provider_class");
        final String cache2 = cacheProperties.getProperty("hibernate.cache.region.factory_class");
        if ((cache1 != null && cache1.contains("hazelcast") || cache2 != null && cache2.contains("hazelcast"))
                && !Manager.getInstance().isFeatureActive(Features.ENGINE_CLUSTERING)) {
            // Empty if ???
        }
        final Properties properties = new Properties();
        for (final Entry<Object, Object> entry : normalProperties.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        for (final Entry<Object, Object> entry : cacheProperties.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        return properties;
    }

    @Override
    public Map<String, String> getCacheQueries() {
        return cacheQueries;
    }

    @Override
    protected Configuration buildConfiguration(final Properties properties, final HibernateResourcesConfigurationProvider hibernateResourcesConfigurationProvider) {
        final Configuration configuration = super.buildConfiguration(properties, hibernateResourcesConfigurationProvider);
        final Map<String, String> exceptions = ((HibernateResourcesConfigurationProviderExt)hibernateResourcesConfigurationProvider).getCacheConcurrencyStrategiesExceptions();
        final String defaultCacheConcurrencyStrategy = ((HibernateResourcesConfigurationProviderExt)hibernateResourcesConfigurationProvider).getDefaultCacheConcurrencyStrategy();
        final Iterator<PersistentClass> entities = configuration.getClassMappings();
        while (entities.hasNext()) {
            final PersistentClass entity = entities.next();
            final String className = entity.getClassName();
            if (entity instanceof RootClass) {
                String cacheConcurrencyStrategy = defaultCacheConcurrencyStrategy;
                if (exceptions.containsKey(className)) {
                    cacheConcurrencyStrategy = exceptions.get(className);
                }
                if (!NO_CACHE_STRATEGY.equals(cacheConcurrencyStrategy)) {
                    configuration.setCacheConcurrencyStrategy(className, cacheConcurrencyStrategy);
                }
            }
        }

        return configuration;
    }
}
