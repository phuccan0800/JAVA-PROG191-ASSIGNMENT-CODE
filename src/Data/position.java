package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class position {
    public static int numberOfPositionID = 0;
    int positionID = 0;
    String positionName;
    int salary;

    public position(String position, int salary) {
        numberOfPositionID++;
        positionID = numberOfPositionID;
        this.positionName = position;
        this.salary = salary;
    }

    public position() {

    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getPosition() {
        return positionName;
    }

    public void setPosition(String position) {
        this.positionName = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
