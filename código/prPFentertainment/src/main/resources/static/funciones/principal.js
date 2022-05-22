//* Guión principal.
import cambiar_tema from "./tema.js";
import crear_dados from "./dado.js";
import crear_vidas from "./vidas.js";
import Tablero from "./tablero.js";

// Botón para cambiar el tema.
const botón_tema = document.getElementById("botón_tema");
const nodo_tema = document.getElementById("tema_css");
const nodo_logo = document.getElementById("logotipo");

botón_tema.addEventListener("click", () => {
	cambiar_tema(nodo_tema, botón_tema, nodo_logo);
});

// Creación y asignación del lienzo.
const lienzo = document.getElementById("lienzo");
const ctx = lienzo.getContext("2d");

lienzo.ancho = 1024;
lienzo.alto = 576;

// Funcionalidad del dado.
let dados = crear_dados();
const contenedor = document.getElementById("juego");
for (let i = 1; i <= 6; i++) {
	contenedor.appendChild(dados[i]);
}

// Bloque con las vidas.
let vidas = crear_vidas(3);
contenedor.appendChild(vidas);

// Creación del tablero.
let tablero_base = new Tablero(980, 420, { x: 20, y: 128 });

// Bucle que renderiza y actualiza.
function bucle_principal() {
	tablero_base.dibuja(ctx);
	tablero_base.actualiza();
	window.requestAnimationFrame(bucle_principal);
}

bucle_principal();