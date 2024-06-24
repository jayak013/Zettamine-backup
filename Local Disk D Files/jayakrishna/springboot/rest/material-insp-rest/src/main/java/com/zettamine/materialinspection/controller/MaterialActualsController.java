package com.zettamine.materialinspection.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.materialinspection.entities.MaterialActuals;
import com.zettamine.materialinspection.entities.MaterialChars;
import com.zettamine.materialinspection.entities.MaterialInspLot;
import com.zettamine.materialinspection.entities.User;
import com.zettamine.materialinspection.service.MaterialActualsService;
import com.zettamine.materialinspection.service.MaterialCharsService;
import com.zettamine.materialinspection.service.MaterialInspLotService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class MaterialActualsController {
	
	private MaterialActualsService matActualsService;
	
	private MaterialInspLotService matInspServiceLot;
	
	private MaterialCharsService matCharsService;


	public MaterialActualsController(MaterialActualsService matActualsService, MaterialInspLotService matInspServiceLot,
			MaterialCharsService matCharsService) {
		this.matActualsService = matActualsService;
		this.matInspServiceLot = matInspServiceLot;
		this.matCharsService = matCharsService;
	}

	@GetMapping("/add-material-actuals/{lotId}")
	public String addMaterialActuals(@PathVariable Integer lotId ,Model model,HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		MaterialActuals materialActuals = new MaterialActuals();
		MaterialInspLot matInspLot = matInspServiceLot.getByLotId(lotId);
		
		List<MaterialChars> matChars = matInspServiceLot.getMatCharsForActuals(lotId);
		
		materialActuals.setMatInsplot(matInspLot);		
		
		if(matChars.size()==0) {
			return "redirect:/user/save-material-insp-lot/"+matInspLot.getLotId();
		}
		
		model.addAttribute("matActuals", materialActuals);
		model.addAttribute("matCharsForActuals", matChars);
		
		return "add-actuals";
	}
	
	@PostMapping("/save-material-actuals")
	public String saveMaterialActuals(@RequestParam("charId") Integer charId ,
			@RequestParam("lotId") Integer lotId,@RequestParam("minMes") Double minMes, @RequestParam("maxMes") Double maxMes
			,Model model) {
		MaterialInspLot inspLot = matInspServiceLot.getByLotId(lotId);
		MaterialChars matChars = matCharsService.getByCharId(charId);
		MaterialActuals materialActuals = new MaterialActuals();
		materialActuals.setMatInsplot(inspLot);
		materialActuals.setMatChars(matChars);
		materialActuals.setMinMes(minMes);
		materialActuals.setMaxMes(maxMes);
		
		matActualsService.addMaterialActuals(materialActuals);
		
		return "redirect:/user/add-material-actuals/"+lotId;
	}
	
	
}
