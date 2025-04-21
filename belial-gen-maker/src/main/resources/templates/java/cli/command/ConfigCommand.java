package com.belial.maker.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.belial.maker.model.DataModel;
import picocli.CommandLine;

import java.lang.reflect.Field;

@CommandLine.Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(DataModel.class);
        for (Field field : fields) {
            System.out.println(field.getName() + ": " + field.getType().getSimpleName());
            System.out.println("-------------------");
        }
    }
}
