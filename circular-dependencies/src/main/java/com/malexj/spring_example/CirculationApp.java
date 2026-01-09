package com.malexj.spring_example;

import com.malexj.base.AbstractClass;
import com.malexj.spring_example.bean.Child;
import com.malexj.spring_example.bean.Parent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.fail;

/*
 * Investigate in IDE:
 * Select project package > Analyze > Analyze Dependency Matrix...
 */
public class CirculationApp extends AbstractClass {

    @Test
    public void runApp() {
        try {
            var context = new AnnotationConfigApplicationContext(Child.class, Parent.class);
            var child = context.getBean(Child.class);
            var parent = context.getBean(Parent.class);
            println("child:", child, "parent:", parent, "parent.getChild():", parent.getChild());
            fail();
        } catch (UnsatisfiedDependencyException | BeanCurrentlyInCreationException e) {
            println("Error:", e.getMessage());
        }
    }
}
