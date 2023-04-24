package Controller;

import Data.Employees;
import Data.salary;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class EmployeesController implements SimpleController {
    public Employees[] AddEmployeesData(){
        Employees.numberOfEmployees = 0;
        Employees[] employees = new Employees[1000];
        int i = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        File file = new File("Employee.txt");
        Scanner scnr = null;
        try {
            scnr = new Scanner(file);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"File Không tồn tại!!");
        }
        while (scnr.hasNextLine()){
            try {
                String data = scnr.nextLine();
                String[] dataget = data.split("\\|");
                    String dateBirthday = dataget[4];
                    String dateTimeStart = dataget[9];
                    String datelastAttendanceDate = dataget[12];
                    Date birthday = null;
                    Date timeStart = null;
                    Date lastAttendanceDate = null;
                    try {
                        birthday = dateFormat.parse(dateBirthday);
                        timeStart = dateFormat.parse(dateTimeStart);
                        lastAttendanceDate = dateFormat.parse(datelastAttendanceDate);
                    } catch (ParseException e) {
                        System.out.println("Lỗi khi chuyển đổi định dạng dữ liệu");
                    } catch (NullPointerException e) {
                        System.out.println("Vui lòng kiểm tra lại tệp");
                    }
                    try {
                        employees[i] = new Employees(Integer.parseInt(dataget[0]),
                                Integer.parseInt(dataget[1]),
                                dataget[2], dataget[3], birthday, dataget[5],
                                dataget[6], dataget[7], dataget[8], timeStart,
                                dataget[10], Integer.parseInt(dataget[11]), lastAttendanceDate);
                        i++;
                    } catch (NullPointerException e) {
                        System.out.println("Lỗi lấy dữ liệu");
                    }
            }catch (ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null, "LỖI NHẬP DỮ LIỆU EMPLOYEES !! CÓ VẺ NHƯ DỮ LIỆU CỦA BẠN BỊ LỖI, HÃY KIỂM TRA");
            }
        }
        return employees;
    }
    public void EditInformation(){

    }

    @Override

    public void AddInformation(String Information) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("Employee.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(Information+"\n");
        printWriter.close();
        fileWriter.close();
    }
    public Employees[] Delete(int row, Employees[] employees) throws IOException {
        File file = new File("Employee.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line;
        int lineCount = 1;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            if (lineCount - 1 == row) {
                String[] dataget = line.split("\\|");
                dataget[11] = "0";
                line = String.join("|", dataget);
            }
            stringBuilder.append(line + "\n");
            lineCount++;
        }
        reader.close();

        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
        JOptionPane.showMessageDialog(null, "Thay đổi dữ liệu thành công");
        return employees;
    }
    public Employees[] savelastAttendance(Employees[] employees,int row) throws IOException {
        File file = new File("Employee.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line;
        int lineCount = 1;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            if (lineCount - 1 == row) {
                System.out.println(employees[row].getLastAttendanceDate());
                String[] dataget = line.split("\\|");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String dateString = sdf.format(employees[row].getLastAttendanceDate());
                dataget[12] = dateString;
                line = String.join("|", dataget);
            }
            stringBuilder.append(line + "\n");
            lineCount++;
        }
        reader.close();

        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
        return employees;
    }
    @Override
    public void DeleteInformation(int numberOfline) {
    }
    public Employees[] EditPassword(String newPassword, int row, Employees[] employees) throws IOException {
        File file = new File("Employee.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line;
        int lineCount = 1;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            if (lineCount-1 == row) {
                String[] dataget = line.split("\\|");
                dataget[10] = newPassword;
                line = String.join("|",dataget);
            }
            stringBuilder.append(line+"\n");
            lineCount++;
        }
        reader.close();

        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
        JOptionPane.showMessageDialog(null, "Thay đổi dữ liệu thành công");
        return employees;
    }
}
