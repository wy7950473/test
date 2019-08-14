package com.example.login.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SqlSessionFactoryConfig {

    @Autowired
    private DataSource dataSource;

    @Value("${mybatis_config_file}")
    private String configLocation;

    @Value("${mapper_path}")
    private String mapperPath;

    @Value("${type_alias_package}")
    private String typeAliasesPackage;

    @Bean(name = "factory")
    public MybatisSqlSessionFactoryBean getMybatisSqlSessionFactoryBean() throws IOException {
        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        //加在mybatis-config文件
        factory.setConfigLocation(new ClassPathResource(configLocation));
        //扫描mapper
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        factory.setMapperLocations(resolver.getResources(packageSearchPath));
        //加在所要设置别名到包
        factory.setTypeAliasesPackage(typeAliasesPackage);
        //注入dataSource
        factory.setDataSource(dataSource);
        return factory;
    }
}
