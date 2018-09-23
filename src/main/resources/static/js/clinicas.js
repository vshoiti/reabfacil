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
        let isFirst = myElem === null;

        if (isFirst){
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
            $('<a></a>').addClass("list-group-item").attr("href", "#").attr('id', (idClinica + idUni)).attr('value',idUni)
        ))

        //Adiciona nome unidade

        var idUnidade = "#" + (idClinica + idUni);
        $(idUnidade).ready($(idUnidade).append(
            $('<h4></h4>').addClass("list-group-item-heading pb-3 pt-2").html(unidade.nome)
            ),
            //Adiciona endereço unidade
            $(idUnidade).append(
                $('<p></p>').addClass("list-group-item-text m-1").html(unidade.endereco)
            )
        )

        // Fixa o item como primeiro filho manualmente
        if (isFirst) {
            console.log("aaa")
            $(idUnidade).addClass('first-child');
        }
    })
}