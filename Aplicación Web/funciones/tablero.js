//* Creación del tablero.
export default class Tablero {
	constructor(posición, casillas, ayuda, div) {
		this.posición = posición;
		this.casillas = casillas;
		this.diferencia = 80;
		this.color = { 1: "#FFF", 2: "#EE47D0", 3: "#A2231D", 4: "#00FFFF", 5: "#FFD500", 6: "#71A92C", 7: "#EC7C26", 8: "#000" };
		this.ayuda = ayuda;
		this.es_creación = true;
		this.tipos_ayuda = { 1: "Casilla de inicio. Partes de esta casilla donde no tienes que responder ninguna pregunta.", 2: "Categoría: Animales. ¿Cuánto sabes de los animales, sus especies, hábitos y sus relaciones?", 3: "Categoría: Entretenimiento. Muestra donde inviertes tu tiempo de ocio.", 4: "Categoría: General. Demuestra que sabes lo suficiente de todo en esta vida.", 5: "Categoría: Historia. Saca a pasear esos datos históricos que llevas almacenados.", 6: "Categoría: Ciencia. Dale pá, esta la tienes que acertar sí o sí.", 7: "Categoría: Deportes. Venga chabales, ¿quién se echa un furbo?", 8: "La meta. Tú único objetivo es llegar a esta casilla. ¿Podrás conseguirlo?" };
		this.div_casillas = div;
		this.preguntas;
	}

	asignar_preguntas(preguntas) {
		this.preguntas = preguntas;
	}

	dibujar_marco(ctx, i, j) {
		ctx.fillStyle = "#AAA";
		ctx.fillRect(this.posición.x + j * this.diferencia - 5, this.posición.y + i * this.diferencia - 5, this.diferencia + 5, this.diferencia + 5);
	}

	dibujar_casilla(ctx, i, j) {
		ctx.fillStyle = this.color[this.casillas[i][j]] ? this.color[this.casillas[i][j]] : "#DCB";
		ctx.fillRect(this.posición.x + j * this.diferencia, this.posición.y + i * this.diferencia, this.diferencia - 4, this.diferencia - 4);
	}

	crear_capa_de_ayuda(i, j) {
		const capa = document.createElement("p");
		capa.setAttribute("class", "casilla");
		capa.style.top = this.posición.y + i * this.diferencia + "px";
		capa.style.left = this.posición.x + j * this.diferencia + "px";
		capa.addEventListener("mouseover", () => {
			this.ayuda.textContent = this.tipos_ayuda[this.casillas[i][j]];
		});
		return capa;
	}

	tratar_casilla(ctx, fila, columna) {
		this.dibujar_marco(ctx, fila, columna);
		this.dibujar_casilla(ctx, fila, columna);
		// Añadir la escucha del cuadro de ayuda en el primer bucle.
		if (this.es_creación) {
			this.div_casillas.appendChild(this.crear_capa_de_ayuda(fila, columna));
		}
	}

	tratar_fila(ctx, fila) {
		for (let columna = 0; columna < this.casillas[0].length; columna++) {
			if (this.casillas[fila][columna] != 0) {
				this.tratar_casilla(ctx, fila, columna);
			}
		}
	}

	dibuja(ctx) {
		for (let fila = 0; fila < this.casillas.length; fila++) {
			this.tratar_fila(ctx, fila);
		}
		this.es_creación = false;
	}
}