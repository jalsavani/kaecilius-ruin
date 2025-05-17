import java.util.Scanner;
import java.util.Random;

public class KaeciliusRuin {
    public static void main(String[] args) {
        // Intro Statement 
        System.out.println("\n\nAfter defeating Malacca, the villagers celebrate your victory. But their joy is short-lived.");
        System.out.println("Kaecilius, the Dragon King, has risen from his lair atop Mount Ruin. Enraged by your interference, he begins draining the mana from the land, causing the skies to darken, rivers to dry, and beasts to mutate.");
        System.out.println("You, the Great Warrior, are the last hope.");
        
        // Initializing mana and hp 
        System.out.println("\n\nAfter your training and the villagers's blessings, you have recieved the divine favour and a mana and hp boost!");
        System.out.println("Your current mana and hp: ");
        System.out.println("HP: 300 \nMana: 300");

        int mana = 300;
        int hp = 300;
        
        // Initializing Scanner 
        Scanner option = new Scanner(System.in);

        // Archetype selection 
        System.out.println("\n\nBefore you head into a battle that might very well go down in history as the fiercest battle of all time, choose an archetype.");
        String archCounter = "";
        String[] archetype = {"Shadowblade - Agile Assasin", "Runeseer - Spellcaster", "Warden - Tank and Barrier User"};

        for (int i = 0; i < archetype.length; i++) {
            System.out.println(i + 1 + ". " + archetype[i]);
        }

        System.out.println("Make your selection (1-3):"); 

        int arch = option.nextInt();
        if (arch == 1) {
            System.out.println("You have chosen the SHADOWBLADE archetype!");
            archCounter = "Shadowblade";
        } else if (arch == 2) {
            System.out.println("You have chosen the RUNESEER archetype!");
            archCounter = "Runeseer";
        } else if (arch == 3) {
            System.out.println("You have chosen the WARDEN archetype!");
            archCounter = "Warden";
        } else {
            System.out.println("Please enter a valid input.");
        }

        // Movesets 
        System.out.println("\nYour moveset has been unlocked:\n");

        if (archCounter.equals("Shadowblade")) {
            hp += 50;
            mana += 50;
            System.out.printf("As a Shadowblade Forbidden Arts User, your updated stats are — HP: %d, Mana: %d%n%n", hp, mana);

            System.out.println("Attack Spells:");
            System.out.println("1) Shadow Strike  (-15 mana, 40 dmg)");
            System.out.println("2) Smoke Dash     (-10 mana, 20 dmg, avoids next attack)");
            System.out.println("3) Backstab       (-30 mana, 80 dmg if enemy HP < 200)");

        } else if (archCounter.equals("Runeseer")) {
            hp += 30;
            mana += 120;
            System.out.printf("As a Master of the Runeseer Spells, your updated stats are  — HP: %d, Mana: %d%n%n", hp, mana);

            System.out.println("Attack Spells:");
            System.out.println("1) Arcane Pulse   (-20 mana, 40 dmg)");
            System.out.println("2) Mana Infusion  (-10 mana, +40 mana next turn)");
            System.out.println("3) Time Distortion (-25 mana, skip enemy's next attack)");

        } else if (archCounter.equals("Warden")) {
            hp += 150;
            System.out.printf("Bearing the might of a 100 trolls, your updated stats as a Warden are  — HP: %d, Mana: %d%n%n", hp, mana);

            System.out.println("Attack Spells:");
            System.out.println("1) Iron Slam      (-20 mana, 30 dmg)");
            System.out.println("2) Shield Wall    (-15 mana, block 100% dmg next turn)");
            System.out.println("3) Vengeance      (-30 mana, return last damage taken * 2)");
        }

        // Mini-Boss Intro
        System.out.println("\n\nThe palace gates groan open, revealing a towering figure: Ravager Thorne, Kaecilius' oldest and most loyal servant.");
        System.out.println("Forged in the fires of Mount Ruin and bound by an oath of blood, Thorne has crushed every warrior who's dared challenge the Dragon King's domain.");
        System.out.println("Clad in obsidian armor with molten cracks glowing beneath, he raises a colossal axe that hums with dark magic.");
        System.out.println("No words. No mercy. Only the test.");

        // Ravager Thorne Battle 
        int ravagerHp = 350;
        boolean dodgeNext = false;
        boolean skipEnemyAttack = false;
        boolean blockNext = false;
        int lastDamageTaken = 0;
        Random rng = new Random();

        while (ravagerHp > 0 && hp > 0 && mana > 0) {
            // Showing the user stats after every turn
            System.out.printf("\n\nYour HP: %d", hp);
            System.out.printf("\n\nYour Mana: %d", mana);
            System.out.printf("\n\nRavager Thorne's HP: %d", ravagerHp);

            System.out.println("\n\nChoose your move (1-3): ");
            int move = option.nextInt();
            System.out.println();
            
            // Control flow for Shadowblade archetype
            if (archCounter.equals("Shadowblade")) {
                if (move == 1) {
                    System.out.println("You used Shadow Strike!");
                    if (mana >= 15) {
                        mana -= 15;
                        ravagerHp -= 40;
                    } else {
                        System.out.println("Not enough mana!");
                    }
                } else if (move == 2) {
                    System.out.println("You used Smoke Dash!");
                    if (mana >= 10) {
                        mana -= 10;
                        System.out.println("You dodge the next attack!");
                        dodgeNext = true;
                    } else {
                        System.out.println("Not enough mana!");
                    }
                } else if (move == 3) {
                    System.out.println("You used Backstab!");
                    if (mana >= 30) {
                        mana -= 30;
                        if (ravagerHp < 200) {
                            ravagerHp -= 80;
                        } else {
                            ravagerHp -= 40;
                            System.out.println("It wasn't very effective... (Enemy HP too high)");
                        }
                    } else {
                        System.out.println("Not enough mana!");
                    }
                }
            
            // Control flow for Runeseer archetype
            } else if (archCounter.equals("Runeseer")) {
                if (move == 1) {
                    System.out.println("You used Arcane Pulse!");
                    if (mana >= 20) {
                        mana -= 20;
                        ravagerHp -= 40;
                    } else {
                        System.out.println("Not enough mana!");
                    }
                } else if (move == 2) {
                    System.out.println("You used Mana Infusion!");
                    if (mana >= 10) {
                        mana -= 10;
                        mana += 40;
                        System.out.println("You restored 40 mana!");
                    } else {
                        System.out.println("Not enough mana!");
                    }
                } else if (move == 3) {
                    System.out.println("You used Time Distortion!");
                    if (mana >= 25) {
                        mana -= 25;
                        System.out.println("You will skip Ravager Thorne’s next attack!");
                        skipEnemyAttack = true;
                    } else {
                        System.out.println("Not enough mana!");
                    }
                }

            // Control flow for Warden archetype
            } else if (archCounter.equals("Warden")) {
                if (move == 1) {
                    System.out.println("You used Iron Slam!");
                    if (mana >= 20) {
                        mana -= 20;
                        ravagerHp -= 30;
                    } else {
                        System.out.println("Not enough mana!");
                    }
                } else if (move == 2) {
                    System.out.println("You used Shield Wall!");
                    if (mana >= 15) {
                        mana -= 15;
                        System.out.println("You will block 100% of the next enemy damage!");
                        blockNext = true;
                    } else {
                        System.out.println("Not enough mana!");
                    }
                } else if (move == 3) {
                    System.out.println("You used Vengeance!");
                    if (mana >= 30) {
                        mana -= 30;
                        ravagerHp -= lastDamageTaken * 2;
                        System.out.println("You returned " + (lastDamageTaken * 2) + " damage to Ravager Thorne!");
                    } else {
                        System.out.println("Not enough mana!");
                    }
                }

            // Invalid input
            } else {
                System.out.println("Invalid archetype or move.");
            }

        // Control flow for Ravager Thorne
            if (skipEnemyAttack) {
                System.out.println("Time slows... Ravager Thorne’s attack misses completely!");
                skipEnemyAttack = false;
            } else {
                int enemyMove = rng.nextInt(3) + 1;
        
                if (enemyMove == 1) {
                    System.out.println("Thorne uses Molten Slam!");
                    int damage = 50;
                    if (dodgeNext) {
                        System.out.println("You dodged the attack!");
                        damage = 0;
                        dodgeNext = false;
                    } else if (blockNext) {
                        System.out.println("You blocked the attack with Shield Wall!");
                        damage = 0;
                        blockNext = false;
                    }
        
                hp -= damage;
                lastDamageTaken = damage;
        
            } else if (enemyMove == 2) {
                System.out.println("Thorne unleashes Flame Quake!");
                int damage = 65;
                if (dodgeNext) {
                    System.out.println("You dodged the attack!");
                    damage = 0;
                    dodgeNext = false;
                } else if (blockNext) {
                    System.out.println("You blocked the attack with Shield Wall!");
                    damage = 0;
                    blockNext = false;
                }
        
                hp -= damage;
                lastDamageTaken = damage;
        
            } else {
                System.out.println("Thorne lets out an Obsidian Roar!");
                if (!dodgeNext && !blockNext) {
                    mana -= 25;
                    lastDamageTaken = 0;
                } else {
                    System.out.println("You resist the effect!");
                    dodgeNext = false;
                    blockNext = false;
                }
            }
        }
    }

        // Concluding mini-boss battle
        if (ravagerHp <= 0) {
            System.out.println("\n\nIt took a lot out of you but you defeated the ominous gatekeeper, Ravager Thorne and rid this world of a great evil.");
            System.out.println("But the real challenge begins now, the Gates of Mount Ruin creak open! It is time to take on KAECILIUS");
            System.out.println("Before that, defeating an entity like Ravager Thorne earned you some rewards!");

            mana += 200;
            hp += 200;

            System.out.printf("Your current Mana and HP were boosted by 200 each!");
            System.out.println("\nYou also unlocked an ultimate move: Warrior's Determination | dmg - 150 | mana - 50");
        } else if (mana < 0 || hp < 0) {
            System.out.println("You fell before the gatekeeper of Mount Ruin. Train, get stronger and come back to try your luck."); 
            System.out.println("There is no shame in being weak but there is shame in staying weak.");
        }

        // Facing Kaecilius
        System.out.println("\nThe gates thunder open. You step into the heart of Mount Ruin.");
        System.out.println("Kaecilius, the Dragon King, towers before you — his wings ablaze, eyes glowing with raw power.");
        System.out.println("This is your final test, Warrior...");
        
        // Initialize
        int kaeciliusHP = 600;
        boolean usedUltimate = false;
        dodgeNext = false;
        blockNext = false;
        skipEnemyAttack = false;
        lastDamageTaken = 0;

        
        // Begin combat loop
        while (kaeciliusHP > 0 && hp > 0 && mana > 0) {
            // Showing the user stats after every turn
            System.out.printf("\n\nYour HP: %d", hp);
            System.out.printf("\n\nYour Mana: %d", mana);
            System.out.printf("\n\nKaecilius' HP: %d", kaeciliusHP);
            
            System.out.println("\n\nChoose your move (1-3): ");
            int move = option.nextInt();
            System.out.println();
        
            // Player move logic
            if (archCounter.equals("Shadowblade")) {
                if (move == 1 && mana >= 15) {
                    System.out.println("You used Shadow Strike!");
                    mana -= 15;
                    kaeciliusHP -= 40;
                } else if (move == 2 && mana >= 10) {
                    System.out.println("You used Smoke Dash!");
                    mana -= 10;
                    dodgeNext = true;
                } else if (move == 3 && mana >= 30) {
                    System.out.println("You used Backstab!");
                    mana -= 30;
                    if (kaeciliusHP < 200) {
                        kaeciliusHP -= 80;
                    } else {
                        kaeciliusHP -= 40;
                        System.out.println("It wasn't very effective...");
                    }
                } else if (move == 4 && !usedUltimate && mana >= 50) {
                    System.out.println("You unleash Warrior’s Determination!");
                    mana -= 50;
                    kaeciliusHP -= 150;
                    usedUltimate = true;
                } else {
                    System.out.println("Not enough mana or invalid move.");
                }
        
            } else if (archCounter.equals("Runeseer")) {
                if (move == 1 && mana >= 20) {
                    System.out.println("You used Arcane Pulse!");
                    mana -= 20;
                    kaeciliusHP -= 40;
                } else if (move == 2 && mana >= 10) {
                    System.out.println("You used Mana Infusion!");
                    mana -= 10;
                    mana += 40;
                    System.out.println("You restored 40 mana!");
                } else if (move == 3 && mana >= 25) {
                    System.out.println("You used Time Distortion!");
                    mana -= 25;
                    skipEnemyAttack = true;
                } else if (move == 4 && !usedUltimate && mana >= 50) {
                    System.out.println("You unleash Warrior’s Determination!");
                    mana -= 50;
                    kaeciliusHP -= 150;
                    usedUltimate = true;
                } else {
                    System.out.println("Not enough mana or invalid move.");
                }
        
            } else if (archCounter.equals("Warden")) {
                if (move == 1 && mana >= 20) {
                    System.out.println("You used Iron Slam!");
                    mana -= 20;
                    kaeciliusHP -= 30;
                } else if (move == 2 && mana >= 15) {
                    System.out.println("You used Shield Wall!");
                    mana -= 15;
                    blockNext = true;
                } else if (move == 3 && mana >= 30) {
                    System.out.println("You used Vengeance!");
                    mana -= 30;
                    kaeciliusHP -= lastDamageTaken * 2;
                    System.out.println("You dealt " + (lastDamageTaken * 2) + " vengeance damage!");
                } else if (move == 4 && !usedUltimate && mana >= 50) {
                    System.out.println("You unleash Warrior’s Determination!");
                    mana -= 50;
                    kaeciliusHP -= 150;
                    usedUltimate = true;
                } else {
                    System.out.println("Not enough mana or invalid move.");
                }
            }
        
            // Skip enemy turn if Time Distortion was used
            if (skipEnemyAttack) {
                System.out.println("Kaecilius' attack was frozen in time!");
                skipEnemyAttack = false;
                continue;
            }
        
            // Kaecilius attack
            int enemyMove = rng.nextInt(3) + 1;
            int damage = 0;
        
            if (enemyMove == 1) {
                System.out.println("Kaecilius hurls a Dark Flame!");
                damage = 40;
            } else if (enemyMove == 2) {
                System.out.println("Kaecilius slashes with Dragon Claw!");
                damage = 50;
            } else {
                System.out.println("Kaecilius casts Mana Rupture!");
                mana -= 30;
                damage = 0;
            }
        
            // Apply defense effects
            if (dodgeNext) {
                System.out.println("You dodged the attack!");
                damage = 0;
                dodgeNext = false;
            } else if (blockNext) {
                System.out.println("You blocked all damage with your Shield Wall!");
                damage = 0;
                blockNext = false;
            }
        
            hp -= damage;
            lastDamageTaken = damage;
        }
        
        // Outcome
        if (kaeciliusHP <= 0) {
            System.out.println("\nYou stand victorious over Kaecilius, Dragon King of Ruin.");
            System.out.println("The skies clear, mana flows once again, and peace returns to the realm.");
            System.out.println("You have earned your title: Champion of the Eternal Flame.");
        } else if (hp <= 0 || mana <= 0) {
            System.out.println("\nYou fall in battle. Kaecilius laughs as the last light leaves your eyes.");
            System.out.println("But legends say heroes rise again...");
        }
        
    }
}