package org.butu.ucenter;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author BUTU
 */
public class CodeGeneratorUtils {
    public static void main(String[] args) {
        List<String> tables = new ArrayList<>();
        tables.add("uc_app");//需要生成的表
        tables.add("uc_black_list");
        tables.add("uc_fans");
        tables.add("uc_images");
        tables.add("uc_login_record");
        tables.add("uc_register_info");
        tables.add("uc_settings");
        tables.add("uc_statistics");
        tables.add("uc_token");
        tables.add("uc_user");
        tables.add("uc_user_info");

        FastAutoGenerator.create("jdbc:mariadb://localhost:3306/mo_yu_ucenter?useUnicode=true&characterEncoding=utf-8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai","root","root")
                .globalConfig(builder -> {
                    builder.author("BUTUbird")               //作者
                            .outputDir(System.getProperty("user.dir")+"\\u-center\\src\\main\\java")    //输出路径(写到java目录)
                            .enableSwagger()           //开启swagger
                            .commentDate("yyyy-MM-dd")
                            .fileOverride();            //开启覆盖之前生成的文件

                })
                .packageConfig(builder -> {
                    builder.parent("org.butu")
                               .moduleName("ucenter")
                            .entity("pojo")
                            .service("service")
                            .serviceImpl("service.Impl")
                            .controller("api")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,System.getProperty("user.dir")+"\\u-center\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .addTablePrefix("uc_") //过滤表名前缀
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
                            .enableLombok()
                            .logicDeleteColumnName("deleted")
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()
                            .formatXmlFileName("%sMapper");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
