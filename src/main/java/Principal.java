import model.Funcionario;
import service.FuncionarioService;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Principal {

    private final List<Funcionario> funcionarios;

    public Principal(){
        this.funcionarios = new ArrayList<>();
    }
    private void executar(){
        this.insereRemoveEListaFuncionarios(); // Requisito 3.1,3.2 e 3.3
        this.aumentoDeSalarioELista(); //Requisito 3.4
        this.agrupaPorFuncaoELista(); //Requisito 3.5 e 3.6
        this.listaFuncionariosPorAniversarios(); //Requisito 3.8 e 3.9
        this.exibeOrdemAlfabetica(); //Requisito 3.10
        this.calculosComSalario(); //Requisito 3.11 e 3.12
    }

    public static void main(String[] args){
        Principal app = new Principal();
        app.executar();
    }

    private void insereRemoveEListaFuncionarios(){
        //Inserir os funcionários na mesma ordem e com as mesmas informações da tabela.
        FuncionarioService.inserirFuncionario(funcionarios,"Maria", LocalDate.of(2000,10,18),new BigDecimal("2009.44"),"Operador");
        FuncionarioService.inserirFuncionario(funcionarios,"João", LocalDate.of(1990,5,12),new BigDecimal("2284.38"),"Operador");
        FuncionarioService.inserirFuncionario(funcionarios,"Caio", LocalDate.of(1961,5,2),new BigDecimal("9836.14"),"Coordenador");
        FuncionarioService.inserirFuncionario(funcionarios,"Miguel", LocalDate.of(1988,10,14),new BigDecimal("19119.88"),"Diretor");
        FuncionarioService.inserirFuncionario(funcionarios,"Alice", LocalDate.of(1995,1,5),new BigDecimal("2234.68"),"Recepcionista");
        FuncionarioService.inserirFuncionario(funcionarios,"Heitor", LocalDate.of(1999,11,19),new BigDecimal("1582.72"),"Operador");
        FuncionarioService.inserirFuncionario(funcionarios,"Arthur", LocalDate.of(1993,3,31),new BigDecimal("4071.84"),"Contador");
        FuncionarioService.inserirFuncionario(funcionarios,"Laura", LocalDate.of(1994,7,8),new BigDecimal("3017.45"),"Gerente");
        FuncionarioService.inserirFuncionario(funcionarios,"Heloísa", LocalDate.of(2003,5,24),new BigDecimal("1606.85"),"Eletricista");
        FuncionarioService.inserirFuncionario(funcionarios,"Helena", LocalDate.of(1996,9,2),new BigDecimal("2799.93"),"Gerente");

        // Remover o funcionário "João" da lista.
        FuncionarioService.removeFuncionario(funcionarios,"João");

        //Imprimir todos os funcionários com todas as suas informações
        System.out.println("\nLista de funcionários:");
        FuncionarioService.imprimeListaDeFuncionarios(funcionarios);
    }

    private void aumentoDeSalarioELista(){
        //Atualizar lista com um aumento de 10% de salário para todos.
        int porcentagem = 10;
        FuncionarioService.aumentaSalarios(funcionarios,porcentagem);
        System.out.println("\nLista de funcionários após aumento de "+porcentagem+ "% no salário:");
        FuncionarioService.imprimeListaDeFuncionarios(funcionarios);
    }

    private void agrupaPorFuncaoELista(){
        //Criar Map para agrupar funcionários por função
        Map<String,List<Funcionario>> funcionariosAgrupados = FuncionarioService.criaMapAgrupadoPorAtributo(funcionarios,Funcionario::getFuncao);
        //Exibir lista de funcionários agrupados por função
        System.out.println("\nLista de funcionários agrupados por função:");
        FuncionarioService.imprimeMapAgrupado(funcionariosAgrupados);
    }

    private void listaFuncionariosPorAniversarios(){
        //Imprimir funcionários que fazem aniversário no mês 10 e 12
        System.out.println("\nFuncionários que fazem aniversário mês 10:");
        FuncionarioService.imprimeFuncionariosPorMesAniversario(funcionarios,10);
        System.out.println("\nFuncionários que fazem aniversário mês 12:");
        FuncionarioService.imprimeFuncionariosPorMesAniversario(funcionarios,12);

        //Imprimir funcionário com maior Idade
        Funcionario maisVelho = FuncionarioService.funcionarioMaisVelho(funcionarios);
        System.out.println("\nFuncionário mais velho:");
        System.out.println("- Nome:"+maisVelho.getNome()+", Idade:"+ Period.between(maisVelho.getDataNascimento(),LocalDate.now()).getYears());
    }

    private void exibeOrdemAlfabetica(){
        //Imprimir lista de funcionários em ordem alfabética
        System.out.println("\nLista de funcionários em ordem alfabética:");
        FuncionarioService.imprimeListaDeFuncionariosEmOrdemAlfabetica(funcionarios);
    }

    private void calculosComSalario(){
        //Imprimir o total de salários de todos os funcionários:
        BigDecimal totalSalario = FuncionarioService.calculaTotalDeSalarios(funcionarios);
        System.out.println("\nSoma total de salários:");
        System.out.println(NumberFormat.getCurrencyInstance(Locale.of("pt","BR")).format(totalSalario));

        //Imprimir quantos salários mínimos cada funcionário ganha,considerando salário mínimo como 1212
        BigDecimal minimo = new BigDecimal("1212.00");
        System.out.println("\nRelação entre Salário mínimo e salário recebido");
        FuncionarioService.calculaEImprimeRelacaoSalarioMinimoESalario(funcionarios,minimo);
    }
}
