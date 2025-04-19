package com.belial;

import com.belial.maker.cli.CommandExecutor;

public class Main {

    public static void main(String[] args) {

        //args = new String[]{"generate", "-i", "-a", "-ot", "-l", "-o"};
        // 输入路径 -i /Users/weiren/idea_work/belial/belial-gen-demo/acm-template
        // 输出路径 -o /Users/weiren/idea_work/belial

        //args = new String[]{"config"};
        CommandExecutor executor = new CommandExecutor();
        executor.doExecutor(args);
    }
}