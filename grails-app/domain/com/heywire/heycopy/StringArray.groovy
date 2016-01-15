package com.heywire.heycopy

class StringArray
{
    String name

    String toString() { name }

	static belongsTo = [ platform: Platform, product: Product ]

    static constraints = {
        name(blank: false)
        hwStrings(lazy: false)
    }

	static hasMany = [hwStrings: HWString]
}
