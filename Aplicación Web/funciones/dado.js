//* Iteración en la creación y escucha del dado.
export default function crear_dado(ayuda, ficha, tablero) {
	const ruta = "archivos/dado/";
	const tipo = ".png";
	let dado;

	function tirar_dado() {
		let resultado = Math.floor(Math.random() * 100 % 6 + 1);
		console.log("Dado: " + resultado);
		for (let i = 0; i < resultado; i++) {
			if (tablero.casillas[ficha.posición.actual.y][ficha.posición.actual.x] == 10) {
				console.log("MECHA MECHAAAAAA");
				break;
			}
			ficha.avanzar();
		}
	}

	// Asignar elementos <img class="dado" src="archivos/dado/x.png"> al array.
	dado = document.createElement("img");
	dado.setAttribute("class", "dado");
	dado.setAttribute("src", ruta + 1 + tipo);
	// Escuchar la tirada del dado.
	dado.addEventListener("click", () => {
		tirar_dado();
	});
	// Escucha del cuadro de ayuda.
	dado.addEventListener("mouseover", () => {
		ayuda.textContent = "DADODODODODODO";
	});

	return dado;
}