package Controller;
import Data.Employees;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesControllerTest {

    @Test
    void addEmployeesData() {
    }

    @Test
    void editInformation() {
    }

    @Test
    void addInformation() {
        EmployeesController employee = new EmployeesController();
        String information = "Test Information";
        try {
            employee.AddInformation(information);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File("Employee.txt");
        assertTrue(file.exists());
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get("Employee.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(content.contains(information));
    }

    @Test
    void delete() {
    }

    @Test
    void savelastAttendance() {
    }

    @Test
    void deleteInformation() {
    }

    @Test
    void editPassword() {
    }
}