//* Carga de archivo JSON.
export default async function carga_json(URL) {
	const petición = new Request(URL);
	const respuesta = await fetch(petición);

	const datos = await respuesta.json();

	return datos;
}