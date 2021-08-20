package aula05;

import java.util.*;
import java.util.stream.Collectors;

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

        Optional<Curso> first = cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .findFirst(); // findAny, retorna qq um
        //Opcional eh uma classe do java 8 para lidar melhor com null.
        // Ele basicamente diz: 'pode retornar ou nao', caso eu colocasse > 5000, n ia retornar curso algum.
        Curso curso = first.orElse(null); // se tiver curso, retorne, se nao, retorne null


        //outra forma
        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .collect(Collectors.toMap(
                        c -> c.getNome(), // chave
                        c -> c.getAlunos() // valor
                ))// p retornar um map
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos +" alunos."));
                ;
    }
}
