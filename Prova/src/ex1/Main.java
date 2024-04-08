package ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//Desenvolva um sistema de gerenciamento de estoque para uma loja de
//conveniência. O sistema deve permitir que o usuário adicione novos produtos ao
//estoque e remova-os quando necessário. Além disso, o sistema deve ser capaz de
//recuperar informações sobre um produto específico rapidamente.
//Implemente uma pilha para rastrear as adições e remoções mais recentes de
//produtos, e uma tabela hash para armazenar informações detalhadas sobre cada
//produto, como nome, preço e quantidade em estoque. Como parte da solução,
//utilize o método de multiplicação para implementar a tabela hash e resolva colisões
//com listas encadeadas em um vetor.


public class Main {
    public static void main(String[] args) {
// teste
        Scanner scan = new Scanner(System.in);

        Integer choice;

        do {
            System.out.println("""
                    0 - Sair
                    1 - Inserir item
                    2 - Remover item
                    3 - Buscar item
                    4 - Imprimir pilha dos itens removidos e adicionados
                    5 - Imprimir HashMap dos itens
                    """);
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Digite o nome do item: ");
                    String nome = scan.next();
                    System.out.println("Digite o preço do item: ");
                    Double preco = scan.nextDouble();
                    System.out.println("Digite a quantidade em estoque do item: ");
                    Integer qtdeEstoque = scan.nextInt();
                    System.out.println("Digite o código de barras do item: ");
                    String codigoBarras = scan.next();

                    Item item = new Item(nome, preco, qtdeEstoque);

                    GerenciadorEstoque.inserirItemNoHashMap(GerenciadorEstoque.getItensDoEstoque(), GerenciadorEstoque.getItensRemovidosAdicionados(), item, codigoBarras);
                    break;
                case 2:
                    System.out.println("Digite o código de barras do item: ");
                    String codigoBarrasRemover = scan.next();
                    GerenciadorEstoque.removerItemDoHashMap(GerenciadorEstoque.getItensDoEstoque(), GerenciadorEstoque.getItensRemovidosAdicionados(), codigoBarrasRemover);
                    break;
                case 3:
                    System.out.println("Digite o código de barras do item: ");
                    String codigoBarrasBuscar = scan.next();
                    GerenciadorEstoque.buscarItemNoEstoque(GerenciadorEstoque.getItensDoEstoque(), codigoBarrasBuscar);
                    break;
                case 4:
                    GerenciadorEstoque.imprimirItensRemovidosAdicionados(GerenciadorEstoque.getItensRemovidosAdicionados());
                    break;
                case 5:
                    GerenciadorEstoque.imprimirItensDoEstoque(GerenciadorEstoque.getItensDoEstoque());
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (choice != 0);
    }
}
