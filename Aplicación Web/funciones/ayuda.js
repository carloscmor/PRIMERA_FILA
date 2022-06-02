//* Texto superior que proporciona información del objeto en cuestión.
export default function crear_ayuda() {
	const bloque = document.createElement("p");
	bloque.setAttribute("class", "ayuda");

	let defecto = "Esta es la caja de ayuda. Pasa el ratón por encima de un elemento para mostrar información relativa a dicho elemento. También muestra si aciertas o fallas las preguntas.";
	bloque.textContent = defecto;
	// Escucha del propio cuadro de ayuda.
	bloque.addEventListener("mouseover", () => {
		bloque.textContent = defecto;
	});
	// Se devuelve para escuchar al resto.
	return bloque;
}