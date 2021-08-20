package aula06;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);
        //representa apenas data, nao tem hh:mm:ss.
        LocalDate olimpiadasRio = LocalDate.of(2023, Month.JUNE, 5);

        Period periodo = Period.between(hoje, olimpiadasRio);
        System.out.println(periodo.plusYears(4)); // essa bib nao altera o objeto, retorna um novo.
        System.out.println(olimpiadasRio);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String valorFormatado = olimpiadasRio.format(formatador);
        System.out.println(valorFormatado);

        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

        //ele retorna tb hh:mm:ss
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorComHoras));
    }
}
