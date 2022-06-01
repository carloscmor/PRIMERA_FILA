//* Clase ficha que avanza por el tablero.
export default class Ficha {
	constructor(imagen, tablero) {
		this.imagen = imagen;
		this.posición = {
			actual: { x: 0, y: 0 },
			anterior: { x: 0, y: 0 }
		};
		this.tablero = tablero;
	}

	dibuja(ctx) {
		ctx.drawImage(this.imagen, 35 + 80 * (this.posición.actual.x), 140 + 80 * (this.posición.actual.y), 71, 71);
	}

	es_anterior(anterior) {
		switch (anterior) {
			case 0:
				if (this.posición.anterior.y == this.posición.actual.y - 1) {
					return true;
				}
				break;
			case 1:
				if (this.posición.anterior.x == this.posición.actual.x + 1) {
					return true;
				}
				break;
			case 2:
				if (this.posición.anterior.y == this.posición.actual.y + 1) {
					return true;
				}
				break;
			case 3:
				if (this.posición.anterior.x == this.posición.actual.x - 1) {
					return true;
				}
				break;
		}
		return false;
	}

	avanzar() {
		if (this.posición.actual.y != 0 && this.tablero[this.posición.actual.y - 1][this.posición.actual.x] != 0 && !this.es_anterior(0)) {
			this.posición.anterior.x = this.posición.actual.x;
			this.posición.anterior.y = this.posición.actual.y;
			this.posición.actual.y--;
		} else if (this.posición.actual.x != 12 && this.tablero[this.posición.actual.y][this.posición.actual.x + 1] != 0 && !this.es_anterior(1)) {
			this.posición.anterior.x = this.posición.actual.x;
			this.posición.anterior.y = this.posición.actual.y;
			this.posición.actual.x++;
		} else if (this.posición.actual.y != 5 && this.tablero[this.posición.actual.y + 1][this.posición.actual.x] != 0 && !this.es_anterior(2)) {
			this.posición.anterior.x = this.posición.actual.x;
			this.posición.anterior.y = this.posición.actual.y;
			this.posición.actual.y++;
		} else if (this.posición.actual.x != 0 && this.tablero[this.posición.actual.y][this.posición.actual.x - 1] != 0 && !this.es_anterior(3)) {
			this.posición.anterior.x = this.posición.actual.x;
			this.posición.anterior.y = this.posición.actual.y;
			this.posición.actual.x--;
		}

		if (this.tablero[this.posición.actual.y][this.posición.actual.x] == 1) {
			console.log("META");
		}
	}
}