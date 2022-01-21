package com.cloud.client.config;

import com.cloud.client.properties.DatabaseProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MasterDatasourceConfig {

    @Autowired
    private DatabaseProperties databaseProperties;

    @Primary
    @Bean(name = "masterDataSource")
    public DataSource masterDataSource() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(databaseProperties.getMaster().getDatasource().getUrl());
        config.setUsername(databaseProperties.getMaster().getDatasource().getUsername());
        config.setPassword(databaseProperties.getMaster().getDatasource().getPassword());

        config.addDataSourceProperty("prepStmtCacheSize",Integer.valueOf(databaseProperties.getHikari().getConfig().getPrepStmtCacheSize()));
        config.addDataSourceProperty("prepStmtCacheSqlLimit",Integer.valueOf(databaseProperties.getHikari().getConfig().getPrepStmtCacheSqlLimit()));
        config.addDataSourceProperty("cachePrepStmts",Boolean.valueOf(databaseProperties.getHikari().getConfig().getCachePrepStmts()));
        config.addDataSourceProperty("useServerPrepStmts",Boolean.valueOf(databaseProperties.getHikari().getConfig().getUseServerPrepStmts()));

        return new HikariDataSource(config);
    }
}