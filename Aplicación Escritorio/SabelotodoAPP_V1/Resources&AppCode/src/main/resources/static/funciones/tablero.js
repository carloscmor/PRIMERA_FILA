//* Creación del tablero.
export default class Tablero {
	constructor(posición, casillas, ayuda, div) {
		this.posición = posición;
		this.casillas = casillas;
		this.diferencia = 80;
		this.color = { 1: "#FFF", 2: "#FF0", 3: "#F0F", 4: "#F00", 5: "#0FF", 6: "#0F0", 7: "#00F", 8: "#000" };
		this.ayuda = ayuda;
		this.es_creación = true;
		this.tipos_ayuda = { 0: "CEROCEROCERO", 1: "UNOUNOUNO", 2: "DOSDOSDOS", 3: "TRESTRESTRES", 4: "CUATROCUATROCUATRO", 5: "CINCOCINCoCINCO", 6: "SEISSEISSEIS", 7: "SIETESIETESIETE", 8: "OCHOCHOCHO" };
		this.div_casillas = div;
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