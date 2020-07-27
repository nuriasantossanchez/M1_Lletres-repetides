package fase4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UtilsList {

	private List<Character> listCharacterNombre;
	private List<Character> listCharacterApellido;
	private String strNombre;
	private String strApellido;
	final private char charEspacio = ' ';

	public UtilsList(List<Character> listCharacterNombre, List<Character> listCharacterApellido) {
		this.listCharacterNombre = listCharacterNombre;
		this.listCharacterApellido = listCharacterApellido;
	}

	public UtilsList(List<Character> listCharacterNombre, String strApellido) {
		this.listCharacterNombre = listCharacterNombre;
		this.strApellido = strApellido;
	}

	public UtilsList(String strNombre, String strApellido) {
		this.strNombre = strNombre;
		this.strApellido = strApellido;
	}

	public List<Character> getListCharacterNombre() {
		return listCharacterNombre;
	}

	public void setListCharacterNombre(List<Character> listCharacterNombre) {
		this.listCharacterNombre = listCharacterNombre;
	}

	public List<Character> getListCharacterApellido() {
		return listCharacterApellido;
	}

	public void setListCharacterApellido(List<Character> listCharacterApellido) {
		this.listCharacterApellido = listCharacterApellido;
	}

	public String getStrNombre() {
		return strNombre;
	}

	public void setStrNombre(String strNombre) {
		this.strNombre = strNombre;
	}

	public String getStrApellido() {
		return strApellido;
	}

	public void setStrApellido(String strApellido) {
		this.strApellido = strApellido;
	}

	public List<Character> getListName() {
		List<Character> listName = new ArrayList<Character>();

		if (getListCharacterNombre() != null) {
			char caracter;
			Iterator<Character> it = getListCharacterNombre().iterator();
			while (it.hasNext()) {
				caracter = it.next();
				listName.add(Character.toUpperCase(caracter));
			}
		} else {
			for (int i = 0; i < this.getStrNombre().length(); i++) {
				listName.add(Character.toUpperCase(this.getStrNombre().charAt(i)));
			}
		}
		return listName;
	}

	public List<Character> getListSurname() {
		List<Character> listSurname = new ArrayList<Character>();

		if (getListCharacterApellido() != null) {
			char caracter;
			Iterator<Character> it = getListCharacterApellido().iterator();
			while (it.hasNext()) {
				caracter = it.next();
				listSurname.add(Character.toUpperCase(caracter));
			}
		} else {
			for (int i = 0; i < this.getStrApellido().length(); i++) {
				listSurname.add(Character.toUpperCase(this.getStrApellido().charAt(i)));
			}
		}
		return listSurname;
	}

	public List<Character> getListFullName() {
		List<Character> listFullName = new ArrayList<Character>();

		listFullName.addAll(getListName());
		listFullName.add(this.charEspacio);
		listFullName.addAll(getListSurname());

		return listFullName;
	}

	public void printListFullName() {

		System.out.print("FullName: ");
		System.out.print(getListFullName());
		System.out.println();
		System.out.println("---------");
	}
	
}
