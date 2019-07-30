package pokedeck;

public class Pokemon {

	private int id; // might want to use an enumerator to store these, and then save values withtin
	private TypePokemon type;
	private String nickName;
	private int hp = 1;
	private int atk = 1;
	private int def = 1;
	private int spAtk = 1;
	private int spDef = 1;
	private int speed = 1;
	private int level = 0;
	private int exp = 0;

    public Pokemon(int id, TypePokemon type, String nickName) {
        this.id = id;
        this.type = type;
        this.nickName = nickName;
    }

	

    public Pokemon(int id, TypePokemon type, String nickName, int hp, int atk, int def, int spAtk, int spDef, int speed, int level, int exp) {
        this.id = id;
        this.type = type;
        this.nickName = nickName;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
        this.level = level;
        this.exp = exp;
    }
        
        

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the type
     */
    public TypePokemon getType() {
        return type;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * @return the atk
     */
    public int getAtk() {
        return atk;
    }

    /**
     * @return the def
     */
    public int getDef() {
        return def;
    }

    /**
     * @return the spAtk
     */
    public int getSpAtk() {
        return spAtk;
    }

    /**
     * @return the spDef
     */
    public int getSpDef() {
        return spDef;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return the exp
     */
    public int getExp() {
        return exp;
    }
        
        

}