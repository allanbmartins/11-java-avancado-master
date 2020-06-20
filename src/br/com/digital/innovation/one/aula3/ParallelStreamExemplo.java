package br.com.digital.innovation.one.aula3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExemplo {
    public static void main(String[] args) {
//        long inicio = System.currentTimeMillis();
////        IntStream.range(1,10000).forEach(num -> System.out.println(fatorial(num)));
//        IntStream.range(1,100000).forEach(num -> fatorial(num)); // Serial stream
//        long fim = System.currentTimeMillis();
//        System.out.println("Tempo de execução Serial :: "+(fim-inicio));
//
//        inicio = System.currentTimeMillis();
////        IntStream.range(1,10000).forEach(num -> System.out.println(fatorial(num)));
//        IntStream.range(1,100000).forEach(num -> fatorial(num)); // Parallel stream
//        fim = System.currentTimeMillis();
//        System.out.println("Tempo de execução Parallel :: "+(fim-inicio));

//        List<String> nomes = Arrays.asList("João","Paulo","Oliveira","Santos");
        List<String> nomes = Arrays.asList("João","Oliveira","Paulo","Santos");
        nomes.parallelStream().forEach(System.out::println);


    }

    public static long fatorial(long nun){
        long fat = 1;

        for (long i = 2; i <- nun ; i++) {
            fat*=i;
        }
        return fat;
    }



}
//
//