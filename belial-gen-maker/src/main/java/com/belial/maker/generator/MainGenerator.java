package com.belial.maker.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.belial.maker.generator.file.DynamicFileGenerator;
import com.belial.maker.meta.Meta;
import com.belial.maker.meta.MetaManger;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        Meta metaObject = MetaManger.getMetaObject();
        System.out.println(metaObject);

        // 读取模板文件，获取resource路径
        ClassPathResource resource = new ClassPathResource("");
        String inputResourcePath = resource.getAbsolutePath();
        String inputPath = inputResourcePath + File.separator + "templates/java/model/DataModel.java.ftl";

        // 项目根路径
        String projectPath = System.getProperty("user.dir");
        // 输出路径
        String outputPath = projectPath + File.separator + "generate" + File.separator + metaObject.getName();
        if (!FileUtil.exist(outputPath)) {
            FileUtil.mkdir(outputPath);
        }
        // 获取包路径
        String basePackage = metaObject.getBasePackage().replace(".", File.separator);
        outputPath = outputPath + File.separator + basePackage + File.separator +  "maker/model/DataModel.java";


        DynamicFileGenerator.doGenerator(inputPath, outputPath, metaObject);
    }
}
