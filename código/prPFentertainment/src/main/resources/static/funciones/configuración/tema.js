//* Función que cambia el tema.
export default function cambiar_tema(css) {
	if (css.getAttribute("href") === "estilos/oscuro.css") {
		css.setAttribute("href", "estilos/claro.css");
	} else {
		css.setAttribute("href", "estilos/oscuro.css");
	}
}