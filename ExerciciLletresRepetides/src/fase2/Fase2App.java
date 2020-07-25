package fase2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fase2App {

	public static void main(String[] args) {
		
		List<Character> listChar = Arrays.asList('N','u','R','i','A',' ','0','9');
		List<Character> listCharEmpty = new ArrayList<>();
		List<Character> listCharNull =null;
		String cadena =" @ Nuria Maria  Antonia  123@ ## ";
		char arrayChar[]= {' ','N','u','6','r','i','a',' ','@',' ',' ','1','2','3','-','a',' '};
		char arrayCharNull[]= null;
		char arrayCharNotNull[]= new char[10];
		
		UtilsListCharacter utilListChar = new UtilsListCharacter(listChar);
		utilListChar.pritListChar();
		
		UtilsListCharacter utilListCharEmpty = new UtilsListCharacter(listCharEmpty);
		utilListCharEmpty.pritListChar();
		
		UtilsListCharacter utilListCharNull = new UtilsListCharacter(listCharNull);
		utilListCharNull.pritListChar();
		
		UtilsListCharacter utilListCharInitConCadena = new UtilsListCharacter(cadena);
		utilListCharInitConCadena.pritListChar();
		
		UtilsListCharacter utilListCharInitConArrayChar = new UtilsListCharacter(arrayChar);
		utilListCharInitConArrayChar.pritListChar();
		
		UtilsListCharacter utilListCharInitConArrayCharNull = new UtilsListCharacter(arrayCharNull);
		utilListCharInitConArrayCharNull.pritListChar();
		
		UtilsListCharacter utilListCharInitConArrayCharNotNull = new UtilsListCharacter(arrayCharNotNull);
		utilListCharInitConArrayCharNotNull.pritListChar();

	}
}
