package br.dojo.numeroToLiteral;

public class Conversor {
	static String[] numeros = {
		"zero",
		"um", "dois", "três", "quatro", "cinco",
		"seis", "sete", "oito", "nove"
	};

	static String[] numerosDeOnzeADezenove = {
		"dez", "onze", "doze", "treze", "quatorze",
		"quinze", "dezesseis",
		"dezessete", "dezoito", "dezenove"
	};

	static String[] dezenas = {"vinte", "trinta", "quarenta",
		"cinquenta","sessenta","setenta","oitenta",
	"noventa"};


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
				return numerosDeOnzeADezenove[index];
			}					

			default: return getDezena(num);	
			}

		case 3:			 
				if(num.equals("100"))
					return "cem";
				if(num.charAt(1) == '0')
				{
					return "cento e " + 
					numeros[Integer.parseInt(""+num.charAt(2))];
				}							
			return "cento e " + 
			numeroToLiteral(Integer.parseInt(""+num.charAt(1)+num.charAt(2)));

			
		}
		return "?";

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






