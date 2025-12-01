package edu.sustech.xiangqi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeForDisplayAndLater {
    /**
     * 助手方法：显示一个 JLabel，并在指定毫秒后自动隐藏。
     * @param label 要显示/隐藏的 JLabel
     * @param durationMs 持续显示的时间（毫秒）
     */
    /// ////////////////////////////////////////////////////时间延迟通用代码的方法
    public static void displayAndHideJLabel(JLabel label, int durationMs) {//字段的设置延迟时间（先展示后消失）
        // 1. 立即显示 Label
        label.setVisible(true);

        // 2. 创建 Timer，设置延迟时间
        Timer timer = new Timer(durationMs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 3. 延迟时间到，设置 Label 隐藏
                label.setVisible(false);

                // 4. 停止并销毁 Timer，因为只需要运行一次
                ((Timer) e.getSource()).stop();
            }
        });

        // 确保 Timer 只执行一次 (如果不需要重复，建议设置)
        timer.setRepeats(false);

        // 5. 启动计时器
        timer.start();
    }

    public static void displayAndHideFrame(JFrame jFrame, int durationMs) {//框架的延迟时间（先显示后不显示）
        // 1. 立即显示 Label
        jFrame.setVisible(true);

        // 2. 创建 Timer，设置延迟时间
        Timer timer = new Timer(durationMs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 3. 延迟时间到，设置 Label 隐藏
                jFrame.setVisible(false);

                // 4. 停止并销毁 Timer，因为只需要运行一次
                ((Timer) e.getSource()).stop();
            }
        });

        // 确保 Timer 只执行一次 (如果不需要重复，建议设置)
        timer.setRepeats(false);

        // 5. 启动计时器
        timer.start();
    }

    public static void hideAndDisplayFrame(JFrame jFrame, int durationMs) {//框架的延迟时间（先不显示后显示）
        // 1. 立即显示 Label
        jFrame.setVisible(false);

        // 2. 创建 Timer，设置延迟时间
        Timer timer = new Timer(durationMs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 3. 延迟时间到，设置 Label 隐藏
                jFrame.setVisible(true);

                // 4. 停止并销毁 Timer，因为只需要运行一次
                ((Timer) e.getSource()).stop();
            }
        });

        // 确保 Timer 只执行一次 (如果不需要重复，建议设置)
        timer.setRepeats(false);

        // 5. 启动计时器
        timer.start();
    }

    public static void onlyHideFrame(JFrame jFrame, int durationMs) {//框架的延迟时间消失


        // 2. 创建 Timer，设置延迟时间
        Timer timer = new Timer(durationMs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 3. 延迟时间到，设置 Label 隐藏
                jFrame.setVisible(false);

                // 4. 停止并销毁 Timer，因为只需要运行一次
                ((Timer) e.getSource()).stop();
            }
        });

        // 确保 Timer 只执行一次 (如果不需要重复，建议设置)
        timer.setRepeats(false);

        // 5. 启动计时器
        timer.start();
    }

    public static void onlyDisplayFrame(JFrame jFrame, int durationMs) {//框架的延迟时间显示
        // 2. 创建 Timer，设置延迟时间
        Timer timer = new Timer(durationMs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 3. 延迟时间到，设置 Label 隐藏
                jFrame.setVisible(true);

                // 4. 停止并销毁 Timer，因为只需要运行一次
                ((Timer) e.getSource()).stop();
            }
        });

        // 确保 Timer 只执行一次 (如果不需要重复，建议设置)
        timer.setRepeats(false);

        // 5. 启动计时器
        timer.start();
    }
}
