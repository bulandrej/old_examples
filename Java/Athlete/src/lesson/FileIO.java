package lesson;

import java.io.*;
import java.util.ArrayList;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class FileIO {

     public static ArrayList<Athlete> ReadCSV() {
    //public static void ReadCSV(String filePath) {
            ArrayList<Athlete> athlets = new ArrayList<Athlete>();
        try {
            //File file = new File(filePath);
            File file = new File("./src/lesson/data.csv");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            athlets.add(ParseToObj(line));

            while (line!= null) {
                line = reader.readLine();
                if(line!= null) athlets.add(ParseToObj(line));
            }
            return athlets;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //public static void appendCSV(String filePath, String text) {
    public static void appendCSV(String text) {

            //File file = new File(filePath);
            File file = new File("./src/lesson/data.csv");
            FileWriter fr = null;
            try {
                fr = new FileWriter(file,true);
                fr.write("\n"+text);

            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public static Gymnast ParseToObj(String in){
            String[] fields = in.split("[,]");
            Gymnast g = new Gymnast(fields[0],parseInt(fields[1]),fields[2]);
            g.setScoreForRings((float)parseDouble(fields[3]));
            g.setScoreForBars((float)parseDouble(fields[4]));
            g.setScoreForVault((float)parseDouble(fields[5]));
            return g;
        }

}


