package com.belial.maker.cli.command;

import picocli.CommandLine;

/**
 * 遍历出要输出的所有文件
 */
@CommandLine.Command(name = "list", description = "遍历出要输出的所有文件", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
    @Override
    public void run() {
        // 再GenerateCommand中让用户指定了文件路径，这里暂时没什么必要
    }
}
