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

function reverseGeocode() {
    var geocoder = new google.maps.Geocoder;
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
                lat: parseFloat(position.coords.latitude),
                lng: parseFloat(position.coords.longitude)
            }
        geocoder.geocode({'location': pos}, function(results, status) {
            console.log(pos);
            if(status === 'OK') {
                if (results[0]){
                    results.forEach(function(element){
                        element.address_components.forEach(function(element2){
                            element2.types.forEach(function(element3){
                                switch(element3){
                                    case 'locality':
                                        endereco = element2.long_name;
                                        enviaLocalizacao(endereco);
                                        break;
                                }
                            })
                        });
                    });
                } else {
                    alert('No results found');
                }
            }else {
                alert('Geocoder failed due to: ' + status);
            }
        });
        });
    }
}





// No HTMl utilize o seguinte:
// <div id="map" style="width:500px;height:250px"></div>
//     <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCfv8SEY0CVK5QIY9TfKd7ulkK7RVzNoYA&callback=initMap"
// async defer></script>