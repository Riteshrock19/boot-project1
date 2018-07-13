package com.app.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.app.model.Uom;

@Component
public class UomUtil {
    
	public Map<String, String> getUomTypes(){
		Map<String, String> uomTypes = new LinkedHashMap<String, String>();
		uomTypes.put("PACK", "PACKING");
		uomTypes.put("NOPACK", "NO PACKING");
		uomTypes.put("NA", "-NA-");
		return uomTypes;
	}
	
	public List<Uom> replaceWitValues(List<Uom> uomList){
		Iterator<Uom> uomItr = uomList.iterator();
		while (uomItr.hasNext()) {
			Uom uom = (Uom) uomItr.next();
			uom.setUomType(getUomTypes().get(uom.getUomType()));
		}
		return uomList;
	}
}
