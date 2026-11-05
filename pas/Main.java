package pas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Game Mode: ");
        String mode = sc.nextLine();

        //
        boolean state = false;
        if(mode.equals("Night") || mode.equals("Fog")) {
            state = true;
        }
        //

        String input;
        do {
            System.out.print("Add a plant: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Sun-shroom":
                    plants.add(new Mushroom.SunShroom(state));
                    break;
                case "Puff-shroom":
                    plants.add(new Mushroom.PuffShroom(state));
                    break;
                case "Doom-shroom":
                    plants.add(new Mushroom.DoomShroom(state));
                    break;
                //==================================================
                case "Sunflower":
                    plants.add(new Plant.Sunflower());
                    break;
                case "Twin Sunflower": {
                    int idx = -1;
                    for (int i = 0; i < plants.size(); i++) {
                        if (plants.get(i) instanceof Plant.Sunflower) {
                            idx = i;
                            break;
                        }
                    }
                    if (idx >= 0) {
                        Plant old = plants.remove(idx);
                        plants.add(idx, (Plant) ((Upgradable) old).upgrade());
                    } else {
                        plants.add(new Plant.TwinSunflower());
                    }
                    break;
                }
                case "Peashooter":
                    plants.add(new Plant.Peashooter());
                    break;
                case "Wall Nut":
                    plants.add(new Plant.WallNut());
                    break;
                case "Squash":
                    plants.add(new Plant.Squash());
                    break;
                case "Jalapeno":
                    plants.add(new Plant.Jalapeno());
                    break;
                case "Coffee Bean":
                    Plant.CoffeeBean bean = new Plant.CoffeeBean();
                    for(Plant p : plants) {
                        if(p instanceof Mushroom && !((Mushroom)p).isAwake()) {
                            ((Mushroom)p).awaken(bean);
                            System.out.println(bean.die());
                            break;
                        }
                    }
                    break;
                case "Lily Pad":
                    plants.add(new Plant.LilyPad());
                    break;
                case "Cattail": {
                    int idx = -1;
                    for (int i = 0; i < plants.size(); i++) {
                        if (plants.get(i) instanceof Plant.LilyPad) {
                            idx = i;
                            break;
                        }
                    }
                    if (idx >= 0) {
                        Plant old = plants.remove(idx);
                        plants.add(idx, (Plant) ((Upgradable) old).upgrade());
                    } else {
                        plants.add(new Plant.Cattail());
                    }
                    break;
                }
                // add more plants here
                default:
                    System.out.println(input + " is not a plant");
            }
        } while (!input.equals("DONE"));
        //========================================================
        do {
            System.out.print("Do something: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Produce Sun":
                    // add implementation here
                    int n= 0;
                    int x = 0;

                    for(Plant p : plants) {
                        if(p instanceof SunProducer) {
                            n++;
                            x += ((SunProducer)p).produce_sun();
                        }
                    }
                    if(n == 0) {
                        System.out.println("You have no sun producers");
                    } else {
                        System.out.println(n + " sun producers gather " + x + " suns");
                    }
                    break;
                case "Attack":
                    // add implementation here
                    int n1 = 0;
                    int x1 = 0;

                    for(Plant p : plants) {
                        if(p instanceof Attacker && p.isAlive()) {
                            x1 += ((Attacker)p).attack();

                            if(!p.isAlive()) {
                                System.out.println(p.die());
                            }
                            n1++;
                        }

                    }

                    if(n1 == 0) {
                        System.out.println("You have no attackers");
                    } else {
                        System.out.println(n1 + " attackers dealing " + x1 + " damage");
                    }
                    break;
                case "Instant Kill Status":
                    int ctr1 = 0;
                    for(Plant p : plants) {
                        if(p instanceof InstantKiller && p.isAlive()) {
                            ctr1 = 1;
                            int type = ((InstantKiller)p).killType();
                            //1.close-contact   2.instant-kill
                            if(type == 1) {
                                System.out.println(p.name + " can kill on contact");
                            } else if(type == 2) {
                                System.out.println(p.name + " can kill instantly");
                            } else {
                                System.out.println("Cannot determine...");
                            }
                        }
                    }

                    if(ctr1 == 0) {
                        System.out.println("You have no plants which can kill instantly");
                    }

                    break;
                case "Attacker Status":
                    int ctr2 = 0;
                    for(Plant p : plants) {
                        if(p instanceof Attacker && p.isAlive()) {
                            ctr2 = 1;
                            int rtype = ((Attacker)p).rangeType();
                            //1.single-line    2.AOE     3.limited-range   4.free-range
                            if(rtype == 1) {
                                System.out.println(p.name + " can attack on a single line");
                            } else if(rtype == 2) {
                                System.out.println(p.name + " can attack using area-of-effect");
                            } else if(rtype == 3) {
                                System.out.println(p.name + " can attack only when enemy is nearby");
                            } else if(rtype == 4) {
                                System.out.println(p.name + " can attack any enemies from anywhere");
                            } else {
                                System.out.println("Cannot determine");
                            }
                        }
                    }

                    if(ctr2 == 0) {
                        System.out.println("You have no attackers");
                    }
                    break;
                case "Sort by HP":
                    Collections.sort(plants, new Plant.HpComparator());

                    for(Plant p : plants) {
                        System.out.println(p);
                    }
                    break;
                case "Sort by Name":
                    Collections.sort(plants, new Plant.NameComparator());
                    for(Plant p : plants) {
                        System.out.println(p);
                    }
                    break;
                case "Sort by Sun Cost":
                    Collections.sort(plants, new Plant.SunComparator());
                    for(Plant p : plants) {
                        System.out.println(p);
                    }
                    break;
                // add more cases here
                default:
                    System.out.println("Unknown action: " + input);
            }
        } while (!input.equals("DONE"));
    }
}




//======================================================================================================================





//======================================================================================================================

/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Game Mode: ");
        String mode = sc.nextLine();

        //
        boolean state = false;
        if(mode.equals("Night") || mode.equals("Fog")) {
            state = true;
        }
        //

        String input;
        do {
            System.out.print("Add a plant: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Sun-shroom":
                    plants.add(new Mushroom.SunShroom(state));
                    break;
                case "Puff-shroom":
                    plants.add(new Mushroom.PuffShroom(state));
                    break;
                case "Doom-shroom":
                    plants.add(new Mushroom.DoomShroom(state));
                    break;
                //==================================================
                case "Sunflower":
                    plants.add(new Plant.Sunflower());
                    break;
                case "Twin Sunflower": {
                    int idx = -1;
                    for (int i = 0; i < plants.size(); i++) {
                        if (plants.get(i) instanceof Plant.Sunflower) {
                            idx = i;
                            break;
                        }
                    }
                    if (idx >= 0) {
                        Plant old = plants.remove(idx);
                        plants.add(idx, (Plant) ((Upgradable) old).upgrade());
                    } else {
                        plants.add(new Plant.TwinSunflower());
                    }
                    break;
                }
                case "Peashooter":
                    plants.add(new Plant.Peashooter());
                    break;
                case "Wall Nut":
                    plants.add(new Plant.WallNut());
                    break;
                case "Squash":
                    plants.add(new Plant.Squash());
                    break;
                case "Jalapeno":
                    plants.add(new Plant.Jalapeno());
                    break;
                case "Coffee Bean":
                    Plant.CoffeeBean bean = new Plant.CoffeeBean();
                    for(Plant p : plants) {
                        if(p instanceof Mushroom && !((Mushroom)p).isAwake()) {
                            ((Mushroom)p).awaken(bean);
                            System.out.println(bean.die());
                            break;
                        }
                    }
                    break;
                case "Lily Pad":
                    plants.add(new Plant.LilyPad());
                    break;
                case "Cattail": {
                    int idx = -1;
                    for (int i = 0; i < plants.size(); i++) {
                        if (plants.get(i) instanceof Plant.LilyPad) {
                            idx = i;
                            break;
                        }
                    }
                    if (idx >= 0) {
                        Plant old = plants.remove(idx);
                        plants.add(idx, (Plant) ((Upgradable) old).upgrade());
                    } else {
                        plants.add(new Plant.Cattail());
                    }
                    break;
                }
                // add more plants here
                default:
                    System.out.println(input + " is not a plant");
            }
        } while (!input.equals("DONE"));
        //========================================================
        do {
            System.out.print("Do something: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Produce Sun":
                    // add implementation here
                    int n= 0;
                    int x = 0;

                    for(Plant p : plants) {
                        if(p instanceof SunProducer) {
                            n++;
                            x += ((SunProducer)p).produce_sun();
                        }
                    }
                    if(n == 0) {
                        System.out.println("You have no sun producers");
                    } else {
                        System.out.println(n + " sun producers gather " + x + " suns");
                    }
                    break;
                case "Attack":
                    // add implementation here
                    int n1 = 0;
                    int x1 = 0;

                    for(Plant p : plants) {
                        if(p instanceof Attacker && p.isAlive()) {
                            x1 += ((Attacker)p).attack();

                            if(!p.isAlive()) {
                                System.out.println(p.die());
                            }
                            n1++;
                        }

                    }

                    if(n1 == 0) {
                        System.out.println("You have no attackers");
                    } else {
                        System.out.println(n1 + " attackers dealing " + x1 + " damage");
                    }
                    break;
                case "Instant Kill Status":
                    int ctr1 = 0;
                    for(Plant p : plants) {
                        if(p instanceof InstantKiller && p.isAlive()) {
                            ctr1 = 1;
                            int type = ((InstantKiller)p).killType();
                            //1.close-contact   2.instant-kill
                            if(type == 1) {
                                System.out.println(p.name + " can kill on contact");
                            } else if(type == 2) {
                                System.out.println(p.name + " can kill instantly");
                            } else {
                                System.out.println("Cannot determine...");
                            }
                        }
                    }

                    if(ctr1 == 0) {
                        System.out.println("You have no plants which can kill instantly");
                    }

                    break;
                case "Attacker Status":
                    int ctr2 = 0;
                    for(Plant p : plants) {
                        if(p instanceof Attacker && p.isAlive()) {
                            ctr2 = 1;
                            int rtype = ((Attacker)p).rangeType();
                            //1.single-line    2.AOE     3.limited-range   4.free-range
                            if(rtype == 1) {
                                System.out.println(p.name + " can attack on a single line");
                            } else if(rtype == 2) {
                                System.out.println(p.name + " can attack using area-of-effect");
                            } else if(rtype == 3) {
                                System.out.println(p.name + " can attack only when enemy is nearby");
                            } else if(rtype == 4) {
                                System.out.println(p.name + " can attack any enemies from anywhere");
                            } else {
                                System.out.println("Cannot determine");
                            }
                        }
                    }

                    if(ctr2 == 0) {
                        System.out.println("You have no attackers");
                    }
                    break;
                case "Sort by HP":
                    Collections.sort(plants, new Plant.HpComparator());

                    for(Plant p : plants) {
                        System.out.println(p);
                    }
                    break;
                case "Sort by Name":
                    Collections.sort(plants, new Plant.NameComparator());
                    for(Plant p : plants) {
                        System.out.println(p);
                    }
                    break;
                case "Sort by Sun Cost":
                    Collections.sort(plants, new Plant.SunComparator());
                    for(Plant p : plants) {
                        System.out.println(p);
                    }
                    break;
                // add more cases here
                default:
                    System.out.println("Unknown action: " + input);
            }
        } while (!input.equals("DONE"));
    }
}
*
*/




//======================================================================================================================
