package com.fgorostiaga.springcourse.controller;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fgorostiaga.springcourse.model.BeanFilterExample;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleFilterController {


    /* Dynamic filtering using jackson's SimpleBeanPropertyFilter */
    @GetMapping("/filtering")
    public MappingJacksonValue beanFilterExample() {
        BeanFilterExample bean = new BeanFilterExample("value1", "value2", "value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("BeanCustomFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(bean);
        mapping.setFilters(filters);
        return mapping;
    }

}
