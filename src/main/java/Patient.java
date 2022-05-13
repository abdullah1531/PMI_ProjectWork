public class Patient extends Person{
    private int id;
    private String diseaseName;

    public Patient(String name, int age, String diseaseName ,int id) {
        super(name, age);
        this.diseaseName = diseaseName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Override
    public String toString() {
        return String.format("Patient{ID : %d, %s, Disease Name : %s}", getId(), super.toString(), getDiseaseName());
    }
}
