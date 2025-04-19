package com.belial.maker.cli;

import com.belial.maker.cli.command.ConfigCommand;
import com.belial.maker.cli.command.GenerateCommand;
import picocli.CommandLine;

/**
 * 命令行统一执行器
 */

@CommandLine.Command(name = "commandExecutor", description = "命令行统一执行器", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    private CommandLine commandLine;

    {
        // 添加子命令
        commandLine = new CommandLine(this);
        commandLine.addSubcommand(new GenerateCommand());
        commandLine.addSubcommand(new ConfigCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时，给出友好提示
        System.out.println("请输入具体命令，或者使用 --help 查看帮助信息");
    }

    /**
     * 执行命令
     */
    public Integer doExecutor(String[] args) {
        return commandLine.execute(args);
    }
}
