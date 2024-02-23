import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Double> xs = new ArrayList<>();
    private List<Double> ws = new ArrayList<>();
    private List<Double> dws = new ArrayList<>();
    private double sigma = 0;

    public Node(int inputNumber) {
        for (int i = 0; i < inputNumber; i++) {
            double value = Randomm.randomDouble();
            this.ws.add(value);
        }
    }

    public double getSigma() {
        return sigma;
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    public List<Double> getXs() {
        return xs;
    }

    public void setXs(List<Double> xs) {
        this.xs = xs;
    }

    public List<Double> getWs() {
        return ws;
    }

    public List<Double> getDws() {
        return dws;
    }

    public double sum() {
        double sum = 0;
        for (int i = 0; i < this.xs.size(); i++) {
            sum += this.xs.get(i) * this.ws.get(i);
        }
        return sum;
    }
}