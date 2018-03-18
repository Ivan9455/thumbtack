package net.thumbtack.lessons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import com.google.gson.Gson;

/* добавить в pom.xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.2</version>
</dependency>
*/

class Person  {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class SerializeToJsonDemo {

    public static void main(String[] args) {

        Person person = new Person("Вася Пупкин", 20);
        Gson gson = new Gson();
        String gsonText = gson.toJson(person);
        System.out.println(gsonText);

        Person person1 = gson.fromJson(gsonText, Person.class);
        System.out.println(person1.toString());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("1.txt")))) {
            gson.toJson(person, bw);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(new File("1.txt")))) {
            person1 = gson.fromJson(br,Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(person1.toString());
    }
}
