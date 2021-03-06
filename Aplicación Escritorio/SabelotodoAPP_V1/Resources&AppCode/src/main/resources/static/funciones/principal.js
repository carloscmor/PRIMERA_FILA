//* Guión principal.
import cambiar_tema from "./tema.js";
import crear_dados from "./dado.js";
import crear_vidas from "./vidas.js";
import Tablero from "./tablero.js";
import crear_ayuda from "./ayuda.js";

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
contenedor.appendChild(ayuda);

// Bloque con las vidas.
let vidas = crear_vidas(3, ayuda);
contenedor.appendChild(vidas);

// Funcionalidad del dado.
let dados = crear_dados(ayuda);
for (let i = 1; i <= 6; i++) {
	contenedor.appendChild(dados[i], ayuda);
}

// Creación del tablero.
let tablero_ejemplo =
	[[1, 2, 3, 4, 0, 2, 4, 5, 6, 3, 4, 0],
	[0, 0, 0, 5, 0, 3, 0, 0, 0, 0, 2, 0],
	[0, 8, 7, 6, 0, 9, 0, 2, 2, 6, 5, 0],
	[0, 2, 0, 0, 0, 8, 0, 6, 0, 0, 0, 0],
	[0, 3, 4, 5, 6, 7, 0, 3, 4, 5, 6, 1]];
let tablero_base = new Tablero({ x: 33, y: 138 }, tablero_ejemplo, ayuda, contenedor);

// Bucle que renderiza y actualiza.
function bucle_principal() {
	ctx.clearRect(0, 0, lienzo.ancho, lienzo.alto);
	tablero_base.dibuja(ctx);
	window.requestAnimationFrame(bucle_principal);
}

bucle_principal();