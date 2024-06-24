package com.zettamine.materialinspection.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.zettamine.materialinspection.entities.Material;
import com.zettamine.materialinspection.entities.MaterialChars;
import com.zettamine.materialinspection.model.MaterialCharacteristics;
import com.zettamine.materialinspection.service.MaterialCharsService;




@RestController
@RequestMapping("/user")
public class MaterialCharController {
	
	private MaterialCharsService matCharsService;

	public MaterialCharController(MaterialCharsService matCharsService) {
		this.matCharsService = matCharsService;
	}

	
	@GetMapping("/add-material-chars/{matid}")
	public String addMaterialDetails(@PathVariable("matid") String matId, Model model) {
		Material m = new Material();
		m.setMaterialId(matId);
		MaterialChars materialChars = new MaterialChars();
		
		MaterialCharacteristics[] materialCharacteristics = MaterialCharacteristics.values();//added now
		
		
		
		materialChars.setMaterial(m);
		
		System.out.println(materialChars);
		
		model.addAttribute("matChars", materialChars);
		model.addAttribute("materialChars", materialCharacteristics);//added now
		model.addAttribute("matid", matId);
		return "add-material-chars";
	}
	
	@PostMapping("/save-material-chars")
	public String saveMaterialChars(MaterialChars matChars,Model model) {
		matCharsService.addMaterialChar(matChars);
		String uri = "/user/add-material-chars/"+matChars.getMaterial().getMaterialId();	
		return "redirect:"+uri;
	}
	
	@GetMapping("/update-material-chars/{materialId}/{charid}")
	public String updateMaterialDetails(@PathVariable("charid") Integer charId, @PathVariable("materialId") String matId , Model model) {
		MaterialChars matChars =  matCharsService.getByCharId(charId);
		model.addAttribute("matChars", matChars);
		model.addAttribute("matid", matId);
		return "add-material-chars";
	}
	
	@GetMapping("/delete-material-chars/{matid}/{charid}")
	public RedirectView deleteMaterialDetails(@PathVariable("charid") Integer charId,@PathVariable("matid") String matId) {
		matCharsService.removeMatChars(charId);
		return new RedirectView("/zettamine/user/show-material-chars/"+matId);
	}
}
