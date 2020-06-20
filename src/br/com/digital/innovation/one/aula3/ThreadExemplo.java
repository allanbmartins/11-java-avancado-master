package br.com.digital.innovation.one.aula3;

public class ThreadExemplo {

//    public static void main(String[] args) {
//        BarraDeCarregamento2 barraDeCarregamento2 = new BarraDeCarregamento2();
//
//        BarraDeCarregamento3 barraDeCarregamento3 = new BarraDeCarregamento3();
//
//        barraDeCarregamento2.start();
//        barraDeCarregamento3.start();
//
//
//
//
//    }

//    public static void main(String[] args) {
//        Thread thread = new Thread(new BarraDeCarregamento2());
//        Thread thread2 = new Thread(new BarraDeCarregamento3());
//
//        thread.start();
//        thread2.start();
//        System.out.println("Nome da thread : "+thread.getName());
//        System.out.println("Nome da thread : "+thread2.getName());
//
//
//
//    }

    public static void main(String[] args) {
        GeradorPDF iniciarGeradorPdf = new GeradorPDF();
        Thread iniciarBarraDeCarregamento = new BarraDeCarregamento(iniciarGeradorPdf);

        iniciarGeradorPdf.start();
        iniciarBarraDeCarregamento.start();

    }


}

//class GerarPDF implements Runnable {
//
//    @Override
//    public void run() {
//
//        System.out.println("Gerar PDF");
//    }
//}

class GeradorPDF extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Iniciar geração de PDF");
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Gerar PDF");
    }
}

//class BarraDeCarregamento implements Runnable {
//
//    @Override
//    public void run() {
//            System.out.println("Loading ...");
//    }
//
//}

class BarraDeCarregamento extends Thread {
    private Thread iniciarGeradorPdf;

    public BarraDeCarregamento(Thread iniciarGeradorPdf) {
        this.iniciarGeradorPdf = iniciarGeradorPdf;

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);

                if (!iniciarGeradorPdf.isAlive()){
                    break;
                }
                System.out.println("Loading ...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }




        }

    }

}

//class BarraDeCarregamento2 extends Thread {
//
//    @Override
//    public void run() {
//        super.run();
//
//
//        try {
//            Thread.sleep(3000);
//            System.out.println("rodei Barra de carregamento2 : " + this.getName());
//        } catch (InterruptedException e) {
//             e.printStackTrace();
//        }
//  }
//}
//
//class BarraDeCarregamento3 extends Thread {
//
//    @Override
//    public void run() {
//        super.run();
//
//
//        try {
//            Thread.sleep(10000);
//            System.out.println("rodei Barra de carregamento3 : " + this.getName());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}


//class BarraDeCarregamento2 implements Runnable {
//
//    @Override
//    public void run() {
//
//        try {
//            Thread.sleep(3000);
//            System.out.println("rodei Barra de carregamento2 : ");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//class BarraDeCarregamento3 implements Runnable {
//
//    @Override
//    public void run() {
//
//        try {
//            Thread.sleep(10000);
//            System.out.println("rodei Barra de carregamento3 : ");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
