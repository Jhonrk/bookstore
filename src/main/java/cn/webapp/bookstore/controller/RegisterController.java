package cn.webapp.bookstore.controller;

import cn.webapp.bookstore.model.UserModel;
import cn.webapp.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    /**
     * 注册用户方法
     * 如果输入的用户名已经存在 则不注册
     * @param userName 输入的用户名
     * @param password 输入的密码
     * @return 成功则返回登录页面
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, Model model,
                           @RequestParam(name = "userName") String userName,
                           @RequestParam(name = "password") String password) {

        UserModel userModel = userService.findByUser(userName);
        if (userModel != null) {
            model.addAttribute("message", "用户已存在");
            return "/login";
        }

        userModel = new UserModel();
        userModel.setUserName(userName);
        userModel.setPassword(password);

        int result = userService.addUser(userModel);
        if (result > 0) {
            model.addAttribute("message", "注册完毕,请登录");
            return "/login";
        } else {
            model.addAttribute("message", "注册失败");
            return "/register";
        }
    }
}
