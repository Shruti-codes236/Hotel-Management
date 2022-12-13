package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.extraclass.GetBooking;
import com.dbms.HotelManagement.jsonResponse.ServicesEmp;
import com.dbms.HotelManagement.model.Service;
import com.dbms.HotelManagement.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping("/admin/addService")
    public int addService(@RequestBody Service service){
        return serviceService.addService(service.getServiceName(), service.getPrice(), service.isAvailability(), service.getHeadedBy());

    }

    @PostMapping("/admin/deleteService")
    public int deleteService(@RequestBody String serviceName){
        return serviceService.deleteService(serviceName);
    }

    @GetMapping("/admin/service")
    public List<ServicesEmp> allServices(){
        return serviceService.getServices();
    }

    @GetMapping("/booking/services")
    public List<Service> serviceNames() {
        return serviceService.serviceNames();
    }
    @PostMapping("/admin/alterAvail")
    public List<ServicesEmp> changeAvail(@RequestBody ServicesEmp servicesEmp){
        servicesEmp.setAvailability(!servicesEmp.isAvailability());
        serviceService.updateService(servicesEmp.getServiceName(), servicesEmp.getPrice(), servicesEmp.isAvailability());
        return serviceService.getServices();
    }

    @PostMapping("/booked/services")
    public String getServices(@RequestBody GetBooking getBooking){
        System.out.println(getBooking.getBookingID());
        return serviceService.getBookingServices(getBooking.getBookingID());

    }
}
