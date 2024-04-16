package ex3;

public class ArvoreBinariaBusca {

    No raiz;

    public ArvoreBinariaBusca() {
        raiz = null;
    }

    public void inserir(String palavraChave) {
        raiz = inserirRec(raiz, palavraChave);
    }

    private No inserirRec(No raiz, String palavraChave) {
        if (raiz == null) {
            raiz = new No(palavraChave);
            return raiz;
        }

        int cmp = palavraChave.compareToIgnoreCase(raiz.palavraChave);
        if (cmp < 0) {
            raiz.esquerda = inserirRec(raiz.esquerda, palavraChave);
        } else if (cmp > 0) {
            raiz.direita = inserirRec(raiz.direita, palavraChave);
        }

        return raiz;
    }

    public boolean buscar(String palavraChave) {
        return buscarRec(raiz, palavraChave);
    }

    private boolean buscarRec(No raiz, String palavraChave) {
        if (raiz == null) {
            return false;
        }

        int cmp = palavraChave.compareToIgnoreCase(raiz.palavraChave);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return buscarRec(raiz.esquerda, palavraChave);
        } else {
            return buscarRec(raiz.direita, palavraChave);
        }
    }

}
