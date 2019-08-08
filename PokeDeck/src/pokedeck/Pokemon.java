package pokedeck;

public class Pokemon {

	private int id = 0000;
	private TypePokemon type;
	private String nickName;
	private int exp;
	private int level;
	private int hp;
	private int atk;
	private int def;
	private int spAtk;
	private int spDef;
	private int speed;
        private String img;

    public Pokemon(int id, TypePokemon type, String nickName) {
        this.type = type;
        setStats();
        this.id = id;
        
        this.nickName = nickName;
    }
    
    public Pokemon(TypePokemon type) {
        this.type = type;
        setStats();
    }
    
    public Pokemon(TypePokemon type, String nickName) {
        this.type = type;
        setStats();
        this.nickName = nickName;
    }


    public Pokemon(int id, TypePokemon type, String nickName, int hp, int atk, int def, int spAtk, int spDef, int speed, int level, int exp) {
        this.type = type;
        setStats();
        this.id = id;
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
    
    public void setStats() {
        nickName = type.name();
	exp = 0;
	level = exp/100;
	hp = type.hp + type.hp*level;
	atk = type.atk + type.atk*level;
	def = type.def + type.def*level;
	spAtk = type.spAtk + type.spAtk*level;
	spDef = type.spDef + type.spDef*level;
	speed = type.speed + type.speed*level;
        img = type.img;
    }
        
    public String getImg() {
        return img;
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

    void replace(Pokemon pokemon) {
        this.type = pokemon.getType();
        setStats();
        this.id = pokemon.getId();
        this.nickName = pokemon.getNickName();
        this.exp = pokemon.getExp();
    }
    
        @Override
    public String toString() {
        String result = "";
        result += "id = " + id + ", type = " + type + ", nickName = " 
                + nickName + ", hp = " + hp + ", atk = " + atk + ", def = " +
                def + ", spAtk = " + spAtk + ", spDef = " + spDef + ", speed = " +
                speed + ", level = " + level + ", exp = " + exp;
        return result;
    };
    
    public String extract() {
        String result = "";
        result += id + " " + type.name() + " " + nickName + " " + hp + " " + atk + 
                " " + def + " " + spAtk + " " + spDef + " " + speed + 
                " " + level + " " + exp;
        return result;
    };
        
        

}