package ex2;

import org.w3c.dom.ls.LSOutput;

import java.util.Objects;

public class ArvoreBinaria {

    private static No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public static void inserir(Contato contato) {
        raiz = inserirRecursivo(raiz, contato);
    }

    private static No inserirRecursivo(No no, Contato contato) {
        if (Objects.isNull(no)) {
            return new No(contato);
        }

        if (contato.getNumero().compareTo(no.getContato().getNumero()) < 0) {
            no.setEsquerda(inserirRecursivo(no.getEsquerda(), contato));
        }

        if (contato.getNumero().compareTo(no.getContato().getNumero()) > 0) {
            no.setDireita(inserirRecursivo(no.getDireita(), contato));
        }

        return no;
    }

    public static void emOrdem() {
        emOrdemRecursivo(raiz);
    }

    private static void emOrdemRecursivo(No no) {
        if (Objects.nonNull(no)) {
            emOrdemRecursivo(no.getEsquerda());
            System.out.println("Nome: " + no.getContato().getNome() + " Telefone: " + no.getContato().getNumero());
            emOrdemRecursivo(no.getDireita());
        }
    }

    public static void remover(String nome) {
        if (Objects.isNull(raiz)) {
            return;
        }

        raiz = removerRecursivo(raiz, nome);
    }

    private static No removerRecursivo(No no, String numero) {
        if (Objects.isNull(no)) {
            return null;
        }

        if (numero.compareTo(no.getContato().getNumero()) < 0) {
            no.setEsquerda(removerRecursivo(no.getEsquerda(), numero));
        }

        if (numero.compareTo(no.getContato().getNumero()) > 0) {
            no.setDireita(removerRecursivo(no.getDireita(), numero));
        } else {
            if (Objects.isNull(no.getEsquerda()) && Objects.isNull(no.getDireita())) {
                return null;
            }
            if (Objects.isNull(no.getEsquerda())) {
                return no.getDireita();
            }
            if (Objects.isNull(no.getDireita())) {
                return no.getEsquerda();
            }
            No sucessor = encontrarMenorNo(no.getDireita());
            no.setContato(sucessor.getContato());
            no.setDireita(removerRecursivo(no.getDireita(), sucessor.getContato().getNumero()));
        }
        return no;
    }

    private static No encontrarMenorNo(No no) {
        No atual = no;
        while (Objects.isNull(atual.getEsquerda())) {
            atual = atual.getEsquerda();
        }

        return atual;
    }

    public static void buscarPorNumero(String numero) {
        System.out.println(buscarPorNumeroRecursivo(raiz,numero));
    }

    private static Contato buscarPorNumeroRecursivo(No no, String numero) {
        if (Objects.isNull(no)) {
            return null;
        }

        if (no.getContato().getNumero().equals(numero)) {
            return no.getContato();
        } else if (numero.compareTo(no.getContato().getNumero()) < 0) {
            return buscarPorNumeroRecursivo(no.getEsquerda(), numero);
        } else {
            return buscarPorNumeroRecursivo(no.getDireita(), numero);
        }
    }
}