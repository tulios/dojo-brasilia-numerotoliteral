package br.dojo.numeroToLiteral;


public class Conversor {
	static String[] numeros = {
		"zero",
		"um", "dois", "três", "quatro", "cinco",
		"seis", "sete", "oito", "nove"
	};

	static String[] numerosDezADezenove = {
		"dez", "onze", "doze", "treze", "quatorze",
		"quinze", "dezesseis",
		"dezessete", "dezoito", "dezenove"
	};

	static String[] dezenas = {
		"vinte", "trinta", "quarenta",
		"cinquenta","sessenta","setenta","oitenta",
		"noventa"
	};

	static String[] centenas = {
		"cento", "duzentos", "trezentos", "quatrocentos",
		"quinhentos", "seiscentos", "setecentos",
		"oitocentos", "novecentos"
	};
	
	public static String numeroToLiteral(int numero) {
		int index;

		String num = String.valueOf(numero);
		switch(num.length()){
		case 1:
			index = Integer.parseInt(""+num.charAt(0));
			return numeros[index];

		case 2:
			switch(num.charAt(0)){
			case '1':{
				index = Integer.parseInt(""+num.charAt(1));
				return numerosDezADezenove[index];
			}					

			default: return getDezena(num);	
			}

		case 3:		
			int centena = Integer.parseInt(""+num.charAt(0));
			switch (centena) {
			case 1:
				//TODO unificar o ifelse desses dois cases
				if (num.charAt(1)=='0' && num.charAt(2)=='0'){
					return "cem";
				}else{
					return getCentena(num);
				}

			default:
				if (num.charAt(1)=='0' && num.charAt(2)=='0'){ 
					return centenas[centena-1];
				}else{
					return getCentena(num);
				}
			}
		}
		return "?";

	}

	private static String getCentena(String num) {
		return centenas[Integer.parseInt(""+num.charAt(0))-1]+" e "+
		Conversor.numeroToLiteral(
			Integer.parseInt(""+num.charAt(1)+num.charAt(2))
		);
	}

	private static String getDezena(String num) {
		int index, index2;
		index2 = Integer.parseInt(""+num.charAt(0))-2;
		if (num.charAt(1) == '0'){
			return dezenas[index2];
		}else{
			index = Integer.parseInt(""+num.charAt(1));
			return dezenas[index2]+" e "+numeros[index];
		}
	}

}






