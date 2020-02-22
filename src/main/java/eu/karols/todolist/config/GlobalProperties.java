package eu.karols.todolist.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix="global")
public class GlobalProperties {

    private Map<String, String> test;
}
