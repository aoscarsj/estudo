<?php

//include 'funcoes.php'; // caso nao encontre, ele manda um warning e continua
//require 'funcoes.php'; // se n encotrar, nao continua, da erro.
require_once 'funcoes.php'; // so importa se ainda nao tiver sido importado.

$contasCorrentes = [
    '123.456.789-10' => [
        'titular' => 'Maria',
        'saldo' => 10000
    ],
    '123.456.689-11' => [
        'titular' => 'Alberto',
        'saldo' => 300
    ],
    '123.256.789-12' => [
        'titular' => 'Vinicius',
        'saldo' => 100
    ]
];


$contasCorrentes['123.456.789-10'] = sacar(
    $contasCorrentes['123.456.789-10'],
    500
);

$contasCorrentes['123.456.689-11'] = sacar(
    $contasCorrentes['123.456.689-11'],
    200
);

$contasCorrentes['123.256.789-12'] = depositar(
    $contasCorrentes['123.256.789-12'],
    900
);

titularComLetrasMaiusculas($contasCorrentes['123.256.789-12']);

foreach ($contasCorrentes as $cpf => $conta) {
    //exibeMensagem("$cpf $conta[titular] $conta[saldo]"); // forma 1
    exibeMensagem("$cpf {$conta['titular']} {$conta['saldo']}"); // forma 2
}




