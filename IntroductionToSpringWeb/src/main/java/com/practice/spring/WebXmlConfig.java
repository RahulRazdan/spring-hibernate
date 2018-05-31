package com.practice.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
 
public class WebXmlConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ConfigClass.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
 
 }
/*public class WebXmlConfig implements WebApplicationInitializer {
 
    @Override
    public void onStartup(ServletContext container) { 
        // Create the 'root' Spring application context
        //AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        
        // Manage the lifecycle of the root application context 
        container.addListener(new ContextLoaderListener(new AnnotationConfigWebApplicationContext()));
 
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(ConfigClass.class);
             
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setMultipartConfig(new MultipartConfigElement("C:/temp"));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
         
    }
 
 }*/
