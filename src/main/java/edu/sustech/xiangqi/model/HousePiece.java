package edu.sustech.xiangqi.model;

public class HousePiece extends AbstractPiece {
    public HousePiece(String name, int row, int col, boolean isRed) {
        super(name, row, col, isRed);
    }
    @Override
    public boolean canMoveTo(int targetRow, int targetCol, ChessBoardModel model) {
        int currentRow = getRow();
        int currentCol = getCol();

        if (currentRow == targetRow && currentCol == targetCol) {
            return false;
        }

        int rowDiff = targetRow - currentRow;
        int colDiff = Math.abs(targetCol - currentCol);


        if (isRed()) {
            if (Math.abs(rowDiff) == 2 &&  Math.abs(colDiff) == 1 ||  Math.abs(rowDiff) == 1 &&  Math.abs(colDiff) == 2) {
                return true;
            } else {
                return false;
            }
        } else {
            if (Math.abs(rowDiff) == 2 &&  Math.abs(colDiff) == 1 ||  Math.abs(rowDiff) == 1 &&  Math.abs(colDiff) == 2) {
                return true;
            } else {
                return false;
            }
        }
    }
}
