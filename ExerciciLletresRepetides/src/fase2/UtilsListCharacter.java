package fase2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UtilsListCharacter {
	
	private char arrayChar[];
	private List<Character> listChar;
	
	public UtilsListCharacter() {
		this.listChar=Arrays.asList('N','u','r','i','a');
	}

	public UtilsListCharacter(List<Character> listCharacter) {
		if (listCharacter!=null) {
			this.listChar = listCharacter;
		}
	}
	
	public UtilsListCharacter(char[] arrayChar) {
		if(arrayChar!=null && arrayChar.length!=0) {
			this.arrayChar = arrayChar;
			int asciiChar_NUL=0;//valor ASCII de una variable 'char x[]=new[n]' sin valores
			this.listChar = new ArrayList<>();
			if ((int)getArrayChar()[0]!=asciiChar_NUL) {
				for (int i=0;i<this.getArrayChar().length;i++) {
					listChar.add(this.arrayChar[i]);
				}
			}
		}
	}
	
	public UtilsListCharacter(String cadena) {
		this.listChar = getListCharDeCadena(cadena);
	}
	
	public char[] getArrayChar() {
		return arrayChar;
	}

	public void setArrayChar(char[] arrayChar) {
		this.arrayChar = arrayChar;
	}

	public List<Character> getListChar() {
		return listChar;
	}

	public void setListChar(List<Character> listChar) {
		this.listChar = listChar;
	}
	
	private List<Character> getListCharDeCadena(String cadena) {
		List<Character> listChar = new ArrayList<>();
		for (int i = 0; i < cadena.length(); i++) {
			listChar.add(cadena.charAt(i));
		}
		setListChar(listChar);
		return this.getListChar();
	}
	
	public void pritListChar() {
		
		if (null==getListChar()){
			System.out.println("-----------------------------------------------------------");
			System.out.println("List<Character> de entrada nulo");
			System.out.println("-----------------------------------------------------------");
		}else if (getListChar().isEmpty()) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("List<Character> de entrada vacio");
			System.out.println("-----------------------------------------------------------");
		}else {
			System.out.println("-----------------------------------------------------------");
			System.out.print("List<Character> de entrada: '");
			
			for (Character ch:getListChar()) {
				System.out.print(ch);
			}

			System.out.println("'");
			System.out.println("-----------------------------------------------------------");
			System.out.println();
			
			printVocalConsonateListChar(getListChar());
		}
	}
	
	public void printVocalConsonateListChar(List<Character> lista) {
		
		Iterator<Character> it = lista.iterator();
		char caracter;
		while(it.hasNext()) {
			caracter=it.next();
			System.out.print("[" + caracter + "]: ");
			switch (Character.toUpperCase(caracter)) {
			case 'A':
				System.out.println("VOCAL");
				break;
			case 'E':
				System.out.println("VOCAL");
				break;
			case 'I':
				System.out.println("VOCAL");
				break;
			case 'O':
				System.out.println("VOCAL");
				break;
			case 'U':
				System.out.println("VOCAL");
				break;
			default:
				if (!printConsonante(caracter)) {
					printCharNoPermitido(caracter);
				}
				break;
			}
		}
	}
	
	private boolean printConsonante(char caracter) {
		boolean esConsonante=false;
		int ascii = (int) caracter;
		boolean esAscciMayuscula = (ascii >= 65 && ascii <= 90);
		boolean esAsciiMinuscula = (ascii >= 97 && ascii <= 122);
		boolean esCharPermitido = (esAscciMayuscula || esAsciiMinuscula);
		if (esCharPermitido) {
			 System.out.println("CONSONANTE");
			 esConsonante=true;
		 }
		return esConsonante;
	}

	private void printCharNoPermitido(char caracter) {
		char charEspacio = ' ';
		int ascii =(int) caracter;;
		boolean esAsciiNumero = (ascii >= 48 && ascii <= 57);
		boolean esAscciMayuscula = (ascii >= 65 && ascii <= 90);
		boolean esAsciiMinuscula = (ascii >= 97 && ascii <= 122);
		boolean esCharPermitido = (esAscciMayuscula || esAsciiMinuscula);

		if (esAsciiNumero) {
			System.out.println("Los nombres de personas no contienen numeros");
		}else if (caracter == charEspacio){
			System.out.println("Es un espacio");
		}
		else if (!esCharPermitido) {
			System.out.println("Caracter no permitido.");
		}
	}
	
}
