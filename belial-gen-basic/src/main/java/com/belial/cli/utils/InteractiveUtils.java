package com.belial.cli.utils;

import org.jline.terminal.Terminal;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

/**
 * 交互式菜单选择工具类
 */
public class InteractiveUtils {

    /**
     * 实现交互式菜单，直接显示 options 列表，用户只能用上下箭头移动选择，
     * 按回车确认最终的选择。
     *
     * @param terminal 当前终端
     * @param options  菜单选项列表
     * @return 用户选择的选项
     * @throws IOException 读取输入可能抛出 IOException
     */
    public static String selectOption(Terminal terminal, List<String> options, String remark) throws IOException {
        int selected = 0;
        PrintWriter writer = terminal.writer();
        Reader reader = terminal.reader();

        while (true) {
            // 使用 ANSI 转义序列清屏，定位光标到屏幕顶部
            writer.print("\033[H\033[2J");
            writer.flush();

            writer.println(remark);
            // 显示菜单，并对当前选中项进行标记
            for (int i = 0; i < options.size(); i++) {
                if (i == selected) {
                    writer.println("> " + options.get(i));
                } else {
                    writer.println("  " + options.get(i));
                }
            }
            writer.flush();

            int c = reader.read();
            if (c == 27) { // 检测到 ESC 字符，通常是箭头键的起始
                int next1 = reader.read();
                if (next1 == 91) { // 确保后续字符为 '['
                    int next2 = reader.read();
                    if (next2 == 65) { // 上箭头 (ESC [ A)
                        selected = (selected - 1 + options.size()) % options.size();
                    } else if (next2 == 66) { // 下箭头 (ESC [ B)
                        selected = (selected + 1) % options.size();
                    }
                    // 如果不是上下箭头则忽略
                }
            } else if (c == '\r' || c == '\n') { // 回车确认输入
                break;
            }
            // 其他按键直接忽略
        }
        return options.get(selected);
    }
}
