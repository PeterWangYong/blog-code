package com.peter.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Executor {
  public static void main(String[] args) {
    // 创建generator对象
    AutoGenerator generator = new AutoGenerator();

    // 数据源配置
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    dataSourceConfig.setDbType(DbType.MYSQL);
    dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybatisplus?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=UTF8");
    dataSourceConfig.setUsername("root");
    dataSourceConfig.setPassword("password");
    dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
    generator.setDataSource(dataSourceConfig);

    // 全局配置
    GlobalConfig globalConfig = new GlobalConfig();
    globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
    globalConfig.setOpen(false);
    globalConfig.setAuthor("peter");
    globalConfig.setServiceName("%sService");
    generator.setGlobalConfig(globalConfig);

    // 包命名配置
    PackageConfig packageConfig = new PackageConfig();
    packageConfig.setParent("com.peter.mybatisplus");
    packageConfig.setModuleName("generator");
    packageConfig.setController("controller");
    packageConfig.setService("service");
    packageConfig.setServiceImpl("service.impl");
    packageConfig.setMapper("mapper");
    packageConfig.setEntity("entity");
    generator.setPackageInfo(packageConfig);

    // 代码生成策略配置
    StrategyConfig strategyConfig = new StrategyConfig();
    strategyConfig.setEntityLombokModel(true);
    strategyConfig.setNaming(NamingStrategy.underline_to_camel);
    strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
    generator.setStrategy(strategyConfig);

    // 开始执行
    generator.execute();

  }
}
