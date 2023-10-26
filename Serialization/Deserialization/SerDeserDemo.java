package Serialization.Deserialization;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerDeserDemo {
    public static void main(String[] args)
    {
        //Serialization
        Student student = new Student("John", 25, "23 East, California");
        student.setX(10);
        String filename = "Test.txt";
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;
        try{
            fileOut = new FileOutputStream(filename);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(student);
            objOut.close();
            fileOut.close();
            System.out.println("Object has been serialized: \n" + student);

        }catch (IOException ex){
            System.out.println("IOException");

        }

        //Deserialization
        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;
        try {
            fileIn = new FileInputStream(filename);
            objIn = new ObjectInputStream(fileIn);
            Student object = (Student) objIn.readObject();
            System.out.println("Object has been deserialized: \n" + object);
            System.out.println("The deserialized value of x: " + object.getX());

        } catch (IOException ex)
        {
            System.out.println("IO Exception");
        } catch (ClassNotFoundException ex)
        {
            System.out.println("ClassNotFound Exception");

        }

    }
}
