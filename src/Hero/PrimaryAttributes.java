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

    private int Strength;
    private int Dexterity;
    private int Intelligence;
    private int Vitality;

}
