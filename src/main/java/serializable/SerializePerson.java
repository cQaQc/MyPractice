package serializable;

import java.io.*;

public class SerializePerson {

    public static void sePerson() throws IOException {
        Person person = new Person();
        person.setName("柯柯");
        person.setAge(22);
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(new File("D:/person.text")));
        oos.writeObject(person);
        System.out.println(person+"序列化成功");
        oos.close();
    }


    public static void main(String[] args) {
        SePerson p = new SePerson();

        try {
            sePerson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            p.noPerson();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class SePerson{
    public static Person noPerson() throws IOException, ClassNotFoundException {
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(new File("D:/person.text")));
        Person person = (Person) ois.readObject();
        System.out.println(person+"反序列化成功");
        return person;
    }
}