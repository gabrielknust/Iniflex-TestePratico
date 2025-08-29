package service;

import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FuncionarioService {
    public static void inserirFuncionario(List<Funcionario> list,String nome, LocalDate nascimento, BigDecimal salario, String funcao){
        list.add(new Funcionario(nome,nascimento,salario,funcao));
    }

    public static void removeFuncionario(List<Funcionario> list,String nome){
        list.removeIf(f -> f.getNome().equals(nome));
    }

    public static void imprimeListaDeFuncionarios(List<Funcionario> list){
        list.forEach(f -> {
            System.out.println("- "+f);
        });
    }

    public static void imprimeListaDeFuncionariosEmOrdemAlfabetica(List<Funcionario>list){
        list.stream().sorted(Comparator.comparing(Funcionario::getNome)).forEach(f->System.out.println("- "+f.getNome()));
    }

    public static void aumentaSalarios(List<Funcionario> list,int porcentagem){
        list.forEach(f -> f.setSalario(f.getSalario().multiply(new BigDecimal(1+ (double) porcentagem/100))));
    }

    //Essa função cria um Map agrupado por um atributo da classe Funcionario. O primeiro argumento é a lista de funcionários e o segundo é a função do atributo que
    //será utilizado para agrupar os funcionários. Exemplo: Funcionario::getFuncao para agrupar por função.
    public static Map<String,List<Funcionario>> criaMapAgrupadoPorAtributo(List<Funcionario> list, Function<Funcionario,String> extrator){
        return list.stream().collect(Collectors.groupingBy(extrator));
    }

    public static void imprimeMapAgrupado(Map<String,List<Funcionario>> map){
        map.forEach((funcao,lista) -> {
            System.out.println("Função:"+funcao);
            lista.forEach(f -> System.out.println("- "+f.getNome()));
        });
    }

    public static void imprimeFuncionariosPorMesAniversario(List<Funcionario> list, int mes){
        List<Funcionario> aniversariantes = list.stream().filter(f->f.getDataNascimento().getMonthValue() == mes).toList();
        if (aniversariantes.isEmpty()) {
            System.out.println("Não existem aniversariantes no mês "+mes);
        } else {
            aniversariantes.forEach(f -> System.out.println("- " + f.getNome()));
        }
    }

    public static Funcionario funcionarioMaisVelho(List<Funcionario> list){
        return Collections.min(list, Comparator.comparing(Funcionario::getDataNascimento));
    }
    
    public static BigDecimal calculaTotalDeSalarios(List<Funcionario> list){
        return list.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public static void calculaEImprimeRelacaoSalarioMinimoESalario(List<Funcionario> list, BigDecimal salarioMinimo){
        list.forEach(f-> {
            System.out.println("- Nome:"+f.getNome()+", Salários Mínimos:" + f.getSalario().divide(salarioMinimo,2, RoundingMode.HALF_UP));
        });
    }
}
