package com.learn.rest.webservices.restful_web_services.filtering;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringRestEndpoint {

    @GetMapping("/some-class")
    public SomeClass noFiltering() {
        return new SomeClass("Value1", "Value2", "Value3");
    }

    @GetMapping("some-class-filter")
    public SomeClass staticFiltering() {

        return new SomeClass("Value1", "Value2", "Value3");
    }
}
