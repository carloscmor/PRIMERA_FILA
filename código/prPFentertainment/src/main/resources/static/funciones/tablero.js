//* Creación del tablero.
export default class Tablero {
	constructor(posición, casillas) {
		this.posición = posición;
		this.casillas = casillas;
		this.diferencia = 80;
		this.color = { 1: "#FFF", 2: "#FF0", 3: "#F0F", 4: "#F00", 5: "#0FF", 6: "#0F0", 7: "#00F", 8: "#000" };
	}

	dibuja(ctx) {
		for (let fila_casilla = 0; fila_casilla < this.casillas.length; fila_casilla++) {
			for (let casilla = 0; casilla < this.casillas[0].length; casilla++) {
				if (this.casillas[fila_casilla][casilla] != 0) {
					// Dibujar marco de casilla.
					ctx.fillStyle = "#AAA";
					ctx.fillRect(this.posición.x + casilla * this.diferencia - 5, this.posición.y + fila_casilla * this.diferencia - 5, this.diferencia + 5, this.diferencia + 5);
					// Dibujar casilla en función de su número.
					ctx.fillStyle = this.color[this.casillas[fila_casilla][casilla]] ? this.color[this.casillas[fila_casilla][casilla]] : "#DCB";
					ctx.fillRect(this.posición.x + casilla * this.diferencia, this.posición.y + fila_casilla * this.diferencia, this.diferencia - 4, this.diferencia - 4);
				}
			}
		}
	}
}