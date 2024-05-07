package ru.aplk.management;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.aplk.management.tables.departments.DepartmentService;
import ru.aplk.management.tables.education.EducationService;
import ru.aplk.management.tables.languages.LanguageService;
import ru.aplk.management.tables.positions.Position;
import ru.aplk.management.tables.positions.PositionService;
import ru.aplk.management.tables.user_audit.UserAuditService;
import ru.aplk.management.users.User;
import ru.aplk.management.users.UserRepo;
import ru.aplk.management.users.UserService;


@Controller
@RequiredArgsConstructor
public class WebController {

    private final DepartmentService departmentService;
    private final EducationService educationService;
    private final LanguageService languageService;
    private final PositionService positionService;
    private final UserAuditService userAuditService;
    private final UserService userService;


    @Autowired
    private UserRepo userRepo;

    @PostMapping("/auth/register")
    public String saveUser(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/auth/login"; // перенаправление на страницу успеха
    }

    @GetMapping("/auth/register")
    public String registerPage(@ModelAttribute("user") User user){
        return "auth/register";
    }



    @GetMapping("/auth/login")
    public String loginPage(@ModelAttribute("user") User user){
        //return "redirect:/shop";
        return "/auth/login";

    }

    @GetMapping("/tables")
    //public String booksPage(@ModelAttribute("user") User user){
    //    return "auth/shop";
    //}
    public String getAllData(Model model){
        model.addAttribute("departments", departmentService.findAllWeb());
        model.addAttribute("educations", educationService.findAllWeb());
        model.addAttribute("languages", languageService.findAllWeb());
        model.addAttribute("positions", positionService.findAllWeb());
        //model.addAttribute("user_audits", userAuditService.findAllWeb());

        return "auth/shop";
    }
/*
    @GetMapping("/user")
    //public String booksPage(@ModelAttribute("user") User user){
    //    return "auth/shop";
    //}
    public String getData(Model model){
        model.addAttribute("users", userService.findAllWeb());
        //model.addAttribute("user_audits", userAuditService.findAllWeb());

        return "auth/user";
    }
*/

}
