package Classes.java;
import javax.swing.*;
import static Executavel.java.Main.clientes;
import static Executavel.java.Main.registroServicos;
public class Cliente extends RegistroServico{
    private static int contador = 1;
    private int codigo;
    private String nome;
    private String email;
    private String sexo;
    private Endereco endereco;



    public Cliente(String nome, String email, String sexo, Endereco endereco){
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.endereco =endereco;
        this.codigo = contador;
        contador +=1;

    }


    public int getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void removerClientes(Cliente cliente, int codigo){
        if(cliente.getCodigo() == codigo){
            clientes.remove(cliente);
            JOptionPane.showMessageDialog(null, "Cliente removido");
        }
        else {
            JOptionPane.showMessageDialog(null, "Não foi possível remover cliente.");
        }
    }
    public void alterarClientes(Cliente cliente, int codigo, String nome, String email, String sexo, int numero, String bairro, String cidade, String uf, String rua){
        if(cliente.getCodigo() ==codigo){
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setSexo(sexo);
            cliente.setEnderecoNumero(numero);
            cliente.setEnderecoBairro(bairro);
            cliente.setEnderecoCidade(cidade);
            cliente.setEnderecoUf(uf);
            cliente.setEnderecoRua(rua);
            JOptionPane.showMessageDialog(null, "Serviço atualizado");
        }
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void setEnderecoNumero(int numero){
        this.endereco.setNumero(numero);
    }
    public void setEnderecoBairro(String nome){
        this.endereco.setBairro(nome);
    }
    public void setEnderecoCidade(String cidade){
        this.endereco.setBairro(cidade);
    }
    public void setEnderecoRua(String rua){
        this.endereco.setRua(rua);

    }

    public String getSexo() {
        return sexo;
    }

    public void setEnderecoLogradouro(String logradouro){
        this.endereco.setLogradouro(logradouro);
    }
    public void setEnderecoUf(String uf){
        this.endereco.setUf(uf);
    }


    public String print(){
        return  "Código: "+getCodigo() + "\n" +
                "Nome: " + getNome() + "\n" +
                "Email: " +getEmail() + "\n" +
                "Sexo: " +getSexo() + "\n" +
                "Endereço: " + getEndereco().getRua() + " "+ getEndereco().getBairro() + " " + +getEndereco().getNumero() + ", " + getEndereco().getCidade() + ", " +getEndereco().getUf();
    }

    public void Adiciconaa(Cliente cliente){
        registroServicos.add(cliente);}

    public String toString() {
        return "Cliente que recebeu o serviço: " +getNome();
    }
}
