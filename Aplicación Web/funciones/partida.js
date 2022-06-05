//* Clase que guarda valores globales.
export default class Partida {
	constructor() {
		this.estado = 0;
		this.tipo = 0;
		this.dificultad = 0;
		this.estados = {
			"inicio": 0,
			"ejecución": 1,
			"fin": 2
		};
		this.tipos = {
			"rápida": 0,
			"desafío": 1
		};
		this.dificultades = {
			"fácil": 0,
			"medio": 1,
			"difícil": 3
		};
	}

	asignar_estado(estado) {
		this.estados = estado;
	}

	asignar_tipo(tipo) {
		this.tipo = this.tipos[tipo];
	}

	asignar_dificultad(dificultad) {
		this.dificultad = this.dificultades[dificultad];
	}
}