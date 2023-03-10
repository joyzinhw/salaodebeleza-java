package Classes.java;
import Executavel.java.Main;


import javax.swing.*;
import java.time.LocalDate;

import static Executavel.java.Main.*;
public class Servico extends RegistroServico{
    private static int contador = 1;
    private String nome;
    private String descricao;
    private double valor;
    private int codigo;
    private LocalDate data;
    private LocalDate servico;

    private Funcionario funcionario;


    public Servico(String nome, String descricao, Double valor, Funcionario funcionario, LocalDate data) {
        this.descricao = descricao;
        this.nome = nome;
        this.valor = valor;
        this.codigo = contador;
        this.funcionario = funcionario;
        this.data = data;
        contador += 1;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }
    public void remover(Servico servico, int codigo) {
        if (servico.getCodigo() == codigo) {
            servicos.remove(servico);
            JOptionPane.showMessageDialog(null, "Serviço removido.");
        } else {
            JOptionPane.showMessageDialog(null, " Não foi possivel remover serviço.");
        }
    }

    public LocalDate getData() {
        return data;
    }

    public void alterar(Servico servico, int codigo, String nome, double valor, String descricao, String nomefuncionario) {
        if (servico.getCodigo() == codigo) {
            servico.setValor(valor);
            servico.setDescricao(descricao);
            servico.setNome(nome);
            servico.funcionario.setNome(nomefuncionario);

            JOptionPane.showMessageDialog(null," Serviço alterado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null,"Nao foi possivel fazer a alteração");
        }
    }

    public String getDescricao() {

        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }



    public void setValor(double valor) {
        this.valor = valor;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionarioNome(String nome) {
        this.funcionario.setNome(nome);
    }

    @Override
    public Cliente getCliente() {
        return super.getCliente();
    }

    public void Adiciconaa(Servico servico){
        registroServicos.add(servico);
    }
    public String print(){
        return "Código: " +getCodigo() + " \n " +
                "Serviço: " +getNome()+ " \n " +
                "Descriçao: " + getDescricao() + " \n " +
                "Valor: " + getValor() + " \n " +
                "Funcionário: " + getFuncionario().getNome();

    }

    public String toString() {
        return
                "Dados do serviço " +  "\n" +
                        "Serviço: " +getNome() + "\n" +
                        "Valor: " + getValor() + "\n" +
                        "Data do Servico: " +getData() + "\n" +
                        "Funcionário que realizou o serviço: " +getFuncionario().getNome() ;
    }
}
