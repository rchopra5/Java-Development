package Serialization.Deserialization;
import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String address;
     int x;

    public Student(String name, int age, String address)
    {
        this.address = address;
        this.name = name;
        this.age = age;
    }

    public void setX(int x)
    {
        this.x = x;
    }
    public int getX()
    {
        return this.x;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return this.age;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getAddress()
    {
        return this.address;
    }
    public String toString(){
        return ("Student name is " + this.getName() + ", age is: " + this.getAge() + " and address is: " + this.getAddress());
    }

    
}
