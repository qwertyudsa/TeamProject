package allclasses.Bao;

public class Person {


    public String name;
    String surname;
    int age;


    public Person()
    {
        name = "Иван";
        surname = "Иванов";
        age = 20;
    }

    public Person(String name, String surname, int age)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public String GetInitials()
    {
        return name + " " + surname;
    }

    public int GetAge()
    {
        return age;
    }

    public String GetGreatings()
    {
        return "Привет, я " + name;
    }
}
