//* Función que cambia el tema.
export default function cambiar_tema(nodo, accionador) {
	const tema_oscuro = "estilos/oscuro.css";
	const tema_claro = "estilos/claro.css";
	const icono_oscuro = "archivos/vectores/modo_oscuro.svg";
	const icono_claro = "archivos/vectores/modo_claro.svg";
	const alternativa_oscuro = "Cambiar a modo oscuro";
	const alternativa_claro = "Cambiar a modo claro";

	if (nodo.getAttribute("href") === tema_oscuro) {
		nodo.setAttribute("href", tema_claro);
		accionador.setAttribute("src", icono_oscuro);
		accionador.setAttribute("alt", alternativa_oscuro);
		accionador.setAttribute("title", alternativa_oscuro);
	} else {
		nodo.setAttribute("href", tema_oscuro);
		accionador.setAttribute("src", icono_claro);
		accionador.setAttribute("alt", alternativa_claro);
		accionador.setAttribute("title", alternativa_claro);
	}
}