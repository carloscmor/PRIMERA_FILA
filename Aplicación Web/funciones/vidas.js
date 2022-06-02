//* Creación del bloque vidas.
export default function crear_vidas(número_vidas, ayuda) {
	const bloque = document.createElement("div");
	bloque.setAttribute("class", "vidas");
	// El número de vidas.
	const cantidad_vidas = document.createElement("span");
	cantidad_vidas.setAttribute("class", "número_vidas");
	cantidad_vidas.textContent = número_vidas;
	// La imagen del corazón.
	const corazón = document.createElement("img");
	corazón.setAttribute("src", "archivos/corazón.png");
	corazón.setAttribute("class", "corazón");

	bloque.appendChild(cantidad_vidas);
	bloque.appendChild(corazón);
	// Escucha del cuadro de ayuda.
	bloque.addEventListener("mouseover", () => {
		ayuda.textContent = "Esta son las vidas que tienes. Partes de tener 3 vidas y puedes perder una vida si fallas una preguntas, por lo que perderás la partida si te quedas sin ninguna.";
	});

	return bloque;
}