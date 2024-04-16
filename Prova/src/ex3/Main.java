package ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaBusca abb = new ArvoreBinariaBusca();


        try (BufferedReader br = new BufferedReader(new FileReader("palavras_chave.txt"))) {
            String palavra;
            while ((palavra = br.readLine()) != null) {
                abb.inserir(palavra.trim());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma palavra para buscar no dicionário: ");
        String palavraBusca = scanner.nextLine().trim();

        if (abb.buscar(palavraBusca)) {
            System.out.println("A palavra '" + palavraBusca + "' está presente no dicionário.");
        } else {
            System.out.println("A palavra '" + palavraBusca + "' não está presente no dicionário.");
        }
        scanner.close();
    }
}
