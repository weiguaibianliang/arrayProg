package JAVA8;

public class Trader1 {
    private final String name;
    private final String city;


    public Trader1(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader1{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
