package org.anubhav;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "redis")
public class Config {
    private String connectionString;

    public String getConnectionString(){
        return this.connectionString;
    }
    public void setConnectionString(String connectionString){
        this.connectionString = connectionString;
    }
}
