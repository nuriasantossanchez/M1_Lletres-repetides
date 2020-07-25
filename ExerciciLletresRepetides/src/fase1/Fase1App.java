package fase1;

public class Fase1App {

	public static void main(String[] args) {
		String cadena =" @ Nuria Maria  Antonia  123@ ## ";
		char arrayNotNull[]=new char[4];
		char arrayNull[]=null;		
		char arrayBlancos[]= {' ',' ',' ',' ',' ',' ',' '};
		char arrayKo[]= {' ',' ',',','1',' ','@',' ',' ',' ',' ',' ','/',' ',';',')',' ',' '};
		char arrayOk1[]= {' ',' ',' ',' ',' ','N','u',',','1',' ','@','a',' ',' ','v','e','c','e','s',' ',' ',' ','x'};
		char arrayOk2[]= {'&',' ',' ','N','u',' ','r','i',' ',' ',' ',' ','a'};
		
	
		InicializadorArrayChar test1_InicicalizaPorDefecto= new InicializadorArrayChar();
		test1_InicicalizaPorDefecto.printArrayChar();
		
		InicializadorArrayChar test2_InicializaArrayNotNull=new InicializadorArrayChar(arrayNotNull);
		test2_InicializaArrayNotNull.printArrayChar();
		
		InicializadorArrayChar test3_InicializaArrayNull=new InicializadorArrayChar(arrayNull);
		test3_InicializaArrayNull.printArrayChar();
		
		InicializadorArrayChar test4_InicializaArrayConString=new InicializadorArrayChar(cadena);
		test4_InicializaArrayConString.printArrayChar();
		
		InicializadorArrayChar test5_InicializaArrayBlancos=new InicializadorArrayChar(arrayBlancos);
		test5_InicializaArrayBlancos.printArrayChar();
	
		InicializadorArrayChar test6_InicializaArrayKo=new InicializadorArrayChar(arrayKo);
		test6_InicializaArrayKo.printArrayChar();
		
		InicializadorArrayChar test7_InicializaArrayOk1=new InicializadorArrayChar(arrayOk1);
		test7_InicializaArrayOk1.printArrayChar();
		
		InicializadorArrayChar test8_InicializaArrayOk2=new InicializadorArrayChar(arrayOk2);
		test8_InicializaArrayOk2.printArrayChar();
	}
}
