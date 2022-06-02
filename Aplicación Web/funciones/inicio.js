//* Creación de la pantalla de inicio y sus entradas.
export default function crear_pantalla_inicio(partida) {
	const pantalla = document.createElement("div");
	const fragmento = document.createDocumentFragment();

	const título = document.createElement("p");
	título.setAttribute("class", "título_inicio");
	título.textContent = "SABELOTODO :D";
	fragmento.appendChild(título);

	// Botón Empezar.
	const opciones = document.createElement("div");
	const empezar = document.createElement("button");
	empezar.setAttribute("class", "botón_empezar botón");
	empezar.textContent = "Empezar";
	empezar.addEventListener("click", () => {
		partida.asignar_tipo(tipo.value);
		partida.asignar_dificultad(dificultad.value);
		partida.estado = partida.estados.ejecución;
		pantalla.remove();
	});

	// Selección de tipo.
	const tipo = document.createElement("select");
	tipo.setAttribute("name", "tipo");
	tipo.setAttribute("id", "tipo");
	tipo.setAttribute("class", "tipo botón");
	const tipo_rápida = document.createElement("option");
	tipo_rápida.textContent = "Rápida";
	tipo_rápida.value = "rápida";
	const tipo_desafío = document.createElement("option");
	tipo_desafío.textContent = "Desafío";
	tipo_desafío.value = "desafío";
	tipo.appendChild(tipo_rápida);
	tipo.appendChild(tipo_desafío);

	tipo.addEventListener("change", () => {
		if (tipo.value == "desafío") {
			dificultad.disabled = true;
			dificultad.value = "difícil";
			dificultad.style.cursor = "not-allowed";
		} else {
			dificultad.disabled = false;
			dificultad.value = "fácil";
			dificultad.style.cursor = "pointer";
		}
	});

	// Selección de dificultad.
	const dificultad = document.createElement("select");
	dificultad.setAttribute("name", "dificultad");
	dificultad.setAttribute("id", "dificultad");
	dificultad.setAttribute("class", "dificultad botón");
	const fácil = document.createElement("option");
	fácil.textContent = "Fácil";
	fácil.value = "fácil";
	const medio = document.createElement("option");
	medio.textContent = "Medio";
	medio.value = "medio";
	const difícil = document.createElement("option");
	difícil.textContent = "Difícil";
	difícil.value = "difícil";
	dificultad.appendChild(fácil);
	dificultad.appendChild(medio);
	dificultad.appendChild(difícil);

	opciones.appendChild(empezar);
	opciones.appendChild(tipo);
	opciones.appendChild(dificultad);
	fragmento.appendChild(opciones);

	pantalla.appendChild(fragmento);
	return pantalla;
}