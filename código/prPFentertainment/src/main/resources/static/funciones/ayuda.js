//* Texto superior que proporciona información del objeto en cuestión.
export default function crear_ayuda() {
	const bloque = document.createElement("p");
	bloque.setAttribute("class", "ayuda");

	let defecto = "AYUDADADADADADADA";
	bloque.textContent = defecto;
	// Escucha del propio cuadro de ayuda.
	bloque.addEventListener("mouseover", () => {
		bloque.textContent = defecto;
	});
	// Se devuelve para escuchar al resto.
	return bloque;
}