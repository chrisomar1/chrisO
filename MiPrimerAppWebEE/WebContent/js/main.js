$(document).ready(function(){//Entra hasta que la pagina se cargó
    var arregloDeObjetos = [];//Guardar posts


    //------Validar evento click guardar post  

    $("button#add-post") //Selector
    .on(     //Metodo on
        "click",         //Evento a manejar
        function( event ){    //Función manejadora

           // console.log("Hiciste click en guardar");
                //var postText = $("#textoPost");
    var postText = $("textarea#textoPost").val(); //Estamos apuntando al textarea. Devuelve un string
    postText =  $.trim(postText); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

    //Si hay contenido que publicar
    //"     " !== ""
    if(postText !== "")
    {
        console.log($("div.mi-post").length + 1);
        //Empieza lo bueno
        //Nuestro nuevo post 
    var nuevoPost = {
        //numero: arregloDeObjetos.length + 1,
        numero: $("div.mi-post").length + 1,
        contenido: postText
    };
   // console.log("Estamos listos");
    //console.log("Contenido",postText);
    console.log(arregloDeObjetos); //nuevoPost
    //arregloDeObjetos[arregloDeObjetos.length] = nuevoPost;
    //numeroPost++;

        //Obtienes contenido HTML
    var html = $("div#posts").html();
    //console.log(html);

    //Editas contenido HTML
    //$("div#posts").html("<h1>Publicacion</h1>");

   // $("div#posts").prepend("<h1>Publicacion"+(arregloDeObjetos.length+1)+"</h1>"); //Apila los comentarios

   $("div#posts").prepend(
       '<div id="mi-post-'+ nuevoPost.numero +'"class= "container mi-post">'+ 
            '<div class="row">'+
                            '<div class="col-5">'+
                                '<img src="img/author1.jpeg">'+
                            '</div>'+
                            '<div class="col-5">'+
                                    'Texto 1<br>'+
                                    'Post #'+
                                    nuevoPost.numero+
                            '</div>'+
                            '<div class="col-2">'+
                            '<button class= "btn btn-outline-danger btn-sm   post-delete" data-numero="'+nuevoPost.numero+'">&times;</button>'+
                    '</div>'+
                        '</div>'+
                        '<div class="row">'+
                                '<div class="col-12">'+
                                        nuevoPost.contenido+
                                '</div>'+
                        '</div>'+
        '</div>'
   );

   //Para limpiar la caja de texto una vez que se agrego al home
   //var postText = $("textarea#textoPost").val("");
   $("textarea#textoPost").val("");
   //Clickear botón cerrar.
   //$("button#close-post").click();

   $("div#myModal").modal("hide");

    }
    else
    {
        alert("Escribe algo");
    }

    

    });  //Funcion para manejar un evento

    $("div#posts") //En que contenedor lo vamos a buscar, en donde se inyectó
    .on(
        "click", //Evento a validar
        "button.post-delete", //Botón o elemento a validar
       function(event){ //Función manejadora
        //console.log("Ya te vas a ir");
        //$("div.mi-post").remove();
        //$(this).parent();


        if(confirm("Estás seguro?")){

        //Nos traemos el atributo data-numero
        var numero = $(this).data("numero");
        //data.saludo
        //var saludo = $(this).data("saludo");
        var miId = "div#mi-post-" + numero;
        console.log(miId);

        $(miId).remove();

        }

    });

}); //Cerrar sesion JQuery