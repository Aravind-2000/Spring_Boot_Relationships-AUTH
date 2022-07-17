package com.futura.test.Service;


import com.futura.test.Entity.Address;
import com.futura.test.Repository.AddressRepository;
import com.futura.test.error.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {


    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ErrorService errorService;


    public List<Address> getAllAddress(){
        return addressRepository.getAllValidAddress();
    }

    public Address getAddress(Long id){
        return addressRepository.findById(id).get();
    }

    public String addAddress(Address address){
        address.setActive(true);
        addressRepository.save(address);
        return errorService.getErrorById("ER001");
    }

    public  String updateAddress(Long id ,Address newOne){
        Address oldOne = addressRepository.getById(id);

        if(newOne.getEmployeeName() != null){
            oldOne.setEmployeeName(newOne.getEmployeeName());
        }

        if(newOne.getAddressLine() != null){
            oldOne.setAddressLine(newOne.getAddressLine());
        }

        addressRepository.save(oldOne);
        return errorService.getErrorById("ER003");
    }

    public String softDeleteAddress(Long id){
        Address oldOne = addressRepository.getById(id);
        oldOne.setActive(false);
        addressRepository.save(oldOne);
        return errorService.getErrorById("ER003");
    }

    public String hardDeleteAddress(Long id){
        addressRepository.deleteById(id);
        return errorService.getErrorById("ER003");
    }


}
