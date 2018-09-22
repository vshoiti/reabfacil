window.onload = function() {
  inicializaDropdown();
};
    function inicializaDropdown(){
        const url = 'http://localhost:8080/api/tratamento';

        $.getJSON(url, function (data) {
           console.log(data)
           $.each(data, function (index, tratamento) {
                console.log(tratamento.nome);
                $('#dropdown').append(
                     $('<option></option>').val(tratamento.nome).html(tratamento.nome)
                 );
           });
        });
    }


function enviaLocalizacao(endereco){
    var tratamento = $('#dropdown').find(":selected").text();

    var stringParams = window.location.href;
    var paramsBusca = new URLSearchParams(stringParams.search());

    paramsBusca.append("cidade", endereco);
    paramsBusca.append("tratamento", tratamento);

    var novoLink = "clinicas.html" + "?" + paramsBusca.toString();
    window.location.href =  novoLink;
}

