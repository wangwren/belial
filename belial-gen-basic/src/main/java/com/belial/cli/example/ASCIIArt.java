package com.belial.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

// 使用@Command注解定义命令行应用程序,mixinStandardHelpOptions=true表示自动生成帮助选项,即--help和-h
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true) 
public class ASCIIArt implements Runnable { // 实现 Runnable 接口 或 Callable 接口

    //@Option通过注解定义命令行选项，可以给选项设置名称和描述,指定默认值
    @Option(names = { "-s", "--font-size" }, description = "Font size") 
    int fontSize = 19;

    // @Parameters注解用于定义命令行参数,可以指定参数的名称和描述，这个是参数，跟上面的@Option不一样(是选项)，
    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli", 
               description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" }; 

    // 在run() 或 call()方法中实现具体的业务逻辑,当命令解析成功(用户输入命令敲了回车后)执行
    @Override
    public void run() {
        // 自己实现业务逻辑
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    public static void main(String[] args) {
        // execute返回一个int类型的值，表示命令行应用程序的退出状态码，0表示成功，非0表示失败
        // args是命令行参数，传入的参数会被解析成对应的选项和参数，也可以自己指定
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);

        // 将该退出码作为参数，从而向调用进程表示成功或失败
        System.exit(exitCode); 
    }
}
