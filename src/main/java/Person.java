public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
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

    public void setAge(int phone) {
        this.age = phone;
    }

    @Override
    public String toString() {
       return String.format("Name : %s, Age : %d", name, age);
    }

    @Override
    public int compareTo(Person o) {
        return getName().compareTo(o.getName());
    }
}
