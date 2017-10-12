package com.jd.test.springboot.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by sunboyu on 2017/10/12.
 */
@Configuration
@Slf4j
public class DruidDBConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.druid.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.druid.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.druid.max-active}")
    private int maxActive;

    @Value("${spring.datasource.druid.max-wait}")
    private long maxWait;

    @Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
    private long minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.validation-query}")
    private String validationQuery;

    @Value("${spring.datasource.druid.test-while-idle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.druid.test-on-borrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.druid.test-on-return}")
    private boolean testOnReturn;

    @Value("${spring.datasource.druid.pool-prepared-statements}")
    private boolean poolReparedStatements;

    @Value("${spring.datasource.druid.max-pool-prepared-statement-perconnection-size}")
    private int maxPoolPreparedStatementPerconnectionSize;

    @Value("${spring.datasource.druid.filters}")
    private String filters;


    @Value("${spring.datasource.druid.connection-properties}")
    private String connectionProperties;

    @Bean
    @Primary
    public DataSource dataSource() {

        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.setUrl(this.url);
        druidDataSource.setUsername(this.username);
        druidDataSource.setPassword(this.password);
        druidDataSource.setDriverClassName(this.driverClassName);

        // configuration
        druidDataSource.setInitialSize(this.initialSize);
        druidDataSource.setMinIdle(this.minIdle);
        druidDataSource.setMaxActive(this.maxActive);
        druidDataSource.setMaxWait(this.maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(this.validationQuery);

        druidDataSource.setTestWhileIdle(this.testWhileIdle);
        druidDataSource.setTestOnBorrow(this.testOnBorrow);
        druidDataSource.setTestOnReturn(this.testOnReturn);

        druidDataSource.setPoolPreparedStatements(this.poolReparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerconnectionSize);

        try {
            druidDataSource.setFilters(this.filters);
        } catch (SQLException e) {
            log.error("druid configuration initialization filter", e);
        }

        druidDataSource.setConnectionProperties(this.connectionProperties);

        return druidDataSource;
    }
}
