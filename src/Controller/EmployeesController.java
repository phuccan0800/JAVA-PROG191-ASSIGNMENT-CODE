package Controller;

import Data.Employees;

import javax.swing.*;
import java.io.*;
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
        File file = new File("Employees.txt");
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
            fileWriter = new FileWriter("Employees.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("\n"+Information);
        printWriter.close();
        fileWriter.close();
    }

    @Override
    public void DeleteInformation(int numberOfline) {
        System.out.println(numberOfline);
        String fileName = "Employees.txt";
        File inputFile = new File(fileName);
        File tempFile = new File("temp.txt");

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            int i = 1;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (i!=numberOfline && i==1) {
                    bufferedWriter.write(line);
                    i++;
                }
                else if (i!=numberOfline){
                    bufferedWriter.write("\n");
                    bufferedWriter.write(line);
                    i++;
                } else i++;
            }
            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi khi xóa dòng khỏi tệp " + fileName);
        }
    }
}
