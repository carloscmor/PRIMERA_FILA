//* Creación de la pantalla de inicio y sus entradas.
export default function crear_pantalla_inicio(partida) {
	const pantalla = document.createElement("div");
	const fragmento = document.createDocumentFragment();

	const título = document.createElement("p");
	título.setAttribute("class", "título_inicio");
	título.textContent = "SABELOTODO :D";
	fragmento.appendChild(título);

	const opciones = document.createElement("div");
	const rápida = document.createElement("button");
	rápida.setAttribute("class", "botón_rápida");
	rápida.textContent = "Rápida";
	rápida.addEventListener("click", () => {
		partida.tipo = partida.tipos.rápida;
		partida.estado = partida.estados.ejecución;
		pantalla.remove();
	});

	const desafío = document.createElement("button");
	desafío.setAttribute("class", "botón_desafío");
	desafío.textContent = "Desafío";
	desafío.addEventListener("click", () => {
		partida.tipo = partida.tipos.desafío;
		partida.estado = partida.estados.ejecución;
		pantalla.remove();
	});

	opciones.appendChild(rápida);
	opciones.appendChild(desafío);
	fragmento.appendChild(opciones);

	pantalla.appendChild(fragmento);
	return pantalla;
}