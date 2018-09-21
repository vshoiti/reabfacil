window.onload = function() {
  inicializaDropdown();
};
    var map, infoWindow;
                    function initMap() {
                        map = new google.maps.Map(document.getElementById('map'), {
                            zoom: 14
                        });
                        infoWindow = new google.maps.InfoWindow;

                        // Try HTML5 geolocation.
                        if (navigator.geolocation) {
                            navigator.geolocation.getCurrentPosition(function(position) {
                                var pos = {
                                    lat: position.coords.latitude,
                                    lng: position.coords.longitude
                                };

                                infoWindow.setPosition(pos);
                                infoWindow.setContent('Você está aqui.');
                                infoWindow.open(map);
                                map.setCenter(pos);
                            }, function() {
                                handleLocationError(true, infoWindow, map.getCenter());
                            });
                        } else {
                            // Browser doesn't support Geolocation
                            handleLocationError(false, infoWindow, map.getCenter());
                        }
                    }

                    function handleLocationError(browserHasGeolocation, infoWindow, pos) {
                        infoWindow.setPosition(pos);
                        infoWindow.setContent(browserHasGeolocation ?
                            'Error: The Geolocation service failed.' :
                            'Error: Your browser doesn\'t support geolocation.');
                        infoWindow.open(map);
                    }
                    
        function inicializaDropdown(){           
        let dropdown = document.getElementById("dropdown");

        dropdown.empty();

        dropdown.append('<option selected="true" disabled>Escolha uma opção</option>');
        dropdown.prop('selectedIndex', 0);

        const url = 'http://localhost:8080/api/tratamentos';

        // Populate dropdown with list of provinces
        $.getJSON(url, function (data) {
          $.each(data, function (key, entry) {
            dropdown.append($('<option></option>').attr('value', entry.abbreviation).text(entry.name));
          })
        });
    }