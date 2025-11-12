package edu.sustech.xiangqi.model;

public class XiangPiece extends AbstractPiece{
    public XiangPiece(String name, int row, int col, boolean isRed) {
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

        //象的移动（1.分黑白 2.不过楚河汉界 3.斜线的田字）
        if (isRed()) {
                    if ((Math.abs(rowDiff) == 2 && Math.abs(colDiff) == 2) && targetRow >= 5) {
                        return true;
                    } else {
                        return false;
                    }
                } else if ((Math.abs(rowDiff) == 2 && Math.abs(colDiff) == 2) && targetRow <= 4) {
                    return true;
                } else{
                    return false;
                }

    }
}
