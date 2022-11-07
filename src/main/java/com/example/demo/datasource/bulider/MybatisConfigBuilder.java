package com.example.demo.datasource.bulider;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import tk.mybatis.mapper.code.Style;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 数据库配置
 *
 * @author zaochun.zjw
 * @date 2022/11/2
 */
public class MybatisConfigBuilder {


    /**
     * 创建Mysql SqlSessioFactoryBean
     *
     * @param dataSource    数据源
     * @param configuration mybatis配置
     * @return SqlSessionFactoryBean
     */
    public static SqlSessionFactoryBean buildMysqlSessionFactoryBean(DataSource dataSource, Configuration configuration) {
        configuration.setMapUnderscoreToCamelCase(true);

        Properties properties = new Properties();
        properties.setProperty("dialect", "com.github.pagehelper.PageHelper");
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "false");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "count=countSql");

        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(properties);

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage("com.example.demo.**.data");
        sessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});

        return sessionFactoryBean;
    }

    /**
     * 创建 Mysql Dao (Mapper) 扫描配置
     *
     * @param sessionFactory sessionFactory Bean名称
     * @return Mysql Dao (Mapper) 扫描配置
     */
    public MapperScannerConfigurer buildMapperScanConfig(String sessionFactory) {
        Config config = new Config();
        config.setIDENTITY("MYSQL");
        config.setStyle(Style.camelhumpAndLowercase);

        MapperHelper mapperHelper = new MapperHelper();
        mapperHelper.setConfig(config);

        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setSqlSessionFactoryBeanName(sessionFactory);
        scannerConfigurer.setBasePackage("com.example.demo.**.dao");
        scannerConfigurer.setMapperHelper(mapperHelper);

        return scannerConfigurer;
    }
}
