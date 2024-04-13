package ru.gb_spring.homeworkspring_04.repositories;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

/*  Задание со звездочкой:
    Использовать configuration-processor для работы с настройками приложения:
    - a) Создать объект инкапсулирующий шаблоны запросов к базе данных H2
    - b) Использовать аннотации **@ConfigurationProperties** и **@ConfigurationPropertiesScan** для заполнения полей этого класса
    - с) Вынести все SQL шаблоны в настройки приложения.
*/


/**
 * Шаблон SQL запросов
 */
@Configuration
@ConfigurationProperties(prefix = "sqlrequest")
@ConfigurationPropertiesScan
@Setter
@Getter
public class SqlRequest {
    private String findAll;
    private String save;
    private String delete;
    private String getById;
    private String update;
    private String count;
}
