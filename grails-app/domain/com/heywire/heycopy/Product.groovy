package com.heywire.heycopy

class Product implements Comparable
{
    String name
	
	public int compareTo(object) {
        return name.compareTo(((Product) object).name)
    }

	String toString() { name }
		
    static constraints = {
        name(blank: false, unique: true)
    }

	static hasMany = [hwStrings: HWString, stringArrays: StringArray]
}
