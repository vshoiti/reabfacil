window.onload = function() {
    var paramsString = this.window.location.href;
    var searchParams = new URLSearchParams(paramsString);

    var filtros = {
        cidade: searchParams.get('cidade').toString() ,
        tratamento: searchParams.get('tratamento').toString(),
    };
    inicializaLista(filtros);
}; 
//Id do DIV onde a clinica fica é definido pelo seu ID
//Id do nome da clinica é seu id + nome.
function inicializaLista(filtros) {
    const url = 'http://localhost:8080/api/unidade';
    console.log(filtros);
    $.getJSON(url,filtros,function (data) {
        console.log(data)
        $.each(data, function (index, unidade) {
            const urlClinica = 'http://localhost:8080/api/clinica/' + unidade.idClinica;
            //Cria lista de clinica que ainda não existe
            listaClinica(urlClinica , unidade);
            }
        );
    });
}

function listaClinica(urlClinica , unidade) {
    $.getJSON(urlClinica,function (dataClinica) {

        var idUni = unidade.id.toString();
        var idClinica = dataClinica.id.toString();
        var nomeClinica = dataClinica.nome.toString();
        var myElem = document.getElementById(idClinica);

        if (myElem === null){
            // Clinica Ainda não listada
            $('#listaClinicas').append(
                $('<div></div>').attr('id',idClinica).addClass("list-group")
            ); //Criando DIV para Clinica.

            $('#'+idClinica).ready(
                $('#'+idClinica).append(
                    $('<h3></h3>').html(dataClinica.nome).attr('id',idClinica + nomeClinica)
                ))

        }

        $('#'+idClinica).ready(
            $('#'+idClinica).append(
            $('<a></a>').addClass("list-group-item").attr("href", "#").attr('id', idClinica + idUni)
        ))

        //Adiciona nome unidade
        $('#' + (idClinica + idUni)).ready($('#' + (idClinica + idUni)).append(
            $('<h4></h4>').addClass("list-group-item-heading").html(unidade.nome)
            ),
            //Adiciona endereço unidade
            $('#' + (idClinica + idUni)).append(
                $('<p></p>').addClass("list-group-item-text").html(unidade.endereco)
            )
        )
    })
}

function listaUnidade(unidade) {

    console.log(unidade);
    var idClinica = unidade.idClinica.toString();
    var idUnidade = unidade.id.toString();

    var teste = document.getElementById(idClinica);
    console.log(teste);
    //Pega div da clinica, e posta a unidade lá dentro
    $('#' + idClinica).append(
        $('<a></a>').addClass("list-group-item").attr('id', idUnidade).attr("href", "#")
    ); //Criando DIV para Clinica.


    //Criei o <a>, agora irei adicionar as informações dentro
    $('#' + idUnidade).append(
        $('<h4></h4>').html("Unidade " + unidade.nome)
    ); //Criando DIV para Clinica.
}