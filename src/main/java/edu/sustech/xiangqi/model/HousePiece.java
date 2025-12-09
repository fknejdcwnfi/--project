package edu.sustech.xiangqi.model;

public class HousePiece extends AbstractPiece {
    public HousePiece(String name, int row, int col, boolean isRed,  int value) {
        super(name, row, col, isRed,   value);
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
        int inColDiff = targetCol - currentCol;

            if (Math.abs(rowDiff) == 2 &&  Math.abs(colDiff) == 1 ||  Math.abs(rowDiff) == 1 &&  Math.abs(colDiff) == 2) {
                int modelRow = getRow();//压马脚
                int modelCol = getCol();
                int houseRow = getRow() + rowDiff / 2;
                int houseCol = getCol() + inColDiff / 2;
                if (model.getPieceAt(houseRow, houseCol) != null) {
                    return false;
                }
                return true;
            }
             return false;
    }
}
