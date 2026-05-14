package services;

import java.util.ArrayList;
import java.util.List;

public class CalculoPreco {

    public List<String> produtos = new ArrayList<>();
    public List<Double> precos = new ArrayList<>();
    public List<Integer> quantidades = new ArrayList<>();

    private double total;
    private double frete;
    private String status;

    public void calcularTotal() {
        total = 0;
        for (int i = 0; i < precos.size(); i++) {
            total += precos.get(i) * quantidades.get(i);
        }
    }

    public void calcularFrete() {
        if (clienteEndereco.contains("SC")) {
            frete = total * 0.05;
        } else {
            frete = total * 0.15;
        }
    }

    public void aplicarDesconto() {
        if (total > 500) {
            total *= 0.85;
        } else if (total > 200) {
            total *= 0.9;
        }
    }

    public void calcularPreco(double total, double frete) {

    }

}
