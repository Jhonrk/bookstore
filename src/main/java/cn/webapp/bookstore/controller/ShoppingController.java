package cn.webapp.bookstore.controller;

import cn.webapp.bookstore.model.CatalogModel;
import cn.webapp.bookstore.model.UserModel;
import cn.webapp.bookstore.service.CartService;
import cn.webapp.bookstore.service.CatalogService;
import cn.webapp.bookstore.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShoppingController {

    @Autowired
    private CatalogService catalogService;
    @Autowired
    private CartService cartService;

    /**
     * 获取购物车页面 显示当前用户的购物车信息
     */
    @GetMapping("/shopping")
    public String getShoppingPage(HttpServletRequest request, Model model) {
        UserModel user = (UserModel)request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("message", "未登录");
            return "/error";
        }
        List<CatalogModel> catalogModelList = catalogService.findAllCata();
        List<CartVo> cartVoList = cartService.findCartById(user.getUserId());
        if (cartVoList != null) {
            model.addAttribute("lists", cartVoList);
        }
        model.addAttribute("items", catalogModelList);
        return "/shopping";
    }

    /**
     *  购买成功后 返回购买成功的页面
     *  括弧 其实并没有买,就是看看 括弧结束
     */
    @RequestMapping("/shopResult")
    public String forwardToShopResult(Model model)
    {
        List<CatalogModel> catalogModelList = catalogService.findAllCata();
        model.addAttribute("lists",catalogModelList);
        return "shopResult";
    }
}
