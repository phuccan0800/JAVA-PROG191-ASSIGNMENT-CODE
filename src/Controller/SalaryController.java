package Controller;

import Data.Employees;
import Data.salary;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class SalaryController implements SimpleController {
    public salary[] AddsalaryData(){
        salary.salaryIDs = 0;
        salary[] salaries = new salary[1000];
        Employees employees[] = new Employees[1000];
        int i = 0;
        File file = new File("salary.txt");
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
                salaries[i] = new salary(Integer.parseInt(dataget[0]), Integer.parseInt(dataget[1]), Integer.parseInt(dataget[2]), Integer.parseInt(dataget[3]), Integer.parseInt(dataget[4]), Integer.parseInt(dataget[5]),Integer.parseInt(dataget[6]));
                i++;
            }catch (ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null, "LỖI NHẬP DỮ LIỆU SALARY !! CÓ VẺ NHƯ DỮ LIỆU CỦA BẠN BỊ LỖI, HÃY KIỂM TRA");
            }
        }
        return salaries;
    }

    public int CaculatorRemainSalary(int staticSalary,int PaidSalary,int DayWork, int Overtimes, int SmallProject, int NormalProject, int BigProject) {
        int RemainSalary = 0;
        int totalSalary = CaculatorTotalSalary(staticSalary, DayWork, Overtimes, SmallProject, NormalProject, BigProject);
        RemainSalary = totalSalary - PaidSalary;
        return RemainSalary;
    }
    public int CaculatorTotalSalary(int staticSalary, int DayWork, int Overtimes, int SmallProject, int NormalProject, int BigProject){
        int TotalSalary = 0;
        TotalSalary = staticSalary/24 *DayWork + Overtimes*500000 + SmallProject*500000 + NormalProject*1500000+ BigProject*5000000;
        return TotalSalary;
    }

    @Override
    public void EditInformation() {

    }

    @Override
    public void AddInformation(String Information) throws IOException {
        FileWriter fileWriter = new FileWriter("salary.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("\n"+Information);
        printWriter.close();
        fileWriter.close();
    }

    @Override
    public void DeleteInformation(int numberOfline) {
        String fileName = "salary.txt";
        File inputFile = new File(fileName);
        File tempFile = new File("temp2.txt");

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
                }else i++;
            }
            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi xóa dòng khỏi tệp " + fileName);
        }
    }
}
