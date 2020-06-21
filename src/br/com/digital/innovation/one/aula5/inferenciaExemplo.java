// Aula "Novidades do Java 10" módulos "Aplicando os novos releases da linguagem na prática I, II e III"
// https://www.youtube.com/watch?v=OweZAewo54A : Instalando o Docker no Windows
// https://www.youtube.com/watch?v=TrnrH2EP3zo : Como INSTALAR Docker no Linux | RAPIDO E FACIL
// https://dzone.com/articles/java-string-format-examples : Especificadores de formato

package br.com.digital.innovation.one.aula5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
//import java.net.URLConnection;
import java.util.stream.Collectors;
import java.util.Formatter;

public class inferenciaExemplo {

//    private var joao = new String("joao"); // var não consegue utilizar a nível de classe, só variáveis locais, de preferencia dentro de um for ou métodos.

//    public static void main(String[] args) throws IOException {
////        URL url = new URL("Https://docs.oracle.com/javase/10/language/");
////        URLConnection urlConnection = url.openConnection();
////        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));
//
//        var url = new URL("Https://docs.oracle.com/javase/10/language/");
//        var urlConnection = url.openConnection();
//        var bufferedReader = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));
//
//        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">",">\n"));


//    public static void main(String[] args) throws IOException {
//        testar("Joao","Santos");
//    }

//    public static void main(String[] args) throws IOException {
//        printarSoma(5, 5, 5);
//    }

    public static void main(String[] args) {
        connectAndPrintURLJavaOracle();
    }


//    private static void connectAndPrintURLJavaOracle() throws IOException {
//        var url = new URL("Https://docs.oracle.com/javase/10/language/");
//        var urlConnection = url.openConnection();
//        var bufferedReader = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));
//        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
//    }

    private static void connectAndPrintURLJavaOracle() {

        try {
             var url = new URL("Https://docs.oracle.com/javase/10/language/");
             var urlConnection = url.openConnection();

             try (var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                 System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">",">\n"));
             }
        } catch(Exception e) {
            e.printStackTrace();


        }
    }

//    public void testar() {

//    public static void testar(String nome) {
////    public static void testar(var nome) { // var não pode ser utilizado em nível de class ou como parametro
//
//        System.out.println(nome);
//    }

//    public static void testar(String nome, String sobrenome) {
//        var nomeCompleto = String.format("%s %s",nome,sobrenome);
//        System.out.println(nomeCompleto);
//
//    }

    public static void printarNomeCompleto(String nome, String sobrenome) {
        var nomeCompleto = String.format("%s %s", nome, sobrenome);
        System.out.println(nomeCompleto);
    }

//    public static void printarSoma(int a, int b) {
//        var soma = a+b;
//
//        System.out.println(soma);
//    }

//    public static void printarSoma(int... numeros) {
//        int soma;
//        if (numeros.length > 0) {
//            soma = 0;
//            for (int numero : numeros) {
//                soma += numero;
//            }
//            System.out.println("A soma é ::: "+soma);
//        }
//    }

    public static void printarSoma(int... numeros) {
        int soma;
//        var soma;
        if (numeros.length > 0) {
            soma = 0;
//            for (var numero : numeros) {
//                soma += numero;
//            }

//            for (int numero = 0; numero < numeros.length; numero++) {
            for (var numero = 0; numero < numeros.length; numero++) {
                soma+=numeros[numero];

            }

            System.out.println("A soma é ::: "+soma);
        }
    }

    // Consegue

       // variáveis locais inicializadas
       // variável suporte do enhaced for
       // variável suporte do for interativo
       // variável try with resouce


    // Não consegue

        // var não pode ser utilizado em nível de class
        // var não pode ser utilizado como parametro
        // var não pode ser utilizado em variáveis locais não inicializadas

    // Link para estudos: Https://docs.oracle.com/javase/10/language/

}

//AULA DOCKER
//
//        $ docker --version
//        $ docker
//        $ sudo docker container run -it -m512m --entrypoint bash openjdk:7-jdk
//        $ java -XX:+PrintFlagsFinal -version
//        $ java -XX:+PrintFlagsFinal -version | grep MaxHeapSize
//        $ sudo docker ps
//        $ sudo docker ps -a
//        $ sudo docker run -it -m512m --entrypoint bash openjdk:10-jdk
//        $ java -XX:+PrintFlagsFinal -version | grep MaxHeapSize
//        $ sudo docker run -it --cpus 2 openjdk:10-jdk
//        $ Runtime.getRuntime().availableProcessors()
//        $ /exit
//        $ sudo docker run -it --cpus 1 openjdk:10-jdk
//        $ Runtime.getRuntime().availableProcessors()
//        $
//        $
//        $
//        $
//        $
//        $
//        $
//        $

