package com.jojoldu;

import com.jojoldu.dto.helloresponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//

public class hello {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/hello/dto")
    public helloresponse hellodto(@RequestParam("name") String name,
                                  @RequestParam("amount") int amount) {
        return new helloresponse(name,amount);
    }

}
