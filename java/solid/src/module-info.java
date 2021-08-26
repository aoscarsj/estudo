module solid {
    /*SOLID
        * Single Responsibility Principle
            * Principio da responsabilidade Unica
            * "Uma classe deveria ter apenas um unico motivo para mudar" (Uncle Bob)
            * Ele busca manter uma auta coesao do codigo, deixando classes pequenas e enxutas
        *
        * Open Closed Principle
            *   "Entidades de software (classes, módulos, funcoes, etc.)
            *   devem estar abertas p extensao, porem fechadas para modificacao!"
            *   Deixe-o extensivel, evitando ao maximo mexer para colocar algo novo. O ideal
            *   eh separar.
        * Liskov Susbtitution Principle
            *   Use a abstracao correta! Se tem coisas que nao fazem sentido, nao use, cuidado
            *   com efeitos colaterais.
            *   "Se q(x) é uma propriedade demonstrável dos objetos x de tipo T, entao q(y)
            *   deve ser verdadeiro para objetos y de tipo S, onde S é um subtipo de T."
            *                       - Barbara Liskov
            *   Quando a heranca nao fizer sentido, usar composicao.
        * Interface Segragation Principle
            *     As vezes sera necessario implementar uma interface que nao faz sentido.
            *   "Uma classe nao deveria ser forcada a depender de metodos que nao utilizara."
            *                       -Robert (Uncle Bob) Martin.
            *   A classe as vezes tera de implementar metodos que nao fazem sentido pq da interface
            *   O que fazer? Cria outra interface e a que usa o metodo, joga.
            *   A classe nao deve implementar metodos que nao fazem sentido!
            *   Joga uma heranca entre interfaces. Resolve o problema.
        * Dependency Inversion Principle
            *   "Abstracoes nao devem depender de implementacoes
            *    implementacoes devem depender de abstracao"
            *                       -Robert (Uncle Bob) Martin.
    *
    * Princípios da OO
        * Coesão
            * Harmonia entre elemementos.
            * Os atrib e os metodos devem estar coesas. Ter coisas em comum.
            * Ter atrib e metodos que representam de fato aquilo.
            * As coisas tratam da mesma coisa.
            * Qdo tem muito atributo solto, nao eh melhor extrair?
            *
        * Encapsulamento
            *  É por regra, controlar o fluxo de entrada de informações.
            *  Ele busca por regras de negócio para alterações na classe.
            *  Classes nao encapsuladas permitem violacao de regras de negocio, alem de aumentarem o acoplamento.
            * => Encher de setters nao eh encapsulamento! Encapsulamento eh controlar as alteracoes, pondo regras...
            * Getters e setters por si so nao fornecem nenhum tipo de encapsulamento.
            *
        * Acoplamento
            * Agrupamento aos pares.
            * Classe A usando Classe B.
            * O problema eh quando a conversa esta muito "intima", cria-se uma dependencia mt forte.
            * Nao faca o trabalho da classe, fora dela!
            * Qualquer mudanca em um ponto, quebra outros pontos. Mexe em A, impacta B, B impacta C
            * Se mal feito, quebra a aplicacao de forma facil.
    *   Resumo:
    *   Coesão:
            Uma classe coesa faz bem uma única coisa
            Classes coesas não devem ter várias responsabilidades
        Encapsulamento:
            Getters e setters não são formas eficientes de aplicar encapsulamento
            É interessante fornecer acesso apenas ao que é necessário em nossas classes
            O encapsulamento torna o uso das nossas classes mais fácil e intuitivo
        Acoplamento:
            Acoplamento é a dependência entre classes
            Acoplamento nem sempre é ruim, e que é impossível criar um sistema sem nenhum acoplamento
            Devemos controlar o nível de acoplamento na nossa aplicação (falaremos mais sobre isso)
    *
    * Resumo final:
        * Que é mais interessante e mais seguro para o nosso código depender de interfaces
            (classes abstratas, assinaturas de métodos e interfaces em si)
            do que das implementações de uma classe;
        * Que as interfaces são menos propensas a sofrer mudanças enquanto implementações
            podem mudar a qualquer momento;
        * Que o Princípio de Inversão de Dependência (DIP) diz que implementações devem
            depender de abstrações e abstrações não devem depender de implementações;
        * Que as interfaces devem definir apenas os métodos que fazem sentido para seu contexto;
        * Que o Princípio de Segregação de Interfaces (ISP) diz que uma classe não
            deve ser obrigada a implementar um método que ela não precisa;
        * Os conceitos aprendidos neste treinamento formam o acrônimo SOLID
            * Single Responsibility Principle
            * Open Closed Principle
            * Liskov Substitution Principle
            * Interface Segregation Principle
            * Dependency Inversion Principle
    *
    * */
}