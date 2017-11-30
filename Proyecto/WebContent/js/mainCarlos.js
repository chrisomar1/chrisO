$(document).ready(function() {//Entra hasta que la pagina se cargó

	$("button#add-user")
	//Selector
	.on("click", //Evento a manejar
	function(event) {
		var estadoEmail=1;

		saveName = $("input#nombre").val(); //Estamos apuntando al textarea. Devuelve un string
		saveName = $.trim(saveName); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

		saveCorreo = $("input#correo").val(); //Estamos apuntando al textarea. Devuelve un string
		saveCorreo = $.trim(saveCorreo); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

		saveContrasena = $("input#contrasena").val(); //Estamos apuntando al textarea. Devuelve un string
		saveContrasena = $.trim(saveContrasena); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

		var nuevaPublicacion = {
			"nombre" : saveName,
			"correo" : saveCorreo,
			"contrasena" : saveContrasena,
		//saveAddall

		};

		//alert(nuevaPublicacion);
		//alert(nuevaPublicacion);
		
		//Verificar correo:
		
		  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;

		    if (regex.test($("input#correo").val().trim())) {
		        console.log('Correo validado');

		    } else {
		    	
		    	if(saveCorreo!=="")
		    		{
			        	alert('La direccion de correo no es valida');
			        	estadoEmail=0;
		    		}

		    }


		if (saveName !== "" && saveCorreo !== "" && saveContrasena !== ""&&estadoEmail!=0) {
			console.log(saveName);
			console.log(saveCorreo);
			console.log(saveContrasena);

			//Insertar nueva publicacion.

			$.ajax({
				url : "http://localhost:8080/Proyecto/AgregarUsuario",
				type : "POST",
				//Qué espero recibir de la ruta
				contentType : "application/json",
				//Que tipo de datos te voy a enviar
				dataType : "json",
				data : JSON.stringify(nuevaPublicacion),

				//Servlet existe y me devolvió un JSON
				success : function(data, textStatus, jqXHR) {
					console.log("Si el acceso al servlet fue correcto");
					setTimeout(console.log(data), 10000);
					//console.log(data); //data.dato
					alert("Usuario agregado correctamente");

				},
				error : function(jqXHR, textStatus, errorThrown) {
					//console.log(data);
					console.log(jqXHR);
					console.log(textStatus);
					console.log(errorThrown);
				}
			});

		} else {
			if(estadoEmail!=0)
			alert("Debes completar todos los campos para poder continuar.");

		}

	}); //Funcion para manejar un evento

	$("button#login-user")
	//Selector
	.on("click", //Evento a manejar
	function(event) {

		saveCorreo1 = $("input#correologin").val(); //Estamos apuntando al textarea. Devuelve un string
		saveCorreo1 = $.trim(saveCorreo1); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.
		//saveCorreo1 = utf8_encode(saveCorreo1);

		saveContrasena1 = $("input#contrasenalogin").val(); //Estamos apuntando al textarea. Devuelve un string
		saveContrasena1 = $.trim(saveContrasena1); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

		var nuevaPublicacion = {
			"correo" : saveCorreo1,
			"contrasena" : saveContrasena1,
		//saveAddall

		};

		//alert(nuevaPublicacion);
		//alert(nuevaPublicacion);

		if (saveCorreo1 !== "" && saveContrasena1 !== "") {
			console.log(saveCorreo1);
			console.log(saveContrasena1);

			//Insertar nueva publicacion.

			$.ajax({
				url : "http://localhost:8080/Proyecto/BuscarUsuario",
				type : "POST",
				//Qué espero recibir de la ruta
				contentType : "application/json",
				//Que tipo de datos te voy a enviar
				dataType : "json",
				data : JSON.stringify(nuevaPublicacion),

				//Servlet existe y me devolvió un JSON
				success : function(data, textStatus, jqXHR) {
					console.log("Si el acceso al servlet fue correcto");
					console.log(data); //data.dato
					if(data.correo=="error"||data.contrasena=="error")
						{
							alert("Usuario y/o contraseña incorrecta");
						}
					else
						alert("Acceso correcto");

				},
				error : function(jqXHR, textStatus, errorThrown) {
					//console.log(data);
					console.log(jqXHR);
					console.log(textStatus);
					console.log(errorThrown);
				}
			});

		} else {
			
			
				alert("Debes completar todos los campos para poder continuar.");

		}

	}); //Funcion para manejar un evento

});
