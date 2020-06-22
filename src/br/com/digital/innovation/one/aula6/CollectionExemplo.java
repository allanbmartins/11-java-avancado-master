package br.com.digital.innovation.one.aula6;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CollectionExemplo {

    public static void main(String[] args) {
        Collection<String> nomes = Arrays.asList("Joao","Paulo","Oliveira", "Santos");
        Collection<String> nomes2 = List.of("Joao","Paulo","Oliveira", "Santos");
        Collection<String> nomes3 = Set.of("Joao","Paulo","Oliveira", "Santos");



        System.out.println("Exemplo 1 :: "+nomes+"\n");
        System.out.println("Exemplo 2 :: "+nomes2+"\n");
        System.out.println("Exemplo 3 :: "+nomes3+"\n");

    }


}
