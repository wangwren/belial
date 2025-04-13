package com.belial.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态代码生成器
 */
public class StaticGenerator {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        // 源文件路径，File.separator 根据不同操作系统匹配不同的分隔符
        String sourcePath = projectPath + File.separator + "belial-gen-demo" + File.separator + "acm-template";
        System.out.println(sourcePath);

        // 输出路径，项目根路径
        String targetpath = projectPath;
        copyFilesByHutool(sourcePath, targetpath);
    }

    /**
     * 拷贝文件
     * 使用Hutool工具类
     */
    public static void copyFilesByHutool(String sourcePath, String targetPath) {

        FileUtil.copy(sourcePath, targetPath, true);

    }
}
