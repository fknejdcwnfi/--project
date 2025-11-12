package edu.sustech.xiangqi.model;

/**
 * 帅/将
 */
public class GeneralPiece extends AbstractPiece {

    public GeneralPiece(String name, int row, int col, boolean isRed) {
        super(name, row, col, isRed);
    }

    @Override
    public boolean canMoveTo(int targetRow, int targetCol, ChessBoardModel model) {
        //TODO: 实现将/帅的移动规则
        int currentRow = getRow();
        int currentCol = getCol();

        if (currentRow == targetRow && currentCol == targetCol) {
            return false;
        }

        int rowDiff = targetRow - currentRow;
        int colDiff = Math.abs(targetCol - currentCol);

        if (isRed()) {
            if (((Math.abs(rowDiff) == 0 && Math.abs(colDiff) == 1) || (Math.abs(rowDiff) == 1 && Math.abs(colDiff) == 0)) && targetRow <= 9 && targetCol <= 5 && targetRow >= 7 && targetCol >= 3) {
                return true;
            } else {
                return false;
            }
        } else if (((Math.abs(rowDiff) == 0 && Math.abs(colDiff) == 1) || (Math.abs(rowDiff) == 1 && Math.abs(colDiff) == 0)) && targetRow <= 2 && targetCol <= 5 && targetRow >= 0 && targetCol >= 3) {
            return true;
        } else{
            return false;
        }
    }
}
