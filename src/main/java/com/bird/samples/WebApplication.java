package com.bird.samples;

import com.bird.samples.pojo.TestArg;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.Map;

@EnableAsync(proxyTargetClass = true)
//@EnableScheduling
@SpringBootApplication
@MapperScan("com.bird.samples.mapper")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);

        System.out.println("================");

        ExpressionParser expressionParser = new SpelExpressionParser();

        Map<String,Object> map = new HashMap<>(4);
        map.put("demo",new TestArg("liuxx"));
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
//        evaluationContext.setVariable("demo",new TestArg("liuxx"));
        evaluationContext.setVariables(map);

        String name = expressionParser.parseExpression("#demo.name").getValue(evaluationContext,String.class);
        System.out.println(name);
    }

}
