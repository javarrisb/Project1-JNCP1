package com.company.Summative1CristieJBNicholas.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")//PK
    private Integer invoice_id;
    @Column(name = "name")
    private String name;

    private String lastName;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name="item_id")
    private Integer item_id;
    @Column(name="item_type")
    private String item_type;
    @Column(name="unit_price")
    private double unit_price;
    @Column(name="quantity")
    private int quantity;
    @Column(name="processing_fee")
    private double processing_fee;
    @Column(name="tax")
    private double tax;
    @Column(name="total")
    private double total;


    public Invoice(){}
}
// invoice_id int not null auto_increment primary key,
//    name varchar(80) not null,
//    street varchar(30) not null,
//    city varchar(30) not null,
//    state char(2) not null,
//    zipcode varchar(5) not null,
//    item_type varchar(20) not null,
//    item_id int not null,
//    unit_price decimal(5,2) not null,
//    quantity int not null,
//    subtotal decimal(5,2) not null,
//    tax decimal(5,2) not null,
//    processing_fee decimal (5,2) not null,
//    total decimal(5,2) not null
//
//Create
//   Read
//  Read All
//  By Customer Name

