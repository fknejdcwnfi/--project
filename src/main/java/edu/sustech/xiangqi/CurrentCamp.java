package edu.sustech.xiangqi;

public class CurrentCamp {
    // true = 红方回合, false = 黑方回合
    private boolean isRedTurn;

    public CurrentCamp() {
        // 默认游戏开始时是红方先走
        this.isRedTurn = true;
    }

    /**
     * 获取当前是否是红方回合
     */
    public boolean isRedTurn() {
        return isRedTurn;
    }

    /**
     * 切换回合（红变黑，黑变红）
     */
    public void nextTurn() {
        this.isRedTurn = !this.isRedTurn;
    }

    /**
     * 重置为红方（用于新游戏开始）
     */
    public void reset() {
        this.isRedTurn = true;
    }
}
