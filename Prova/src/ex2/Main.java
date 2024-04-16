package ex2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*2. Considere que você precisa armazenar os contatos de uma lista telefônica, onde
        cada contato é composto por um nome (string) e um número de telefone (string). O
        programa deve ser capaz de adicionar novos contatos, remover contatos existentes
        e buscar por um contato específico.
        Para resolver esse problema, utilize três estruturas de dados diferentes:
        a. Vetor: armazena os contatos em uma lista não ordenada.
        b. Lista encadeada: armazena os contatos em uma lista ordenada por nome.
                c. Árvore binária de busca: armazena os contatos em uma estrutura de dados
        mais eficiente para busca.*/

        Scanner scan = new Scanner(System.in);

        Integer choice;

        do {
            System.out.println("""
                    0 - Sair
                    1 - Inserir contato no Vetor
                    2 - Inserir contato na Lista Encadeada
                    3 - Inserir contato na Árvore Binária
                    4 - Remover contato do Vetor
                    5 - Remover contato da Lista Encadeada
                    6 - Remover contato da Árvore Binária
                    7 - Buscar contato no Vetor
                    8 - Buscar contato na Lista Encadeada
                    9 - Buscar contato na Árvore Binária
                    10 - Imprimir Árvore Binária
                    11 - Imprimir Vetor
                    12 - Imprimir Lista
                    """);

            choice = scan.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Digite o nome do Contato: ");
                    String nomeVetor= scan.next();
                    System.out.println("Digite o número do Contato: ");
                    String numeroVetor = scan.next();

                    Contato contatoVetor = new Contato(nomeVetor, numeroVetor);

                    Vetor.adicionarContato(contatoVetor);
                    break;
                case 2:
                    System.out.println("Digite o nome do Contato: ");
                    String nomeLista = scan.next();
                    System.out.println("Digite o número do Contato: ");
                    String numeroLista = scan.next();

                    Contato contatoLista = new Contato(nomeLista, numeroLista);

                    ListaEncadeada.adicionarContato(contatoLista);
                    break;
                case 3:
                    System.out.println("Digite o nome do Contato: ");
                    String nomeArvore = scan.next();
                    System.out.println("Digite o número do Contato: ");
                    String numeroArvore = scan.next();

                    Contato contatoArvore = new Contato(nomeArvore, numeroArvore);

                    ArvoreBinaria.inserir(contatoArvore);
                    break;
                case 4:
                    System.out.println("Digite o número do contato que deseja remover: ");
                    String numeroRemovidoVetor = scan.next();

                    Vetor.removerContato(numeroRemovidoVetor);
                    break;
                case 5:
                    System.out.println("Digite o número do contato que deseja remover: ");
                    String numeroRemovidoLista = scan.next();

                    ListaEncadeada.removerContato(numeroRemovidoLista);
                    break;
                case 6:
                    System.out.println("Digite o número do contato que deseja remover: ");
                    String numeroRemovidoArvore = scan.next();

                    ArvoreBinaria.remover(numeroRemovidoArvore);
                    break;
                case 7:
                    System.out.println("Digite um número de um contato para buscar: ");
                    String numeroBuscadoVetor = scan.next();

                    Vetor.buscarContato(numeroBuscadoVetor);
                    break;
                case 8:
                    System.out.println("Digite um número de um contato para buscar: ");
                    String numeroBuscadoLista = scan.next();

                    ListaEncadeada.buscarContato(numeroBuscadoLista);
                    break;
                case 9:
                    System.out.println("Digite um número de um contato para buscar: ");
                    String numeroBuscadoArvore = scan.next();

                    ArvoreBinaria.buscarPorNumero(numeroBuscadoArvore);
                    break;
                case 10:
                    ArvoreBinaria.emOrdem();
                    break;
                case 11:
                    Vetor.getContatos().forEach(System.out::println);
                    break;
                case 12:
                    ListaEncadeada.getContatos().forEach(System.out::println);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (choice != 0);
    }
}
