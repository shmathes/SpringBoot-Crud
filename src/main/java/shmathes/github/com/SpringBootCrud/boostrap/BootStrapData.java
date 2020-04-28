package shmathes.github.com.SpringBootCrud.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import shmathes.github.com.SpringBootCrud.model.Employee;
import shmathes.github.com.SpringBootCrud.repository.EmployeeRepository;

import java.util.Scanner;

@Component
public class BootStrapData implements CommandLineRunner
{
    private final EmployeeRepository employeeRepository;
    Scanner scanner = new Scanner(System.in);

    public BootStrapData(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        int count = 0;
        int i = 0;
        System.out.print("How many employees? ");
        count = scanner.nextInt();
        while (i < count)
        {
            String firstName = "";
            String lastName = "";
            String email = "";

            System.out.print("Employee #" + Integer.toString(i+1) + " first name: ");
            firstName = scanner.next();
            System.out.print("Employee #" + Integer.toString(i+1) + " last name: ");
            lastName = scanner.next();
            System.out.print("Employee #" + Integer.toString(i+1) + " email: ");
            email = scanner.next();

            Employee emp = new Employee();
            emp.setFirstName(firstName);
            emp.setLastName(lastName);
            emp.setEmailId(email);
            employeeRepository.save(emp);
            i+= 1;
        }
    }
}
