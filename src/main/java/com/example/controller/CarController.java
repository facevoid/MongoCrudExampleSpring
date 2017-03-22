package com.example.controller;

import com.example.domain.Car;
import com.example.repository.CarMongoRepository;
import com.example.repository.CarSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Shaurav on 3/17/2017.
 */
@Controller
public class CarController {

    @Autowired
    CarMongoRepository carRepository;

    @Autowired
    CarSearchRepository carSearchRepository;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("carList",carRepository.findAll());
        return "home2";
    }
    @RequestMapping("/home")
    public String home2(Model model){
        model.addAttribute("carList",carRepository.findAll());
        return "home2";
    }

    @RequestMapping(value = "/addCar",method = RequestMethod.POST)
    public String addCar(@ModelAttribute Car car){
        carRepository.save(car);
        return "redirect:home";
    }

    @RequestMapping(value = "/delete")
    public String delete (@RequestParam String id){
        carRepository.delete(id);
        return "redirect:home";
    }
    @RequestMapping(value = "/update")
    public String update(@ModelAttribute Car car){

        return "update";
    }
    @RequestMapping(value = "/updated")
    public String updated(@ModelAttribute Car car){

        carRepository.save(car);
        return "redirect:home";
    }



    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam String search) {
        model.addAttribute("carList", carSearchRepository.searchCars(search));
        model.addAttribute("search", search);
        return "home2";
    }

}
