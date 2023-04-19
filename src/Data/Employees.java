package Data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employees{
    public static int numberOfEmployees = 0;
    int ID;
    int positionID ;
    String name;
    String sex;
    Date birthday;
    String hometown;
    String IDCard;
    String phone;
    String email;
    Date TimeStart;
    String avatar;
    String password;
    int status;
    public Employees(){}

    public Employees(int ID, int positionID, String name,String sex, Date birthday, String hometown,String IDCard , String phone, String email, Date timeStart, String password, int status) {
        numberOfEmployees++;
        this.ID = ID;
        this.sex = sex;
        this.positionID = positionID;
        this.name = name;
        this.birthday = birthday;
        this.IDCard = IDCard;
        this.hometown = hometown;
        this.phone = phone;
        this.email = email;
        TimeStart = timeStart;
        this.avatar = "img/"+Integer.toString(ID)+".png";
        this.password = password;
        this.status = status;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.valueOf(outputDateFormat.format(birthday));
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getTimeStart() {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return outputDateFormat.format(TimeStart);
    }

    public void setTimeStart(Date timeStart) {
        TimeStart = timeStart;
    }

    public int getID() {
        return ID;
    }

    public String getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }}
