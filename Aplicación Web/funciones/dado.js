//* Iteración en la creación y escucha del dado.
export default function crear_dado(ayuda, ficha, tablero, partida) {
	const ruta = "archivos/dado/";
	const tipo = ".png";
	let dado;

	function tirar_dado() {
		const resultado = Math.floor(Math.random() * 100 % 6 + 1);
		const dado = document.getElementsByClassName("dado");
		dado[0].setAttribute("src", ruta + resultado + tipo);
		for (let i = 0; i < resultado; i++) {
			if (tablero.casillas[ficha.posición.actual.y][ficha.posición.actual.x] == 8) {
				partida.estado = 2;
				break;
			}
			ficha.avanzar();
		}
		if (tablero.casillas[ficha.posición.actual.y][ficha.posición.actual.x] != 8 && tablero.casillas[ficha.posición.actual.y][ficha.posición.actual.x] != 1) {
			ficha.preguntar();
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