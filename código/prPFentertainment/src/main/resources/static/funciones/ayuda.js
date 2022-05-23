//* Texto superior que proporciona información del objeto en cuestión.
export default function crear_ayuda() {
	const bloque = document.createElement("p");
	bloque.setAttribute("class", "ayuda");

	let defecto = "AYUDADADADADADADA";
	bloque.textContent = defecto;

	bloque.addEventListener("mouseover", () => {
		bloque.textContent = defecto;
	});
	
	return bloque;
}