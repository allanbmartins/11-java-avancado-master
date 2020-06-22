package br.com.digital.innovation.one.aula6;

import java.util.function.Function;

public class InferenciaLambda {
    public static void main(String[] args) {
//        String nome = "Joao";
//        var nome = "Joao";

        Function<Integer, Double> divisaoPor2 = (var numero) -> numero / 2.0;
//        Function divisaoPor2 = (var numero) -> numero.getClass();

        System.out.println(divisaoPor2.apply(9849387));
    }
}
