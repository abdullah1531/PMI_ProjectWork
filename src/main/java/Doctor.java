public class Doctor extends Person{
    private String department;
    private int doctorId;

    public Doctor(String name, int age, String department, int doctorId) {
        super(name, age);
        this.department = department;
        this.doctorId = doctorId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
         return String.format("Doctor{ID : %d, %s, Department : %s}",getDoctorId(), super.toString(), getDepartment());

    }
}
