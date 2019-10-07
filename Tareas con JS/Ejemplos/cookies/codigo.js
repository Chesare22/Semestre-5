var Ofertas = new Array ()
Ofertas [0] = "50% de descuento en juguetes"
Ofertas [1] = "10% de descuento en pago en efectivo"
Ofertas [2] = "5% de descuento en pagos con tarjeta"

var Noticias = new Array ()
Noticias [0] = "Tenemos nueva mercancía"
Noticias [1] = "Ya llegaron los arbolitos navideños"
Noticias [2] = "Fiesta este fin de semana por aniversario"

//función para leer cookies
function GetCookie (name, InCookie) {
	var prop = name + "="; // propiedad buscada
	var plen = prop.length;
	var clen = InCookie.length;
	var i=0;
	if (clen>0) { // Cookie no vacío
		i = InCookie.indexOf(prop,0); // aparición de la propiedad
		if (i!=-1) { // propiedad encontrada
			// Buscamos el valor correspondiente
			j = InCookie.indexOf(";",i+plen);
			if(j!=-1) // valor encontrado
				return unescape(InCookie.substring(i+plen,j));
			else //el último no lleva ";"
				return unescape(InCookie.substring(i+plen,clen));
		}
		else
			return "";
	}
	else
		return "";
}

//función para escribir cookies
function SetCookie (name, value) {
	// número de parámetros variable.
	var argv = SetCookie.arguments;
	var argc = SetCookie.arguments.length;
	// asociación de parámetros a los campos cookie. 
	var expires = (argc > 2) ? argv[2] : null
	var path = (argc > 3) ? argv[3] : null
	var domain = (argc > 4) ? argv[4] : null
	var secure = (argc > 5) ? argv[5] : false
	// asignación de la propiedad tras la codificación URL
	document.cookie = name + "=" + escape(value) +
		((expires==null) ? "" : ("; expires=" + expires.toGMTString())) +
		((path==null) ? "" : (";path=" + path)) +
		((domain==null) ? "" : ("; domain=" + domain)) +
		((secure==true) ? "; secure" : "");
}

function EstablecerPresentacion() {
	SetCookie("estilo", presentacion.estilo.value)
	SetCookie("elemento", presentacion.estilo.selectedIndex)
	SetCookie("ofertas", presentacion.ofertas.checked)
	SetCookie("noticias", presentacion.noticias.checked)

	window.location.reload()
}

function EscribirEstilo() {
	var estilo
	var cadena

	estilo = GetCookie("estilo",document.cookie)

	if ( estilo == "" ) {
		cadena = "<link rel=\"stylesheet\" href=\"estilos.css\" type=\"text/css\">"
	} else {
		cadena = "<link rel=\"stylesheet\" href=\"" + estilo + "\" type=\"text/css\">"
	}
	document.writeln (cadena)
}

function EscribirOfertas() {
	var ofertas
	var cadena = ""
	var contador

	document.writeln ("<h1>Ofertas</h1>")
	ofertas = GetCookie("ofertas",document.cookie)
	if ( ofertas == "true" ) {
		cadena="<ul>"
		for (contador=0; contador < Ofertas.length; contador++)
			cadena = cadena + "<li>" + Ofertas [contador] + "</li>" + "\n"
		cadena= cadena + "</ul>"
	}
	document.writeln (cadena)
}

function EscribirNoticias() {
	var noticias
	var cadena = ""
	var contador

	document.writeln ("<h1>Noticias</h1>")
	noticias = GetCookie("noticias",document.cookie)
	if ( noticias == "true" ) {
		cadena="<ul>"
		for (contador=0; contador < Noticias.length; contador++)
			cadena = cadena + "<li>" + Noticias [contador] + "<li>" + "\n"
		cadena= cadena + "</ul>"
	}
	document.writeln (cadena)
}

function DefinirForma() {
	presentacion.estilo.selectedIndex = GetCookie("elemento", document.cookie)
	presentacion.ofertas.checked = eval(GetCookie("ofertas", document.cookie))
	presentacion.noticias.checked = eval(GetCookie("noticias", document.cookie))
}