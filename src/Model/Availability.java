package Model;

public class Availability {
    private String availibility;

    public Availability(String availibility) {
        this.availibility = availibility;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "availibility='" + availibility + '\'' +
                '}';
    }

    public String getAvailibility() {
        return availibility;
    }

    public void setAvailibility(String availibility) {
        this.availibility = availibility;
    }
}
