package com.example.mongodb.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String loc_id;
    private LocationName lname;

    public Location(LocationName lname) {
        this.lname = lname;
    }
    
    public enum LocationName {
        GUATENG("Gauteng Province"), 
        LIMPOPO("Limpopo Province"), 
        CAPE_TOWN("Cape Town Province");

        public final String loc_text;

        LocationName(String p_loc_name) {
            loc_text = p_loc_name;
        }
    }
}
