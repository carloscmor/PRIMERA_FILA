//* Clase ficha que avanza por el tablero.
export default class Ficha {
	constructor(imagen) {
		this.imagen = imagen;
		this.posición = { x: 0, y: 0 };
	}

	dibuja(ctx) {
		ctx.drawImage(this.imagen, 35 + 80 * (this.posición.x), 140 + 80 * (this.posición.y), 71, 71);
	}

	avanzar() {
		
	}
}