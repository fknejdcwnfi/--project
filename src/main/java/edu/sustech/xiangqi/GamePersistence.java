package edu.sustech.xiangqi;

import javax.imageio.IIOException;
import java.io.*;

public class GamePersistence {

    //Serializes(saves) the GameSession object to file named after the player

    public static void saveGame(PlayGameSession session) {
        String filename = session.getPlayerNameID() + ".sav";
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(session);
            System.out.println("Game saved successfully to: " + filename);
        } catch (IOException i) {
            System.err.println("Error saving name: " + i.getMessage());
            i.printStackTrace();
        }
    }


    //Deserializes (loads) a GameSession object from a player's save file
    //@return the loaded PlayGameSession object or null if the file is not found
    public static PlayGameSession loadGame(String playerName) {
        String filename = playerName + ".sav";
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            PlayGameSession session = (PlayGameSession) in.readObject();
            System.out.println("Game loaded successfully for: " + playerName);
            return session;
        } catch (FileNotFoundException e) {
            System.out.println("NO saved game found for " + playerName + ".Starting new game");
        return null;//return null to indicate a new game should be created
        } catch (IOException i) {
            System.err.println("Error loading game: " +  i.getMessage());
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.err.println("PlayGameSession class not found. " +  c.getMessage());
            c.printStackTrace();
            return null;
        }
    }


}
