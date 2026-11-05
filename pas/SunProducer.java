package pas;

public interface SunProducer {
    int produce_sun();
}

// add more interfaces here
interface Attacker {
    int attack();
    int rangeType();
}

interface InstantKiller {
    int killType();
}

interface PlantUpgrade {
    int concurrentSunCost();
}

interface Upgradable {
    PlantUpgrade upgrade();
}