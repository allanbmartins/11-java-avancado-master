package br.com.digital.innovation.one.aula3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//public class FutureExemplo {
//    private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);

public class FutureExemplo {
    private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);


//    public static void main(String[] args) {
//        Casa casa = new Casa(new Quarto());
//        casa.obterAfazeresDaCasa().forEach( atividade -> threadPool.execute(() -> atividade.realizar()));
//        threadPool.shutdown();
//
//    }

//    public static void main(String[] args) {
//        Casa casa = new Casa(new Quarto());
//        casa.obterAfazeresDaCasa().forEach( atividade -> threadPool.execute(() -> {
//            try {
//                atividade.realizar();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }));
//        threadPool.shutdown();
//
//    }

//    public static void main(String[] args) {
//        Casa casa = new Casa(new Quarto());
//        List<? extends Future<?>> futuros = casa.obterAfazeresDaCasa().stream()
////              .map(atividade -> threadPool.submit(atividade::realizar))
////              .map(atividade -> pessoasParaExecutarAtividade.submit(() -> atividade.realizar()))
//                .map(atividade -> pessoasParaExecutarAtividade.submit(() -> atividade.realizar()))
//                .collect(Collectors.toList());

//        public static void main(String[] args) throws InterruptedException {
//            Casa casa = new Casa(new Quarto());
//            List<? extends Future<?>> futuros =
//            new CopyOnWriteArrayList<>(casa.obterAfazeresDaCasa().stream()
//                    .map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
//                        try {
//                            atividade.realizar();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }))
//                    .collect(Collectors.toList()));

//    public static void main(String[] args) throws InterruptedException {
//        Casa casa = new Casa(new Quarto());
//        List<? extends Future<String>> futuros =
//                new CopyOnWriteArrayList<Future<String>>(casa.obterAfazeresDaCasa().stream()
//                        .map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
//                              try {
//                                  return atividade.realizar();
//                              } catch (InterruptedException e) {
//                                  e.printStackTrace();
//                              }
//                              return null;
//                        }))
//                        .collect(Collectors.toList()));

    public static void main(String[] args) throws InterruptedException {
        Casa casa = new Casa(new Quarto());
        List<Future<String>> futuros =
                new CopyOnWriteArrayList<>(casa.obterAfazeresDaCasa().stream()
                        .map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
                                try {
                                    return atividade.realizar();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                return null;
                            })
                        )
                        .collect(Collectors.toList()));

//        while (!futuros.stream().allMatch(Future::isDone)) {
        while (true) {
            int numeroDeAtividadesNaoFinalizadas = 0;
            for (Future<?> futuro : futuros) {
                if (futuro.isDone()) {
                    try {
                        System.out.println("Parabéns você terminou de " + futuro.get());
                        System.out.println("_______________________________________________________________________\n");
                        futuros.remove(futuro);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    numeroDeAtividadesNaoFinalizadas++;

                }
            }
            if (futuros.stream().allMatch(Future::isDone)){
                break;
            }
            System.out.println("Número de atividades não realizadas : " + numeroDeAtividadesNaoFinalizadas);
            Thread.sleep(500);
        }
//       threadPool.shutdown();
        pessoasParaExecutarAtividade.shutdown();
    }
}

class Casa {
    private List<Comodo> comodos;

    Casa(Comodo... comodos) { this.comodos = Arrays.asList(comodos); }

    List<Atividade> obterAfazeresDaCasa () {
        return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });



    }

}
//interface Atividade {
//    void realizar();


//interface Atividade {
//    void realizar() throws InterruptedException;


interface Atividade {
    String realizar() throws InterruptedException;

}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();

}

class Quarto extends Comodo {
    @Override
    List<Atividade> obterAfazeresDoComodo() {

//        ArrayList<Object> objects = new ArrayList<>();
//        objects.add(this.arrumarACama);
//        objects.add(this.varrerOQuarto);
//        objects.add(this.arrumarGuardaRoupa);

        return Arrays.asList(
                this::arrumarACama,
                this::varrerOQuarto,
                this::arrumarGuardaRoupa
        );
    }

//   private void arrumarGuardaRoupa() {
//        System.out.println("Arrumar o guarda roupa");
//    }
//
//   private void varrerOQuarto() {
//        System.out.println("Varrer o quarto");
//    }
//
//   private void arrumarACama() {
//        System.out.println("Arrumar a cama");
//    }


//   private void arrumarGuardaRoupa() throws InterruptedException {
//       Thread.sleep(5000);
//        System.out.println("Arrumar o guarda roupa");}
//
//   private void varrerOQuarto() throws InterruptedException {
//       Thread.sleep(7000);
//        System.out.println("Varrer o quarto");}
//
//   private void arrumarACama() throws InterruptedException {
//       Thread.sleep(10000);
//        System.out.println("Arrumar a cama");}


    private String arrumarGuardaRoupa() throws InterruptedException {
        Thread.sleep(5000);
        String arrumar_o_guarda_roupa = "Arrumar o quarda roupa";
        System.out.println(arrumar_o_guarda_roupa);
        return arrumar_o_guarda_roupa;
    }

    private String varrerOQuarto() throws InterruptedException {
        Thread.sleep(7000);
        String varrer_o_quarto = "Varrer o quarto";
        System.out.println(varrer_o_quarto);
        return varrer_o_quarto;
    }

    private String arrumarACama() throws InterruptedException {
        Thread.sleep(10000);
        String arrumar_a_cama = "Arrumar a cama";
        System.out.println(arrumar_a_cama);
        return arrumar_a_cama;
    }

}









