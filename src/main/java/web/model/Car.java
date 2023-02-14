package web.model;

public class Car {
    private static int nextId = 1;
    private int id;
    private String model;
    private String series;

    public Car () { }
    public Car(int id, String model, String series) {
        this.id = nextId++;
        this.model = model;
        this.series = series;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }


    @Override
    public String toString() {
        return id + ". Car: " + model + ", " + series;
    }
}
