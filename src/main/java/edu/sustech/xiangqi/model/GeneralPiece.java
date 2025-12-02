package edu.sustech.xiangqi.model;

/**
 * 帅/将
 */
public class GeneralPiece extends AbstractPiece implements Cloneable {

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
        int between = countPiecesBetween(currentRow, currentCol, targetRow, targetCol, model);
        if (isRed()) {
            if ((((Math.abs(rowDiff) == 0 && Math.abs(colDiff) == 1) || (Math.abs(rowDiff) == 1 && Math.abs(colDiff) == 0)) && targetRow <= 9 && targetCol <= 5 && targetRow >= 7 && targetCol >= 3) || ((model.getPieceAt(targetRow,targetCol) != null) && (model.getPieceAt(targetRow,targetCol).getName().equals("將")) && between == 0)) {
                return true;
            } else {
                return false;
            }
        } else if ((((Math.abs(rowDiff) == 0 && Math.abs(colDiff) == 1) || (Math.abs(rowDiff) == 1 && Math.abs(colDiff) == 0)) && targetRow <= 2 && targetCol <= 5 && targetRow >= 0 && targetCol >= 3) || ((model.getPieceAt(targetRow,targetCol) != null) && (model.getPieceAt(targetRow,targetCol).getName().equals("帅")) && between == 0)) {
            return true;
        } else{
            return false;
        }
    }

    private int countPiecesBetween(int r1, int c1, int r2, int c2, ChessBoardModel model) {
        int count = 0;
        if (r1 == r2) {
            int start = Math.min(c1, c2) + 1;
            int end = Math.max(c1, c2) - 1;
            for (int c = start; c <= end; c++) {
                if (model.getPieceAt(r1, c) != null) count++;
            }
        } else if (c1 == c2) {
            int start = Math.min(r1, r2) + 1;
            int end = Math.max(r1, r2) - 1;
            for (int r = start; r <= end; r++) {
                if (model.getPieceAt(r, c1) != null) count++;
            }
        } else {
            // 不是直线，不是炮的移动
            return -1;
        }
        return count;
    }
}
