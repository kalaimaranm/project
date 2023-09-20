package model;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String houseNo;
    private String street;
    private String distric;
    private String state;
    private String pincode;

    @Override
    public String toString() {
        return "\nHouse No : "+houseNo+"\nStreet : "+street+"\nDistric : "+distric+"\nState : "+state+"\nPincode : "+ pincode;
    }
}
