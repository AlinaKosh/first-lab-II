import java.util.ArrayList;
import java.util.List;

public class Network {
    List<List<Node>> network;
    ActiveFunc activeFunc;
    ActiveFunc df;
    double nu;

    public Network(int input, int output, int[] arr, ActiveFunc activeFunc, ActiveFunc df, double nu) {
        this.network = new ArrayList<>(); //сеть
        this.activeFunc = activeFunc; //активационная функция
        this.df = df; //производная
        this.nu = nu; //спец коэффициент 0-1

        int prev = input;
        //инициализация сети
        for (int elem : arr) {
            List<Node> n = new ArrayList<>();

            for (int i = 0; i < elem; i++) {
                n.add(new Node(prev));
            }

            network.add(n);
            prev = elem;
        }

        List<Node> node = new ArrayList<>();

        for (int i = 0; i < output; i++) {
            node.add(new Node(prev));
        }

        network.add(node);
    }

    //обработка
    public double[] go(double[] inputs) {
        double[] oldInputs = inputs;

        for (List<Node> layer : network) {
            double[] newInputs = new double[layer.size()];

            for (int j = 0; j < layer.size(); j++) {
                List<Double> inputList = new ArrayList<>();
                for (double input : oldInputs) {
                    inputList.add(input);
                }
                layer.get(j).setXs(inputList);

                newInputs[j] = this.activeFunc.invoke(layer.get(j).sum());
            }

            oldInputs = newInputs;
        }

        return oldInputs;
    }

    public double mistake(double[] outputs, double[] expects) {
        double res = 0;
        for (int i = 0; i < expects.length; i++) {
            res += (outputs[i] - expects[i]) * (outputs[i] - expects[i]);
        }
        return res / 2;
    }

    public void correct(double[] realOutputs, double[] expectedOutputs) {
        int i = network.size() - 1;

        for (int j = 0; j < network.get(i).size(); j++) {
            network.get(i).get(j).setSigma((realOutputs[j] - expectedOutputs[j]) * df.invoke(network.get(i).get(j).sum()));

            for (int k = 0; k < network.get(i).get(j).getXs().size(); k++) {
                network.get(i).get(j).getDws().add(-this.nu * network.get(i).get(j).getSigma() * network.get(i).get(j).getXs().get(k));
            }
        }

        i--;
        for (; i >= 0; i--) {
            for (int j = 0; j < network.get(i).size(); j++) {
                double sigmaSum = 0;

                for (int k = 0; k < network.get(i + 1).size(); k++) {
                    sigmaSum += network.get(i + 1).get(k).getWs().get(j) * network.get(i + 1).get(k).getSigma();
                }

                network.get(i).get(j).setSigma(sigmaSum * df.invoke(network.get(i).get(j).sum()));

                for (int k = 0; k < network.get(i).get(j).getXs().size(); k++) {
                    network.get(i).get(j).getDws().add(-this.nu * network.get(i).get(j).getSigma() * network.get(i).get(j).getXs().get(k));
                }
            }
        }

        for (List<Node> layer : network) {
            for (Node node : layer) {
                for (int p = 0; p < node.getWs().size(); p++) {
                    node.getWs().set(p, node.getWs().get(p) + node.getDws().get(p));
                }

                node.getDws().clear();
            }
        }
    }
}