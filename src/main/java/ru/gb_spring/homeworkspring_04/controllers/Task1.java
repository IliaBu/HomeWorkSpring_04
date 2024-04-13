package ru.gb_spring.homeworkspring_04.controllers;

/*1. Создание базового веб-приложения Spring MVC
    Начните с создания простого веб-приложения с использованием Spring MVC.
    Это может быть простой сайт, который выводит "Привет, мир!" на главной странице.
    Используйте аннотацию @Controller и @RequestMapping для маршрутизации запросов на эту страницу.
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Task1 {

    /** Функция перехода на страницу
     * @return страницу
     */
    @RequestMapping("/hello")
    public String hello() {
        return "helloWorld";
    }

}
