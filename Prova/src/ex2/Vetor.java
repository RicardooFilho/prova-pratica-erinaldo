package ex2;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Vetor {

    private static List<Contato> contatos = new ArrayList<>();

    public static void adicionarContato(Contato contato)    {
        if (contatos.stream().anyMatch(contatos -> contatos.getNumero().equals(contato.getNumero()))) {
            System.out.println("Contato já adicionado no vetor");
            return;
        }

        contatos.add(contato);
        System.out.println("Contato adicionado no vetor!");
    }

    public static void removerContato(String numero) {
        if (contatos.stream().noneMatch(contatos -> contatos.getNumero().equals(numero))) {
            System.out.println("Contato não encontrado no vetor");
            return;
        }

        contatos.removeIf(contatos -> contatos.getNumero().equals(numero));
        System.out.println("Contato removido do vetor!");
    }

    public static void buscarContato(String numero) {
        if (contatos.stream().noneMatch(contatos -> contatos.getNumero().equals(numero))) {
            System.out.println("Contato não encontrado no vetor");
            return;
        };

        contatos.forEach(contatos -> {
            if (contatos.getNumero().equals(numero)) {
                System.out.println(contatos);
            }
        });
    }

    public static List<Contato> getContatos() {
        return contatos;
    }
}
