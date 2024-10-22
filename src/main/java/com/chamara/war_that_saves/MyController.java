package com.chamara.war_that_saves;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {

    @Autowired
    EmployeeRepository repo;

    @GetMapping("hello")
    public String hello() {
        Employee referenceById = repo.getReferenceById(1);
        log.info(referenceById.getName());
        return referenceById.getName();
    }

    @PostMapping("employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return repo.save(employee);
    }

}
