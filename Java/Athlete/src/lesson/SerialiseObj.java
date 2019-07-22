package lesson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialiseObj {

  public static void serialiseToFile(ArrayList<Athlete> at){

  try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("./src/lesson/data.dat")))
    {
        os.writeObject(at);
    }
    catch(Exception ex){
        System.out.println(ex.getMessage());
    }
  }

    public static ArrayList<Athlete> deserialiseFile(){

        ArrayList<Athlete> at = new ArrayList<Athlete>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/lesson/data.dat")))
        {
            at=(ArrayList<Athlete>)ois.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return at;
    }
}
