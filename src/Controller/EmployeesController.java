package Controller;

import Data.Employees;

import javax.swing.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.nio.file.Files;

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
                Date birthday = null;
                Date timeStart = null;
                try {
                    birthday = dateFormat.parse(dateBirthday);
                    timeStart = dateFormat.parse(dateTimeStart);
                } catch (ParseException e) {
                    System.out.println("Lỗi ở đây");
                } catch (NullPointerException e) {
                    System.out.println("Vui lòng kiểm tra lại tệp");
                }
                try {
                    employees[i] = new Employees(Integer.parseInt(dataget[0]),Integer.parseInt(dataget[1]), dataget[2], dataget[3], birthday, dataget[5], dataget[6], dataget[7], dataget[8], timeStart, dataget[10]);
                    i++;
                } catch (NullPointerException e) {
                    System.out.println("Lỗi lấy dữ liệu");
                }
            }catch (ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null, "LỖI NHẬP DỮ LIỆU EMPLOYEES !! CÓ VẺ NHƯ DỮ LIỆU CỦA BẠN BỊ LỖI, HÃY KIỂM TRA");
            }
        }
        System.out.println("Đọc dữ liệu thành công !");
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

    @Override
    public void DeleteInformation(int numberOfline) {
        File file = new File("Employee.txt");
        try {
            // Tạo một đối tượng BufferedReader để đọc dữ liệu từ tệp
            BufferedReader reader = new BufferedReader(new FileReader(file));

            // Tạo một đối tượng BufferedWriter để ghi dữ liệu vào tệp
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));

            // Đếm số dòng đã đọc được
            int lineNumber = 0;

            // Đọc từng dòng của tệp
            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                System.out.println(line);
                // Nếu dòng hiện tại không phải là dòng cần xóa, ghi dòng đó vào tệp
                if (lineNumber != numberOfline) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            // Đóng đối tượng BufferedReader và BufferedWriter
            reader.close();
            writer.close();

            System.out.println("Đã xóa dòng " + numberOfline + " và ghi lại dữ liệu vào tệp Employee.txt.");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
