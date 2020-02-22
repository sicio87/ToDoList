package eu.karols.todolist.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        GlobalProperties.class
})
public class TaskConfiguration {

}
