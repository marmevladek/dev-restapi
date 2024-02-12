package com.project.devrestapi.repository;

import com.project.devrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {

//    List<Employee> findByDepartmentName(String name);


//    @Transactional
//    @Modifying
//    @Query("DELETE FROM Employee WHERE name = :name")
//    Integer deleteEmployeeByName(String name);


}
