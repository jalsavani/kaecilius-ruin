import java.util.Scanner;
import java.util.Random;

public class KaeciliusRuin {

    public static void main(String[] args) {

        // Intro
        System.out.println("\n\nAfter defeating Malacca, the villagers celebrate your victory. But their joy is short-lived.");
        System.out.println("Kaecilius, the Dragon King, has risen from his lair atop Mount Ruin.");
        System.out.println("Enraged by your interference, he begins draining the mana from the land.");
        System.out.println("You, the Great Warrior, are the last hope.");

        // Base stats
        int mana = 300;
        int hp = 300;

        System.out.println("\nAfter your training and the villagers' blessings,");
        System.out.println("you receive divine favor and a massive boost!");

        System.out.println("HP: " + hp);
        System.out.println("Mana: " + mana);

        Scanner option = new Scanner(System.in);
        Random rng = new Random();

        // Archetype Selection
        System.out.println("\nChoose your archetype:");

        String[] archetype = {
            "Shadowblade - Agile Assassin",
            "Runeseer - Spellcaster",
            "Warden - Tank and Barrier User"
        };

        for (int i = 0; i < archetype.length; i++) {
            System.out.println((i + 1) + ". " + archetype[i]);
        }

        System.out.print("Enter choice (1-3): ");

        int arch = option.nextInt();
        String archCounter = "";

        if (arch == 1) {
            archCounter = "Shadowblade";
            hp += 50;
            mana += 50;

            System.out.println("\nYou have chosen SHADOWBLADE!");
            System.out.println("HP: " + hp + " | Mana: " + mana);

            System.out.println("\nMoves:");
            System.out.println("1) Shadow Strike  (-15 mana, 40 dmg)");
            System.out.println("2) Smoke Dash     (-10 mana, dodge next attack)");
            System.out.println("3) Backstab       (-30 mana, 80 dmg if enemy HP < 200)");

        } else if (arch == 2) {
            archCounter = "Runeseer";
            hp += 30;
            mana += 120;

            System.out.println("\nYou have chosen RUNESEER!");
            System.out.println("HP: " + hp + " | Mana: " + mana);

            System.out.println("\nMoves:");
            System.out.println("1) Arcane Pulse    (-20 mana, 40 dmg)");
            System.out.println("2) Mana Infusion   (-10 mana, +40 mana)");
            System.out.println("3) Time Distortion (-25 mana, skip enemy turn)");

        } else if (arch == 3) {
            archCounter = "Warden";
            hp += 150;

            System.out.println("\nYou have chosen WARDEN!");
            System.out.println("HP: " + hp + " | Mana: " + mana);

            System.out.println("\nMoves:");
            System.out.println("1) Iron Slam    (-20 mana, 30 dmg)");
            System.out.println("2) Shield Wall  (-15 mana, block next attack)");
            System.out.println("3) Vengeance    (-30 mana, reflect last damage x2)");

        } else {
            System.out.println("Invalid choice.");
            option.close();
            return;
        }

        // =========================
        // RAVAGER THORNE FIGHT
        // =========================

        System.out.println("\nThe palace gates groan open...");
        System.out.println("Ravager Thorne appears!");

        int ravagerHp = 350;

        boolean dodgeNext = false;
        boolean blockNext = false;
        boolean skipEnemyAttack = false;

        int lastDamageTaken = 0;

        while (ravagerHp > 0 && hp > 0 && mana > 0) {

            mana = Math.max(mana, 0);
            hp = Math.max(hp, 0);

            System.out.println("\n========================");
            System.out.println("YOUR HP: " + hp);
            System.out.println("YOUR MANA: " + mana);
            System.out.println("THORNE HP: " + ravagerHp);
            System.out.println("========================");

            System.out.print("Choose move (1-3): ");
            int move = option.nextInt();

            if (move < 1 || move > 3) {
                System.out.println("Invalid move!");
                continue;
            }

            // Shadowblade
            if (archCounter.equals("Shadowblade")) {

                if (move == 1) {

                    if (mana >= 15) {
                        System.out.println("You used Shadow Strike!");
                        mana -= 15;
                        ravagerHp -= 40;
                    } else {
                        System.out.println("Not enough mana!");
                    }

                } else if (move == 2) {

                    if (mana >= 10) {
                        System.out.println("You used Smoke Dash!");
                        mana -= 10;
                        dodgeNext = true;
                    } else {
                        System.out.println("Not enough mana!");
                    }

                } else if (move == 3) {

                    if (mana >= 30) {
                        System.out.println("You used Backstab!");
                        mana -= 30;

                        if (ravagerHp < 200) {
                            ravagerHp -= 80;
                        } else {
                            ravagerHp -= 40;
                            System.out.println("Enemy HP too high!");
                        }

                    } else {
                        System.out.println("Not enough mana!");
                    }
                }
            }

            // Runeseer
            else if (archCounter.equals("Runeseer")) {

                if (move == 1) {

                    if (mana >= 20) {
                        System.out.println("You used Arcane Pulse!");
                        mana -= 20;
                        ravagerHp -= 40;
                    } else {
                        System.out.println("Not enough mana!");
                    }

                } else if (move == 2) {

                    if (mana >= 10) {
                        System.out.println("You used Mana Infusion!");
                        mana -= 10;
                        mana += 40;
                    } else {
                        System.out.println("Not enough mana!");
                    }

                } else if (move == 3) {

                    if (mana >= 25) {
                        System.out.println("You used Time Distortion!");
                        mana -= 25;
                        skipEnemyAttack = true;
                    } else {
                        System.out.println("Not enough mana!");
                    }
                }
            }

            // Warden
            else if (archCounter.equals("Warden")) {

                if (move == 1) {

                    if (mana >= 20) {
                        System.out.println("You used Iron Slam!");
                        mana -= 20;
                        ravagerHp -= 30;
                    } else {
                        System.out.println("Not enough mana!");
                    }

                } else if (move == 2) {

                    if (mana >= 15) {
                        System.out.println("You used Shield Wall!");
                        mana -= 15;
                        blockNext = true;
                    } else {
                        System.out.println("Not enough mana!");
                    }

                } else if (move == 3) {

                    if (mana >= 30) {
                        System.out.println("You used Vengeance!");
                        mana -= 30;

                        int vengeanceDamage = lastDamageTaken * 2;

                        ravagerHp -= vengeanceDamage;

                        System.out.println("You dealt " + vengeanceDamage + " damage!");
                    } else {
                        System.out.println("Not enough mana!");
                    }
                }
            }

            // Victory check
            if (ravagerHp <= 0) {
                break;
            }

            // Enemy turn
            if (skipEnemyAttack) {
                System.out.println("Time slows... Thorne misses!");
                skipEnemyAttack = false;
                continue;
            }

            int enemyMove = rng.nextInt(3) + 1;
            int damage = 0;

            if (enemyMove == 1) {
                System.out.println("Thorne uses Molten Slam!");
                damage = 50;

            } else if (enemyMove == 2) {
                System.out.println("Thorne unleashes Flame Quake!");
                damage = 65;

            } else {
                System.out.println("Thorne uses Obsidian Roar!");
                mana -= 25;
            }

            // Defense effects
            if (dodgeNext) {
                System.out.println("You dodged the attack!");
                damage = 0;
                dodgeNext = false;

            } else if (blockNext) {
                System.out.println("You blocked the attack!");
                damage = 0;
                blockNext = false;
            }

            hp -= damage;
            lastDamageTaken = damage;
        }

        // Lose condition
        if (hp <= 0 || mana <= 0) {

            System.out.println("\nYou were defeated by Ravager Thorne.");
            System.out.println("The gates of Mount Ruin remain closed.");

            option.close();
            return;
        }

        // Rewards
        System.out.println("\nYou defeated Ravager Thorne!");
        System.out.println("The Gates of Mount Ruin open!");

        hp += 200;
        mana += 200;

        System.out.println("\nRewards:");
        System.out.println("+200 HP");
        System.out.println("+200 Mana");

        System.out.println("\nULTIMATE MOVE UNLOCKED!");
        System.out.println("4) Warrior's Determination (-50 mana, 150 dmg)");

        // =========================
        // KAECILIUS FIGHT
        // =========================

        System.out.println("\nKaecilius emerges from the shadows...");
        System.out.println("The final battle begins!");

        int kaeciliusHP = 600;

        boolean usedUltimate = false;

        dodgeNext = false;
        blockNext = false;
        skipEnemyAttack = false;
        lastDamageTaken = 0;

        while (kaeciliusHP > 0 && hp > 0 && mana > 0) {

            mana = Math.max(mana, 0);
            hp = Math.max(hp, 0);

            System.out.println("\n========================");
            System.out.println("YOUR HP: " + hp);
            System.out.println("YOUR MANA: " + mana);
            System.out.println("KAECILIUS HP: " + kaeciliusHP);
            System.out.println("========================");

            System.out.print("Choose move (1-4): ");
            int move = option.nextInt();

            if (move < 1 || move > 4) {
                System.out.println("Invalid move!");
                continue;
            }

            // Shadowblade
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
                    }

                } else if (move == 4 && !usedUltimate && mana >= 50) {

                    System.out.println("You unleash Warrior's Determination!");
                    mana -= 50;
                    kaeciliusHP -= 150;
                    usedUltimate = true;

                } else {
                    System.out.println("Invalid move or not enough mana!");
                }
            }

            // Runeseer
            else if (archCounter.equals("Runeseer")) {

                if (move == 1 && mana >= 20) {

                    System.out.println("You used Arcane Pulse!");
                    mana -= 20;
                    kaeciliusHP -= 40;

                } else if (move == 2 && mana >= 10) {

                    System.out.println("You used Mana Infusion!");
                    mana -= 10;
                    mana += 40;

                } else if (move == 3 && mana >= 25) {

                    System.out.println("You used Time Distortion!");
                    mana -= 25;
                    skipEnemyAttack = true;

                } else if (move == 4 && !usedUltimate && mana >= 50) {

                    System.out.println("You unleash Warrior's Determination!");
                    mana -= 50;
                    kaeciliusHP -= 150;
                    usedUltimate = true;

                } else {
                    System.out.println("Invalid move or not enough mana!");
                }
            }

            // Warden
            else if (archCounter.equals("Warden")) {

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

                    int vengeanceDamage = lastDamageTaken * 2;

                    kaeciliusHP -= vengeanceDamage;

                    System.out.println("You dealt " + vengeanceDamage + " damage!");

                } else if (move == 4 && !usedUltimate && mana >= 50) {

                    System.out.println("You unleash Warrior's Determination!");
                    mana -= 50;
                    kaeciliusHP -= 150;
                    usedUltimate = true;

                } else {
                    System.out.println("Invalid move or not enough mana!");
                }
            }

            // Victory check
            if (kaeciliusHP <= 0) {
                break;
            }

            // Skip attack
            if (skipEnemyAttack) {
                System.out.println("Kaecilius is frozen in time!");
                skipEnemyAttack = false;
                continue;
            }

            // Kaecilius attacks
            int enemyMove = rng.nextInt(3) + 1;
            int damage = 0;

            if (enemyMove == 1) {

                System.out.println("Kaecilius hurls Dark Flame!");
                damage = 40;

            } else if (enemyMove == 2) {

                System.out.println("Kaecilius slashes with Dragon Claw!");
                damage = 50;

            } else {

                System.out.println("Kaecilius casts Mana Rupture!");
                mana -= 30;
            }

            // Defensive effects
            if (dodgeNext) {

                System.out.println("You dodged the attack!");
                damage = 0;
                dodgeNext = false;

            } else if (blockNext) {

                System.out.println("You blocked the attack!");
                damage = 0;
                blockNext = false;
            }

            hp -= damage;
            lastDamageTaken = damage;

            // Phase 2
            if (kaeciliusHP <= 300 && kaeciliusHP > 250) {
                System.out.println("\nKAECILIUS ENTERS PHASE 2!");
                System.out.println("The mountain trembles with dragonfire...");
            }
        }

        // Final outcome
        if (kaeciliusHP <= 0) {

            System.out.println("\nYou stand victorious over Kaecilius!");
            System.out.println("Peace returns to the realm.");
            System.out.println("You are now known as the Champion of the Eternal Flame.");

        } else {

            System.out.println("\nYou have fallen.");
            System.out.println("Kaecilius consumes the world in darkness...");
        }

        option.close();
    }
}
