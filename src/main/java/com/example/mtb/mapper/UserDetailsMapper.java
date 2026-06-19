package com.example.mtb.mapper;



import com.example.mtb.dto.response.UserRegisterResponse;
import com.example.mtb.entity.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {


    public UserRegisterResponse userDetailsResponseMapper(UserDetails userDetails){
        if(userDetails == null)
            return null;
        return new UserRegisterResponse(
                userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getUserRoles()
        );
    }

}
