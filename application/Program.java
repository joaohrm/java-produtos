package application;

import entities.Componente;
import entities.Jogo;
import entities.Kit;
import entities.Produto;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao = 9;
        List<Produto> listaDeProdutos = new ArrayList<>();

        System.out.println("Bem vindo ao sistema de cadastro de estoque de informática");


        do {
            System.out.println();
            System.out.println("Escolha uma opção do sistema: ");
            System.out.println("1 - Cadastrar um componente de pc/notebook");
            System.out.println("2 - Cadastrar um jogo");
            System.out.println("3 - Cadastrar um kit de computador pré-montado");
            System.out.println("4 - Listar produtos cadastrados");
            System.out.println("0 - Encerrar sistema");
            System.out.print("Digite sua opção: ");

            try {
                opcao = sc.nextInt();
            } catch (Exception err) {
                System.out.println("Valor digitado é inválido!");
            }

            int codigo = 0;
            String nome = "";
            String descricao = "";
            double valor = 0.0;

            if(opcao > 0 && opcao < 4) {

                System.out.print("Digite o código do produto: ");
                codigo = sc.nextInt();

                System.out.print("Digite o nome do produto: ");
                sc.nextLine();
                nome = sc.nextLine();


                System.out.print("Digite a descrição do produto: ");
                descricao = sc.nextLine();

                System.out.print("Digite o valor do produto: ");
                valor = sc.nextDouble();

            }

            if(opcao == 1){

                System.out.print("Digite o tipo do produto: ");
                sc.next();
                String tipo = sc.nextLine();

                System.out.print("Digite os requisitos: ");
                sc.next();
                String requisitos = sc.nextLine();

                Produto produto = new Componente(codigo, nome, descricao, valor, tipo, requisitos);
                listaDeProdutos.add(produto);

                System.out.println("Componente cadastrado com sucesso!");

            } else if(opcao == 2){

                System.out.print("Descreva os requisitos do sistema para rodar o jogo: ");
                sc.next();
                String requisitos = sc.nextLine();

                Produto produto = new Jogo(codigo, nome, descricao, valor, requisitos);
                listaDeProdutos.add(produto);

                System.out.println("Jogo cadastrado com sucesso!");

            } else if(opcao == 3){

                List<Produto> pecas = new ArrayList<>();
                //int codigoKit = 99;

                System.out.println("Para montar um kit precisa escolhar um ou mais produtos já cadastrados");
                System.out.println("Listando todos os produtos cadastrados: ");
                System.out.println("--------------------------------------");
                for (Produto produto: listaDeProdutos) {
                    System.out.println(produto);
                }
                System.out.println("--------------------------------------");
                System.out.println();

                int codigoFechar = 99;
                do{
                    System.out.print("Digite o código do produto que gostaria de incluir no kit ou 0 para fechar o kit: ");
                    int codigoKit = sc.nextInt();
                    codigoFechar = codigoKit;
                    try{
                        System.out.println(listaDeProdutos.stream().filter(obj -> obj.getCodigo() == codigoKit).findAny().orElse(null).getNome() + " adicionado ao kit!");
                        pecas.add(listaDeProdutos.stream().filter(obj -> obj.getCodigo() == codigoKit).findAny().orElse(null));
                    } catch (NullPointerException err){
                        codigoFechar = 0;
                    }
                }while(codigoFechar != 0);

                System.out.println("Kit fechado, itens cadastrados no kit: ");

                for (Produto produto: pecas) {
                    System.out.println("1x "+produto);
                }

                System.out.println("");

                Produto produto = new Kit(codigo, nome, descricao, valor, pecas);
                listaDeProdutos.add(produto);
                System.out.println("kit cadastrado com sucesso!");

            } else if(opcao == 4){

                System.out.println("Listando todos os produtos cadastrados: ");

                for (Produto produto: listaDeProdutos) {
                    System.out.println(produto);
                }

            } else if(opcao == 0){
                System.out.println("Encerrando o sistema, obrigado por utilizar nossos serviços!");
            } else {
                System.out.println("Opção inválida, vamos novamente?");
            }


        } while(opcao != 0);

        sc.close();

    }

}
