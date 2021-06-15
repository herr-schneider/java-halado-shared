public class Game {
    private String firstCountry;
    private String secondCountry;
    private String firstCountryScore;
    private String secondCountryScore;

    public Game(String firstCountry, String secondCountry, String firstCountryScore, String secondCountryScore) {
        this.firstCountry = firstCountry;
        this.secondCountry = secondCountry;
        this.firstCountryScore = firstCountryScore;
        this.secondCountryScore = secondCountryScore;
    }

    public String whoIsTheWinner(){
        return Integer.parseInt(firstCountry) > Integer.parseInt(firstCountry) ? firstCountry : secondCountry;
    }
    public String getFirstCountry() {
        return firstCountry;
    }

    public void setFirstCountry(String firstCountry) {
        this.firstCountry = firstCountry;
    }

    public String getSecondCountry() {
        return secondCountry;
    }

    public void setSecondCountry(String secondCountry) {
        this.secondCountry = secondCountry;
    }

    public String getFirstCountryScore() {
        return firstCountryScore;
    }

    public void setFirstCountryScore(String firstCountryScore) {
        this.firstCountryScore = firstCountryScore;
    }

    public String getSecondCountryScore() {
        return secondCountryScore;
    }

    public void setSecondCountryScore(String secondCountryScore) {
        this.secondCountryScore = secondCountryScore;
    }

    //    ## Feladat
//    A mai feladatban az EB meccsek eredményeit kell egy alkalmazásban
//    tárolnod, és különböző feladatokat elvégezned.
//            ### Game
//    Legyen egy `Game` nevű osztályod a következő attribútumokkal
//+ `firstCountry (String)`
//            + `secondCountry (String)`
//            + `firstCountryScore (int)`
//            + `secondCountryScore (int)`
//            ### GameRepository
//    Legyen egy `GameRepository` nevű osztályod, melynek van egy meccseket
//    memóriában tároló listája.
//### GameService
//    Legyen egy `GameService` nevű osztályod, ami különböző statisztikai adatokat jelenít meg.
//    Legyen egy `GameRepository` attribútuma amin keresztül eléri a benne lévő listát.


}
