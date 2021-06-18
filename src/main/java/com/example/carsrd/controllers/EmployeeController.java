package com.example.carsrd.controllers;

import com.example.carsrd.domain.Employee;
import com.example.carsrd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Get All Employees
    @GetMapping("employees")
    public String findAll(Model model){

        model.addAttribute("employees", employeeService.findAll());


        return "employee";
    }

    @RequestMapping("employees/findById")
    @ResponseBody
    public Employee findById(Integer id)
    {
        return employeeService.findById(id);
    }

    //Add Employee
    @PostMapping(value="employees/addNew")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value="employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.update(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value="employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }


    @RequestMapping(value="/employees/uploadPhoto", method= RequestMethod.POST, consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File newFile = new File("D:\\SOLUTIONS\\fleetms\\uploads" + file.getOriginalFilename());
        newFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(newFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    }


    @PostMapping("/employees/uploadPhoto2")
    public String uploadFile2(@RequestParam("file") MultipartFile file, Principal principal)
            throws IllegalStateException, IOException {
        String baseDirectory = "D:\\SOLUTIONS\\fleetms\\src\\main\\resources\\static\\img\\photos\\" ;
        file.transferTo(new File(baseDirectory + principal.getName() + ".jpg"));
        return "redirect:/employees";
    }


//    @RequestMapping(value="/employees/profile")
//    public String profile(Model model, Principal principal) {
//        String un = principal.getName();
//        model.addAttribute("employee", employeeService.findByUsername(un));
//        return "profile";
//    }

}
