package Controller;

import Data.position;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PositionController {
    public position[] AddPositionData() throws FileNotFoundException {
        position[] positions = new position[1000];
        position.numberOfPositionID = 0;
        int i = 0;
            File file = new File("position.txt");
            Scanner scnr2 = null;

            scnr2 = new Scanner(file);

            while (scnr2.hasNextLine()) {
                String data = scnr2.nextLine();
                String[] dataget = data.split("\\|");
                try {
                    positions[i] = new position(dataget[0], Integer.parseInt(dataget[1]));
                    i++;
                } catch (NullPointerException e) {
                    System.out.println("Lỗi lấy dữ liệu");
                }
            }
            return positions;
    }
}
