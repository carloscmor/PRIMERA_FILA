//* Clase que guarda valores globales.
export default class Partida {
	constructor() {
		this.estado = 0;
		this.tipo = 0;
		this.estados = {
			inicio: 0,
			ejecución: 1,
			fin: 2
		};
		this.tipos = {
			rápida: 0,
			desafío: 1
		};
	}

	asignar_estado(estado) {
		this.estados = estado;
	}

	asignar_tipo(tipo) {
		this.tipos = tipo;
	}
}