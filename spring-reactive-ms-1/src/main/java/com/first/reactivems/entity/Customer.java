package com.first.reactivems.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author rgrover
 *
 */

@Data
@Document(collection="customer")
public class Customer {

    @Id
    private Integer customerId;
    private String name;
    private String mobile;
    private String address;
}
