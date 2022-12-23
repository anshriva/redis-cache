package org.anubhav;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RedisClientWrapper {
    @Autowired
    public Config config;

    @Bean
    public RedisCommands<String, String> GetRedisSyncCommand(){
        io.lettuce.core.RedisClient client = io.lettuce.core.RedisClient.create(this.config.getConnectionString());
        StatefulRedisConnection<String, String> connection = client.connect();
        return connection.sync();
    }
}
