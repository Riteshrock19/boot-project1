package com.app.controller.multipart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.controller.view.UomExcelView;
import com.app.model.Uom;
import com.app.service.IUomService;

@Controller
public class UomMultipartController {
     @Autowired
	private IUomService service;
     
     @GetMapping("/uomMultipart")
     public String showUomMultipartFile(){
    	 return "UomMultipart";
     }
     
     @GetMapping("/uomExport")
     public ModelAndView exportUom(){
    	 List<Uom> uoms = service.getAll();
    	 return new ModelAndView(new UomExcelView(), "uomList", uoms);
     }
}
