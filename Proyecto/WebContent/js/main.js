$(document)
		.ready(
				function() {//Entra hasta que la pagina se cargó

					var arregloDeObjetos = [];//Guardar registros del formulario
					var arregloMiembros = [];
					var contador = 0;
					var bandera = 1;
					var camposCompletos=0;
					var temporal = "";
					var saveName = "";
					var saveDesc = "";
					var saveStart = "";
					var saveEnd = "";

					$("span#add")
							//Selector
							.on(
									"click", //Evento a manejar
									function(event) { //Función manejadora

										//alert("Hola");

										var saveAdd = $(
												"input#inputNombreMiembro")
												.val(); //Estamos apuntando al textarea. Devuelve un string
										saveAdd = $.trim(saveAdd); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

										if (saveAdd != "") {
											saveAdd = {
												"id" : saveAdd
											};
											//Ajax para verificar si existe el id del miembro en la bd.
											$
													.ajax({
														url : "http://localhost:8080/Proyecto/BuscarProyecto",
														type : "POST",
														//Qué espero recibir de la ruta
														contentType : "application/json",
														//Que tipo de datos te voy a enviar
														dataType : "json",
														data : JSON
																.stringify(saveAdd),

														//Servlet existe y me devolvió un JSON
														success : function(
																data,
																textStatus,
																jqXHR) {
															console
																	.log("Si el acceso al servlet fue correcto");
															console.log(data); //data.dato

															if ((data.id)
																	.localeCompare("error")) {
																console
																		.log("good");
																
																temporal= $(
																"input#inputNombreMiembro")
																.val(); 
																
																//Si el id de usuario sí existe en la bd procedemos a verificar que no se encuentre ya agregado en el arreglo de miembros.
																
																for(var j= 0; j<contador; j++)
																	{
																		if(!arregloMiembros[j].localeCompare(temporal))
																			{
																				console.log("Este usuario ya fue agregado a la lista anteriormente");
																				alert("Este usuario ya fue agregado a la lista anteriormente")
																				bandera = 0;
																				
																			}
																		else
																			{
																			console.log("Usuario agregado exitosamente");
																			//bandera = 1;

																			}
																																			}
																
																if(bandera!=0)	{
																	
																	arregloMiembros[contador] = temporal;
																	arregloMiembros[contador] = $.trim(arregloMiembros[contador]);
																	contador++;
																	console.log("contador:"+arregloMiembros[contador-1]);
																	var html = $(
																			"textarea#exampleFormControlTextarea2")
																			.html();
																	$(
																			"textarea#exampleFormControlTextarea2")
																			.append(

																					data.id
																							+ "\t"
																									+data.nombre 
																													+"\n"

																			);

																	$(
																			"input#inputNombreMiembro")
																			.val("");
													
																	
																}
																				
																bandera = 1;

															} else {
																console
																		.log("bad");
																alert("Id de usuario no existe");
																$(
																		"input#inputNombreMiembro")
																		.val("");
															}

														},
														error : function(jqXHR,
																textStatus,
																errorThrown) {
															console.log(jqXHR);
															console
																	.log(textStatus);
															console
																	.log(errorThrown);
														}
													});

										} else {
											alert("Introduce un nombre válido");
										}

									}); //Funcion para manejar un evento

					$("button#add-info")
							//Selector
							.on(
									"click", //Evento a manejar
									function(event) { //Función manejadora

										saveName = $(
												"input#inputNombreProyecto")
												.val(); //Estamos apuntando al textarea. Devuelve un string
										saveName = $.trim(saveName); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

										saveDesc = $(
												"textarea#exampleFormControlTextarea1")
												.val(); //Estamos apuntando al textarea. Devuelve un string
										saveDesc = $.trim(saveDesc); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

										saveStart = $(
												"input#inputStartDate").val(); //Estamos apuntando al textarea. Devuelve un string
										saveStart = $.trim(saveStart); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

										saveEnd = $("input#inputEndDate")
												.val(); //Estamos apuntando al textarea. Devuelve un string
										saveEnd = $.trim(saveEnd); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

										var saveAddall = $(
												"textarea#exampleFormControlTextarea2")
												.val(); //Estamos apuntando al textarea. Devuelve un string
										saveAddall = $.trim(saveAddall); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

										if (saveName !== "" && saveDesc !== ""
												&& saveStart !== ""
												&& saveEnd !== ""
												&& saveAddall !== "") {
											console.log(saveName);
											console.log(saveDesc);
											console.log(saveStart);
											console.log(saveEnd);
											console.log(saveAddall);
											camposCompletos=1;


											//Insertar nueva publicacion.

											var html = $("div#posts").html();
											$("div#posts")
													.prepend(

															'<label class = "form-control-label" for = "textoPost">¿Deseas agregar el siguiente registro?</label>'
																	+

																	'<textarea class = "form-control" id="textoPost">'
																	+

																	'Nombre de Proyecto: '
																	+ saveName
																	+ '\n'
																	+ 'Descripcion: '
																	+ saveDesc
																	+ '\n'
																	+ 'Fecha de Inicio: '
																	+ saveStart
																	+ '\n'
																	+ 'Fecha de Termino: '
																	+ saveEnd
																	+ '\n'
																	+ 'Miembros: '
																	+ "\n"
																	+ saveAddall
																	+

																	'</textarea>');

											

										} else {
												
											for(x=0;x<contador;x++)
											{
												console.log(arregloMiembros[x]);
											}
											//alert("Debes completar todos los campos para poder continuar.");
											var html = $("div#posts").html();
											$("div#posts").prepend(

													'<textarea class = "form-control" id="textoPost">'
															+

															'Debes completar todos los campos para poder continuar.'
															+

															'</textarea>'

											);

										}

									}); //Funcion para manejar un evento
					
					$("button#add-post")
					//Selector
					.on(
							"click", //Evento a manejar
							function(event) { //Función manejadora
								
								if(camposCompletos==1)
									{
									//Objeto a enviar al servlet
									var nuevaPublicacion = {
										"nombreproyecto" : saveName,
										"descripcion" : saveDesc,
										"fechainicio" : saveStart,
										"fechafin" : saveEnd,
										"estado" : "1",
										"miembros" : "3"   //saveAddall

									};

									//alert(nuevaPublicacion);
									alert(nuevaPublicacion);
									
									$
									.ajax({
										url : "http://localhost:8080/Proyecto/AgregarProyecto",
										type : "POST",
										//Qué espero recibir de la ruta
										contentType : "application/json",
										//Que tipo de datos te voy a enviar
										dataType : "json",
										data : JSON
												.stringify(nuevaPublicacion),

										//Servlet existe y me devolvió un JSON
										success : function(
												data,
												textStatus,
												jqXHR) {
											console
													.log("Si el acceso al servlet fue correcto");
											console.log(data); //data.dato

										},
										error : function(jqXHR,
												textStatus,
												errorThrown) {
											console.log(jqXHR);
											console
													.log(textStatus);
											console
													.log(errorThrown);
										}
									});

									}
								camposCompletos=0;
								
							});
					
					$("button#close-post")
					//Selector
					.on(
							"click", //Evento a manejar
							function(event) { //Función manejadora
								
								//AGREGAR CODIGO PARA QUE NO APILE LAS CAJAS DE TEXTO DESPUES DE DARLE CANCELAR A GUARDAR REGISTROS Y DESPUES QUERER VOLVER A GUARDARLOS.
								saveName = "";
								saveDesc = "";
								saveStart = "";
								saveEnd = "";
							});

				});
