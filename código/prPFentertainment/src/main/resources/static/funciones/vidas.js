//* Creación del bloque vidas.
export default function crear_vidas(número_vidas) {
	const bloque = document.createElement("div");
	bloque.setAttribute("class", "vidas");

	const cantidad_vidas = document.createElement("span");
	cantidad_vidas.setAttribute("class", "número_vidas");
	cantidad_vidas.textContent = número_vidas;

	const corazón = document.createElement("img");
	corazón.setAttribute("src", "archivos/corazón.png");
	corazón.setAttribute("class", "corazón");

	bloque.appendChild(cantidad_vidas);
	bloque.appendChild(corazón);

	return bloque;
}