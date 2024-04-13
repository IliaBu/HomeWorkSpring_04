package ru.gb_spring.homeworkspring_04.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb_spring.homeworkspring_04.model.User;
import ru.gb_spring.homeworkspring_04.service.UserService;

import java.util.List;

/* 2. Добавление Thymeleaf в проект.
        Добавьте Thymeleaf в свое веб-приложение Spring MVC.
        Создайте простую страницу с некоторыми переменными, которые заполняются с помощью модели Spring MVC и отображаются на странице с использованием Thymeleaf.

   3. Создание формы ввода и обработка данных формы.
        Создайте страницу с формой ввода, используя Thymeleaf для рендеринга формы.
        Затем создайте контроллер Spring MVC, который обрабатывает отправку формы и выводит полученные данные.
        Это может быть форма для регистрации или любая другая форма, которая собирает информацию от пользователя.
        **(Не обязательно)** Добавить в HTML в тег <style> простой css код. Например изменить цвет заголовков, стиль таблицы или обернуть форму в рамочку
*/

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /** Перенаправление с корня сайта на главную страницу "/" на "/html"
     * @return страницу
     */
    @GetMapping("/")
    public String homepage() {
        return "redirect:/home.html";
    }

    /** Страница вывода списка пользователей
     * @param model модель
     * @return список пользователей
     */
    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    /** Страница с вводом данных нового пользователя
     * @param user пользователь
     * @return страницу
     */
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    /** Сохранение нового пользователя
     * @param user пользователь
     * @return страницу со списком пользователей
     */
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    /** Удаление пользователя по id
     * @param id идентификатор пользователя
     * @return страницу со списком пользователей
     */
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    /** Редактирование пользователя по id
     * @param model модель
     * @param id идентификатор пользователя
     * @return страницу изменения пользователя
     */
    @GetMapping("/user-update/{id}")
    public String editUserForm(Model model, @PathVariable int id) {
        User user = userService.getUserByID(id);
        if (user == null) return "redirect:/users";
        System.out.println(user);
        model.addAttribute("user", user);
        return "user-update";
    }

    /** Изменение пользователя по id
     * @param user пользователь
     * @return страницу со списком пользователей
     */
    @PostMapping("/user-update/{id}")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
