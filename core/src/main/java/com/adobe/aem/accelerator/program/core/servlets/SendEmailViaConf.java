package com.adobe.aem.accelerator.program.core.servlets;

import com.adobe.aem.accelerator.program.core.service.email.EmailServiceModel;
import com.adobe.aem.accelerator.program.core.service.email.impl.EmailService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "= TEst email service",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/apps/fixedemail"},immediate = true,enabled = true)
public class SendEmailViaConf extends SlingAllMethodsServlet {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Reference
    EmailService emailService;

    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        List<String> emailList = null;
        try {
            Map<String,String> map = new HashMap<>();
            map.put("message","Test Mail");
            emailList = emailService.sendEmail(map);
        }catch(Exception e){
            LOGGER.error("Exception {}",e.getMessage(),e);
        }
        response.getWriter().print(CollectionUtils.isEmpty(emailList)?"Email Sent":"Email Sending Failed");
    }
}
