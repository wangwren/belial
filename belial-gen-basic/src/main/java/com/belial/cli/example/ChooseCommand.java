package com.belial.cli.example;

import com.belial.cli.utils.InteractiveUtils;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import picocli.CommandLine;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@CommandLine.Command(name = "choose", description = "直接显示菜单供用户选择")
public class ChooseCommand implements Runnable{

    // 通过 ParentCommand 注入主命令（非必需，只用于共享数据或控制流程）
    @CommandLine.ParentCommand
    Shell parent;

    @Override
    public void run() {
        Terminal terminal = null;
        try {
            // 构建终端并进入原始模式（原始模式下按键会即时传递）
            terminal = TerminalBuilder.builder().system(true).jna(true).build();
            terminal.enterRawMode();
            List<String> options = Arrays.asList("Option 1", "Option 2", "Option 3");
            String selection = InteractiveUtils.selectOption(terminal, options, "请选择一个选项（使用上下箭头移动，回车确认）：");
            terminal.close();
            System.out.println("您选择了: " + selection);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 执行SelectFruitCommand
        new SelectFruitCommand().run();
    }
}
