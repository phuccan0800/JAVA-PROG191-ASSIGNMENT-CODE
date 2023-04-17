package Data;

import org.hamcrest.Description;

public class Project {
    public static int numberOfProject = 0;
    int ID;
    String Name;
    int EmployeeID;
    int kindOfProject;
    int toEmployeeID;
    String Description;
    String DateStart;
    String DateEnd;
    int Status;
    int done;
    public Project(){}

    public Project(int ID, String name, int employeeID, int kindOfProject,int toEmployeeID, String description, String dateStart, String dateEnd, int status, int done) {
        numberOfProject++;
        this.ID = ID;
        Name = name;
        EmployeeID = employeeID;
        this.kindOfProject = kindOfProject;
        this.toEmployeeID = toEmployeeID;
        Description = description;
        DateStart = dateStart;
        DateEnd = dateEnd;
        Status = status;
        this.done = done;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static int getNumberOfProject() {
        return numberOfProject;
    }

    public static void setNumberOfProject(int numberOfProject) {
        Project.numberOfProject = numberOfProject;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public int getKindOfProject() {
        return kindOfProject;
    }

    public void setKindOfProject(int kindOfProject) {
        this.kindOfProject = kindOfProject;
    }

    public String getDateStart() {
        return DateStart;
    }

    public void setDateStart(String dateStart) {
        DateStart = dateStart;
    }

    public String getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(String dateEnd) {
        DateEnd = dateEnd;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getToEmployeeID() {
        return toEmployeeID;
    }

    public void setToEmployeeID(int toEmployeeID) {
        this.toEmployeeID = toEmployeeID;
    }
}
