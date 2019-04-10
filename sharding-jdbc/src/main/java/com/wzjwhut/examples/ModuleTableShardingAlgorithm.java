package com.wzjwhut.examples;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.log4j.Log4j2;

import java.util.Collection;

@Log4j2
public class ModuleTableShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<String> shardingValue) {
        log.info("[sharding table] tables: {}, sharding: {}", tableNames, shardingValue);
        try {
            String value = shardingValue.getValue();
            int hash = Math.abs(value.hashCode());
            int index = hash % tableNames.size();
            for(String name : tableNames){
                if(name.endsWith(String.valueOf(index))){
                    return name;
                }
            }
        }catch(Throwable ex){
            log.error("sharding error", ex);
        }
        return null;
    }
}
