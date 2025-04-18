package com.belial.generator;

import com.belial.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 动静结合代码生成器
 * 1. 先生成静态文件
 * 2. 再生成动态文件，覆盖静态文件
 */
public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 源文件路径，File.separator 根据不同操作系统匹配不同的分隔符
        String sourcePath = projectPath + File.separator + "belial-gen-demo" + File.separator + "acm-template";

        // 输出路径，项目根路径
        String targetpath = projectPath;
        StaticGenerator.copyFilesByHutool(sourcePath, targetpath);

        String inputPath = "belial-gen-basic/src/main/resources/templates/MainTemplate.java.ftl";
        // 这个路径就是上面静态文件生成后的路径，通过动态文件生成将其替换
        String outputPath = "acm-template/src/com/core/MainTemplate.java";

        MainTemplateConfig model = new MainTemplateConfig();
        model.setAuthor("weiren");
        model.setOutputText("测试测试");
        model.setLoop(Boolean.TRUE);
        DynamicGenerator.doGenerator(inputPath, outputPath, model);
    }

    /**
     * 动静结合生成文件
     */
    public static void doGenerator(String inputPath, String outputPath, Object model) throws IOException, TemplateException {

        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        String inputPathFtl= "/Users/weiren/idea_work/belial/belial-gen-basic/src/main/resources/templates/MainTemplate.java.ftl";
        // 这个路径就是上面静态文件生成后的路径，通过动态文件生成将其替换
        outputPath = outputPath + File.separator + "acm-template/src/com/core/MainTemplate.java";

        DynamicGenerator.doGenerator(inputPathFtl, outputPath, model);
    }
}
