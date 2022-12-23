package org.anubhav;

import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private RedisCommands<String, String> syncCommands;

    @Autowired
    private ServerProperties serverProperties;

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "i am running on port "+ this.serverProperties.getPort();
    }

    @GetMapping("/data")
    public String GetData(@RequestParam String key) {
        return "i am running on port "+ this.serverProperties.getPort()+ " value = "+ syncCommands.get(key);
    }

    @GetMapping("/set_data")
    public String SetData(@RequestParam String key, @RequestParam String val) {
        syncCommands.set(key, val);
        return "from port: "+ this.serverProperties.getPort()+" set the value success";
    }
}
