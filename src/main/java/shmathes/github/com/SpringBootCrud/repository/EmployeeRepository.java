package shmathes.github.com.SpringBootCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shmathes.github.com.SpringBootCrud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

}
