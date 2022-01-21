package com.cloud.client.properties;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "database")
public class DatabaseProperties {
    private Master master;
    private Slave slave;
    private Hikari hikari;

    @ToString
    @Getter
    @Setter
    public static class Master {
        public Datasource datasource;

        @ToString
        @Getter
        @Setter
        public static class Datasource {
            private String url;
            private String username;
            private String password;
        }
    }

    @ToString
    @Getter
    @Setter
    public static class Slave {
        public Datasource datasource;

        @ToString
        @Getter
        @Setter
        public static class Datasource {
            private String url;
            private String username;
            private String password;
        }
    }

    @ToString
    @Getter
    @Setter
    public static class Hikari {
        public Config config;

        @ToString
        @Getter
        @Setter
        public static class Config {
            private String prepStmtCacheSize;
            private String useServerPrepStmts;
            private String cachePrepStmts;
            private String prepStmtCacheSqlLimit;
        }
    }

}
