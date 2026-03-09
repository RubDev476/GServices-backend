package com.rubev.GServices.controller;

import com.rubev.GServices.dto.CreateServiceDTO;
import com.rubev.GServices.dto.ServiceDTO;
import com.rubev.GServices.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/services")
public class ServiceController {
    private final ServicesService servicesService;

    @PostMapping
    public ResponseEntity<String> createService(@RequestBody CreateServiceDTO service) {
        servicesService.createService(service);

        return ResponseEntity.ok("Service created successfully");
    }

    @GetMapping
    public ResponseEntity<List<ServiceDTO>> getAllServices() {
        return new ResponseEntity<>(servicesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<ServiceDTO>> getServicesByUserId(@PathVariable long userId) {
        return ResponseEntity.ok(servicesService.findByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody CreateServiceDTO service) {
        boolean updated = servicesService.updateService(id, service);

        if(updated) return ResponseEntity.ok("Service updated successfully");

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        servicesService.deleteServiceById(id);

        return ResponseEntity.ok("Service deleted successfully");
    }
}
