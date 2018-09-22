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