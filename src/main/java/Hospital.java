import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hospital implements Serializable {
    static ArrayList<Person> persons;


    public Hospital() {
        this.persons = new ArrayList<>();
    }

    public void removePerson(String name) {
        for(int i = 0; i < persons.size(); i++) {
            if(persons.get(i).getName().replaceAll(" ", "").equalsIgnoreCase(name.replaceAll(" ", ""))){
                System.out.println(persons.get(i).getName() + " has been removed!");
                persons.remove(i);
            }
        }

    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person getPerson(int index) {
        return persons.get(index);
    }

    public int getAllPersonsSize(){
        return persons.size();
    }

    public void printPatient(){
        for(Person p: persons){
            if(p instanceof Patient){
                System.out.println(p);
            }
        }
    }

    public void printDoctor(){
        for(Person p: persons) {
            if (p instanceof Doctor) {
                System.out.println(p);
            }
        }
    }

    public void sort(){
        Collections.sort(persons);
    }

    public void updatePerson(String name){
        Scanner scanner = new Scanner(System.in);
        for (Person p : persons) {
            if (p instanceof Patient &&
                    ((Patient)p).getName().replaceAll(" ", "").equalsIgnoreCase(name.replaceAll(" ", ""))) {
                    System.out.println("What would you like to update: ");
                    System.out.println("1. Name");
                    System.out.println("2. Age");
                    System.out.println("3. Disease Name");
                    int i = Integer.parseInt(scanner.nextLine());
                    if(i == 1){
                        System.out.println("Enter new Name: ");
                        String newName = scanner.nextLine();
                        ((Patient) p).setName(newName);
                        System.out.println("Patient's Name has been updated!");
                    }
                    else if(i == 2){
                        System.out.println("Enter new Age: ");
                        int newAge = Integer.parseInt(scanner.nextLine());
                        ((Patient) p).setAge(newAge);
                        System.out.println("Patient's Age has been updated!");
                    }
                    else if(i == 3){
                        System.out.println("Enter new Disease Name: ");
                        String newDiseaseName = scanner.nextLine();
                        ((Patient) p).setDiseaseName(newDiseaseName);
                        System.out.println("Patient's Disease Name has been updated!");
                    }
                    else if(i >= 4){
                        System.out.println("Please enter number between (1-3)!");
                    }
            }
            else if (p instanceof Doctor &&
                    ((Doctor)p).getName().replaceAll(" ", "").equalsIgnoreCase(name.replaceAll(" ", ""))) {
                System.out.println("What would you like to update: ");
                System.out.println("1. Name");
                System.out.println("2. Age");
                System.out.println("3. Department");
                int i = Integer.parseInt(scanner.nextLine());
                if(i == 1){
                    System.out.println("Enter new Name: ");
                    String newName = scanner.nextLine();
                    ((Doctor)p).setName(newName);
                    System.out.println("Doctor's Name has been updated!");
                }
                else if(i == 2){
                    System.out.println("Enter new Age: ");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    ((Doctor)p).setAge(newAge);
                    System.out.println("Doctor's Age has been updated!");
                }
                else if(i == 3){
                    System.out.println("Enter new Department: ");
                    String newDepartment = scanner.nextLine();
                    ((Doctor) p).setDepartment(newDepartment);
                    System.out.println("Doctor's Department has been updated!");
                }
                else if(i >= 4){
                    System.out.println("Please enter number between (1-3)!");
                }
            }

        }
        System.out.println("This person doesn't exist!");
    }

}
