package com.belial.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.belial.generator.DynamicGenerator;
import com.belial.generator.MainGenerator;
import com.belial.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import lombok.Data;
import picocli.CommandLine;

import java.io.IOException;

/**
 * 生成代码命令
 */
@CommandLine.Command(name = "generate", description = "生成代码", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Runnable{

    @CommandLine.Option(names = {"-i", "--input"}, description = "读取文件路径", required = true, interactive = true, echo = true)
    private String inputPath;

    // interactive 开启交互式; echo 开启回显
    @CommandLine.Option(names = {"-a", "--author"}, description = "作者", interactive = true, echo = true)
    private String author;

    @CommandLine.Option(names = {"-ot", "--outputText"}, description = "输出内容", interactive = true, echo = true)
    private String outputText;

    @CommandLine.Option(names = {"-l", "--loop"}, description = "是否循环", interactive = true, echo = true)
    private Boolean loop = Boolean.FALSE;

    @CommandLine.Option(names = {"-o", "--output"}, description = "输出文件路径", required = true, interactive = true, echo = true)
    private String outputPath;

    @Override
    public void run() {

        MainTemplateConfig config = BeanUtil.copyProperties(this, MainTemplateConfig.class);
        try {
            MainGenerator.doGenerator(inputPath, outputPath, config);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
