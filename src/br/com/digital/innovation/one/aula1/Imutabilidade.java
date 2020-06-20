package br.com.digital.innovation.one.aula1;

import java.util.function.UnaryOperator;

public class Imutabilidade {
    public static void main(String[] args) {
        int valor = 20;
        UnaryOperator<Integer> retornarDobro = v -> v * 2;

//        UnaryOperator<Integer> retornarDobro = v -> {
//            valor = 30; // Exemplo que não pode ser usado na imutabilidade
//            return v * 2;
//
//        };

        System.out.println(retornarDobro.apply(valor)); // retorna o dobro do valor
        System.out.println(valor); // valor nao sera alterado
    }
}
