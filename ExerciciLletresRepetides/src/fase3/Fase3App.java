package fase3;

import java.util.Arrays;
import java.util.List;


public class Fase3App {

	public static void main(String[] args) {

		List<Character> listChar = Arrays.asList('0','N', 'u','6',' ',' ','R', 'i', 'A', ' ', 'A', 'I','n','a');
		
		UtilsMap utils=new UtilsMap(listChar);
		utils.printMap();
	}
}
