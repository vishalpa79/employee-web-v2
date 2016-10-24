package com.evoke.researchlabs.row.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evoke.researchlabs.row.domain.Employee;
import com.evoke.researchlabs.row.repositories.RestServiceCall;

@Controller
public class EmployeeController {

	@Autowired(required = true)
	RestServiceCall restfulClient;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("employees", restfulClient.listAllUsers());
		return "employees";
	}

	@RequestMapping(value = "/employee/view", method = RequestMethod.GET)
	public String showProduct(@ModelAttribute("emp") Employee empolyeeBean, Model model) {
		model.addAttribute("emp", empolyeeBean);
		return "employeeshow";
	}

	@RequestMapping("product/edit")
	public String edit(Model model, Employee employeeBean) {
		model.addAttribute("employee", restfulClient.postEntity(employeeBean));
		return "employeeform";
	}

	@RequestMapping("employee/new")
	public String newProduct(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeform";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveEmployee(Employee employeeBean, Model model) {
		Employee emp = restfulClient.postEntity(employeeBean);
		System.out.println("emp username"+emp.getEmailId());
		model.addAttribute("emp", emp);
		return "employeeshow";

	}

}
