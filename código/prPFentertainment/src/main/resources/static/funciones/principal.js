//* Guión principal.
import cambiar_tema from "./configuración/tema.js";

const botón_tema = document.getElementById("botón_tema");
const nodo_tema = document.getElementById("tema_css");

// Botón para cambiar el tema.
botón_tema.addEventListener("click", () => {
	cambiar_tema(nodo_tema, botón_tema);
});