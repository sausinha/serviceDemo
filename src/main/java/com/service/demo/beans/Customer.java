/**
 * 
 */
package com.service.demo.beans;

/**
 * @author
 *
 */
public class Customer extends BaseBean {
	private static final long serialVersionUID = -3163463667976867333L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	private String location;

	@Override
	public String toString() {
		return "Customer [name=" + name + ", Location = " + location + "]";
	}

}
