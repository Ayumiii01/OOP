package pas;

import java.util.Comparator;

public abstract class Plant {
    public static final int INFINITE = Integer.MAX_VALUE;

    String name;
    int hp;
    int sun_cost;

    public Plant(String name, int sun_cost) {
        this.name = name;
        this.hp = 6;
        this.sun_cost = sun_cost;
    }

    public Plant(String name, int hp, int sun_cost) {
        this.name = name;
        this.hp = hp;
        this.sun_cost = sun_cost;
    }

    public boolean isAlive() {
        // TODO implementation
        if(hp > 0) {
            return true;
        }
        return false;
    }

    public String die() {
        // TODO implementation
        hp = 0;
        return name + " dies";
    }

    @Override
    public String toString() {
        // TODO implementation
        //return super.toString();
        String hp2 = (hp == INFINITE) ? "?" : String.valueOf(hp);
        return name + " (" + hp2 + ") " + "- cost: " + sun_cost;
    }

    // Add Plant subclasses here, and
    public static class Sunflower extends Plant implements SunProducer, Upgradable {
        public Sunflower() {
            super("Sunflower", 50);
        }

        @Override
        public int produce_sun() {
            int n = 25;
            System.out.println(name + " produces " + n + " suns");
            return n;
        }

        @Override
        public PlantUpgrade upgrade() {
            return new TwinSunflower();
        }
    }

    public static class TwinSunflower extends Plant implements SunProducer, PlantUpgrade {
        public TwinSunflower() {
            super("Twin Sunflower", 250);
        }

        @Override
        public int produce_sun() {
            int n = 50;
            System.out.println(name + " produces " + n + " suns");
            return n;
        }

        @Override
        public int concurrentSunCost() {
            return 50;
        }
    }

    public static class Peashooter extends Plant implements Attacker {
        public Peashooter() {
            super("Peashooter", 100);
        }

        @Override
        public int attack() {
            System.out.println(name + " attacks");
            return 1;
        }

        @Override
        public int rangeType() {
            return 1;            //single-line
        }
    }

    // WallNut and CoffeeBean given for free
    public static class WallNut extends Plant {
        public WallNut() {
            super("Wall Nut", 25, 50);
        }

    }

    public static class Squash extends Plant implements InstantKiller, Attacker {

        public Squash() {
            super("Squash", INFINITE, 50);
        }

        @Override
        public int attack() {
            System.out.println(name + " attacks");
            hp = 0;
            return 3;
        }

        @Override
        public int rangeType() {
            return 3;               //limited-range
        }

        @Override
        public int killType() {
            return 1;               //close-contact
        }

        @Override
        public String die() {
            return super.die() + " while squashing zombies";
        }
    }

    public static class Jalapeno extends Plant implements InstantKiller, Attacker {


        public Jalapeno() {
            super("Jalapeno", INFINITE, 125);
        }

        @Override
        public int attack() {
            System.out.println(name + " attacks");
            hp = 0;
            return 5;
        }

        @Override
        public int rangeType() {
            return 1;               //single-line
        }

        @Override
        public int killType() {
            return 2;               //instant-kill
        }


        @Override
        public String die() {
            return super.die() + " while exploding";
        }
    }

    // WallNut and CoffeeBean given for free
    public static class CoffeeBean extends Plant {
        public CoffeeBean() {
            super("Coffee Bean", INFINITE, 75);
        }
    }

    public static class LilyPad extends Plant implements Upgradable {
        public LilyPad() {
            super("Lily Pad", 25);
        }

        @Override
        public PlantUpgrade upgrade() {
            return new Cattail();
        }
    }

    public static class Cattail extends Plant implements PlantUpgrade, Attacker {
        public Cattail() {
            super("Cattail", 225);
        }

        @Override
        public int attack() {
            System.out.println(name + " attacks");
            return 1;
        }

        @Override
        public int rangeType() {
            return 4;               //free-range
        }

        @Override
        public int concurrentSunCost() {
            return 25;
        }
    }
    // Hint: You can also add Comparator inner classes here

    public static class HpComparator implements Comparator<Plant> {
        @Override
        public int compare(Plant p1, Plant p2) {
            int c = Integer.compare(p2.hp, p1.hp);
            return (c != 0) ? c : p1.name.compareTo(p2.name);
        }
    }

    public static class NameComparator implements Comparator<Plant> {
        @Override
        public int compare(Plant p1, Plant p2) {
            return p1.name.compareTo(p2.name);
        }
    }

    public static class SunComparator implements Comparator<Plant> {
        @Override
        public int compare(Plant p1, Plant p2) {
            int c = Integer.compare(p2.sun_cost, p1.sun_cost);
            return (c != 0) ? c : p1.name.compareTo(p2.name);
        }
    }
}
