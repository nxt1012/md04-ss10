package spring.mvc.bt.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.mvc.bt.product.model.dao.ProductDAOImpl;
import spring.mvc.bt.product.model.entity.Product;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductDAOImpl productDAO;

    @RequestMapping("")
    public String index(Model model) {
        List<Product> productList = productDAO.getAll();
        model.addAttribute("productList", productList);
        return "product";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-add";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") int productId, Model model) {
        Product product = productDAO.getById(productId);
        model.addAttribute("product", product);
        return "product-edit";
    }

    @RequestMapping("/edit/result")
    public String result(@ModelAttribute("product") Product product) {
        productDAO.update(product, product.getId());
        return "redirect:/product";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int productId) {
        productDAO.delete(productId);
        return "redirect:/product";
    }

}
