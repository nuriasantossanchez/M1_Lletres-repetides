package fase1;

public class InicializadorArrayChar {

	private final char DEFAULT_VALUE_ARRAYCHAR[] = { 'N', 'U', 'R', 'I', 'A' };
	private final int ERROR_ARRAYCHAR_NULL=0;
	private final int ERROR_ARRAYCHAR_NO_INICIALIZADO=1;
	private final int ERROR_ARRAYCHAR_NO_PERMITIDO=2;
	private final int ERROR_ARRAYCHAR_ESPACIOS=3;
	
	private char arrayChar[];

	public InicializadorArrayChar() {
		arrayChar = DEFAULT_VALUE_ARRAYCHAR;
	}

	public InicializadorArrayChar(char[] arrayChar) {
		if (arrayChar != null) {
			this.arrayChar = arrayChar;
		}
	}

	public InicializadorArrayChar(String cadena) {
		this.arrayChar = getArrayCharDeCadena(cadena);
	}

	public char[] getArrayChar() {
		return arrayChar;
	}

	public void setArrayChar(char[] arrayChar) {
		this.arrayChar = arrayChar;
	}

	private char[] getArrayCharDeCadena(String cadena) {
		this.arrayChar = new char[cadena.length()];
		for (int i = 0; i < cadena.length(); i++) {
			this.arrayChar[i] = cadena.charAt(i);
		}
		setArrayChar(this.arrayChar);
		return this.getArrayChar();
	}

	public boolean validarArrayChar(char[] array) {
		boolean esValido = false;
		if (array != null && array.length != 0) {
			esValido = true;
		}
		return esValido;
	}

	public void printArrayChar() {
		char arrayAImprimir[] = null;
		char charEspacio = ' ';
		int ascii = (int) charEspacio;

		if (!validarArrayChar(this.getArrayChar())) {
			printMensajeError(this.getArrayChar(),ERROR_ARRAYCHAR_NULL);
		} else {
			printCabecera();
			printArrayCharDeEntrada(this.getArrayChar());
			arrayAImprimir = new char[this.getArrayChar().length];
			arrayAImprimir = limpiarCaracteresNoPermitidos(this.getArrayChar());

			System.out.print("Me llamo ");
			for (int i = 0; i < arrayAImprimir.length; i++) {
				System.out.print(arrayAImprimir[i]);
				ascii = arrayAImprimir[i];
				for (int j = i; j < arrayAImprimir.length && ascii == (int) charEspacio; j++) {
					ascii = (int) arrayAImprimir[j];
					i = (i<0)?0:(j - 1);
					if (j == arrayAImprimir.length-1 && ascii == (int) charEspacio) {
						i=j;
						break;
					}
				}
			}
			System.out.println();
		}
	}

	private char[] limpiarCaracteresNoPermitidos(char[] arrayChar) {
		char charEspacio = ' ';
		int ascii = (int) charEspacio;
		boolean esAscciMayuscula = (ascii >= 65 && ascii <= 90);
		boolean esAsciiMinuscula = (ascii >= 97 && ascii <= 122);
		boolean esCharPermitido = (esAscciMayuscula || esAsciiMinuscula);
		int contBlancos = 0;
		int contNoPermitidos = 0;
		int asciiChar_NUL=0;//valor ASCII de una variable 'char x[]=new[n]' sin valores
		int contAsciiChar_NUL=0;
		
		if (!validarArrayChar(arrayChar)) {
			printMensajeError(arrayChar,ERROR_ARRAYCHAR_NULL);
		} else {
			for (int i = 0; i < arrayChar.length; i++) {
				ascii = (int) arrayChar[i];
				esAscciMayuscula = (ascii >= 65 && ascii <= 90);
				esAsciiMinuscula = (ascii >= 97 && ascii <= 122);
				esCharPermitido = (esAscciMayuscula || esAsciiMinuscula);
				if(ascii==asciiChar_NUL) {
					System.out.println("char["+arrayChar.length+"] sin valor. Posición [" + i + "]");
					arrayChar[i] = charEspacio;
					contAsciiChar_NUL++;
				}else if (!esCharPermitido && ascii != (int) charEspacio) {
					System.out.println("Caracter [" + arrayChar[i] + "] no permitido. Posición [" + i + "]");
					arrayChar[i] = charEspacio;
					contNoPermitidos++;
				} else if (ascii == (int) charEspacio){
					System.out.println("Caracter [" + arrayChar[i] + "] es un espacio. Posición [" + i + "]");
					contBlancos++;
				}
			}
			System.out.println();
		}
		
		if(contBlancos == arrayChar.length) {
			printMensajeError(arrayChar,ERROR_ARRAYCHAR_ESPACIOS);
			char arrayPorDefecto[]=getDefaultValueParaArrayDeNPosiciones(contBlancos);
			this.setArrayChar(arrayPorDefecto);
		}else if (contNoPermitidos + contBlancos == arrayChar.length) {
			printMensajeError(arrayChar,ERROR_ARRAYCHAR_NO_PERMITIDO);
			char arrayPorDefecto[]=getDefaultValueParaArrayDeNPosiciones(contBlancos);
			this.setArrayChar(arrayPorDefecto);
		} else if (contAsciiChar_NUL==arrayChar.length){
			printMensajeError(arrayChar,ERROR_ARRAYCHAR_NO_INICIALIZADO);
			char arrayPorDefecto[]=getDefaultValueParaArrayDeNPosiciones(contAsciiChar_NUL);
			this.setArrayChar(arrayPorDefecto);
		}else {
			this.setArrayChar(arrayChar);
		}

		return this.getArrayChar();
	}

	private char[] getDefaultValueParaArrayDeNPosiciones(int tamanio) {
		char charEspacio = ' ';
		char arrayDeNPosiciones[] =new char[tamanio];
		
		if(tamanio<DEFAULT_VALUE_ARRAYCHAR.length) {
			for(int i=0;i<tamanio;i++) {
				arrayDeNPosiciones[i]=DEFAULT_VALUE_ARRAYCHAR[i];	
			}
		}
		else {
			for(int i=0;i<DEFAULT_VALUE_ARRAYCHAR.length;i++) {
				arrayDeNPosiciones[i]=DEFAULT_VALUE_ARRAYCHAR[i];
				
				if(i==arrayDeNPosiciones.length-1){
					for(int j=i;j<arrayDeNPosiciones.length;j++){
						arrayDeNPosiciones[j]=charEspacio;
					}
				}
			}
		}
		
		return arrayDeNPosiciones;
	}

	private void printCabecera() {
		System.out.println();
		System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- --");
		System.out.println("Test inicializar char[] con mi nombre");
		System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- --");
	}
	
	private void printArrayCharDeEntrada(char[] arrayChar) {
		System.out.println("-----------------------------------------");
		System.out.print("Datos de entrada {");
		for (int i = 0; i < arrayChar.length; i++) {
			System.out.print(arrayChar[i]);
		}
		System.out.print("}");
		System.out.println("\n-----------------------------------------\n");
	}

	private void printMensajeError(char[] arrayChar, int tipoError) {
		
		if (tipoError == ERROR_ARRAYCHAR_NULL) {
			printCabecera();
			System.out.println("-----------------------------------------");
			System.out.print("Detalle de error: ");
			System.out.print("char[] es nulo");
			System.out.println("\n-----------------------------------------\n");
			System.out.print("Por defecto ");
			printValorPorDefecto();
			return;
		} else {
			System.out.println("-----------------------------------------");
			System.out.print("Detalle de error: ");
			
			if (tipoError == ERROR_ARRAYCHAR_NO_INICIALIZADO) {
				System.out.print("char[" + arrayChar.length + "] no inicializado");
			} else if (tipoError == ERROR_ARRAYCHAR_NO_PERMITIDO) {
				System.out.print("char[" + arrayChar.length + "] tiene todos los caracteres no permitidos");
			} else if (tipoError == ERROR_ARRAYCHAR_ESPACIOS) {
				System.out.print("char[" + arrayChar.length + "] todos los caracteres son espacios");
			}
		}
		
		System.out.println("\n-----------------------------------------\n");
		System.out.print("Por defecto ");
	}

	private void printValorPorDefecto() {
		System.out.print("Me llamo ");
		for (int i = 0; i < DEFAULT_VALUE_ARRAYCHAR.length; i++) {
			System.out.print(DEFAULT_VALUE_ARRAYCHAR[i]);
		}
	}

}
