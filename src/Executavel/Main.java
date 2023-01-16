package Executavel;

import Classes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Servico> servicos;
    public static ArrayList<Cliente> clientes;
    public static ArrayList<RegistroServico>registroServicos;

    static Scanner Entrada = new Scanner(System.in);


    public static void main(String[] args) {

        servicos = new ArrayList<>();
        clientes = new ArrayList<>();
        registroServicos = new ArrayList<>();


        menu();
    }

    private static void menu() {

        System.out.println("1-cadastroCliente\n2-cadastroServiço\n3-listarrServicos\n4-removerServicos\n5-alterarServicos\n6-removerClientes\n7-listarClientes\n8-alterarClientes\n9-registroServicos\n10-Sair");

        int opcao = Entrada.nextInt();

        switch (opcao) {
            case 1:
                cadastroCliente();

            case 2:
                cadastroServicos();

            case 3:
                listarServicos();

            case 4:
                removerServico();

            case 5:
                alterarServicos();

            case 6:
                removerClientes();

            case 7:
                listarClientes();

            case 8:
                alterarClientes();

            case 9:
                registroServicos();
            case 10:
                sair();

        }
    }
    private static void cadastroServicos() {
        System.out.println("nome do serviço: ");
        String nomeServico = Entrada.next();
        System.out.println("Nome do CLasses.Funcionario que faz o serviço: ");
        String funcionario = Entrada.next();
        System.out.println("data que o serviço foi feito: ");
        String dataString = Entrada.next();
        String[] dataseparada = dataString.split("/");
        LocalDate datanascimento = LocalDate.of(Integer.parseInt(dataseparada[2]), Integer.parseInt(dataseparada[1]), Integer.parseInt(dataseparada[0]));
        System.out.println("valor do serviço: ");
        double valor = Entrada.nextDouble();
        System.out.println("Descriçao do serviço: ");
        String descricao = Entrada.next();
        Funcionario Funcionarioo = new Funcionario(funcionario);
        Servico servico = new Servico(nomeServico, descricao, valor,Funcionarioo,datanascimento);
        servicos.add(servico);
        servico.Adiciconaa(servico);
        System.out.println("Serviço cadastrado com sucesso");
        menu();
    }

    private static void cadastroCliente() {
        System.out.println("nome do cliente: ");
        String nome = Entrada.next();
        System.out.println("email do cliente: ");
        String email = Entrada.next();
        System.out.println("sexo do cliente: ");
        String sexo = Entrada.next();
        System.out.println("uf do cliente: ");
        String uf = Entrada.next();
        System.out.println("cidade do cliente: ");
        String cidade = Entrada.next();
        System.out.println("Bairro do cliente: ");
        String bairro = Entrada.next();
        System.out.println("rua do cliente: ");
        String rua = Entrada.next();
        System.out.println("numero da casa do cliente: ");
        int numero = Entrada.nextInt();
        Endereco endereco = new Endereco(numero, bairro, cidade, rua, uf);
        Cliente clientee = new Cliente(nome,email,sexo,endereco);
        clientes.add(clientee);
        clientee.Adiciconaa(clientee);

        System.out.println("CLasses.Cliente cadastrado com sucesso");
        menu();
    }



    private static void listarServicos() {
        if (servicos.size() > 0) {
            for (Servico servico : servicos) {
                System.out.println(servico.print());
            }
        } else {
            System.out.println("nao ha serviços para listar");
        }
        menu();

    }

    private static Servico encontraServicos(int codigo) {
        Servico servico = null;
        if (servicos.size() > 0) {
            for (Servico s : servicos) {
                if (s.getCodigo() == codigo) {
                    servico = s;

                }
            }
        }

        return servico;
    }

    private static Cliente encontrarClientes(int codigo) {
        Cliente cliente = null;
        if (clientes.size() > 0) {
            for (Cliente c : clientes)
                if (c.getCodigo() == codigo) {
                    cliente = c;

                }
        }
        return cliente;
    }

    public static void removerServico() {
        System.out.println(" Digite o codigo para ser encontrado:  ");
        int codigo = Entrada.nextInt();
        Servico servico = encontraServicos(codigo);
        if (servico != null) {
            servico.remover(servico, codigo);

        }
        menu();
    }

    public static void alterarServicos() {


        System.out.println(" Digite o codigo do serviço para ser alterado :  ");
        int codigo = Entrada.nextInt();
        Servico servico = encontraServicos(codigo);
        if (servico != null) {
            System.out.println(" digite o novo nome do serviço:  ");
            String nomee = Entrada.next();
            System.out.println(" digite a novo nome do funcionario para ser alterado:  ");
            String nomefuncionario = Entrada.next();
            System.out.println(" digite o novo valor do servico que deseja alterar:  ");
            double novovalor = Entrada.nextDouble();
            System.out.println(" digite a nova descricao do servico que deseja alterar:  ");
            String descricao = Entrada.next();
            servico.alterar(servico, codigo, nomee, novovalor, descricao, nomefuncionario);


        }

        menu();
    }

    private static void removerClientes() {
        System.out.println("codigo do cliente: ");
        int codigo = Entrada.nextInt();
        Cliente cliente = encontrarClientes(codigo);
        if (cliente != null) {
            cliente.removerClientes(cliente, codigo);

        }

        menu();
    }

    private static void alterarClientes() {
        System.out.println("Digite o codigo do cliente que deseja alterar");
        int codigo = Entrada.nextInt();
        Cliente cliente = encontrarClientes(codigo);
        if (cliente != null) {
            System.out.println("Digite o novo nome para ser alterado: ");
            String nomeee = Entrada.next();
            System.out.println("Digite o novo email para ser alterado: ");
            String email = Entrada.next();
            System.out.println("sexo do cliente para ser alterado : ");
            String sexoo = Entrada.next();
            System.out.println("Digite o novo uf do cliente para ser alterado: ");
            String uf = Entrada.next();
            System.out.println("Digite a nova cidade do cliente para ser alterada: ");
            String cidade = Entrada.next();
            System.out.println("Digite o novo Bairro do cliente para ser alterado: ");
            String bairro = Entrada.next();
            System.out.println("Digite a nova rua do rua do cliente para ser alterado: ");
            String rua = Entrada.next();
            System.out.println("Digite o novo numero da casa do cliente para ser alterado: ");
            int numero = Entrada.nextInt();
            System.out.println("Digite o novo logradourodo cliente para ser alterado: ");
            String logradouro = Entrada.next();
            cliente.alterarClientes(cliente, codigo, nomeee, email, sexoo, numero, bairro, cidade, uf, logradouro, rua);
        } else {
            System.out.println("Não foi possivel fazer a alteração");
        }
        menu();
    }

    private static void listarClientes() {
        if (clientes.size() > 0) {
            for (Cliente cliente : clientes) {
                System.out.println(cliente.print());
            }
        } else {
            System.out.println("Não há serviços para listar");
        }
        menu();

    }



private static void registroServicos(){

        System.out.println("Registro De Serviços");
    if(registroServicos.size() > 0){
            for(RegistroServico registroServico: registroServicos)
                System.out.println(registroServico);
        }
        menu();
    }
    private static void sair(){
        System.out.println("Saída executada !");
        System.exit(1);
    }
    }

