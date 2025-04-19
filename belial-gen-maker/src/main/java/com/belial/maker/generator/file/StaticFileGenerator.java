package com.belial.maker.generator.file;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态代码生成器
 */
public class StaticFileGenerator {

    /**
     * 拷贝文件
     * 使用Hutool工具类
     */
    public static void copyFilesByHutool(String sourcePath, String targetPath) {

        FileUtil.copy(sourcePath, targetPath, true);

    }
}
