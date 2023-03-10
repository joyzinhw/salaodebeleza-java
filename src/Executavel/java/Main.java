package Executavel.java;
import Classes.java.*;

import javax.swing.*;
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

        int operacao =
                Integer.parseInt(JOptionPane.showInputDialog( "1- Cadastrar Cliente \n2- Cadastrar Serviço \n3- Listar Serviços \n4- Remover Serviço\n5- Alterar Serviço \n6- Remover Cliente \n7- Listar Clientes \n8- Alterar Cliente \n9- Registro de Servicos\n10- Sair do programa"));


        switch (operacao) {
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
        String nomeServico = JOptionPane.showInputDialog("Nome do serviço: ");
        String funcionario = JOptionPane.showInputDialog("Nome do Funcionario que faz o serviço: ");
        String dataString = JOptionPane.showInputDialog("Data em que o serviço foi feito: ");
        String[] dataseparada = dataString.split("/");
        LocalDate datanascimento = LocalDate.of(Integer.parseInt(dataseparada[2]), Integer.parseInt(dataseparada[1]), Integer.parseInt(dataseparada[0]));
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do serviço: "));
        String descricao = JOptionPane.showInputDialog("Descriçao do serviço: ");
        Funcionario Funcionarioo = new Funcionario(funcionario);
        Servico servico = new Servico(nomeServico, descricao, valor,Funcionarioo,datanascimento);
        servicos.add(servico);
        servico.Adiciconaa(servico);
        JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso");
        menu();
    }

    private static void cadastroCliente() {
        String nome =
                JOptionPane.showInputDialog("Nome do cliente: ");
        String email =
                JOptionPane.showInputDialog("Email do cliente: ");
        String sexo =
                JOptionPane.showInputDialog("Sexo do cliente: ");
        String uf =
                JOptionPane.showInputDialog("Uf do cliente: ");
        String cidade =
                JOptionPane.showInputDialog("Cidade do cliente: ");
        String bairro =
                JOptionPane.showInputDialog("Bairro do cliente: ");
        String rua =
                JOptionPane.showInputDialog("Rua do cliente: ");
        int numero =
                Integer.parseInt(JOptionPane.showInputDialog("Número da casa do cliente: "));
        Endereco endereco = new Endereco(numero, bairro, cidade, rua, uf);
        Cliente clientee = new Cliente(nome,email,sexo,endereco);
        clientes.add(clientee);
        clientee.Adiciconaa(clientee);

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
        menu();
    }



    private static void listarServicos() {
        if (servicos.size() > 0) {
            for (Servico servico : servicos) {
                JOptionPane.showMessageDialog(null, servico.print());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há serviços para listar.");
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
        int codigo =
                Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do serviço que você deseja remover:  "));
        Servico servico = encontraServicos(codigo);
        if (servico != null) {
            servico.remover(servico, codigo);

        }
        menu();
    }

    public static void alterarServicos() {

        int codigo =
                Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do serviço que você deseja alterar:  "));

        Servico servico = encontraServicos(codigo);
        if (servico != null) {
            String nomee =
                    JOptionPane.showInputDialog("Digite o novo nome do serviço você está alterando:  ");
            String nomefuncionario =
                    JOptionPane.showInputDialog("Digite a novo nome do funcionario que você está alterando:  ");
            double novovalor =
                    Double.parseDouble(JOptionPane.showInputDialog("Digite o novo valor do servico que você está alterando:  "));
            String descricao =
                    JOptionPane.showInputDialog("Digite a nova descricao do servico que deseja alterar:  ");
            servico.alterar(servico, codigo, nomee, novovalor, descricao, nomefuncionario);


        }

        menu();
    }

    private static void removerClientes() {
        int codigo =
                Integer.parseInt(JOptionPane.showInputDialog("Código do cliente que você deseja remover: "));
        Cliente cliente = encontrarClientes(codigo);
        if (cliente != null) {
            cliente.removerClientes(cliente, codigo);

        }

        menu();
    }

    private static void alterarClientes() {
        int codigo =
                Integer.parseInt(JOptionPane.showInputDialog("Digite o código do cliente que você deseja alterar: "));
        Cliente cliente = encontrarClientes(codigo);
        if (cliente != null) {

            String nomeee =
                    JOptionPane.showInputDialog("Digite o novo nome que você está alterando: ");
            String email =
                    JOptionPane.showInputDialog("Digite o novo email que você está alterando: ");
            String sexoo =
                    JOptionPane.showInputDialog("Digite o sexo do cliente que você está alterando : ");
            String uf =
                    JOptionPane.showInputDialog("Digite o novo Uf do cliente que você está alterando: ");
            String cidade =
                    JOptionPane.showInputDialog("Digite a nova Cidade do cliente que você está alterando: ");
            String bairro =
                    JOptionPane.showInputDialog("Digite o novo Bairro do cliente que você está alterando: ");
            String rua =
                    JOptionPane.showInputDialog("Digite a nova Rua do cliente que você está alterando: ");
            int numero =
                    Integer.parseInt(JOptionPane.showInputDialog("Digite o novo numero da casa do cliente que você está alterando: "));
            cliente.alterarClientes(cliente, codigo, nomeee, email, sexoo, numero, bairro, cidade, uf, rua);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel fazer a alteração");
        }
        menu();
    }

    private static void listarClientes() {
        if (clientes.size() > 0) {
            for (Cliente cliente : clientes) {
                JOptionPane.showMessageDialog(null, cliente.print());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há clientes para listar");
        }
        menu();

    }



    private static void registroServicos(){

        if(registroServicos.size() > 0){
            for(RegistroServico registroServico: registroServicos)
                JOptionPane.showMessageDialog(null, registroServico);
        }
        menu();
    }
    private static void sair(){
        JOptionPane.showMessageDialog(null, "OK. Obrigado por usar nossa plataforma.");
        System.exit(1);
    }
}
