package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.ServiceUsed;
import com.dbms.HotelManagement.repository.BookingRepository;
import com.dbms.HotelManagement.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository, BookingRepository bookingRepository) {
        this.serviceRepository = serviceRepository;
        this.bookingRepository = bookingRepository;
    }

    public int addService(String serviceName, int price, boolean isAvail, UUID head){
        return serviceRepository.addService(serviceName, isAvail, price, head);
    }

    public int deleteService(String serviceName){
        return serviceRepository.deleteService(serviceName);
    }

    public void updateService(String serviceName, int price, boolean isAvailable){
        serviceRepository.updatePrice(serviceName, price);
        serviceRepository.updateAvailability(serviceName, isAvailable);
    }

    public List<com.dbms.HotelManagement.jsonResponse.ServicesEmp> getServices(){
        return serviceRepository.getAllService();
    }

    public List<com.dbms.HotelManagement.model.Service> serviceNames() {
        return serviceRepository.serviceNames();
    }
    public void addusedService(List<String> services, UUID customerID){
        for(int i = 0;i<services.size();i++){
            serviceRepository.addusedService(services.get(i), customerID);
        }
    }

    public String getBookingServices(UUID bookingID) {
        List<ServiceUsed> s = serviceRepository.getBookingServices(bookingID);
        String services = "";
        for(int i = 0;i<s.size();i++){
            services += s.get(i).getServiceName();
            services += ", ";
        }
        return services;
    }

    public int getPrice(UUID bookingID) {
        return serviceRepository.serviceCost(bookingID);
    }
}
