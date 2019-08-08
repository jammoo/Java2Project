package pokedeck;

public enum TypePokemon {
    EMPTY("pokedeck/assets/Pikachu.png"), PIKACHU(35, 55, 40, 50, 50, 90, "pokedeck/assets/Pikachu.png"), 
    CHARMANDER(39, 52, 43, 60, 50, 65, "pokedeck/assets/Charmander.png"), 
    BULBASAUR(45, 49, 49, 65, 65, 45, "pokedeck/assets/Bulbasaur.png"), 
    EVEE(55, 55, 50, 45, 65, 55, "pokedeck/assets/Evee.png"), 
    DRAGONITE(91, 134, 95, 100, 100, 80, "pokedeck/assets/Dragonite.png"),
    LUGIA(106, 90, 130, 90, 154, 110, "pokedeck/assets/Lugia.png");
    public final int hp;
    public final int atk;
    public final int def;
    public final int spAtk;
    public final int spDef;
    public final int speed;
    public final String img;
    
    private TypePokemon(int hp, int atk, int def, int spAtk, int spDef, int speed, String img) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
        this.img = img;
    }
    
    private TypePokemon(String img) {
        this.hp = 1;
        this.atk = 1;
        this.def = 1;
        this.spAtk = 1;
        this.spDef = 1;
        this.speed = 1;
        this.img = img;
    }
}