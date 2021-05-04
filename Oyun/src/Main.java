import Abstract.GameService;
import Concrete.GameManager;
import Entity.Campaign;
import Entity.Gamer;

public class Main {

    public static void main(String[] args) {
        Gamer tunahan = new Gamer(1,"123456798","Tunahan", "Berber", "02/19/1999", true);
        Campaign summerDiscount = new Campaign(1, "Yaz indirimi");

        GameService gamer = new GameManager();

        gamer.sell(tunahan, summerDiscount);
    }

}