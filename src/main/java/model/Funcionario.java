package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa{
    public BigDecimal salario;
    public String funcao;

    public Funcionario(String nome,LocalDate dataNascimento,  BigDecimal salario, String funcao) {
        super(dataNascimento, nome);
        this.funcao = funcao;
        this.salario = salario;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.of("pt","BR"));
        return "Nome=" + getNome()+
                ", Data de Nascimento="+getDataNascimento().format(dateFormatter)+
                ", Salário=" + numberFormatter.format(salario) +
                ", Função=" + funcao;
    }
}
