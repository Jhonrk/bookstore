package cn.webapp.bookstore.controller;

import cn.webapp.bookstore.model.CatalogModel;
import cn.webapp.bookstore.model.UserModel;
import cn.webapp.bookstore.service.BookService;
import cn.webapp.bookstore.service.CatalogService;
import cn.webapp.bookstore.vo.BooksVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private CatalogService catalogService;
    @Autowired
    private BookService bookService;

//    Logger logger = Logger.getLogger(IndexController.class);

    /**
     * 通过图书类别ID来查找图书
     * @param id 图书类别ID
     * @returｎ 成功就返回
     */
    @GetMapping("/list")
    public String getCatalogId(HttpServletRequest request, Model model, @RequestParam("catalogId") int id) {
        UserModel user = (UserModel)request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("message", "未登录");
            return "/error";
        }
        List<CatalogModel> list = catalogService.findAllCata();
        model.addAttribute("list",list);
        List<BooksVo> booksVosList = bookService.findAllBooksById(id);
        model.addAttribute("books",booksVosList);
        return "/index";
    }

    /**
     * 通过书名查询
     * @param bookName
     * @return
     */
    @PostMapping("/search")
    public String searchByBookName(HttpServletRequest request, Model model,
                                   @RequestParam("bookName") String bookName) {
        UserModel user = (UserModel)request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("message", "未登录");
            return "/error";
        }
        List<BooksVo> booksVoList = bookService.findAllBooksByName(bookName);
        List<CatalogModel> catalogModelList = catalogService.findAllCata();
        model.addAttribute("books", booksVoList);
        model.addAttribute("list", catalogModelList);
        return "/index";
    }
}
