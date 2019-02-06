/**
Program: Eric Davidson's Creative Project (Text-Based Adventure Game)
Version: Platinum Edition 
Author: Eric Davidson
Date Written: 
Compiler/Platform: Java 1.6, Windows 7

Description: A game in which the user can navigate a city in Utopia from Thomas More's book, Utopia

 */
import java.util.*;
public class Game
{
    public static void main(String[] args)
    {
        
        //Gets the necessary information
        Scanner kbInput = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String name = kbInput.next();
        
        System.out.println("\nHello " + name + ". You're a special emissary that has traveled back in time\n"
            + "to hopefully learn from the Utopians described by Thomas More. The literature has been lost,\n"
            + "so not much is known besides the time period and location. You've been placed on a ship\n"
            + "sailing towards the harbor without a Utopian guide. Without any warning, a force\n"
            + "shakes the ship, and the sea begins to swallow it. You dive off into the water and quickly\n"
            + "swim to the nearest shore. You have no interest in the sailors' business, so you run off into\n"
            + "the woods and to the south.");
            
        //Legend of some commands
        System.out.println("These are a few general commands that you will have to use.\n\n"
            + "|--------------------------------------|"
            + "\n|  North/Up   South/Down   West/Left   |"
            + "\n|                                      |"
            + "\n|  East/Right    Stay        Take      |"
            + "\n|                                      |"
            + "\n|--------------------------------------|");
            
        System.out.println("VERY IMPORTANT. Use 'stay' to further investigate areas. Some will\n"
            + "allow interaction with the setting");
            
        //Starting position of the player
        int row = 0;
        int col = 0;
        
        //Starts the gameplay
        map(row, col);
    }
    
    /**
     * Creates the map of the game, and takes all the given actions from the player
     * pre: None
     * post: An action has been made
     */
    public static void map(int r, int c) //Takes the starting position of 0, 0, and the player.
    {
        Scanner kbInput = new Scanner(System.in);
        boolean hasJewels = false, beenToFarm = false, triedToSell= false, heardSpeech = false; //Objectives, basically. These have to be changed to beat the game.
       
        
        int row = r, col = c; //Takes the starting position
        
        //The game map, two-dimensional array
        int[][] map = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12}};
        int location = map[r][c]; //Starting position
        String actionOrig = "";
        String action = "";
        
        //First area description
        System.out.println("\nYou stop running to take in your surroundings. You're currently standing in a small meadow, hopefully much closer\n"
            + "to the center of the island. The ocean is to the west, and you don't know the way back north. To the south, you can see what looks\n"
            + "some fields, and you can faintly see some voices. To the east, you can see a river.");
        do //
        {
            System.out.print("\nWhat would you like to do?\n> "); //Prompts the user
            actionOrig = kbInput.next(); //Takes an action
            action = actionOrig.toLowerCase(); 
            System.out.println();
            
            //All possible actions
            if (action.equals("quit"))
                break;
            else if (row != 0 && (action.equals("north") || action.equals("up")) )//North, if not at the top of the map
            {
                row = row-1;
                location = map[row][col]; 
            }
            else if (row != 2 && (action.equals("south") || action.equals("down"))) //South, if not at the bottom
            {
                row = row + 1;
                location = map[row][col];
            }
            else if (col != 0 && (action.equals("west")  || action.equals("left"))) //West, if not at the far left
            {
                col = col - 1;
                location = map[row][col];
            }
            else if (col != 3 && (action.equals("east") || action.equals("right"))) //East, if not at the far right
            {
                col = col + 1;
                location = map[row][col];
            }
            
            else if (triedToSell == false && location == 6 && hasJewels == true)  //If in the area with the key
            {
                System.out.println("Remembering your spoils, would you like to try and\n"
                    + "sell your jewels?");
                System.out.print("> ");
                String ans = kbInput.next();
                if (ans.toLowerCase().equals("yes"))
                {
                    triedToSell = true;
                    System.out.println("\nYou approach a man and ask about selling your gems.\n"
                        + "\"What? BWAHAHA!! That was a good one! Hahaha\", and he walks away.");
                }
            }
            else if (location == 7)
            {
                if (heardSpeech == false)
                {
                    heardSpeech = true;
                    System.out.println("\nYou hear a piece of the man's speech,\"...imagine something beyond that! I'm talking\n"
                        + "about the very things you've all told me! I've personally eaten at each of your 30 family tables,\n"
                        + "it would be my greatest honor to become your representative, your Phylarch! I'm on very good terms\n"
                        + "with my potential Tranibor, and he thinks our group of 10 representatives can help make Utopia even\n"
                        + "better. On another note, we've all heard the rumors about the Chief Executive's 'ambition', but....\"\n");
                }    
                if (hasJewels == true)
                {
                    System.out.println("You're distracted by the boy asking for your jewels and gems to play with...\n");
                    System.out.print("Give them to him?\n> ");
                    String k = kbInput.next().toLowerCase();
                    if (k.equals("yes"))
                    {
                        hasJewels = false;
                        System.out.println("\nOh boy!! More toys!!\"");
                    }
                }
            }
            else if (action.equals("take") && location == 5) //If in the area with the meat and soldier
            {
                System.out.println("You have the jewels! They are ornate and beautiful.");
                hasJewels = true; //Objective is complete
            }
            else if (location == 9 && beenToFarm == false) //Just a little fun message
            {
                beenToFarm = true;
                System.out.println("\"Hello there!!\"");
                System.out.println("You turn to see a man that has walked up to you.");
                System.out.println("\"Did you get sent out here to work?\"\n");
                System.out.print("> ");
                String x = kbInput.next();
                if(x.toLowerCase().equals("no"))
                {
                    System.out.println("\n\"Ahh, my mistake. I assumed you were starting your two years of\n"
                        + "agricultural work. It's required for everyone so that the citizens of each\n"
                        + "city stay well rounded and we have plenty of food. Actually, we had a lot\n"
                        + "a lot of excess produce this year, so we'll have to ship it to another city.\n"
                        + "Anyway, I'll see you!\"\n");
                }
                else
                    System.out.println("\n\"Alright then. Well, back to work for me.\"\n");
            }
                
            //The final part of the game
            else if (location == 10 && beenToFarm == true) //If in the area with the huge tower
            {
                System.out.println("You see the man you spoke to before and wave.");
            }
            else if (location == 11) //If in the area with the huge tower
            {
                System.out.print("Would you like to talk to the old man or try a puzzle?\n> ");
                String ans = kbInput.next().toLowerCase();
                if (ans.equals("talk") || ans.equals("man"))
                {
                    System.out.print("\n\"Hello youngster, have I spoken to you before?\"\n\n> ");
                    ans = kbInput.next().toLowerCase();
                    
                    if (ans.equals("no") || ans.equals("yes"))
                    {
                        System.out.println("\"Well splendid! I happen to love talking. I can discuss many\n"
                            + "things about our city, such as population, slavery, money, work, or even military.\"");
                        do{
                            System.out.print("\n\"So what would you like to hear about? Or nothing?\"\n");
                            ans = kbInput.next().toLowerCase();
                        
                            if (ans.equals("slaves") || ans.equals("slavery"))
                            {
                                System.out.println("\n\"A very interesting topic...I've always marveled at the slavery\n"
                                    + "system here at Utopia. In other nations, slaves are typically prisoners of war,\n"
                                    + "and criminals, but interestingly, we had many workers from other nations come and\n"
                                    + "ask to be made slaves. They are treated quite well, and are afforded practically the\n"
                                    + "same rights as any other citizen.");
                            }
                            else if (ans.equals("currency") || ans.equals("gold") || ans.equals("money"))
                            {
                                System.out.println("\n\"This is potentially the strongest aspect of Utopia, I believe. Money\n"
                                    + "or currency doesn't have a place in Utopia because common goods is practiced. Everything\n"
                                    + "is shared with everyone. The benefits are obvious in the lack of crime compared to private\n"
                                    + "property economies. Although the general public is not aware, the chains you see on slaves,\n"
                                    + "along with many other items found around Utopia, are made of something called 'gold' that\n"
                                    + "holds ridiculous value in other nations. As long as there is no war, it will remain worthless\n"
                                    + "here.");
                            }
                            else if (ans.equals("population"))
                            {
                                System.out.println("\n\"That interests me greatly...It's amazing how efficiently our government can\n"
                                    + "keep populations in seperate cities where they need to be by tranferring citizens. Maybe it\n"
                                    + "wouldn't be so important if there were less cities, but with 54 things have to be kept tight.\n"
                                    + "I actually spent a whole year in one of the colonies established on a mainland because of a \n"
                                    + "population boom. A plague came through a few cities, however, and we were brought back.\n"
                                    + "Things are better now, since each family is required to have between 10 and 16 adults.");
                            }
                            else if (ans.equals("work") || ans.equals("hours"))
                            {
                                System.out.println("\n\"Oh, thank goodness I can't handle 6 hours a day anymore. Utopia takes care\n"
                                    + "of its elderly, I tell you. But I admire the younger ones that work 6 hours every day, unless\n"
                                    + "there's really a lack of need.");
                            }
                            else if (ans.equals("military") || ans.equals("soldiers") || ans.equals("mercenaries"))
                            {
                                System.out.println("\n\"Oh, Pfft. This is uninteresting to me, but so be it. I personally find the\n"
                                    + "mercenaries hired from the country of the Zapoletes deplorable. I've always hated them, but\n"
                                    + "they certainly served us well during the occasional war. Of course, its much better that they\n"
                                    + "die than those of us here in our cities.");
                            }
                            else if(ans.equals("nothing"))
                            {
                                
                            }
                            else
                                System.out.println("\n\"Sorry friend, I don't know much about that. Perhaps I don't understand the\n"
                                    + "question. Something else perhaps?\"");
                        }while(ans.equals("nothing") == false);
                    }
                    System.out.println("\n\"Well, it was quite nice discussing with you! Come back anytime, although I may"
                        + "\nnot remember you. Take care!\"");
                }
                else if (ans.equals("puzzle") || ans.equals("try"))
                {
                    System.out.println("\nA man waves you over, and offers the following puzzle...\n");
                    System.out.print("\"My eye is always open,\nAnd yet I cannot see.\nWhat am I?\"\n\n> ");
                    String rid = kbInput.next().toLowerCase();
                    if (rid.equals("needle"))
                    {
                        System.out.println("\n\"Very good! How about another...\"\n");
                        System.out.print("\"I am lighter than a feather,\nyet no man can hold me for very long."
                            + "\nWhat am I?\"\n\n> ");
                        rid = kbInput.next().toLowerCase();
                        if (rid.equals("breath"))
                        {
                            System.out.println("\n\"Splendid!! One last one then...\"\n");
                            System.out.print("\"Feed me and I live,\nGive me something to drink and I'll die."
                                + "\nWhat am I?\"\n\n> ");
                            rid = kbInput.next().toLowerCase();
                            if (rid.equals("fire"))
                            {
                                System.out.println("\n\"That's it!! You're a very sharp man.\"");
                            }
                            else
                                System.out.println("\n\"Ahh, almost. Maybe another time\"");
                        }
                    }
                    else
                        System.out.println("\n\"Ahh, sorry my friend. Maybe next time.\"");
                }
                
            }
            else if (location == 10) //If in the area with the huge tower
            {
                System.out.println("Would you like to enter the hall?");
                System.out.print("> ");
                String ans = kbInput.next();
                if (ans.toLowerCase().equals("yes"))
                {
                    System.out.println("\nThe hall is absolutely massive. The meal has apparantely been eaten\n"
                        + "and the table is currently being cleaned. It's obvious that thousands could easily\n"
                        + "eat here comfortably. There's not much to do though, so you leave.");
                }
            }
            else if (location == 12)
            {
                System.out.print("\nWould you like to return to your homeland? Have you learned enough?\n> ");
                String j = kbInput.next().toLowerCase();
                if (j.equals("yes"))
                {
                    System.out.println("\nHopefully burdened by observational knowledge, you pass through\n"
                        + "the slit, ready to tell all you know about all you have seen.");
                    break;
                }
               
            }
            //Just a few random actions players may enter
            else if (action.equals("jump") || action.equals("run"))
                System.out.println("This is not the time to exercise.\n");
            else if (action.equals("swim"))
                System.out.println("You are not Michael Phelps.");
            else if (action.equals("unlock"))
                System.out.println("Maybe you should use the \"open\" command...");
            else if (action.equals("drop"))
                System.out.println("You really shouldn't drop things...");
            else if (action.equals("yell"))
                System.out.println("a...A..AAARRGHH!");
            else
                System.out.println("Nothing happened, maybe you can't. Try again.");
                
            place(location); //Calls the place method
        }while(!action.equals("quit")); //Just an extra safeguard if a player types "quit"
    }
    
    /**
     * Holds the details for each area on the game map. 
     * pre: None
     * post: The location details have been printed
     */
    public static void place(int location)
    { 
        //Takes the location and prints the details
        switch (location) {
            case 1:
                System.out.println("\nYou're currently standing in a small meadow.\n"
                    + "The ocean is to the west, and you don't know the way back north. To the south, you can see what looks\n"
                    + "some fields, and you can faintly see some voices. The the east, you can see a river.");
                break;
            case 2:
                System.out.println("\nYou're closer to the river, and you can hear some loud noises to the south.\n"
                    + "In that direction, you can see a wall. There's not much to learn here, however.");
                break;
            case 3:
                System.out.println("\nThe river curves south here, towards a wall. You can certainly hear loud\n"
                    + "voices and laughing to the east, along with some sounds of metal clanging.");
                break;
            case 4:
                System.out.println("\nYou can see a large crowd of soldiers, barely armored and laughing uproariously.\n"
                    + "Most of them have bloody stains and battered weapons, but they sure look strong. One of them is\n"
                    + "actually swimming in a huge pile of gold. They look much less majestic than the wall to the\n"
                    + "south. The ocen lies beyond them to the west.");
                break;
            case 5:
                System.out.println("\nThere are a few sparse trees with the ocean still to the west. You definitely\n"
                    + "see fields to the south, and a wall in the east. As you're walking, you stumble on\n"
                    + "something. Looking back, you see a pile of gems just lying on the ground.");
                break;
            case 6:
                System.out.println("\nYou're in the northwestern portion of a city. The buildings are all simple yet\n"
                    + "beautiful. As you're walking, you spot a line of slaves working on a broken portion of road.\n"
                    + "Strangely, they are chained together with gold instead of iron or steel.");
                break;
            case 7:
                System.out.println("\nThere's a large crowd gathered around a pedastal where a man is delivering\n"
                    + "a speech passionately. There's a little boy looking at you curiously also. There's a solid wall to\n");
                break;
            case 8:
                System.out.println("\nThis is another highly populated area of the city, and you listen to passing\n"
                    + "conversations. One man mentioned that his cousin had become a butcher, and he would have to\n"
                    + "become a hunter as well. One mother was explaining to her daughter that virtue is living according\n"
                    + "to nature. Another man was chastising his pre-teen son about his useless hobbies, and that he should\n"
                    + "be developing his mastery of the family craft. There is a solid wall to the east.");
                break;
            case 9:
                System.out.println("\nThere is a huge expanse of farmland, with hundreds upon hundreds of workers bent\n"
                    + "over their work, sweating in the hot sun. You watch as they passionately accomplish their tasks."
                    + "There is no path to the south, and the ocean is still to the west");
                break;
            case 10:
                System.out.println("\nThe river from the ocean passes through this corner of the city, possibly for ships\n"
                    + "to easily access the entirety of the city. There are hundreds of citizens walking around, going to\n"
                    + "various tasks. A couple walks by, and you hear the girl say, \"I'm so glad I'm finally 18! I've been\n"
                    + "waiting to get married for so long. I'm so glad you approved of my body when shown to you...\" You also\n"
                    + "see the inside of a huge hall with the smell of delicious food pouring out. There's a solid wall to the\n"
                    + "south.");
                break;
            case 11:
                System.out.println("\nThere's an old, old man sitting on a bench alone, but this area\n"
                    + "mostly looks normal compared to the others. The people all look very happy and\n"
                    + "content. Not only that, they all seem very preoccupied with some intellectual\n"
                    + "pursuit. Some are reading, some are discussing logic, and others are solving\n"
                    + "puzzles. There's a solid wall to the south.");
                break;
            case 12:
                System.out.println("\nThere's something different about this area of the city. The air\n"
                    + "seems to waver around you. You slowly walk around, and then notice a small slit\n"
                    + "cut in a wall. Through it, you can see the time you came from. This is the path\n"
                    + "back home.");
                break;
            }
        
    }
    
}


