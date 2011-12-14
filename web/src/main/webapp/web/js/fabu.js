// JavaScript Document
var map;

var initialLocation;
var siberia = new google.maps.LatLng(60, 105);
var newyork = new google.maps.LatLng(40.69847032728747, -73.9514422416687);
var browserSupportFlag =  new Boolean();

var leftTop;
var rightBottom;
var bermudaTriangle = new google.maps.Polygon({
		strokeColor: "#FF0000",
		strokeOpacity: 0.5,
		strokeWeight: 2,
		fillColor: "#FF0000",
		fillOpacity: 0.35,
		clickable:false
	  });
var triangleCoords;
var isDragging=false;

function initialize() {
  var myOptions = {
    zoom: 12,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
  
  // Try W3C Geolocation (Preferred)
  if(navigator.geolocation) {
    browserSupportFlag = true;
    navigator.geolocation.getCurrentPosition(function(position) {
      initialLocation = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
      var infowindow = new google.maps.InfoWindow({
      	map: map,
        position: initialLocation,
        content: 'You are here! Location found using HTML5.'
      });	  
      map.setCenter(initialLocation);
    }, function() {
      handleNoGeolocation(browserSupportFlag);
    });
  // Try Google Gears Geolocation
  } else if (google.gears) {
    browserSupportFlag = true;
    var geo = google.gears.factory.create('beta.geolocation');
    geo.getCurrentPosition(function(position) {
      initialLocation = new google.maps.LatLng(position.latitude,position.longitude);
      var infowindow = new google.maps.InfoWindow({
      	map: map,
        position: initialLocation,
        content: 'You are here! Location found using Google Gears.'
      });		  
      map.setCenter(initialLocation);
    }, function() {
      handleNoGeoLocation(browserSupportFlag);
    });
  // Browser doesn't support Geolocation
  } else {
    browserSupportFlag = false;
    handleNoGeolocation(browserSupportFlag);
  }
  
  function handleNoGeolocation(errorFlag) {
    if (errorFlag == true) {
      alert("Geolocation service failed.");
      initialLocation = newyork;
    } else {
      alert("Your browser doesn't support geolocation. We've placed you in Siberia.");
      initialLocation = siberia;
    }
    map.setCenter(initialLocation);
  }

  //½ûÖ¹ÍÏ¶¯
  google.maps.event.addListener(map, 'center_changed', function() { 													
	if(isDragging){
		map.panTo(initialLocation);
	}
  }); 
  google.maps.event.addListener(map, 'mousedown', function(event) {
	if(!event.latLng.equals(rightBottom)){													   
		isDragging=true;	
		initialLocation=map.getCenter();	
		mousedown(event,map);
	}
  });
  google.maps.event.addListener(map, 'mouseup', function(event) {												 
    mouseup(event);
	isDragging=false;
	alert("leftTop is "+leftTop.toString()+",    rightBottom is "+rightBottom.toString());
  });
  google.maps.event.addListener(map, 'mousemove', function(event) {
	if(isDragging){		
    	mousemove(event,map);
	}
  });
}

google.maps.event.addDomListener(window, 'load', initialize);

function mousedown(event,map) {
	 bermudaTriangle.setMap(null);
	leftTop=event.latLng;
}
function mouseup(event) {
	
}
function mousemove(event,map) {
	
	rightBottom=event.latLng; 

	  triangleCoords = [
		leftTop,
		new google.maps.LatLng(rightBottom.lat(), leftTop.lng()),
		rightBottom,
		new google.maps.LatLng(leftTop.lat(), rightBottom.lng()),
		leftTop
	  ];
	 bermudaTriangle.setPath(triangleCoords);
	  bermudaTriangle.setMap(map);	
}