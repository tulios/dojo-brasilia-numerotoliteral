package br.dojo.numeroToLiteral;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;

import java.util.Random;

import org.junit.Test;

public class TesteNumeroToLiteral {
	@Test
	public void testZero(){
		int numero = 0;
		String literal = Conversor.numeroToLiteral(numero);
		assertEquals("zero", literal);
		assertFalse("ZERO".equals(literal));
		assertFalse("Zero".equals(literal));
	}

	@Test
	public void testUm(){
		int numero = 1;
		String literal = Conversor.numeroToLiteral(numero);
		assertEquals("um", literal);
		assertFalse("UM".equals(literal));
		assertFalse("Um".equals(literal));
	}

	@Test
	public void testDeZeroANove(){
		String[] numeros = {
				"zero",
				"um", "dois", "três", "quatro", "cinco",
				"seis", "sete", "oito", "nove"
		};
		for (int numero = 0; numero < 10; numero++){
			String literal = Conversor.numeroToLiteral(numero);
			assertEquals(numeros[numero], literal);
			assertFalse(numeros[numero].toUpperCase().equals(literal));
		}				
	}
	
	@Test
	public void testDez(){
		int numero = 10;
		String literal = Conversor.numeroToLiteral(numero);
		assertEquals("dez", literal);
		assertFalse("DEZ".equals(literal));
		assertFalse("Dez".equals(literal));			
	}
	
	@Test
	public void testDeOnzeADezenove(){
		String[] numeros = {
				"onze", "doze", "treze", "quatorze",
				"quinze", "dezesseis",
				"dezessete", "dezoito", "dezenove"
		};
		for (int numero = 11; numero < 20; numero++){
			String literal = Conversor.numeroToLiteral(numero);
			assertEquals(numeros[numero-11], literal);
			assertFalse(numeros[numero-11].toUpperCase().equals(literal));
		}		
	}
	
	@Test
	public void testVinte(){
		int numero = 20;
		String literal = Conversor.numeroToLiteral(numero);
		assertEquals("vinte", literal);
		assertFalse("VINTE".equals(literal));
		assertFalse("Vinte".equals(literal));			
	}
	
	@Test
	public void testDeVinteUmATrinta(){
		String[] numeros = {
				"vinte e um", "vinte e dois",
				"vinte e três", "vinte e quatro",
				"vinte e cinco", "vinte e seis",
				"vinte e sete", "vinte e oito",
				"vinte e nove", "trinta"
		};
		for(int numero = 21 ; numero < 31 ; numero++)
		{
			String literal = Conversor.numeroToLiteral(numero);
			assertEquals(numeros[numero-21], literal);
			assertFalse(numeros[numero-21].toUpperCase().equals(literal));
		}		
	}
	
	@Test
	public void testDeTrintaUmAQuarenta(){
		String[] numeros = {
				"trinta e um", "trinta e dois",
				"trinta e três", "trinta e quatro",
				"trinta e cinco", "trinta e seis",
				"trinta e sete", "trinta e oito",
				"trinta e nove", "quarenta"
		};
		for(int numero = 31 ; numero < 41 ; numero++)
		{
			String literal = Conversor.numeroToLiteral(numero);
			assertEquals(numeros[numero-31], literal);
			assertFalse(numeros[numero-31].toUpperCase().equals(literal));
		}		
	}
	
	@Test
	public void testAteNoventaNove(){
		for(int numero = 0 ; numero < 100 ; numero++)
		{
			String literal = Conversor.numeroToLiteral(numero);
			assertFalse("?".equals(literal));
		}		
	}
	
	@Test
	public void testCem() {
		int numero = 100;
		
		String literal = Conversor.numeroToLiteral(numero);
		
		assertEquals("cem",literal);
	}
	
	@Test
	public void testCentoUm() {
		int numero = 101;
		
		String literal = Conversor.numeroToLiteral(numero);
		
		assertEquals("cento e um",literal);
	}
	
	@Test
	public void testDeCentoUmACentoDez() {
		String[] numeros = {
				"cento e um", "cento e dois",
				"cento e três", "cento e quatro",
				"cento e cinco", "cento e seis",
				"cento e sete", "cento e oito",
				"cento e nove", "cento e dez"
		};
		for(int numero = 101 ; numero < 111 ; numero++)
		{
			String literal = Conversor.numeroToLiteral(numero);
			assertEquals(numeros[numero-101], literal);
			assertFalse(numeros[numero-101].toUpperCase().equals(literal));
		}		
	}
	
	@Test
	public void testCentoOnzeACentoDezenove(){
		String[] numeros = {
				"cento e onze", "cento e doze",
				"cento e treze", "cento e quatorze",
				"cento e quinze", "cento e dezesseis",
				"cento e dezessete", "cento e dezoito",
				"cento e dezenove"
		};
		for(int numero = 111 ; numero < 120 ; numero++)
		{
			String literal = Conversor.numeroToLiteral(numero);
			assertEquals(numeros[numero-111], literal);
			assertFalse(numeros[numero-111].toUpperCase().equals(literal));
		}
	}
	
	@Test
	public void testeCentoVinteACentoVinteNove(){
		String[] numeros = {
				"cento e vinte", "cento e vinte e um",
				"cento e vinte e dois", "cento e vinte e três",
				"cento e vinte e quatro", "cento e vinte e cinco",
				"cento e vinte e seis", "cento e vinte e sete",
				"cento e vinte e oito", "cento e vinte e nove"
		};
		for(int numero = 120 ; numero < 130 ; numero++)
		{
			String literal = Conversor.numeroToLiteral(numero);
			assertEquals(numeros[numero-120], literal);
			assertFalse(numeros[numero-120].toUpperCase().equals(literal));
		}
	}
	
	@Test
	public void testCentoTrintaACentoNoventaNove(){
		for(int x= 130; x < 200; x++){
			String literal = Conversor.numeroToLiteral(x);
			assertFalse("?".equals(literal));
		}
	}
	
	@Test
	public void testCentoQuarentaCinco(){
		String literal = Conversor.numeroToLiteral(145);
		assertEquals("cento e quarenta e cinco", literal);
	}
	
	@Test
	public void testAleatorioAteDuzentos(){
		Random random = new Random();
		for (int x=0; x<10000; x++){
			/*
			 * Gera números aleatórios de 0 a 199 10.000 vezes.
			 * Math.abs = pega o valor absoluto do inteiro.
			 */
			int numero = Math.abs(random.nextInt() % 200);
			
			String literal = Conversor.numeroToLiteral(numero);
			/*
			 * Verifico se o resultado não é igual a ?
			 */
			assertNotSame(numero+" -> "+literal,"?", literal);	
		}
	}
	
	@Test
	public void testDuzentos(){
		String literal = Conversor.numeroToLiteral(200);
		assertEquals("duzentos", literal);
	}
	
	@Test
	public void testDuzentosUm(){
		String literal = Conversor.numeroToLiteral(201);
		assertEquals("duzentos e um", literal);
	}
	
	@Test
	public void testDuzentosDoisDuzentosNove(){
		String[] numeros = { 
				"duzentos e dois" , "duzentos e três" ,
				"duzentos e quatro" , "duzentos e cinco" , 
				"duzentos e seis", "duzentos e sete",
				"duzentos e oito", "duzentos e nove"
		};
		
		for (int numero = 202; numero < 210; numero++){
			String literal = Conversor.numeroToLiteral(numero);
			assertEquals(numeros[numero-202], literal);
			assertFalse(numeros[numero-202].toUpperCase().equals(literal));
		}
	}
	
	@Test
	public void testTrezentosDoisTrezentosNove(){
		String[] numeros = { 
				"trezentos e dois" , "trezentos e três" ,
				"trezentos e quatro" , "trezentos e cinco" , 
				"trezentos e seis", "trezentos e sete",
				"trezentos e oito", "trezentos e nove"
		};
		
		for (int numero = 302; numero < 310; numero++){
			String literal = Conversor.numeroToLiteral(numero);
			assertEquals(numeros[numero-302], literal);
			assertFalse(numeros[numero-302].toUpperCase().equals(literal));
		}
	}
	
	@Test
	public void testQuatrocentosDoisQuatrocentosNove(){
		String[] numeros = { 
				"quatrocentos e dois" , "quatrocentos e três" ,
				"quatrocentos e quatro" , "quatrocentos e cinco" , 
				"quatrocentos e seis", "quatrocentos e sete",
				"quatrocentos e oito", "quatrocentos e nove"
		};
		
		for (int numero = 402; numero < 410; numero++){
			String literal = Conversor.numeroToLiteral(numero);
			assertEquals(numeros[numero-402], literal);
			assertFalse(numeros[numero-402].toUpperCase().equals(literal));
		}
	}
	@Test
	public void testCentenas(){
		String[] numeros = {
				"cem", "duzentos", "trezentos", "quatrocentos",
				"quinhentos", "seiscentos", "setecentos",
				"oitocentos", "novecentos"
		};
		
		for (int numero = 1; numero < 10; numero++){
			String literal = Conversor.numeroToLiteral(numero*100);
			assertEquals(numeros[numero-1], literal);
		}
	}
	
	@Test
	public void testAleatorioAteNovecentosNoventaNove(){
		Random random = new Random();
		for (int x=0; x<10; x++){
			/*
			 * Gera números aleatórios de 0 a 199 10.000 vezes.
			 * Math.abs = pega o valor absoluto do inteiro.
			 */
			int numero = Math.abs(random.nextInt() % 999);
			
			String literal = Conversor.numeroToLiteral(numero);
			/*
			 * Verifico se o resultado não é igual a ?
			 */
			assertNotSame(numero+" -> "+literal,"?", literal);	
		}
	}
}
















