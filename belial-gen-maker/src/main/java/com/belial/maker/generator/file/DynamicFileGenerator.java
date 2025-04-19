package com.belial.maker.generator.file;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 动态代码生成器
 */
public class DynamicFileGenerator {

    /**
     * 生成文件
     * @param inputPath  模板文件输入路径
     * @param outputPath  输出路径
     * @param model 数据模型
     */
    public static void doGenerator(String inputPath, String outputPath, Object model) throws IOException, TemplateException {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // inputPath是带模板文件的路径，获取模板文件的父文件就是模板文件所在路径
        File file = new File(inputPath).getParentFile();
        // 指定模板文件所在路径
        configuration.setDirectoryForTemplateLoading(file);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("UTF-8");

        // 创建模板对象，加载指定模板
        String name = new File(inputPath).getName();
        Template template = configuration.getTemplate(name);

        // 文件不存在创建文件和父目录
        if (!FileUtil.exist(outputPath)) {
            FileUtil.touch(outputPath);
        }

        // 生成新的文件
        Writer writer = new FileWriter(outputPath);

        template.process(model, writer);

        writer.close();
    }
}
