package com.williambertoldo.cadastro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williambertoldo.cadastro.entity.Address;
import com.williambertoldo.cadastro.repository.addressRepository;

@RestController
@RequestMapping(value="/api")
public class addressResource {

    @Autowired
    addressRepository addressRepository;
    

    @GetMapping("/address/{clientId}")
    public List<Address> getAddressByClientId(@PathVariable(value="clientId") long clientId){
        List<Address> address = addressRepository.findByClientId(clientId);
        return address;
    }
    
    @GetMapping("/address/getById/{id}")
    public Address getAddressById(@PathVariable(value="id") long id){
        return addressRepository.findById(id);
    }

    @PostMapping("/address")
    public Address saveAddress(@RequestBody Address address){
        return addressRepository.save(address);
    }

    @DeleteMapping("/address")
    public void deleteAddress(@RequestBody Address address){
        addressRepository.delete(address);
    }

    @PutMapping("/address")
    public Address updateAddress(@RequestBody Address address){
        return addressRepository.save(address);
    }

    @PutMapping("/address/setAsMain/{id}")
     public List<Address>  setAddressAsMain(@PathVariable(value="id") Long id){
        Address address = getAddressById(id);
        long idClient = address.getClientId();
        List<Address> allAddress = getAddressByClientId(idClient);
        for(int x = 0; x < allAddress.size(); x++){
            allAddress.get(x).setStreet(allAddress.get(x).getStreet());
            allAddress.get(x).setCity(allAddress.get(x).getCity());
            allAddress.get(x).setZipCode(allAddress.get(x).getZipCode());
            allAddress.get(x).setHouseNo(allAddress.get(x).getHouseNo());
            allAddress.get(x).setId(allAddress.get(x).getId());
            allAddress.get(x).setClientId(allAddress.get(x).getClientId());
            if(id.equals(allAddress.get(x).getId()) ){
                allAddress.get(x).setMainAddress(true);
                allAddress.get(x).setId(id);
            }else allAddress.get(x).setMainAddress(false);
            Address updatedAddress = allAddress.get(x);
            addressRepository.save(updatedAddress);
        }
        return allAddress;
    }


}
