//* Creación del tablero.
export default class Tablero {
	constructor(posición, casillas) {
		this.posición = posición;
		this.casillas = casillas;
		this.dx = 80;
		this.dy = 80;
	}

	dibuja(ctx) {
		for (let fila_casilla = 0; fila_casilla < this.casillas.length; fila_casilla++) {
			for (let casilla = 0; casilla < this.casillas[0].length; casilla++) {
				if (this.casillas[fila_casilla][casilla] != 0) {
					ctx.fillStyle = "#AAA";
					ctx.fillRect(this.posición.x + casilla * this.dx - 5, this.posición.y + fila_casilla * this.dy - 5, this.dx + 5, this.dy + 5);
					switch (this.casillas[fila_casilla][casilla]) {
						case 1:
							ctx.fillStyle = "#FFF";
							break;
						case 2:
							ctx.fillStyle = "#FF0";
							break;
						case 3:
							ctx.fillStyle = "#F0F";
							break;
						case 4:
							ctx.fillStyle = "#F00";
							break;
						case 5:
							ctx.fillStyle = "#0FF";
							break;
						case 6:
							ctx.fillStyle = "#0F0";
							break;
						case 7:
							ctx.fillStyle = "#00F";
							break;
						case 8:
							ctx.fillStyle = "#000";
							break;
						default:
							ctx.fillStyle = "#DCB"
							break;
					}
					ctx.fillRect(this.posición.x + casilla * this.dx, this.posición.y + fila_casilla * this.dy, this.dx - 4, this.dy - 4);
				}
			}
		}
	}
}