package edu.sustech.xiangqi.model;

public class ShiPiece extends AbstractPiece {
    public ShiPiece(String name, int row, int col, boolean isRed, int value) {
        super(name, row, col, isRed, value);
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

        //士的移动（边界和斜线，分黑白）
        if (isRed()) {
            if ((Math.abs(rowDiff) == 1 && Math.abs(colDiff) == 1)  && targetRow <= 9 && targetCol <= 5 && targetRow >= 7 && targetCol >= 3) {
                return true;
            } else {
                return false;
            }
        } else if ((Math.abs(rowDiff) == 1 && Math.abs(colDiff) == 1) && targetRow <= 2 && targetCol <= 5 && targetRow >= 0 && targetCol >= 3) {
            return true;
        } else{
            return false;
        }


    }
}
