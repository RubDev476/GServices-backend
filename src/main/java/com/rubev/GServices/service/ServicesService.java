package com.rubev.GServices.service;

import com.rubev.GServices.dto.CreateServiceDTO;
import com.rubev.GServices.dto.ServiceDTO;
import com.rubev.GServices.model.User;
import com.rubev.GServices.repository.ServicesRepository;
import com.rubev.GServices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesService {
    private final ServicesRepository servicesRepository;
    private final UserRepository userRepository;

    public void createService(CreateServiceDTO service) {
        User user = userRepository.findById(service.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        com.rubev.GServices.model.Service newService = new com.rubev.GServices.model.Service();

        newService.setName(service.getName());
        newService.setLocation(service.getLocation());
        newService.setDescription(service.getDescription());
        newService.setCategories(service.getCategories());
        newService.setAvailability(service.getAvailability());
        newService.setUrlImage(service.getUrlImage());
        newService.setPrice(service.getPrice());
        newService.setCreatedBy(user);

        servicesRepository.save(newService);
    }

    public List<ServiceDTO> findAll() {
        return servicesRepository.findAll()
                .stream()
                .map(service -> new ServiceDTO(
                        service.getId(),
                        service.getUrlImage(),
                        service.getDescription(),
                        service.getPrice(),
                        service.getAvailability(),
                        service.getCategories(),
                        service.getLocation(),
                        service.getName()
                ))
                .toList();
    }

    public List<ServiceDTO> findByUserId(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        //with User object
        //return servicesRepository.findByCreatedBy(user);

        //only Service object
        return servicesRepository.findByCreatedBy(user)
                .stream()
                .map(service -> new ServiceDTO(
                        service.getId(),
                        service.getUrlImage(),
                        service.getDescription(),
                        service.getPrice(),
                        service.getAvailability(),
                        service.getCategories(),
                        service.getLocation(),
                        service.getName()
                ))
                .toList();
    }

    public boolean  updateService(Long id, CreateServiceDTO service) {
        return servicesRepository.findById(id)
                .map(currentService -> {
                    currentService.setName(service.getName());
                    currentService.setLocation(service.getLocation());
                    currentService.setDescription(service.getDescription());
                    currentService.setCategories(service.getCategories());
                    currentService.setAvailability(service.getAvailability());
                    currentService.setUrlImage(service.getUrlImage());
                    currentService.setPrice(service.getPrice());

                    servicesRepository.save(currentService);

                    return true;
                }).orElse(false);
    }

    public void deleteServiceById(Long id) {
        servicesRepository.deleteById(id);
    }
}
