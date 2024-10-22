package com.chamara.war_that_saves;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//    @Override
//    <S extends Employee> S save(S entity);
//
//    @Override
//    List<Employee> findAll();
}
