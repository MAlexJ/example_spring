### Spring AOP

AOP is a programming paradigm that aims to increase modularity by allowing the separation of cross-cutting concerns.
It does this by adding additional behavior to existing code without modifying the code itself.

Instead, we can declare the new code and the new behaviors separately.

Spring’s AOP framework helps us implement these cross-cutting concerns.
<br><br>

### AOP Concepts and Terminology

<br>

#### 1. Business Object

A business object is a normal class that has a normal business logic. Let’s look at a simple example of a business
object where we just add two numbers:
<br><br>

#### 2. Aspect

An aspect is a modularization of a concern that cuts across multiple classes. Unified logging can be an example of such
cross-cutting concern.
<br><br>

#### 3. Joinpoint

A Joinpoint is a point during the execution of a program, such as the execution of a method or the handling of an
exception.
<br><br>

#### 4. Pointcut

A Pointcut is a predicate that helps match an Advice to be applied by an Aspect at a particular JoinPoint.

We often associate the Advice with a Pointcut expression, and it runs at any Joinpoint matched by the Pointcut.
<br><br>

#### 5. Advice

An Advice is an action taken by an aspect at a particular Joinpoint. <br>
Different types of advice include “around,” “before,” and “after.”