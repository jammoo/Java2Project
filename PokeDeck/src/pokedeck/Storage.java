package pokedeck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

        public Storage() {};
        
        public Storage(ArrayList<Pokemon> listOfPokemon) {
            this.listOfPokemon = listOfPokemon;
        };
        
        public String[] getNames() {
            String[] temp = new String[this.getListOfPokemon().size()];
            for (int i = 0; i < this.getListOfPokemon().size(); i++) {
                temp[i] = listOfPokemon.get(i).getType().name();
            }
            return temp;
        }
        
        public void move(int i1, int i2) {
            Pokemon temp = listOfPokemon.get(i1);
            listOfPokemon.get(i1).replace(listOfPokemon.get(i2));
            listOfPokemon.get(i2).replace(temp);
        }
        
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
        
        public void replacePokemon(Pokemon original, Pokemon replacement) {
            listOfPokemon.get(listOfPokemon.indexOf(original)).replace(replacement);
        }
        
        /**
         * this method should return a search result
         */
        public ArrayList<Pokemon> findPokemon(TypePokemon search) {
            ArrayList<Pokemon> temp = new ArrayList<>();
            if (search == null) {
                return this.listOfPokemon;
            }
            else {
                for (Pokemon pokemon : this.listOfPokemon) {
                    if (pokemon.getType() == search) {
                        temp.add(pokemon);
                    }
                }
                return temp;
            }
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
            // The name of the file to open.
            String fileName = "pokeDeckData.txt";
            // This will reference one line at a time
            String line = null;
            try {
                // create FileReader object
                FileReader fileReader = new FileReader(fileName);
                // create BufferedReader object to go in the FileReader
                BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(" ");
                int id = Integer.parseInt(values[0]);
                TypePokemon type = TypePokemon.valueOf(values[1]);
                String nickName = values[2];
                int exp = Integer.parseInt(values[3]);
                int level = Integer.parseInt(values[4]);
                int hp = Integer.parseInt(values[5]);
                int atk = Integer.parseInt(values[6]);
                int def = Integer.parseInt(values[7]);
                int spAtk = Integer.parseInt(values[8]);
                int spDef = Integer.parseInt(values[9]);
                int speed = Integer.parseInt(values[10]);
                listOfPokemon.add(new Pokemon(id, type, nickName, hp, atk, def, spAtk, spDef, speed, level, exp));
            }   

            // Always close files.
            bufferedReader.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println("Unable to find file '" + fileName + "'");
            }
            catch(IOException ex) {
                System.out.println("Error reading file '" + fileName + "'");
            }
            success = true;
            return success;
        }
        
        /**
         * this method will save the current list of pokemon to a file
         * @return 
         */
        public boolean saveData() {
            boolean success = true;
             // The name of the file to open.
             String fileName = "pokeDeckData.txt";
             try {
                // create fileWriter object
                FileWriter fileWriter = new FileWriter(fileName);
                // create bufferWriter object
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                // write to the buffer
                 for (int i = 0; i < listOfPokemon.size(); i++) {
                     bufferedWriter.write(listOfPokemon.get(i).extract());
                     bufferedWriter.newLine();
                 }
            // close file
            bufferedWriter.close();
             }
             catch(IOException ex) {
                 System.out.println("Error writing to file '" + fileName + "'");
                 success = false;
             }
             return success;
        }
        
        @Override
        public String toString() {
            String result = "";
            for (int i = 0; i < listOfPokemon.size()-1; i++) {
                result += listOfPokemon.get(i) +"\n";
            }
            return result;
        };

}