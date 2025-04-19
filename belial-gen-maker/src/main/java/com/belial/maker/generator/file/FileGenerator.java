package com.belial.maker.generator.file;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 动静结合代码生成器
 * 1. 先生成静态文件
 * 2. 再生成动态文件，覆盖静态文件
 */
public class FileGenerator {

    /**
     * 动静结合生成文件
     */
    public static void doGenerator(String inputPath, String outputPath, Object model) throws IOException, TemplateException {

        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);

        String inputPathFtl= "/Users/weiren/idea_work/belial/belial-gen-maker/src/main/resources/templates/MainTemplate.java.ftl";
        // 这个路径就是上面静态文件生成后的路径，通过动态文件生成将其替换
        outputPath = outputPath + File.separator + "acm-template/src/com/core/MainTemplate.java";

        DynamicFileGenerator.doGenerator(inputPathFtl, outputPath, model);
    }
}
