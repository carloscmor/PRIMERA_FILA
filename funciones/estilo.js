const cambiar_tema = document.getElementById("tema_botón");
const css = document.getElementById("tema_css");

cambiar_tema.addEventListener("click", () => {
	console.log(css.getAttribute("href"));
	if (css.getAttribute("href") === "estilos/oscuro.css") {
		css.setAttribute("href", "estilos/claro.css");
	} else {
		css.setAttribute("href", "estilos/oscuro.css");
	}
})