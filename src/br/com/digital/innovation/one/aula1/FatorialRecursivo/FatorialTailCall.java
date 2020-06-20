package br.com.digital.innovation.one.aula1.FatorialRecursivo;

public class FatorialTailCall {
    public static void main(String[] args) {
        System.out.println(fatorialA(100000));
    }
    public static double fatorialA( double valor ) {
        return fatorialComTailCall(valor,1);
    }
    public static double fatorialComTailCall(double valor, double numero){
        if (valor == 0){
            return numero;
        }
        return fatorialComTailCall(valor-1,numero*valor);
    }

    // 5
    // 5 * 4 * 3 * 2 * 1
    // 120
//    Tail Call
//    5 * 4 = 20
//    20 * 3
//    60 * 2
//    120 * 1
//    120



}
