package com.model;

public class Customer {

private int customer_id;
private String name;
private int user_id;
public Customer(int customer_id, String name, int user_id) {
	super();
	this.customer_id = customer_id;
	this.name = name;
	this.user_id = user_id;
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
@Override
public String toString() {
	return "Customer [customer_id=" + customer_id + ", name=" + name + ", user_id=" + user_id + "]";
}


}


/*
 * 
 * -------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| customer_id | int(11)      | NO   | PRI | NULL    |       |
| name        | varchar(255) | NO   |     | NULL    |       |
| user_id     | int(11)      | NO   | MUL | NULL    |       |
+-------------+--------------+------+-----+---------+-------+*/
 