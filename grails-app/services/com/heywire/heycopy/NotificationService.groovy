package com.heywire.heycopy

import grails.transaction.Transactional
import grails.util.Environment

@Transactional
class NotificationService {
	def mailService

	def notifyContacts(String theBody) {
		if (!Environment.current.getName().equals("development")) {
			def addresses = new ArrayList<String>()
			Contact.findAll().each {
				addresses.add(it.email)
			}

			mailService.sendMail {
				to  addresses.toArray()
				from "xerxes@mediafriendsinc.com"
				subject "HeyWire copy has been updated"
				body theBody
			}
		}
	}
}
