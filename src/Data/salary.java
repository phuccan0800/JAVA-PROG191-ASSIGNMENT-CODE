package Data;

import Controller.SalaryController;

public class salary extends Employees{
    SalaryController salaryController = new SalaryController();
    public static int salaryIDs = 0;
    int EmployeeID;
    int DayWork;
    int Overtimes;
    int SmallProject;
    int NormalProject;
    int BigProject;
    int PaidSalary;
    public salary(int ID, int dayWork, int overtimes, int smallProject, int normalProject, int bigProject, int paidSalary) {
        salaryIDs++;
        EmployeeID = ID;
        DayWork = dayWork;
        Overtimes = overtimes;
        SmallProject = smallProject;
        NormalProject = normalProject;
        BigProject = bigProject;
        PaidSalary = paidSalary;
    }
    public salary(){}

    public static int getSalaryIDs() {
        return salaryIDs;
    }

    public static void setSalaryIDs(int salaryIDs) {
        salary.salaryIDs = salaryIDs;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public int getDayWork() {
        return DayWork;
    }

    public void setDayWork(int dayWork) {
        DayWork = dayWork;
    }

    public int getOvertimes() {
        return Overtimes;
    }

    public void setOvertimes(int overtimes) {
        Overtimes = overtimes;
    }

    public int getSmallProject() {
        return SmallProject;
    }

    public void setSmallProject(int smallProject) {
        SmallProject = smallProject;
    }

    public int getNormalProject() {
        return NormalProject;
    }

    public void setNormalProject(int normalProject) {
        NormalProject = normalProject;
    }

    public int getBigProject() {
        return BigProject;
    }

    public void setBigProject(int bigProject) {
        BigProject = bigProject;
    }

    public int getPaidSalary() {
        return PaidSalary;
    }

    public void setPaidSalary(int paidSalary) {
        PaidSalary = paidSalary;
    }

}
