package Controller;
import Data.Employees;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesControllerTest {
    EmployeesController employee = new EmployeesController();
    @Test
    void addEmployeesData() {
    }

    @Test
    void editInformation() {
    }
    @Test
    void addInformation() {
        String information = "Test Information";
        try {
            employee.AddInformation(information);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get("Employee.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(content.contains(information));
    }
    @Test
    void addInformationcheckFile(){
        File file = new File("Employee.txt");
        assertTrue(file.exists());
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