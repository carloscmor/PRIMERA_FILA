package Modelo;

public class CasillaEspecial extends Casilla {



	public CasillaEspecial(String categ, int pos, Dificultad d) {
		super(categ, pos, d);
	}
	
	public void ActivarEspecial(Jugador jug) {
		switch (this.getPosicion()) {
		case 2: case 3: {
			/*avanzar casilla
			 Ficha.avanzar();  ????
			 */
			break;
		}
		case 6: case 7:{
			if(jug.getVidas() > 1) {
				jug.setVidas(jug.getVidas() - 1);
			}
		}
			break;
		case 10: case 11: case 22:
			//Pregunta Especial    ????
			break;
		case 14: case 18:
			jug.setVidas(jug.getVidas()+1);
			break;
		case 15: case 17: case 26: 
			/*Retroceder casilla
			 Ficha.retroceder();  ????
			 */
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getPosicion());
		}
		
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
