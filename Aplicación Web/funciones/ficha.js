//* Clase ficha que avanza por el tablero.
export default class Ficha {
	constructor(imagen, tablero, ayuda) {
		this.imagen = imagen;
		this.posición = {
			actual: { x: 0, y: 0 },
			anterior: { x: 0, y: 0 }
		};
		this.tablero = tablero.casillas;
		this.preguntas;
		this.trad = {
			2: "animales",
			3: "entretenimiento",
			4: "general",
			5: "historia",
			6: "ciencia",
			7: "deportes"
		};
		this.ayuda = ayuda;
	}

	asignar_preguntas(preguntas) {
		this.preguntas = preguntas;
	}

	dibuja(ctx) {
		ctx.drawImage(this.imagen, 35 + 80 * (this.posición.actual.x), 140 + 80 * (this.posición.actual.y), 71, 71);
	}

	mezcla(respuestas) {
		let id_actual = respuestas.length;
		while (0 !== id_actual) {
			let randId = Math.floor(Math.random() * id_actual);
			id_actual -= 1;
			let auxiliar = respuestas[id_actual];
			respuestas[id_actual] = respuestas[randId];
			respuestas[randId] = auxiliar;
		}
		return respuestas;
	}

	preguntar() {
		let cantidad = Object.keys(this.preguntas[this.trad[this.tablero[this.posición.actual.y][this.posición.actual.x]]].results).length;
		let pregunta = this.preguntas[this.trad[this.tablero[this.posición.actual.y][this.posición.actual.x]]].results[Math.floor(Math.random() * 100 % cantidad)];

		const respuestas = [pregunta.correct_answer, pregunta.incorrect_answers[0], pregunta.incorrect_answers[1], pregunta.incorrect_answers[2]];
		this.mezcla(respuestas);
		const resp_usr = prompt(pregunta.question + "\n1-" + respuestas[0] + "\n2-" + respuestas[1] + "\n3-" + respuestas[2] + "\n4-" + respuestas[3]);
		if (respuestas[resp_usr - 1] == pregunta.correct_answer) {
			this.ayuda.textContent = "CORRECTO: puedes volver a tirar el dado y continuar.";
		} else {
			this.ayuda.textContent = "INCORRECTO: has perdido una vida por fallar la pregunta. Si te quedas sin vidas perderas la partida. La respuesta correcta era \"" + pregunta.correct_answer + "\".";
			const vidas = document.getElementsByClassName("número_vidas");
			vidas[0].textContent -= 1;
			if (vidas[0].textContent == 0) {
				this.ayuda.textContent = "Has perdido la partida :(";
				const volver_a_jugar = document.createElement("button");
				volver_a_jugar.setAttribute("class", "en_medio botón");
				volver_a_jugar.addEventListener("mouseover", () => {
					this.ayuda.textContent = "Vuelve a empezar la partida, seleccionando de nuevo el tipo de partida y la dificultad.";
				});
				volver_a_jugar.addEventListener("click", () => {
					location.reload();
				});
				volver_a_jugar.textContent = "¿Volver a jugar?";
				const juego = document.getElementById("juego");
				juego.appendChild(volver_a_jugar);
			}
		}
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
	}
}