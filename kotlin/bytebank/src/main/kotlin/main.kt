fun main(){
    println("bem vindo ao bytebank!")

    // existe var e val.
        // var -> variavel que seu valor pode ser modificado
        // val -> nao permite modificar seu valor. Comecar geralmente com val, se precisar muda para var.
    val titular = "Artur Oscar"; // o kotlin converte implicitamente para o tipo.
    val numeroConta: Int = 1000 // para forcar o tipo
    var saldo = 0.0; // eh estaticamente tipado.

    saldo = 100 + 2.0;
    saldo += 200
    println("titular: $titular")
    println("Numero da conta: $numeroConta")
    println("Saldo da conta: $saldo")

}