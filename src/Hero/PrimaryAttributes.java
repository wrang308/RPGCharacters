package Hero;

public class PrimaryAttributes {
    public PrimaryAttributes(int strength, int dexterity, int intelligence, int vitality) {
        Strength = strength;
        Dexterity = dexterity;
        Intelligence = intelligence;
        Vitality = vitality;
    }

    public int getStrength() {
        return Strength;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public int getIntelligence() {
        return Intelligence;
    }

    public int getVitality() {
        return Vitality;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) {
        Intelligence = intelligence;
    }

    public void setVitality(int vitality) {
        Vitality = vitality;
    }

    public void addStrength(int strength) {
        this.Strength += strength;
    }

    public void addDexterity(int dexterity) {
        this.Dexterity += dexterity;
    }

    public void addIntelligence(int intelligence) {
        this.Intelligence += intelligence;
    }

    public void addVitality(int vitality) {
        this.Vitality += vitality;
    }

    private int Strength;
    private int Dexterity;
    private int Intelligence;
    private int Vitality;

}
