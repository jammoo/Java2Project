package pokedeck;

public enum TypePokemon {
    EMPTY(), PIKACHU(35, 55, 40, 50, 50, 90), CHARMANDER(39, 52, 43, 60, 50, 65), 
    BULBASAUR(45, 49, 49, 65, 65, 45), EVEE(55, 55, 50, 45, 65, 55), 
    DRAGONITE(91, 134, 95, 100, 100, 80), LUGIA(106, 90, 130, 90, 154, 110);
    public final int hp;
    public final int atk;
    public final int def;
    public final int spAtk;
    public final int spDef;
    public final int speed;
    
    private TypePokemon(int hp, int atk, int def, int spAtk, int spDef, int speed) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
    }
    
    private TypePokemon() {
        this.hp = 1;
        this.atk = 1;
        this.def = 1;
        this.spAtk = 1;
        this.spDef = 1;
        this.speed = 1;
    }
}