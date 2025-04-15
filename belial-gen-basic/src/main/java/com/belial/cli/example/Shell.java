package com.belial.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "shell", description = "交互式 Shell 示例", subcommands = {
        ChooseCommand.class,
        SelectFruitCommand.class
})
public class Shell implements Runnable {

    @Override
    public void run() {
        System.out.println("欢迎进入交互式 Shell，请输入子命令：choose 或 selectFruit");
    }



    public static void main(String[] args) {
        int exitCode = new CommandLine(new Shell()).execute(args);
        System.exit(exitCode);
    }
}
