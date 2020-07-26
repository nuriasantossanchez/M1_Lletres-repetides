package fase3;

import java.util.Map;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class UtilsMap {

	private Map<Character, Integer> mapLetras;
	private List<Character> listChar;

	public UtilsMap(List<Character> listChar) {
		this.listChar = listChar;
	}

	public Map<Character, Integer> getMapLetras() {
		return mapLetras;
	}

	public void setMapLetras(Map<Character, Integer> mapLetras) {
		this.mapLetras = mapLetras;
	}

	public List<Character> getListChar() {
		return listChar;
	}

	public void setListChar(List<Character> listChar) {
		this.listChar = listChar;
	}

	public Map<Character, Integer> getMapDeListChar(List<Character> listChar) {
		Map<Character, Integer> mapLetras = new LinkedHashMap<Character, Integer>();

		char letra;
		Iterator<Character> it = listChar.iterator();
		while (it.hasNext()) {
			letra = it.next();
			if (!mapLetras.containsKey(Character.toUpperCase(letra)) && !Character.isSpaceChar(letra) && !Character.isDigit(letra)) {
				mapLetras.put(Character.toUpperCase(letra), 1);
			} else {
				for (Map.Entry<Character, Integer> entrada : mapLetras.entrySet()) {
					char clave = entrada.getKey();
					if (entrada.getKey().equals(Character.toUpperCase(letra))) {
						int valor = entrada.getValue() + 1;
						mapLetras.put(clave, valor);
					}
				}
			}
		}
		
		this.setMapLetras(mapLetras);
		return this.getMapLetras();
	}
	
	public void printMap() {
		Map<Character, Integer> Map = getMapDeListChar(this.getListChar());

		for (Map.Entry<Character, Integer> entrada : Map.entrySet()) {
			char clave = entrada.getKey();
			int valor = entrada.getValue();
			if(valor!=1) {
				System.out.println("Letra [" + clave + "] aparece [" + valor + "] veces");
			}
			else {
				System.out.println("Letra [" + clave + "] aparece [" + valor + "] vez");
			}
		}
	}

}
