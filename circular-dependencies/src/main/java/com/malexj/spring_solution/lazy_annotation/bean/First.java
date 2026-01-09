package com.malexj.spring_solution.lazy_annotation.bean;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class First {

    @Value("${first.bean.name:FirstBean}")
    private String name;

    private final LazyBeanInjection second;

    @Override
    public String toString() {
        return "{" + "name=" + name + ", second=" + second.getName() + '}';
    }
}
