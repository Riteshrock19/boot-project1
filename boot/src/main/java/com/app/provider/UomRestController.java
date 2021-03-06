package com.app.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
public class UomRestController {

	@Autowired
	private IUomService service;

	@PostMapping("/rest/saveUom")
	public String saveUom(@RequestBody Uom uom){
		long uomId = service.save(uom);
		return "Uom saved successfully : "+uomId;
	}

	@PostMapping("/rest/updateUom")
	public String updateUom(@RequestBody Uom uom){
		service.update(uom);
		return "Uom data is updated ";
	}

	@GetMapping("/rest/deleteUom/{uomId}")
	public String deleteUom(@PathVariable long uomId)
	{
		String message = null;
		try {
			service.deleteById(uomId);
		} catch (EmptyResultDataAccessException e) {
			message = "Record not Exist";
		}
		return message;
	}

	@GetMapping("/rest/getUom/{uomId}")
	public ResponseEntity<?> getUomById(@PathVariable long uomId){
		Uom uom = service.getOneById(uomId);
		if (uom!=null) {
			return ResponseEntity.ok(uom);
		} else {
			return ResponseEntity.ok("No Data Found");
		}
	}

	@GetMapping("/rest/getAllUoms")
	public ResponseEntity<?> getAll(){
		List<Uom> uomList = service.getAll();
		if (uomList!=null & uomList.size()>0) {
			return ResponseEntity.ok(uomList);
		} else {
			return ResponseEntity.ok("No Data Exist");
		}
	}
}
