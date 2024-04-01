package com.example.mysqldb.config;

import com.example.mysqldb.models.City;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.time.Duration;

@Configuration
@EnableCaching
public class ECacheConfig {

    @Bean
    public CacheManager ecacheManager() {
        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager();

        CacheConfiguration<Integer, City> configuration = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(
                        Integer.class,
                        City.class,
                        ResourcePoolsBuilder
                                .heap(100)
                                .offheap(10, MemoryUnit.MB)
                                .build())
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(10)))
                .build();

        javax.cache.configuration.Configuration<Integer, City> integerListConfiguration =
                Eh107Configuration.fromEhcacheCacheConfiguration(configuration);

        cacheManager.createCache("city_cache", integerListConfiguration);
        return cacheManager;
    }
}
