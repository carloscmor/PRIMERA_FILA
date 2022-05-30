//* Iteración en la creación y escucha del dado.
export default function crear_dados(ayuda) {
	const ruta = "archivos/dado/";
	const tipo = ".png";
	let dado = [];

	for (let i = 1; i <= 6; i++) {
		// Asignar elementos <img class="dado" src="archivos/dado/x.png"> al array.
		dado[i] = document.createElement("img");
		dado[i].setAttribute("class", "dado");
		dado[i].setAttribute("src", ruta + i + tipo);
		// Ocultar todos las imagenes menos la x.
		if (i != 3) {
			dado[i].classList.toggle("oculto", true);
		}
		// Escuchar la tirada del dado.
		dado[i].addEventListener("click", () => {
			console.log("Dado " + i + " clicado.");
		});
		// Escucha del cuadro de ayuda.
		dado[i].addEventListener("mouseover", () => {
			ayuda.textContent = "DADODODODODODO";
		});
	}

	return dado;
}