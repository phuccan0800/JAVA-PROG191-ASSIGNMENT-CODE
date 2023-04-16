package Controller;

import Data.Project;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ProjectController implements SimpleController{
    public Project[] AddProjectData() {
        Project.numberOfProject = 0;
        Project[] projects = new Project[1000];
        int i = 0;
        File file = new File("Project.txt");
        Scanner scnr = null;
        try {
            scnr = new Scanner(file);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File Không tồn tại!!");
        }
        while (scnr.hasNextLine()) {
            try {
                String data = scnr.nextLine();
                String[] dataget = data.split("\\|");;
                try {
                    projects[i] = new Project(Integer.parseInt(dataget[0]),
                            dataget[1],
                            Integer.parseInt(dataget[2]),
                            Integer.parseInt(dataget[3]),
                            dataget[4],
                            dataget[5],
                            dataget[6],
                            Integer.parseInt(dataget[7]),
                            Integer.parseInt(dataget[8]));
                    i++;
                } catch (NullPointerException e) {
                    System.out.println("Lỗi lấy dữ liệu");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "LỖI NHẬP DỮ LIỆU PROJECTs !! CÓ VẺ NHƯ DỮ LIỆU CỦA BẠN BỊ LỖI, HÃY KIỂM TRA");
            }
        }
        System.out.println("Đọc dữ liệu thành công !");
        return projects;
    }
    @Override
    public void EditInformation() {

    }

    @Override
    public void AddInformation(String Information) throws IOException {

    }

    @Override
    public void DeleteInformation(int line) {

    }
}
