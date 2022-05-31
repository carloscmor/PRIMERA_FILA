//* Iteración en la creación y escucha del dado.
export default function crear_dado(ayuda) {
	const ruta = "archivos/dado/";
	const tipo = ".png";
	let dado;

	// Asignar elementos <img class="dado" src="archivos/dado/x.png"> al array.
	dado = document.createElement("img");
	dado.setAttribute("class", "dado");
	dado.setAttribute("src", ruta + 1 + tipo);
	// Escuchar la tirada del dado.
	dado.addEventListener("click", () => {
		console.log("Dado " + i + " clicado.");
	});
	// Escucha del cuadro de ayuda.
	dado.addEventListener("mouseover", () => {
		ayuda.textContent = "DADODODODODODO";
	});

	return dado;
}