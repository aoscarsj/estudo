package aula04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class ExploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));
//        cursos.forEach(c -> System.out.println(c.getNome() + " - " + c.getAlunos()));

        // o que eh feito no stream, nao gera impacto na colecao original
        // ele eh melhor que a forma do for na mao, em desempenho.
        // como filtrar.
        //stream eh um fluxo de objetos, possivel de trabalhar com esse fluxo.
        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                //.map(Curso::getAlunos)
                .mapToInt(Curso::getAlunos)
                .sum()
//                .forEach(System.out::println)

                //.forEach(c -> System.out.println(c.getNome() + " - " + c.getAlunos()))
        ;
        System.out.println(sum);
    }
}
