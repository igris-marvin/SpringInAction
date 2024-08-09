package com.example.mongodb.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb.api.dto.EmployeeDTO;
import com.example.mongodb.persistence.entity.Employee;
import com.example.mongodb.persistence.entity.Location;
import com.example.mongodb.persistence.entity.Location.LocationName;
import com.example.mongodb.persistence.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository empRepo;

    public Boolean insertEmployee(EmployeeDTO emp_dto) {

        try {
            Employee emp = new Employee(
                emp_dto.getEname(), 
                emp_dto.getJob(), 
                Double.parseDouble(emp_dto.getSal()),
                resolveLocations(emp_dto.getLocs())
            );

            empRepo.save(emp);

            return true;

        } catch(NumberFormatException nfe) {
            System.err.println(nfe.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    private List<Location> resolveLocations(List<String> locs) {
        List<Location> loc_list = new ArrayList<>();

        LocationName[] ln = LocationName.values();

        for (LocationName x : ln) {

            for (String y: locs) {
                
                if(y.equalsIgnoreCase(x.loc_text)) {
                    loc_list.add(new Location(x));

                    System.err.println("Executed");

                    break;
                }
            }
        }

        return loc_list;
    }

    public List<String> fetchAllLocationsNames() {
        List<String> list = new ArrayList<>();

        LocationName[] li = LocationName.values();
        
        for (LocationName x : li) {
            
            list.add(x.loc_text);
        }

        return list;
    }
}
