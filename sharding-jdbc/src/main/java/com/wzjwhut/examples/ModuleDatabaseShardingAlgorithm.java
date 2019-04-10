package com.wzjwhut.examples;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.log4j.Log4j2;

import java.util.Collection;

@Log4j2
public class ModuleDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> dbNames, PreciseShardingValue<String> shardingValue) {
        log.info("[sharding database] dbNames: {}, shardingValue: {}", dbNames, shardingValue);
        try {
            String value = shardingValue.getValue();
            int hash = Math.abs(value.hashCode());
            int index = hash % dbNames.size();
            for(String dbName : dbNames){
                if(dbName.endsWith(String.valueOf(index))){
                    return dbName;
                }
            }
        }catch(Throwable ex){
            log.error("sharding error", ex);
        }
        return null;
    }
}
