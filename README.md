## Spring example

1. core
2. aop
3. spring-patterns
4. circular-dependencies

### Spring v.6.+

* Info: https://docs.spring.io/spring-framework/reference/index.html

### JDK v.21

### Gradle v.8.+

* Info: https://docs.gradle.org/current/userguide/userguide.html

#### Grable plugins

Plugins:

1. Gradle Versions Plugin

Displays a report of the project dependencies that are up-to-date, exceed the latest version found,
have upgrades, or failed to be resolved

info: https://github.com/ben-manes/gradle-versions-plugin

```
gradle dependencyUpdates
```

#### Gradle wrapper

Gradle Wrapper Reference:
https://docs.gradle.org/current/userguide/gradle_wrapper.html

How to Upgrade Gradle Wrapper:
https://dev.to/pfilaretov42/tiny-how-to-upgrade-gradle-wrapper-3obl

```
./gradlew wrapper --gradle-version latest
```