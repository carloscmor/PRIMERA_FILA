//* Guión principal.
import cambiar_tema from "./tema.js";
import crear_dado from "./dado.js";
import crear_vidas from "./vidas.js";
import Tablero from "./tablero.js";
import crear_ayuda from "./ayuda.js";
import crear_pantalla_inicio from "./inicio.js";
import Partida from "./partida.js";
import Ficha from "./ficha.js";

// Botón para cambiar el tema.
const botón_tema = document.getElementById("botón_tema");
const nodo_tema = document.getElementById("tema_css");
const nodo_logo = document.getElementById("logotipo");

botón_tema.addEventListener("click", () => {
	cambiar_tema(nodo_tema, botón_tema, nodo_logo);
});

// Creación y asignación del lienzo.
const contenedor = document.getElementById("juego");
const lienzo = document.getElementById("lienzo");
const ctx = lienzo.getContext("2d");

lienzo.ancho = 1024;
lienzo.alto = 576;

// Bloque textual de ayuda.
let ayuda = crear_ayuda();

// Bloque con las vidas.
let vidas = crear_vidas(3, ayuda);

// Creación del tablero.
let tablero =
	[[1, 2, 3, 4, 0, 2, 4, 5, 6, 3, 4, 0],
	[0, 0, 0, 5, 0, 3, 0, 0, 0, 0, 2, 0],
	[0, 8, 7, 6, 0, 9, 0, 2, 2, 6, 5, 0],
	[0, 2, 0, 0, 0, 8, 0, 6, 0, 0, 0, 0],
	[0, 3, 4, 5, 6, 7, 0, 3, 4, 5, 6, 1]];
let tablero_base = new Tablero({ x: 33, y: 138 }, tablero, ayuda, contenedor);

// Ficha.
const ficha_imagen = document.getElementById("ficha");
let ficha = new Ficha(ficha_imagen, tablero);

// Funcionalidad del dado.
let dado = crear_dado(ayuda, ficha);

// Clase partida.
const partida = new Partida();

const estados = {
	inicio: 0,
	ejecución: 1,
	fin: 2
};

const tipos = {
	rápida: 0,
	desafío: 1
};

// Pantalla de Inicio.
const inicio = crear_pantalla_inicio(partida);
let es_creación = true;
let es_primera_vez = true;

// Bucle que renderiza y actualiza.
function bucle_principal() {
	ctx.clearRect(0, 0, lienzo.ancho, lienzo.alto);
	if (partida.estado == estados.ejecución) {
		if (es_primera_vez) {
			contenedor.appendChild(ayuda);
			contenedor.appendChild(vidas);
			contenedor.appendChild(dado, ayuda);
			es_primera_vez = false;
		}
		// ¡DEPURACIÓN!
		console.log("Tipo: " + partida.tipo + " - Dificultad: " + partida.dificultad);
		tablero_base.dibuja(ctx);
		ficha.dibuja(ctx);
	} else if (partida.estado == estados.inicio && es_creación) {
		contenedor.appendChild(inicio);
		es_creación = false;
	} else if (partida.estado == estados.fin) {

	}
	window.requestAnimationFrame(bucle_principal);
}

bucle_principal();