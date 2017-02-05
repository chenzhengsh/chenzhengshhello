package com.hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.LogMapper;
import com.dao.StudentMapper;
import com.log.pojo.Log;
import com.model.StudentEntity;

@Controller
public class GreetingController {
	
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired  
    private LogMapper logMapper;  
      
    public void log(Log log) {  
        logMapper.insert(log);  
    }  

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/getStudentByID")
    public String getStudentByID(@RequestParam(value="id", required=false, defaultValue="World") String id, Model model) {
    	StudentEntity s = studentMapper.getStudent(id);
        model.addAttribute("name", s.getStudentName());
        return "greeting";
    }

}
