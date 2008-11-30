package br.dojo.numeroToLiteral;

import org.junit.Test;
import static org.junit.Assert.*;

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
}








