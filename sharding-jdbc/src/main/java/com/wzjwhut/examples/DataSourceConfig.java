package com.wzjwhut.examples;


import com.mysql.jdbc.Driver;
import com.zaxxer.hikari.HikariDataSource;
import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@Log4j2
public class DataSourceConfig {

    /** 使用sharding-jdbc的源 */
    @Bean
    DataSource createDataSource() throws SQLException, NoSuchFieldException, IllegalAccessException {
        log.info("build data source");

        //收集分库列表
        Map<String, DataSource> dataSourceMap = new LinkedHashMap<>();
        dataSourceMap.put("test", createDataSource("test"));
        dataSourceMap.put("test_0", createDataSource("test_0"));
        dataSourceMap.put("test_1", createDataSource("test_1"));

        //city表的分库分表规则
        TableRuleConfiguration cityRule = new TableRuleConfiguration();
        cityRule.setLogicTable("city");
        cityRule.setActualDataNodes("test_${0..1}.city_${0..1}");

        //分库策略
        cityRule.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration(
                "name",
                new ModuleDatabaseShardingAlgorithm()));

        //分表策略
        cityRule.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration(
                "name",
                new ModuleTableShardingAlgorithm(),null));




        ShardingRuleConfiguration ruleConfig = new ShardingRuleConfiguration();
        ruleConfig.setDefaultDataSourceName("test");
        ruleConfig.getTableRuleConfigs().addAll(Arrays.asList(cityRule));

        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap,
                ruleConfig, Collections.EMPTY_MAP, null);
        return dataSource;
    }

    private static DataSource createDataSource(final String dataSourceName) {
        log.info("create data source: {}", dataSourceName);
        HikariDataSource result = new HikariDataSource();
        result.setJdbcUrl(String.format("jdbc:mysql://localhost:3306/%s", dataSourceName));
        result.setDriverClassName(Driver.class.getName());
        result.setUsername("root");
        result.setPassword("123456");
        return result;
    }
}
