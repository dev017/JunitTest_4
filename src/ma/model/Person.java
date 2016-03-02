package ma.model;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Person {

	private int id;

	private String name;

	private String code;

	private String city;

	private int age;

	// CONST

	public Person() {
	}

	// JUST METHOD

	public String getCodeById(int id) {
		return new BigInteger(130, new SecureRandom()).toString(32);
	}

	public int getAgeById(int id) {
		if (id == 1)
			return 24;
		else
			return 30;
	}

	public int savePerson(Person p) {
		if (0 == p.getId() || null == p.getName())
			return 0; // NOT SAVED
		else
			return 1; // SAVED
	}

	public int updatePerson(Person person) {
		if (person.getId() == 0)
			return 0; // NOT UPDATED
		else
			return 1; // UPDATED
	}

	public int deletePerson(int id) {
		if (id == 0)
			return 0; // NOT DELETED
		else
			return 1; // DELETED
	}

	// GETTERS AND SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
