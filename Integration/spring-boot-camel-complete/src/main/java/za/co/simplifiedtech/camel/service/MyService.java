package za.co.simplifiedtech.camel.service;

import za.co.simplifiedtech.camel.dto.request.UserDTO;

/**
 * a Mock class to show how some other layer
 * (a persistence layer, for instance)
 * could be used inside a Camel
 * 
 */
public class MyService {
    public static void example(UserDTO userDTO) {
        userDTO.setName( "Hello, " + userDTO.getName() );
        userDTO.setId(userDTO.getId() * 10);
    }
}
