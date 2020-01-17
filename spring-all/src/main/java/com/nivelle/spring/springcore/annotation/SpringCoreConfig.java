package com.nivelle.spring.springcore.annotation;

import com.nivelle.spring.pojo.Car;
import com.nivelle.spring.pojo.Dog;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * 注解类学习
 *
 * @author fuxinzhong
 * @date 2019/09/23
 */

/**
 * 采用自定义的过滤方式，必须使用:useDefaultFilters=false
 */
@Configuration
//返回true时将此类作为配置类
@Conditional(MyCondition.class)
//注册器
@Import({Car.class, ImportSelector.class})
public class SpringCoreConfig {

    /**
     * 默认实例名为方法名字
     *
     * @return
     */
    @Bean
    @Lazy
    public Dog bigDog() {
        return new Dog("wangwang", 1, "black");
    }

    /**
     * 默认单例,饿汉模式，通过@Lazy @Scope指定为多实例和懒汉模式
     *
     * @return
     */
    @Bean(value = "buDingDog")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Dog littleDog() {
        return new Dog("buding", 1, "yellow");
    }
}