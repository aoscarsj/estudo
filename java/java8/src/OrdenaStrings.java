import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
    public static void main(String[] args) {
        // metodo antigo de ordenar
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("Casa do código");
        palavras.add("caelum");

        //forma antiga de se ordenar string.
//        Collections.sort(palavras, comparator);

        Comparator<String> comparator = new ComparadorPorTamanho();
        palavras.sort(comparator);

        System.out.println(palavras);

        Consumer<String> consumidor = new ImprimeNaLinha();

        // formas de usar o foreach.
        palavras.forEach(consumidor);
        palavras.forEach(System.out::println);
    }
}
class ImprimeNaLinha implements Consumer<String>{

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
class ComparadorPorTamanho implements Comparator <String> {

    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}
