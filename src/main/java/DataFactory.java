public class DataFactory {
    private static IdGenerator idGenerator = new IdGenerator();

    public static Patient createPatient(String name, int age, String diseaseName) {
        return new Patient(name, age, diseaseName, idGenerator.getPatientNextId());
    }

    public static Doctor createDoctor(String name, int age, String department) {
        return new Doctor(name, age, department, idGenerator.getDoctorNextId());
    }
}
