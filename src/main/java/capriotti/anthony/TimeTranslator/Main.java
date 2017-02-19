package capriotti.anthony.TimeTranslator;

/**
 * Created by anthonycapriotti on 2/15/17.
 */
public class Main {
    public static void main (String[] args){
        StandardConverter standardConverter = new StandardConverter();
        MilitaryConverter militaryConverter = new MilitaryConverter();
        System.out.println(standardConverter.outputTime("12:30 pm"));
        System.out.println(militaryConverter.outputMilitaryTime("23:55"));



    }
}
