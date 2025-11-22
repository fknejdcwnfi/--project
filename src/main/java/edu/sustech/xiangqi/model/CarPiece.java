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
            AbstractPiece target = model.getPieceAt(targetRow, targetCol);
            int between = countPiecesBetween(currentRow, currentCol, targetRow, targetCol, model);
            if (between < 0) return false;

            if (target == null) {
                // 普通移动：中间不能有子
                return between == 0;
            } else {
                return between == 0;
            }
    } else {
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
