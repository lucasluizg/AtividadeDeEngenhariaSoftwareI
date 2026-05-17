package entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String clienteNome;
    private String clienteEmail;
    private String clienteEndereco;

    public Cliente(String nome, String email, String endereco) {
        clienteNome = nome;
        clienteEmail = email;
        clienteEndereco = endereco;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public String getClienteEndereco() {
        return clienteEndereco;
    }

}
