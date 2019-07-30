package pokedeck;

import java.util.ArrayList;

/**
 * must store 30x15 Pokemon objects
 * this class models the storage of Pokemon objects using ArrayLists,
 * it must be able to perform operations such as adding Pokemon objects to the 
 * list, removing Pokemon objects from the list, replacing modified 
 * Pokemon objects in the list, searching for specific Pokemon objects, 
 * reading in Pokemon objects from a file, saving the list of Pokemon objects 
 * to the file, etc. 
 * The list acts as the data file while the program is 
 * running: load the list with Pokemon objects at program startup, then on exit,
 * overwrite the file with the Pokemon objects from the list. Don't perform 
 * add/edit/delete operations on the file directly as they occur - use the list.
 * @author James
 */
public class Storage {

	private ArrayList<Pokemon> listOfPokemon = new ArrayList<Pokemon>();

	/**
	 * 
	 * @param pokemon
	 */
	public void addPokemon(Pokemon pokemon) {
		listOfPokemon.add(pokemon);
	}

	/**
	 * 
	 * @param pokemon
	 */
	public void removePokemon(int location) {
            listOfPokemon.remove(location);
	}
        
        public void replacePokemon(Pokemon pokemon) {
            pokemon.replace(pokemon);
        }
        
        /**
         * this method should return a search result
         */
        public void findPokemon() {
            ///////////////////////////////////////////////////////////////////////
        }

	public ArrayList<Pokemon> getListOfPokemon() {
		return this.listOfPokemon;
	}

	/**
	 *  
	 * @param listOfPokemon
	 */
	public void setListOfPokemon(ArrayList<Pokemon> listOfPokemon) {
		this.listOfPokemon = listOfPokemon;
	}
        
        /**
         * This method will read in a file and set the data to the contents of
         * the file
         */
        public boolean loadData() {
            boolean success = false;
            ///////////////////////////////////////////////////////////////////////
            return success;
        }
        
        /**
         * this method will save the current list of pokemon to a file
         * @return 
         */
        public boolean saveData() {
            boolean success = false;
            ///////////////////////////////////////////////////////////////////////
            return success;
        }

}