package edu.sustech.xiangqi.model;

public class CarPiece extends AbstractPiece {
    public CarPiece(String name, int row, int col, boolean isRed) {
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

        //移动的方法
        if ( (Math.abs(rowDiff) !=0 &&  Math.abs(colDiff) ==0) || (Math.abs(rowDiff) ==0 &&  Math.abs(colDiff) !=0)) {
            return true;
        } else {
            return false;
        }

    }
}
