package com.cy.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

import javax.cache.CacheManager;

@Slf4j
@Configuration
@EnableCaching
public class CacheConfig implements JCacheManagerCustomizer {

  //目录信息
  public static final String CACHE_MENU_USER_ALL = "sysMenuByUserAll";

  public static final String CACHE_MENU_ROOT = "sysMenuRoot";

  public static final String CACHE_MENU_ALL = "sysMenuAll";

  @Override
  public void customize(CacheManager cacheManager) {

  }


}
