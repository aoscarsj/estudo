package aula02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Lambdas {
    public static void main(String[] args) {
        // metodo antigo de ordenar
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("Casa do código");
        palavras.add("caelum");

        /* para a funcao lambda funcionar, a interface deve ter apenas um unico
            metodo abstrato, para que o lambda saiba que a implementacao eh de la.
        */
        // O lambda funciona smp que se tenha uma classe com apenas um metodo abstrato.

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        palavras.sort((s1, s2) -> s1.length() - s2.length());

        System.out.println(palavras);

        // formas de usar o foreach.
        // como so tem um argumento, da para tirar o tipo e os parenteses.
        palavras.forEach(s -> System.out.println(s));
        palavras.forEach(System.out::println);

        //interface sem param.
        new Thread(() -> System.out.println("Executando um Runnable")).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executando um Runnable");
            }

        }).start();
    }
}
