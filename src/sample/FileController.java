package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileController {

    private static String filePath;

    public FileController() {
        filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("/src/sample/score.txt");
    }

    public void write(String name, String score) {
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(filePath, true);
            bw = new BufferedWriter(fw);

            bw.write(name + " " + score);
            System.out.println(name + " " + score);
            bw.newLine();

            System.out.println("writing into file");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
            System.out.println("subor nenajdeny");
        } finally {

            try {
                if (bw != null)
                    bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<Player> read() {

        ArrayList<Player> highScore = new ArrayList<>();
        BufferedReader objReader = null;
        try {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader(filePath));

            while ((strCurrentLine = objReader.readLine()) != null) {

                String[] splited = strCurrentLine.split(" ");
                highScore.add(new Player(splited[0], Long.parseLong(splited[1])));
            }
            return highScore;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

}


