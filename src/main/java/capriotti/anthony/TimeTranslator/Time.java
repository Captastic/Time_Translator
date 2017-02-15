package capriotti.anthony.TimeTranslator;

/**
 * Created by anthonycapriotti on 2/15/17.
 */
public class Time {
    Units units;
    Tens tens;

    public enum Units {one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, noon,
                        thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen}
    public enum Tens { twenty, thirty, forty, fifty }

    public Time(int units, int tens){
        this.units = Units.values()[units];
        this.tens = Tens.values()[tens];
    }

    public Units getUnits() {
        return units;
    }

    public Tens getTens() {
        return tens;
    }
}
