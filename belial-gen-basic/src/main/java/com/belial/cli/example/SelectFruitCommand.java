package com.belial.cli.example;

import com.belial.cli.utils.InteractiveUtils;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import picocli.CommandLine;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@CommandLine.Command(name = "selectFruit", description = "展示水果选项供用户选择")
public class SelectFruitCommand implements Runnable {
    @Override
    public void run() {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        String selection = null;
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).jna(true).build();
            terminal.enterRawMode();
            selection = InteractiveUtils.selectOption(terminal, fruits, "请选择一种水果（使用上下箭头移动，回车确认）：");
            terminal.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("您选择了: " + selection);
    }
}
