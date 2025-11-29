package edu.sustech.xiangqi.model;

import edu.sustech.xiangqi.CurrentCamp;
import edu.sustech.xiangqi.MoveEveryStep;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class ChessBoardModel implements Serializable {
    // 储存棋盘上所有的棋子，要实现吃子的话，直接通过pieces.remove(被吃掉的棋子)删除就可以
    private final List<AbstractPiece> pieces;
    private static final int ROWS = 10;
    private static final int COLS = 9;
    private final List<MoveEveryStep> moveHistory;
    private static final long serialVersionUID = 1L;

    public ChessBoardModel() {
        pieces = new ArrayList<>();
        moveHistory = new ArrayList<>();
        initializePieces();
    }

    private void initializePieces() {
        // 黑方棋子
        pieces.add(new GeneralPiece("將", 0, 4, false));
        pieces.add(new SoldierPiece("卒", 3, 0, false));
        pieces.add(new SoldierPiece("卒", 3, 2, false));
        pieces.add(new SoldierPiece("卒", 3, 4, false));
        pieces.add(new SoldierPiece("卒", 3, 6, false));
        pieces.add(new SoldierPiece("卒", 3, 8, false));
        pieces.add(new HousePiece("马", 0, 1, false));
        pieces.add(new HousePiece("马", 0, 7, false));
        pieces.add(new CarPiece("車", 0, 0, false));
        pieces.add(new CarPiece("車", 0, 8, false));
        pieces.add(new ShiPiece("士", 0, 3, false));
        pieces.add(new ShiPiece("士", 0, 5, false));
        pieces.add(new XiangPiece("象", 0, 2, false));
        pieces.add(new XiangPiece("象", 0, 6, false));
        pieces.add(new PaoPiece("炮", 2, 1, false));
        pieces.add(new PaoPiece("炮", 2, 7, false));


        // 红方棋子
        pieces.add(new GeneralPiece("帅", 9, 4, true));
        pieces.add(new SoldierPiece("兵", 6, 0, true));
        pieces.add(new SoldierPiece("兵", 6, 2, true));
        pieces.add(new SoldierPiece("兵", 6, 4, true));
        pieces.add(new SoldierPiece("兵", 6, 6, true));
        pieces.add(new SoldierPiece("兵", 6, 8, true));
        pieces.add(new HousePiece("馬", 9, 1, true));
        pieces.add(new HousePiece("馬", 9, 7, true));
        pieces.add(new CarPiece("车", 9, 0, true));
        pieces.add(new CarPiece("车", 9, 8, true));
        pieces.add(new ShiPiece("仕", 9, 3, true));
        pieces.add(new ShiPiece("仕", 9, 5, true));
        pieces.add(new XiangPiece("相", 9, 2, true));
        pieces.add(new XiangPiece("相", 9, 6, true));
        pieces.add(new PaoPiece("炮", 7, 1, true));
        pieces.add(new PaoPiece("炮", 7, 7, true));
    }

    public List<AbstractPiece> getPieces() {
        return pieces;
    }

    public AbstractPiece getPieceAt(int row, int col) {
        for (AbstractPiece piece : pieces) {
            if (piece.getRow() == row && piece.getCol() == col) {
                return piece;
            }
        }
        return null;
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }


    public boolean movePiece(AbstractPiece piece, int newRow, int newCol) {//指AbstractPiece piece当前的棋子对象
        if (!isValidPosition(newRow, newCol)) {
            return false;
        }

        if (!piece.canMoveTo(newRow, newCol, this)) {//这里的this指当前调用该方法的对象‌，即‌调用 movePiece 方法的棋盘对象
                return false;
        }
        piece.moveTo(newRow, newCol);
        return true;
    }

    public boolean movePieceForce(AbstractPiece piece, int newRow, int newCol) {
        if (!isValidPosition(newRow, newCol)) return false;
        piece.moveTo(newRow, newCol);
        return true;
    }

    public static int getRows() {
        return ROWS;
    }

    public static int getCols() {
        return COLS;
    }

    public void remove(AbstractPiece getTargetPiece){
        pieces.remove(getTargetPiece);
    }

    public void recordMove(MoveEveryStep move){
        moveHistory.add(move);
        System.out.print("Recorded move " + move.getMoveDescription());
    }

    public List<MoveEveryStep> getMoveHistory() {
        return moveHistory;
    }

    public void removeLastMove() {

        if (moveHistory.isEmpty()) {
            System.out.println("Error: Cannot take back a move. Move history is empty.");
            return;
        }
        MoveEveryStep lastMove = moveHistory.remove(moveHistory.size() - 1);
        trulyPhysicalMove(lastMove);

    }

    private void trulyPhysicalMove(MoveEveryStep move) {
        //下面的是获取最后一步的移动棋子

        AbstractPiece movingPiece = move.getMovingPiece();

        if (movingPiece == null) {
            System.err.println("CRITICAL: Moving piece in history is null. Cannot undo.");
            // You might consider re-adding the move to history here if you can't undo.
            return;
        }

        //下面是将移动棋子移动会原来的位置（开始位置）
        if  (movingPiece != null) {
            movingPiece.moveTo(move.getStartRow(), move.getStartCol());
        }
        //下面的是获取最后一步的被吃棋子
        AbstractPiece capturedPiece = move.getCapturedPiece();
        if (capturedPiece != null) {
            pieces.add(capturedPiece);//在当前的棋子model中加上被吃的棋子
            capturedPiece.moveTo(move.getEndRow(), move.getEndCol());//把背吃的棋子移动到最终的位置
        }
    }
}
