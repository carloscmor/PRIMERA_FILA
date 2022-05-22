//* Creación del tablero.
export default class Tablero {
	constructor(ancho, alto, posición) {
		this.ancho = ancho;
		this.alto = alto;
		this.posición = posición;
	}

	dibuja(ctx) {
		ctx.fillStyle = "#00F";
		ctx.fillRect(this.posición.x, this.posición.y, this.ancho, this.alto);
	}

	actualiza() {

	}
}