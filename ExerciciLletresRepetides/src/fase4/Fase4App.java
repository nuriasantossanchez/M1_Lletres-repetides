package fase4;

import java.util.Arrays;
import java.util.List;

import fase2.UtilsListCharacter;

public class Fase4App {

	public static void main(String[] args) {
		
		String strNombre= "Nuria Maria";
		String strApellido = "Santos";
		List<Character> listCharApellido=Arrays.asList('S','a','n','t','o','s',' ','S','a','n','c','h','e','z');;

		UtilsList utilsList = new UtilsList(strNombre, strApellido);
		utilsList.printListFullName();
		
		UtilsList utilsList2 = new UtilsList(new UtilsListCharacter().getListChar(), strApellido);
		utilsList2.printListFullName();
		
		UtilsList utilsList3 = new UtilsList(new UtilsListCharacter().getListChar(), listCharApellido);
		utilsList3.printListFullName();
		
	}
	
}
