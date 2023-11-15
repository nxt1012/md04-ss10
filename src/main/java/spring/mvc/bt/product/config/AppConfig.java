package spring.mvc.bt.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import spring.mvc.bt.product.model.dao.ProductDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "spring.mvc.bt.product")

public class AppConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver("/views/",".jsp");
    }
    @Bean
    public ProductDAOImpl productDAO() {
        return new ProductDAOImpl();
    }
}
