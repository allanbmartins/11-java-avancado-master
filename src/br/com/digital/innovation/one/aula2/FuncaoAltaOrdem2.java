package br.com.digital.innovation.one.aula2;

public class FuncaoAltaOrdem2 {
    public static void main(String[] args) {
      Calculo2 SOMA =  (a, b) -> a+b;
      Calculo2 SUBTRACAO =  (a, b) -> a-b;
      Calculo2 DIVISAO =  (a, b) -> a/b;
      Calculo2 MULTI =  (a, b) -> a*b;

        System.out.println(executarOperacao(SOMA,1,3));//4
        System.out.println(executarOperacao(SUBTRACAO,4,3));//1
        System.out.println(executarOperacao(DIVISAO,4,2));//2
        System.out.println(executarOperacao(MULTI,7,3));//21
    }



    public static int executarOperacao(Calculo2 calculo2, int a, int b){
        return calculo2.calcular(a,b);
    }
}


@FunctionalInterface
interface Calculo2 {
    public int calcular(int a, int b);
}

//POR PARAMETRO RECEBE OUTRA FUNÇÃO
//OU QUE ELA RETORNA UMA FUNÇÃO