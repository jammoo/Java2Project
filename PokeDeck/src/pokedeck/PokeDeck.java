/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedeck;

/**
 *
 * @author Jammoo
 */
public class PokeDeck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pokemon Larry = new Pokemon(TypePokemon.LUGIA, "Larry");
        System.out.println(Larry.toString());
        Storage pokeDeck = new Storage();
        pokeDeck.addPokemon(new Pokemon(TypePokemon.BULBASAUR));
        pokeDeck.addPokemon(new Pokemon(TypePokemon.CHARMANDER));
        pokeDeck.addPokemon(new Pokemon(TypePokemon.DRAGONITE));
        pokeDeck.addPokemon(new Pokemon(TypePokemon.EVEE));
        System.out.println(pokeDeck.toString());
        System.out.println(pokeDeck.saveData());
    }
    
}
