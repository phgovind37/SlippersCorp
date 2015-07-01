package com.techconquerors.slippers.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.techconquerors.slippers.jpa.User;
import com.techconquerors.slippers.service.interfaces.UserService;

@Controller
public class ReportController {

	 
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
 
    @Autowired
    private UserService userService;
 
    @RequestMapping(method = RequestMethod.GET , value = "/service/report/pdf")
    public ModelAndView generatePdfReport(ModelAndView modelAndView){
 
        logger.debug("--------------generate PDF report----------");
 
        Map<String,Object> parameterMap = new HashMap<String,Object>();
 
        List<User> usersList =userService.getAllUsers();
 
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
 
        parameterMap.put("datasource", JRdataSource);
 
        //pdfReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("pdfReport", parameterMap);
 
        return modelAndView;
 
    }//generatePdfReport
    
    @RequestMapping(method = RequestMethod.GET , value = "/service/report/xls")
    public ModelAndView generateXlsReport(ModelAndView modelAndView){
 
        logger.debug("--------------generate PDF report----------");
 
        Map<String,Object> parameterMap = new HashMap<String,Object>();
 
        List<User> usersList =userService.getAllUsers();
 
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
 
        parameterMap.put("dataSource", JRdataSource);
 
        //pdfReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("xlsReport", parameterMap);
 
        return modelAndView;
 
    }//generatePdfReport
    
    @RequestMapping(method = RequestMethod.GET , value = "/service/report/html")
    public ModelAndView generateHtmlReport(ModelAndView modelAndView){
 
        logger.debug("--------------generate PDF report----------");
 
        Map<String,Object> parameterMap = new HashMap<String,Object>();
 
        List<User> usersList =userService.getAllUsers();
 
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
 
        parameterMap.put("dataSource", JRdataSource);
 
        //pdfReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("htmlReport", parameterMap);
 
        return modelAndView;
 
    }//generatePdfReport
    
    @RequestMapping(method = RequestMethod.GET , value = "/service/report/csv")
    public ModelAndView generatecsvReport(ModelAndView modelAndView){
 
        logger.debug("--------------generate PDF report----------");
 
        Map<String,Object> parameterMap = new HashMap<String,Object>();
 
        List<User> usersList =userService.getAllUsers();
 
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
 
        parameterMap.put("dataSource", JRdataSource);
 
        //pdfReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("csvReport", parameterMap);
 
        return modelAndView;
 
    }//generatePdfReport
 
 
}
