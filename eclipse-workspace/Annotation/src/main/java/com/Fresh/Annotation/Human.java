package com.Fresh.Annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Human {

	private Organs organs;
	private Blood blod;

	Human() {

	}

//	@Autowired
	Human(Organs orgs) {
		this.organs = orgs;
	}

	public String alive(String name) {
		if (!(organs == null)) {
			return organs.heart() + "\n" + name + " is alive";
		}
		return name + " died";
	}

	public String blood(String name) {
		if (!(blod == null)) {
			return name + " is " + blod.groupOfBlood();
		}
		return "Blood group not tested";
	}

	public Blood getBlod() {
		return blod;
	}

	public void setBlod(Blood blood) {
		this.blod = blood;
	}

	public Organs getOrgans() {
		return organs;
	}

	@Autowired
	public void setOrgans(Organs organs) {
		this.organs = organs;
	}
}
