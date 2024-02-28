package com.wissentech.order;

import java.time.ZonedDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// @Entity
public class Order {
	@Id
	private String id;
	@NotEmpty(message = "name should not be empty")
	private String name;
	@Email(message = "it should be in email format")
	private String email;
//	@Min(value = 4)
//	@Max(value = 6,message = "should be in 4 to 6 letters")
	private int value;
//	private ZonedDateTime manu_date = ZonedDateTime.now();
	// private ZonedDateTime joining_date = ZonedDateTime.now();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

//	public ZonedDateTime getManu_date() {
//		return manu_date;
//	}
//
//	public void setManu_date(ZonedDateTime manu_date) {
//		this.manu_date = manu_date;
//	}

	/*
	 * public ZonedDateTime getJoining_date() { return joining_date; }
	 * 
	 * public void setJoining_date(ZonedDateTime joining_date) { this.joining_date =
	 * joining_date; }
	 */

}