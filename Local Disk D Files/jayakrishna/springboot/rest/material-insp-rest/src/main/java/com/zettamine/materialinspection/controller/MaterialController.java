package com.zettamine.materialinspection.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.zettamine.materialinspection.entities.Material;
import com.zettamine.materialinspection.service.MaterialService;

@RestController
@RequestMapping("/user")
public class MaterialController {
	
	private MaterialService matService;

	public MaterialController(MaterialService matService) {
		this.matService = matService;
	}
	
	@GetMapping("/add-material")
	public String addMaterial(Model model) {
		model.addAttribute("material", new Material());
		return "add-material-page";
	}
	
	@PostMapping("/save-material")
	public String saveMaterial(Material material, Model model) {
		
		if(matService.getMaterialById(material.getMaterialId()) !=null) {
			model.addAttribute("message", "Material is updated successfully");
		}else {
			model.addAttribute("message", "Material is added successfully");
		}
		
		matService.addMaterial(material);

			return "add-material-page";

	}
	
	@GetMapping("/show-materials")
	public String showAllMaterials(Model model) {
		List<Material> listOfMaterials = matService.getAllMaterials();
		model.addAttribute("materials", listOfMaterials);
		return "view-materials";
	}
	
	
	@GetMapping("/delete-material/{id}")
	public RedirectView deleteMaterial(@PathVariable("id") String id, Model model) {
		matService.removeMaterial(id);
		return new RedirectView("/zettamine/user/show-materials");
	}
	
	@GetMapping("/update-material/{id}")
	public String materialUpdate(@PathVariable("id") String id,Model model) {
		Material material = matService.getMaterialById(id);
		model.addAttribute("material", material);
		return "add-material-page";
	}
	
	@GetMapping("/show-material-chars/{matid}")
	public String showAllMaterialChars(@PathVariable("matid") String matId,Model model) {
		Material material = matService.getMaterialById(matId);
		model.addAttribute("material", material);
		return "view-material-chars";
	}

}
