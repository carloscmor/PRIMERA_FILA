//* Texto superior que proporciona información del objeto en cuestión.
export default function crear_ayuda() {
	const bloque = document.createElement("p");
	bloque.setAttribute("class", "ayuda");

	bloque.textContent = "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Officia neque repudiandae assumenda nihil facere ipsam rem. Sapiente facilis ipsam doloremque officia animi maiores expedita earum aliquid! Adipisci eligendi ad at. Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias quisquam, excepturi sapiente sit ipsam iste quae, pariatur aperiam qui id cupiditate voluptatum. Odio rerum quisquam beatae, quae harum aliquid dolores! Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, laborum hic harum, voluptates dolores molestiae cum, necessitatibus explicabo corporis accusamus laudantium at doloribus unde deserunt impedit atque nam! Deleniti, illo. Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi iste sequi optio. Id mollitia quia pariatur, reprehenderit sunt sapiente dolore eius nobis necessitatibus molestias voluptatibus deserunt iusto voluptatem tempore tempora.";

	return bloque;
}