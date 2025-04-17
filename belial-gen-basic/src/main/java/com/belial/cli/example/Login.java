package com.belial.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * 交互式命令行示例
 */
public class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    // interactive = true表示该选项是交互式的，用户在输入命令时会提示输入
    @Option(names = {"-p", "--password"}, description = "Passphrase", interactive = true)
    String password;

    public Integer call() throws Exception {
        System.out.println("password = " + password);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user123", "-p");
    }
}
