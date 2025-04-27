package Model;

public class Expertise {
    private String expertise;

    public Expertise(String expertise) {
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @Override
    public String toString() {
        return "Expertise{" +
                "expertise='" + expertise + '\'' +
                '}';
    }
}
