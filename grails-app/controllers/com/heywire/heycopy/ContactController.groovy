package com.heywire.heycopy

class ContactController {
	static scaffold = Contact

	def notifyContacts() {
		def lastNotificationDateSetting = Setting.findBySkey("lastNotificationDate")
		Date lastDate

		if (lastNotificationDateSetting != null) {
			lastDate = lastNotificationDateSetting.lastUpdated
		} else {
			lastDate = new Date(session.getLastAccessedTime())
		}

		//def updatedHWStrings = HWString.findAll()
		def updatedHWStrings = HWString.findAllByLastUpdatedGreaterThanEquals(lastDate)

		if (updatedHWStrings != null && updatedHWStrings.size() > 0) {
			def addresses = new ArrayList<String>()
			Contact.findAll().each {
				addresses.add(it.email)
			}

			StringBuilder sb = new StringBuilder()
			updatedHWStrings.each {
				sb.append(it.label).append(':\t').append(it.copy).append('\n')
			}

			sendMail {
				to  addresses.toArray()
				from "COPY_BOT@YOUR_DOMAIN"
				subject "Copy has been updated"
				body sb.toString()
			}

			flash.message = 'Emailed Changes'

		} else {
			flash.message = 'No Changes'
		}

		//lastNotificationDateSetting = Setting.findOrSaveBySkeyAndSval("lastNotificationDate", String.valueOf(System.currentTimeMillis()))
		lastNotificationDateSetting = Setting.findOrCreateBySkey("lastNotificationDate")
		lastNotificationDateSetting.sval = String.valueOf(System.currentTimeMillis())
		//lastNotificationDateSetting.lastUpdated = lastDate
		lastNotificationDateSetting.save(flush: true)

		redirect(controller: "HWString")
	}
}
