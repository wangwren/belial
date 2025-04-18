# Belial · Java代码生成器

> 一款不正经但很好用的代码生成器  
> —— 专治无聊、致敬优雅、暗藏骚气。

---

## 设计理念

- 能自动，绝不手敲
- 能配置，绝不硬编码
- 能复用，绝不复制
- 能整活，必须整活

---

## 项目目标

写代码不止是效率，更是态度。

### belial-gen-basic
- 基于命令行(Picocli框架)的代码生成器

### 待优化
- 现在要生成的代码路径是写死在代码里的，用起来感觉有点别扭

#### 使用
进入到belial-gen-basic
```bash
chmod a+x generator

./generator -h # 查看帮助

./generator confg # 查看参数

./generator generate -h # 查看帮助

./generator generate -i -a -l -ot -o # 生成代码
```

##### generator脚本解释
- generator文件没有后缀默认就是shell脚本
- `chmod a+x generator`给文件添加可执行权限
- `"$@"`把每个位置参数作为一个独立的参数传给命令