package aula03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MethodReferences {
    public static void main(String[] args) {
        // metodo antigo de ordenar
        List<String> palavras = new ArrayList<>();
        palavras.add("ALUra online");
        palavras.add("Casa do código");
        palavras.add("Caelum");

        palavras.sort((s1, s2) -> s1.length() - s2.length());

        palavras.sort(Comparator.comparing(s -> s.length()));
        palavras.sort(Comparator.comparing(String::length));
        // ordenar por minusculas.
        palavras.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(palavras);

        // formas de usar o foreach.
        // como so tem um argumento, da para tirar o tipo e os parenteses.
        palavras.forEach(s -> System.out.println(s));
        palavras.forEach(System.out::println);

    }
}
