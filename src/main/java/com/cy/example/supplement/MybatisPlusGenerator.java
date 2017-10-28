package com.cy.example.supplement;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 代码生成器演示
 * </p>
 * 
 */
public class MybatisPlusGenerator {

	/**
	 * <p>
	 * MySQL 生成演示
	 * </p>
	 */
	public static void main(String[] args) {

		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("c://freemarker//src//main//java");
		gc.setFileOverride(true);
		gc.setActiveRecord(true);
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setAuthor("Cheny");

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setMapperName("%sMapper");
		gc.setXmlName("%sMapper");
		gc.setServiceName("I%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setControllerName("%sController");
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setTypeConvert(new MySqlTypeConvert() {
			// 自定义数据库表字段类型转换【可选】
			@Override
			public DbColumnType processTypeConvert(String fieldType) {
				System.out.println("转换类型：" + fieldType);
				return super.processTypeConvert(fieldType);
			}
		});
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("0.0.0.");
		dsc.setUrl("jdbc:mysql://localhost:3306/example?characterEncoding=utf8");
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setTablePrefix(new String[] { "plus" });// 此处可以修改为您的表前缀

		strategy.setNaming(NamingStrategy.nochange);// 表名生成策略
		// strategy.setInclude(new String[] { "user" }); // 需要生成的表
		// strategy.setExclude(new
		// String[]{"hibernate_sequence","quartz_%","quartz_*"}); // 排除生成的表
		// 字段名生成策略
		strategy.setNaming(NamingStrategy.nochange);
		// 自定义实体父类
		strategy.setSuperEntityClass("com.cy.example.entity.SuperEntity");
		// 自定义实体，公共字段
		strategy.setSuperEntityColumns(new String[] { "id", "c_createDate",
				"n_creater", "c_updateDate", "n_updater" });
		// 自定义 mapper 父类
		strategy.setSuperMapperClass("com.cy.example.mapper.SuperMapper");
		// 自定义 service 父类
		// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
		// // 自定义 service 实现类父类
		// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
		// 自定义 controller 父类
		strategy.setSuperControllerClass("com.cy.example.controller.BaseController");
		// 【实体】是否生成字段常量（默认 false）
		// public static final String ID = "test_id";
		// strategy.setEntityColumnConstant(true);
		// 【实体】是否为构建者模型（默认 false）
		// public User setName(String name) {this.name = name; return this;}
		// strategy.setEntityBuliderModel(true);
		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.cy.example");
		/* pc.setModuleName("freemarker"); */
		mpg.setPackageInfo(pc);

		// 执行生成
		mpg.execute();
	}

}