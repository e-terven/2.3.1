package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.dao.CarDaoImpl;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/cars")
public class CarController {
	private CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}

//	@GetMapping(value = "/cars")
//	public String printWelcome(ModelMap model) {
//		List<String> messages = new ArrayList<>();
//		messages.add("Hello!");
//		return "cars";
//	}

	@GetMapping(value="cars")
	public String showListCar(Model model) {
		model.addAttribute("cars", carService.getListCarFull());
		return "cars";
	}
//	@GetMapping("/{count}")
//	public String showCountListCar(@PathVariable("count" defaultValue = "5") Integer count,
//								   Model model) {
//		model.addAttribute("cars", carDao.getListCar(count));
//	    return "cars";
//	}
	
}