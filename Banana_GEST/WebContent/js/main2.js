$(document).ready(function() {
	//Clear console
	//console.clear();
	
	$.ajax({
        url: "http://localhost:8080/Banana_GEST/ObtainPost", //Aquí la ruta exacta de su servlet
        type: "POST",
        //Qué espero recibir de la ruta
        contentType: "application/json",
        //Que tipo de datos te voy a enviar
        dataType: "json",
        data: JSON.stringify({}),

        //Servlet existe y me devolvió un JSON
        success: function (data, textStatus, jqXHR) {
        	console.log("Aquí vamos a obtener y renderear los posts");
        	//En data llegarán los posts desde el servlet
        	console.log(data);
        	
        	for(var idx = 0; idx < data.length; idx++)
        		{
        		 var htmlElement = 
		                '<div id="mi-post-'+ data[idx].id + '" class="container mi-post">' +
		            '<div class="row">' +
		                '<div class="col-4">' +
		                    '<img src="img/author1.jpeg">' +
		                '</div>' +
		                '<div class="col-4">' +
		                    '<b>Publicado el </b><label class="h-date-pr" data-date=""> alguna fecha </label><br>' +
		                    '<b>Hace </b><label class="h-date-tp" data-date="">algun momento</label><br>' +
		                '</div>' +
		                '<div class="col-3"><b>POST '+ data[idx].id + '</b></div>' +
		                '<div class="col-1">' +
		                    '<button class="btn btn-outline-danger btn-sm post-delete" data-numero="'+ data[idx].id + '">&times;</button>' +
		                '</div>' +
		            '</div>' +
		            '<div class="row">' +
		            '<div class="col-12 contenido-post" data-numero="' + data[idx].id + '" contenteditable>' + data[idx].content +'</div>' +
		            '</div>' +
		        '</div>';
        		 $("div#posts").append(htmlElement);
        		}
        },
        error: function (jqXHR, textStatus, errorThrown) {
            //console.log(jqXHR);
            //console.log(textStatus);
            //console.log(errorThrown);
        }
    });
    
	
	$("button#add-post").on("click", function(event){
		//console.log("Entré");
		//alert("Entro");
		
		// Obteniendo valor de un elemento por su tipo y su
		var postText = $("textarea#textoPost").val();
		
		//Quitamos espacios en blanco, a las orillas
		postText = $.trim(postText);
		
		//console.log(postText);
		
		//Si llega texto que agregar
		if(postText !== ""){
			//alert(postText);
			
			//Objeto a enviar al servlet
			var nuevaPublicacion = {
					"id"       : $("div.mi-post").length + 1,
					"contenido": postText	
			};
			
			//alert(nuevaPublicacion);
			console.log(nuevaPublicacion);
			
			 /* $.post(
					    "http://localhost:8080/Banana_GEST/NewPost", //apunta a mi servlet con esta info y el servet te regresará algo.
					    nuevaPublicacion,
					    function(data){
					        
					    	
					     console.log("Hola Callback");
					    	
					    	 var htmlElement = 
					                '<div id="mi-post-'+ nuevaPublicacion.id + '" class="container mi-post">' +
					            '<div class="row">' +
					                '<div class="col-4">' +
					                    '<img src="img/author1.jpeg">' +
					                '</div>' +
					                '<div class="col-4">' +
					                    '<b>Publicado el </b><label class="h-date-pr" data-date=""> alguna fecha </label><br>' +
					                    '<b>Hace </b><label class="h-date-tp" data-date="">algun momento</label><br>' +
					                '</div>' +
					                '<div class="col-3"><b>POST '+ nuevaPublicacion.id + '</b></div>' +
					                '<div class="col-1">' +
					                    '<button class="btn btn-outline-danger btn-sm post-delete" data-numero="'+ nuevaPublicacion.id + '">&times;</button>' +
					                '</div>' +
					            '</div>' +
					            '<div class="row">' +
					                '<div class="col-12 contenido-post" contenteditable>' + nuevaPublicacion.contenido +'</div>' +
					            '</div>' +
					        '</div>';
					    	 
					           $("div#posts").prepend(htmlElement);
					           //$(htmlElement).prependTo("div#posts");
					    	
					    },
					    "json"
					   );*/
			
			//Insertar nueva publicacion.
			
			 $.ajax({
	                url: "http://localhost:8080/Banana_GEST/NewPost", 
	                type: "POST",
	                //Qué espero recibir de la ruta
	                contentType: "application/json",
	                //Que tipo de datos te voy a enviar
	                dataType: "json",
	                data: JSON.stringify(nuevaPublicacion),

	                //Servlet existe y me devolvió un JSON
	                success: function(data, textStatus, jqXHR) {
	                    console.log("Si el acceso al servlet fue correcto");
	                    console.log(data.id); //data.dato
	                    
	                    var htmlElement = 
			                '<div id="mi-post-'+ data.id + '" class="container mi-post">' +
			            '<div class="row">' +
			                '<div class="col-4">' +
			                    '<img src="img/author1.jpeg">' +
			                '</div>' +
			                '<div class="col-4">' +
			                    '<b>Publicado el </b><label class="h-date-pr" data-date=""> alguna fecha </label><br>' +
			                    '<b>Hace </b><label class="h-date-tp" data-date="">algun momento</label><br>' +
			                '</div>' +
			                '<div class="col-3"><b>POST '+ data.id + '</b></div>' +
			                '<div class="col-1">' +
			                    '<button class="btn btn-outline-danger btn-sm post-delete" data-numero="'+ data.id + '">&times;</button>' +
			                '</div>' +
			            '</div>' +
			            '<div class="row">' +
			            '<div class="col-12 contenido-post" data-numero="' + data.id + '" contenteditable>' + data.content + '</div>' +
			            '</div>' +
			        '</div>';
			    	 
			           $("div#posts").prepend(htmlElement);
			           
			           //Dejar limpia el área de texto
			           $("textarea#textoPost").val("");
			           //Esconder modal
			           $("div#myModal").modal("hide");
	                    
	                },
	                error: function(jqXHR, textStatus, errorThrown) {
	                    console.log(jqXHR);
	                    console.log(textStatus);
	                    console.log(errorThrown);
	                }
	            });
			
		//Si la publicación está vacía	
		} else{
			alert("Agrega texto no seas flojo");
		}
		
		

	});
	
	 /* ------------------------------------------------------------------------------ *\
    Borrar un nuevo post, al hacer click en el botón agregar
\* ------------------------------------------------------------------------------ */

$("div#posts").on("click", "button.post-delete", function(event) {
    // Entramos a ejecutar las acciones, sólo si el usuario acepta
    if (confirm("Estás seguro?")) {
        // Armar dinámicamente el id del post a eliminar
        // Junto con el número desde el data-numero del botón clickeado
        var numero = $(this).data("numero");
        // console.log(id);
        
        // Generar JSON a enviar
        var jsonSend = {
            "id": numero
        };
        
        // console.log(jsonSend);
        
        $.ajax({
            url         : "http://localhost:8080/Banana_GEST/RemovePost", //Aquí la ruta exacta de su servlet
            type        : "POST",
            // Qué espero recibir de la ruta
            contentType : "application/json",
            // Que tipo de datos te voy a enviar
            dataType    : "json",
            data        : JSON.stringify(jsonSend),

            // Servlet existe y me devolvió un JSON
            success     : function (data, textStatus, jqXHR) {
                var divPost = "div#mi-post-" + data.id;
                console.log(divPost);
                $(divPost).remove();
            },
            error       : function (jqXHR, textStatus, errorThrown) {
                // console.log(jqXHR);
                // console.log(textStatus);
                // console.log(errorThrown);
            }
        });
    }
});

/* ------------------------------------------------------------------------------ *\
Modificar post, al hacer click y abandonar la caja de texto
\* ------------------------------------------------------------------------------ */

// Variable para guardar el contenido del post al hacerle click
var GLOBALLastPostContent = "";

// Click en el contenido del post
$("div#posts").on("click", "div.contenido-post", function (event) {
// console.log("Click contenido");
// Quedarse con el contenido al hacer click
GLOBALLastPostContent = $(this).html();
// console.log(GLOBALLastPostContent);
});

// Salir del focus del contenido del post
$("div#posts").on("blur", "div.contenido-post", function (event) {
// console.log("Abandonar contenido");

// Obtenemos el nuevo contenido
var newContent = $(this).html();

//console.log(newContent);

//Quitar todos los espacios en formato html &nbsp;
newContent = newContent.replace(new RegExp("&nbsp;", 'g'), " "); //g te intercambia los nbsp por espacios en blanca

// Borramos los espacios al principio y al final
newContent = $.trim(newContent);

// Antes que nada hay que asegurarnos de que el nuevo contenido no esté vacío
if (newContent === "") {
    // sólo lanzaremos una alerta indicándolo
    alert("El nuevo contenido no puede ser vacío.");
    
    // Reestablecemos el contenido con el contenido original
    $(this).html(GLOBALLastPostContent);
    
// Si el nuevo contenido no está vacío
} else {
    
    // Comparamos la igualdad con el valor anterior
    if (newContent === GLOBALLastPostContent) {
        // En realidad no se hizo cambio alguno,
        // pero sustituiremos para evitar posibles espacios extras
        $(this).html(GLOBALLastPostContent);
        
        // Sólo se limpia la variable global
        GLOBALLastPostContent = "";
    
    // Si el contenido cambió
    } else {
        // Obtener id post
        var id = $(this).data("numero");
        // console.log(id);
        // Json para enviar al servlet
        var jsonSend = {
            "id"      : id,
            "content" : newContent
        };
        
        // console.log(jsonSend);
        
        $.ajax({
            url         : "http://localhost:8080/Banana_GEST/ModifyPost", //Aquí la ruta exacta de su servlet
            type        : "POST",
            // Qué espero recibir de la ruta
            contentType : "application/json",
            // Que tipo de datos te voy a enviar
            dataType    : "json",
            data        : JSON.stringify(jsonSend),

            // Servlet existe y me devolvió un JSON
            success     : function (data, textStatus, jqXHR) {
                //console.log("Entramos");
                // console.log(data);
                
                // Sustituimos el contenido HTML de nuestro div con el nuevo valor
                $(this).html(data.content);
                // Como ya se acabó el proceso, limpiamos la variable global
                GLOBALLastPostContent = "";
            },
            error       : function (jqXHR, textStatus, errorThrown) {
                // console.log(jqXHR);
                // console.log(textStatus);
                // console.log(errorThrown);
            }
        });
        
    }

}

});
	
});

