//* Guión principal.
import cambiar_tema from "./tema.js";
import crear_dados from "./dado.js";
import crear_vidas from "./vidas.js";

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

// Bucle que renderiza y actualiza.
function bucle_principal() {
	ctx.fillStyle = "#0F0";
	// ctx.fillRect(0, 0, lienzo.ancho, lienzo.alto);
	window.requestAnimationFrame(bucle_principal);
}

bucle_principal();