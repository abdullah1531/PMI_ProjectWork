import java.util.Scanner;

public class Controller {
    Scanner scanner;
    private static Hospital hospital;

    public Controller() {
        this.scanner = new Scanner(System.in);
        hospital = new Hospital();

        hospital.addPerson(DataFactory.createDoctor("Abdullah Malik", 23, "Cardiologist"));
        hospital.addPerson(DataFactory.createDoctor("Sophia", 21, "Surgeon"));
        hospital.addPerson(DataFactory.createDoctor("Ali", 22, "Gynacologist"));
        hospital.addPerson(DataFactory.createDoctor("Mark", 28, "Genral Doctor"));
        hospital.addPerson(DataFactory.createPatient("Jane", 23, "Fever"));
        hospital.addPerson(DataFactory.createPatient("Alex", 21, "Flu"));
        hospital.addPerson(DataFactory.createPatient("John", 22, "Cough"));
        hospital.addPerson(DataFactory.createPatient("Jack", 28, "Headache"));

    }

    public void main() {



        do {
            System.out.println("1 - List Persons");
            System.out.println("2 - Add Person");
            System.out.println("3 - Remove Person");
            System.out.println("4 - Update Person");
            System.out.println("5 - Sorted Person Storage by name");
            System.out.println("0 - Exit");
            System.out.println();
        } while (choice());

    }

    private boolean choice() {
        Scanner scanner = new Scanner(System.in);
        int option = getInt(0, 5);

        switch (option) {
            case 1:
                try {
                    System.out.println("What would you like to print: ");
                    System.out.println("1. Print Doctors");
                    System.out.println("2. Print Patients");
                    System.out.println("3. Print All Persons");
                    int a = Integer.parseInt(scanner.nextLine());
                    if(a == 1){
                        hospital.printDoctor();
                    }
                    else if(a == 2){
                        hospital.printPatient();
                    }
                    else if(a == 3){
                        listPeople(hospital);
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
                break;
            case 2:
                addPerson();
                break;
            case 3:
                try {
                    System.out.println("Enter the name of the person to remove: ");
                    String s = scanner.nextLine();
                    hospital.removePerson(s);
                }catch (Exception e){
                    System.out.println(e);
                }
                break;
            case 4:
                try {
                    System.out.println("Enter the name of the person you would like to update: ");
                    String u = scanner.nextLine();
                    hospital.updatePerson(u);
                }catch (Exception e){
                    System.out.println(e);
                }
                break;
            case 5:
                hospital.sort();
                listPeople(hospital);
                break;
        }

        if (option != 0) {
            System.out.println();
        }

        return option != 0;
    }

    private int getInt(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        boolean isCorrect;
        do {
            System.out.println(String.format("Enter a number (%d-%d)", min, max));
            isCorrect = true;
            try {
                i = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                isCorrect = false;
            }
        } while (!isCorrect || i < min || i > max);

        return i;
    }

    private static void addPerson(){
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        int choose;
        try {
            System.out.println("\nChoose what would you like to add: ");
            System.out.println("1. Patient");
            System.out.println("2. Doctor");
            choose = Integer.parseInt(scanner.nextLine());

            if (choose == 1) {
                String name;
                int age;
                String diseaseName;

                System.out.print("Patient Name: ");
                name = scanner.nextLine();

                System.out.print("Patient Age: ");
                age = Integer.parseInt(scanner.nextLine());

                System.out.print("Disease Name: ");
                diseaseName = scanner.nextLine();

                hospital.addPerson(DataFactory.createPatient(name, age, diseaseName));
                System.out.println("Patient has been successfully added!");
                System.out.println();
            }
            if (choose == 2) {
                String name;
                int age;
                String department;

                System.out.print("Doctor Name: ");
                name = scanner.nextLine();

                System.out.print("Doctor Age: ");
                age = Integer.parseInt(scanner.nextLine());

                System.out.print("Department: ");
                department = scanner.nextLine();

                hospital.addPerson(DataFactory.createDoctor(name, age, department));
                System.out.println("Doctor has been successfully added!");
                System.out.println();
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

    }

    private static void listPeople(Hospital hospital){
        for(int i=0; i< hospital.getAllPersonsSize(); i++){
            System.out.println(hospital.getPerson(i));
        }
    }

}
