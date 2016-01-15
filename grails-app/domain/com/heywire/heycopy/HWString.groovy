package com.heywire.heycopy

class HWString {
	int aOrder
	String comments
	String copy
	String description
	Date dateCreated
	String groupBy
	String label
	Date lastUpdated
	private String emailBody

	def notificationService

	String toString() {
		label + ": " + copy
	}

	static belongsTo = [
		stringArray: StringArray,
		platform: Platform,
		product: Product
	]

	static constraints = {
		label(blank: false, unique: ['product', 'platform'])
		copy(blank: false, size: 0..512)
		description(nullable: true, size: 0..512)
		groupBy(nullable: true)
		platform()
		product()
		lastUpdated(format: "yyyy-MM-dd")
		dateCreated(format: "yyyy-MM-dd")
		comments(nullable: true, size: 0..512)
		stringArray(nullable: true)
		aOrder()
	}

	static mapping = {
		autoTimestamp true
		aOrder defaultValue: 0
		sort label: "asc"
	}

	public HWString(HWString hwString) {
		comments = hwString.comments
		copy = hwString.comments
		description = hwString.comments
		dateCreated = hwString.dateCreated
		groupBy = hwString.groupBy
		label = hwString.label
		lastUpdated = hwString.lastUpdated
	}

	def afterInsert() {
		emailBody = "NEW string:\n" + toString()
		afterUpdate()
	}
	
	def afterUpdate() {
		if (!emailBody.isEmpty()) {
			System.out.println(emailBody)
			notificationService.notifyContacts(emailBody)
			
		} else {
			emailBody = null;
		}
	}
	
	def beforeUpdate() {
		if (isDirty()) {
			emailBody = 'UPDATED ' + label + ':\n'
			
			if (dirtyPropertyNames.contains('label')) {
				def originalValue = getPersistentValue('label')
				emailBody += 'new label: ' + label + '\n'
			}

			if (dirtyPropertyNames.contains('copy')) {
				def originalValue = getPersistentValue('copy')
				emailBody += 'old copy:\t' + originalValue + '\nnew copy:\t' + copy
			}
		}
	}
}
