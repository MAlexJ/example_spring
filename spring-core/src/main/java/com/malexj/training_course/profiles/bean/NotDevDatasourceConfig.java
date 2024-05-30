package com.malexj.training_course.profiles.bean;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!dev")
@Component("myBean")
public class NotDevDatasourceConfig {}
