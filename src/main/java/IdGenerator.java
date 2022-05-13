public class IdGenerator {
    private int patientLastId = 0;
    private int doctorLastId = 0;
    public int getPatientNextId() {
        return ++patientLastId;
    }
    public int getDoctorNextId() {
        return ++doctorLastId;
    }
}