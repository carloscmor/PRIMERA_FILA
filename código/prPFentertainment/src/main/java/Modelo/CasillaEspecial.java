package Modelo;

import java.util.StringJoiner;

public class CasillaEspecial extends Casilla {



	public CasillaEspecial(String categ, int pos) {
		super(categ, pos, Dificultad.dificil);
	}
	
	public void ActivarEspecial(Jugador jug, Ficha f) {
		switch (this.getPosicion()) {
		case 2: case 3: { // Avanzar casilla
			 f.Avanzar(); //  ????
			break;
		}
		case 6: case 7:{ // Restar 1 vida
			if(jug.getVidas() > 1) {
				jug.setVidas(jug.getVidas() - 1);
			}
		}
			break;
		case 10: case 11: case 22:{ // Pregunta Especial = Pregunta dificil aleatoria
			getPregunta();	
			
			break;
		}
		case 14: case 18:  // Aumentar 1 vida
			jug.setVidas(jug.getVidas()+1);
			break;
		case 15: case 17: case 26: //Retroceder casilla
			 f.Retroceder(); //????
			break;
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

	
/*
PR
2  = Avanza 1 casilla
6  = Pierde 1 vida
10 = Pregunta especial
14 = Gana 1 vida
17 = Retrocede 1 casilla
 
PD
3  = Avanza 1 casilla
7  = Pierde 1 vida
11 = Pregunta Especial
15 = Retrocede 1 casilla
18 = Gana 1 vida
22 = Pregunta Especial
26 = Retrocede 1 casilla

 */
}
