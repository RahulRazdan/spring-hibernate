package com.practice.spring;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.practice.spring.api.MagicExistsCondition;
import com.practice.spring.api.Player;
import com.practice.spring.model.CDPlayer;
import com.practice.spring.model.MagicBean;

@ComponentScan
@Configuration
@EnableWebMvc
@ImportResource("classpath:XmlConfig.xml")
@EnableTransactionManagement
@EnableAspectJAutoProxy
@Import({WebSecurityConfig.class})
public class ConfigClass implements WebMvcConfigurer{

	 @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
  
    /*
     * To Run Profiling put -Dspring.profiles.active="Prod" at 
     * System level or environment level.
     */
    @Bean
    @Profile("Prod")
    public DataSource jndiDataSource(){
    	JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
    	bean.setJndiName("dataSource");
    	bean.setProxyInterface(DataSource.class);
    	bean.setResourceRef(true);
    	return (DataSource) bean.getObject();
    }
    
    @Bean
    @Profile("Dev")
    public DataSource embeddedDataSource(){
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jpa");
    	dataSource.setUsername( "tutorialuser" );
    	dataSource.setPassword( "tutorialmy5ql" );
    	return (DataSource) dataSource;
    }
    
   /* @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(emf);
  
       return transactionManager;
    }*/
  
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
       return new PersistenceExceptionTranslationPostProcessor();
    }
    
    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean getMagicBean(){
    	return new MagicBean();
    }
    
   @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }
    
    @Bean
    public ViewResolver viewResolver(){
    	ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    	viewResolver.setTemplateEngine(templateEngine());
    	return viewResolver;
    }
    
    @Bean 
    public TemplateEngine templateEngine(){
    	SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    	templateEngine.setTemplateResolver(templateResolver());
    	return templateEngine;
    }
    
    @Bean
    public ITemplateResolver templateResolver(){
    	SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    	templateResolver.setPrefix("/WEB-INF/templates/");
    	templateResolver.setSuffix(".html");
    	templateResolver.setTemplateMode("HTML5");
    	return templateResolver;
    }
    
    @Bean
    public Player createPlayerBean(){
    	return new CDPlayer();
    }
    
    @Bean
    public MultipartResolver multipartResolver(){
    	return new StandardServletMultipartResolver();
    }
}
