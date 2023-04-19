package Controller;
import Data.Project;
import javax.swing.*;
import java.io.*;
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
                            Integer.parseInt(dataget[4]),
                            dataget[5],
                            dataget[6],
                            dataget[7],
                            Integer.parseInt(dataget[8]),
                            Integer.parseInt(dataget[9]));
                    i++;
                } catch (NullPointerException e) {
                    System.out.println("Lỗi lấy dữ liệu");
                }catch (NumberFormatException e){
                    throw new RuntimeException(e);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "LỖI NHẬP DỮ LIỆU PROJECTs !! CÓ VẺ NHƯ DỮ LIỆU CỦA BẠN BỊ LỖI, HÃY KIỂM TRA");
            }
        }
        System.out.println("Đọc dữ liệu Proejct thành công !");
        return projects;
    }
    @Override
    public void EditInformation() {

    }

    @Override
    public void AddInformation(String Information) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("project.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("\n"+Information);
        printWriter.close();
        fileWriter.close();
    }

    @Override
    public void DeleteInformation(int line) {

    }
    public Project[] upload(int toEmployeeID, int status, int done, int row, Project[] projects) throws IOException {
        File file = new File("project.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line;
        int lineCount = 1;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            if (lineCount == row) {
                String[] dataget = line.split("\\|");
                dataget[4] = String.valueOf(toEmployeeID);
                dataget[8] = String.valueOf(status);
                dataget[9] = String.valueOf(done);
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
        return projects;
    }
}
