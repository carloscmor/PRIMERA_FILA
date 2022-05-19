//* Función que cambia el tema.
export default function cambiar_tema(nodo, accionador, logo) {
	const tema_oscuro = "estilos/oscuro.css";
	const tema_claro = "estilos/claro.css";
	const icono_oscuro = "archivos/vectores/modo_oscuro.svg";
	const icono_claro = "archivos/vectores/modo_claro.svg";
	const alternativa_oscuro = "Cambiar a modo oscuro";
	const alternativa_claro = "Cambiar a modo claro";
	const logo_oscuro = "archivos/Logo oscuro.png";
	const logo_claro = "archivos/logo claro.png";

	if (nodo.getAttribute("href") === tema_oscuro) {
		nodo.setAttribute("href", tema_claro);
		accionador.setAttribute("src", icono_oscuro);
		accionador.setAttribute("alt", alternativa_oscuro);
		accionador.setAttribute("title", alternativa_oscuro);
		logo.setAttribute("src", logo_claro);
	} else {
		nodo.setAttribute("href", tema_oscuro);
		accionador.setAttribute("src", icono_claro);
		accionador.setAttribute("alt", alternativa_claro);
		accionador.setAttribute("title", alternativa_claro);
		logo.setAttribute("src", logo_oscuro);
	}
}