package com.tmob.prueba;

public class TestWS {
	
	public int sumar(int a, int b) {
		return a + b;
	}
	
	public int restar(int a, int b) {
		return a - b;
	}

	public int multiplicar(int a, int b) {
		return a * b;
	}
	
	public String chamuyoDaily()  {
		String res = "";
		
		long milis = System.currentTimeMillis();
		int resto = (int) milis % 10;
		
		switch (Math.abs(resto)) {
		case 0: {
			res = "El codigo no esta, porque esta en mi repositorio personal";
			break;
		}
		case 1: {
			res = "Hoy me levante a las 5 a hablar con india";
			break;
		}
		case 2: {
			res = "Hoy se me inundo el bano";
			break;
		}
		case 3: {
			res = "Ya estoy viendo el tema y lo resuelvo a manana";
			break;
		}
		case 4: {
			res = "Hoy tuve ingles 4 horas";
			break;
		}
		case 5: {
			res = "Estoy estudiando Blockchain";
			break;
		}
		case 6: {
			res = "Estoy estudiando Python";
			break;
		}
		case 7: {
			res = "Estoy estudiando Angular";
			break;
		}
		case 8: {
			res = "Estoy estudiando Vue.js";
			break;
		}
		case 9: {
			res = "Voy a pasear el perro y vengo";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + resto);
		}
		
		System.out.println(res);
		
		return res;
	}


}
