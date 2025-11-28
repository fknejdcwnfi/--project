package edu.sustech.xiangqi;

import edu.sustech.xiangqi.model.ChessBoardModel;
import java.io.Serializable; // <--- Import this
// Change the class definition

public class PlayGameSession implements Serializable{//这是玩家状态属性的类，用来让玩家成为一个对象
    private String PlayerNameID;
    private ChessBoardModel chessBoardModel;
    private CurrentCamp currentCamp;

    public PlayGameSession(String playerName) {
           this.PlayerNameID = playerName;
           this.chessBoardModel = new ChessBoardModel();
           this.currentCamp = new CurrentCamp();
    }

    public ChessBoardModel getChessBoardModel() {
        return chessBoardModel;
    }

    public CurrentCamp getCurrentCamp() {
        return currentCamp;
    }

    public String getPlayerNameID() {
        return PlayerNameID;
    }

    public void setModel(ChessBoardModel newModel) {
        this.chessBoardModel = newModel;
    }
}
