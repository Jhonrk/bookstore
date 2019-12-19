package cn.webapp.bookstore.controller;

import cn.webapp.bookstore.model.CatalogModel;
import cn.webapp.bookstore.model.UserModel;
import cn.webapp.bookstore.service.BookService;
import cn.webapp.bookstore.service.CartService;
import cn.webapp.bookstore.service.CatalogService;
import cn.webapp.bookstore.service.UserService;
import cn.webapp.bookstore.vo.BooksVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

/**
 * @author china
 */
@Controller
public class LoginController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CatalogService catalogService;

    /**
     * 通过输入用户名和密码登录
     * @param userName 输入的用户名
     * @param password 输入的密码
     * @return 成功则返回首页
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginMethod(HttpServletRequest request, Model model,
                              @RequestParam(name = "userName") String userName,
                              @RequestParam(name = "password") String password) {
        System.out.println("userName = " + userName);
        System.out.println("password = " + password);
        UserModel user = userService.findByUser(userName);
        if (user == null) {
            //return "failed";
            model.addAttribute("message", "用户名不存在,请注册");
            return "/error";
        } else {
            model.addAttribute("user", user);
            request.getSession().setAttribute("user", user);
            int catalogId = new Random().nextInt(4)+1;
            List<CatalogModel> list = catalogService.findAllCata();
            model.addAttribute("list",list);
            List<BooksVo> booksVosList = bookService.findAllBooksById(catalogId);
            model.addAttribute("books",booksVosList);
            return "/index";
        }
    }
}
