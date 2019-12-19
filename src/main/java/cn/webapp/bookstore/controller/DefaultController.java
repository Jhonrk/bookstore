package cn.webapp.bookstore.controller;

import cn.webapp.bookstore.model.*;
import cn.webapp.bookstore.service.BookService;
import cn.webapp.bookstore.service.CartService;
import cn.webapp.bookstore.service.CatalogService;
import cn.webapp.bookstore.service.UserService;
import cn.webapp.bookstore.vo.BooksVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author china
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CatalogService catalogService;

//    Logger logger = Logger.getLogger(DefaultController.class);

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        int catalogId = new Random().nextInt(4)+1;
        this.outputModel(model, catalogId);
        return "/index";
    }

    public void outputModel(Model model, int id) {
        List<CatalogModel> list = catalogService.findAllCata();
        model.addAttribute("list",list);
        List<BooksVo> booksVosList = bookService.findAllBooksById(id);
        model.addAttribute("books",booksVosList);
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, Model model) {
        return "/login";
    }

    /**
     * 注册页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(HttpServletRequest request, Model model) {
        return "/register";
    }

    /**
     * 登出账号
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, Model model) {
        request.getSession().removeAttribute("user");
        return "/index";
    }

    /**
     * 添加书籍到购物车
     * (暂未实现)
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Object addCar(Model model, HttpServletRequest request, @RequestParam("bookId") int bookId){
        System.out.println(this.getClass());
        Map<String, Object> map = new HashMap<>();
        Message message = new Message();
        UserModel user = (UserModel)request.getSession().getAttribute("user");
        if(user == null){
            map.put("success", false);
            map.put("message", "未成功");
            model.addAttribute("message","请先登录");
            return map;
        }
        int userId = user.getUserId();
        OrderModel orderModel = new OrderModel();
        orderModel.setUserId(userId);
        orderModel.setOrderDate(new Date());
        OrderItemModel orderItemModel = new OrderItemModel();
        orderItemModel.setBookId(bookId);
        orderItemModel.setQuantity(new Random().nextInt(20)+1);
        int i = cartService.addOrder(orderModel,orderItemModel);
        if(i>0){
            map.put("success", true);
            map.put("message", "更新成功了");
            return map;
        }else{
            map.put("success", false);
            map.put("message", "未成功");
            return  map;
        }
    }

}
