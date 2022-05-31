package com.greetingapp.controller;

import com.greetingapp.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello , %s!";
    private final AtomicLong counter = new AtomicLong();//used for auto increment

    /**
     * @URL:localhost:8080/greeting  -Postman-GET
     * @return: {id =1 , content="hello world!}
     * localhost:8080/greeting?name=Divya
     * @return: { id=2, content="hello Divya !
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}