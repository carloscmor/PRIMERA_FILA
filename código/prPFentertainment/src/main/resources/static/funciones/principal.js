//* Guión principal.
import cambiar_tema from "./configuración/tema.js";

const botón_tema = document.getElementById("botón_tema");
const nodo_tema = document.getElementById("tema_css");
const nodo_logo = document.getElementById("logotipo");

// Botón para cambiar el tema.
botón_tema.addEventListener("click", () => {
	cambiar_tema(nodo_tema, botón_tema, nodo_logo);
});

let dado = [];
for (let i = 1; i <= 6; i++) {
	dado[i] = document.getElementById("dado" + i);
	dado[i].addEventListener("click", () => {
		console.log(dado[i]);
	});
}

const lienzo = document.getElementById("lienzo");
const ctx = lienzo.getContext("2d");

lienzo.ancho = 1024;
lienzo.alto = 576;

ctx.fillStyle = "#0F0";
ctx.fillRect(0, 0, lienzo.ancho, lienzo.alto);