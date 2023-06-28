package com.eqluineas.hello.models;

public class AddressDto {
	private String name;
	private String tel;
	private String address;
	private int age;
	
	public AddressDto() {
		super();
	}
	

	public AddressDto(String name, String tel, String address, int age) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.age = age;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "AddressDto [name=" + name + ", tel=" + tel + ", address=" + address + ", age=" + age + "]";
	}
	
	
}
