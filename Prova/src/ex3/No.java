package ex3;

public class No {

    String palavraChave;
    No esquerda;
    No direita;

    public No(String palavraChave) {
        this.palavraChave = palavraChave;
        esquerda = null;
        direita = null;
    }
}
