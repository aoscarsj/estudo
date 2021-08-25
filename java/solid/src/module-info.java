module solid {
    /*SOLID
        * Single Responsibility Principle
        * Open Closed Principle
        * Liskov Susbtitution Principle
        * Interface Segragation Principle
        * Dependency Inversion Principle
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
    *
    * */
}