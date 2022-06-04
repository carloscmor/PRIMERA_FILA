package Modelo;

import java.util.StringJoiner;

public class CasillaEspecial extends Casilla {
	CasillaEspecial(String categ, int pos) {
		super(categ, pos, "hard");
	}

	/**
	 * <h1>Efectos</h1>
	 * <h2><u>Partida Rápida</u></h2>
	 * <ul>
	 *     <li>2  = Avanza 1 casilla</li>
	 *     <li>6  = Pierde 1 vida</li>
	 *     <li>10 = Pregunta especial</li>
	 *     <li>14 = Gana 1 vida</li>
	 *     <li>17 = Retrocede 1 casilla</li>
	 * </ul>
	 *
	 * <h2><u>Partida Desafío</u></h2>
	 * <ul>
	 *     <li>3  = Avanza 1 casilla</li>
	 *     <li>7  = Pierde 1 vida</li>
	 *     <li>11 = Pregunta Especial</li>
	 *     <li>15 = Retrocede 1 casilla</li>
	 *     <li>18 = Gana 1 vida</li>
	 *     <li>22 = Pregunta Especial</li>
	 *     <li>26 = Retrocede 1 casilla</li>
	 * </ul>
	 */
	public String ActivarEspecial(Partida p) {
		switch (this.getPosicion()) {
		case 2: case 3: { // Avanzar casilla
			p.getFicha().avanzar();
			return "Avanzas una casilla :)";
		}
		case 6: case 7:{ // Restar 1 vida
			if(p.getJugador().getVidas() > 1){
				p.getJugador().setVidas(p.getJugador().getVidas() - 1);
				return "Pierdes una vida :(";
			} else return "Pierdes una vida... \n\nBueno, esta vez te libras...";

		}
		case 10: case 11: case 22:{ // Pregunta Especial = Pregunta dificil aleatoria
			generarPregunta();
			return "";
		}
		case 14: case 18:  // Aumentar 1 vida
			p.getJugador().setVidas(p.getJugador().getVidas()+1);
			return "Ganas una vida :)";
		case 15: case 17: case 26: //Retroceder casilla
			p.getFicha().retroceder();
			return "Retrocedes una casilla :(";
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getPosicion());
		}
	}

	public String toString() {
		return new StringJoiner(", ", "Casilla" + "[", "]")
				.add("Categoria='" + getCategoria() + "'")
				.add("Posicion=" + getPosicion() + " Especial")
				.toString();
	}



}
