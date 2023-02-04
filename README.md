# Fastball 示例项目

Fastball 的示例项目, 主要展示了各种组件以及基本使用方式.

## 环境要求

* [Java](https://openjdk.org/): 8+
* [Maven](https://maven.apache.org/): 3.6.0+
* [NodeJs](https://nodejs.org/): 14+

::: tip 关于 `NodeJs` 与 `pnpm`
`Fastball` 为了节省前端依赖安装时间, 默认使用 `pnpm`, 如果仅安装了 `NodeJs` 但未安装 `pnpm`, 则第一次会尝试自动安装, 如果安装失败, 可以参考 [PNPM官网](https://pnpm.io/installation) 的安装过程.
:::

## 运行示例项目

Fastball 提供了一个演示项目 [Fastball-example](https://github.com/fastball-projects/fastball-example), 准备好环境要求后, 可以 Fork 或者直接 Clone 到本地运行.
或者直接在 `Terminal` 通过命令直接运行:

```bash
# git clone 项目
git clone https://github.com/fastball-projects/fastball-example.git && \

# 进入项目目录
cd fastball-example && \

# 运行项目
mvn package spring-boot:run
```

待运行完毕后访问 [http://127.0.0.1:8080/](http://127.0.0.1:8080/), 如果是通过 Idea 启动, 并且引入了 `fastball-runtime-spring-devtools` 的情况下, 会自动调用浏览器打开, 默认地址是 [http://127.0.0.1:5173/](http://127.0.0.1:5173/).