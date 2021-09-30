package com.fgorostiaga.springcourse.versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    // Versioning by mapping

    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Johnson"));
    }

    /*
        Versioning by headers
        Include header X-API-VERSION=n
    */

    @GetMapping(value="/person/header", headers="X-API-VERSION=1")
    public PersonV1 headerPersonV1() {
        return new PersonV1("Bob");
    }

    @GetMapping(value="/person/header", headers="X-API-VERSION=2")
    public PersonV2 headerPersonV2() {
        return new PersonV2(new Name("Bob", "Johnson"));
    }

    /*
        Versioning by params
        Include param <url>?version=n
    */

    @GetMapping(value="/person/param", params="version=1")
    public PersonV1 paramPersonV1() {
        return new PersonV1("Bob");
    }

    @GetMapping(value="/person/param", headers="version=2")
    public PersonV2 paramPersonV2() {
        return new PersonV2(new Name("Bob", "Johnson"));
    }

    /*
        Versioning by produces (media type versioning)
        Include header Accept: application/vnd.company.app-v1+json
    */

    @GetMapping(value="/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesPersonV1() {
        return new PersonV1("Bob");
    }

    @GetMapping(value="/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesPersonV2() {
        return new PersonV2(new Name("Bob", "Johnson"));
    }


}
