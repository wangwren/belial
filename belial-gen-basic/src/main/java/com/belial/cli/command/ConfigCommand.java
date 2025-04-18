package com.belial.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.belial.model.MainTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;

@CommandLine.Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println(field.getName() + ": " + field.getType().getSimpleName());
            System.out.println("-------------------");
        }
    }
}
