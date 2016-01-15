package com.heywire.heycopy

import grails.converters.JSON
import groovy.util.XmlParser
import groovy.xml.XmlUtil

class AdminController {
	def importExportService

	def index() {
	}

	def download() {
		def platformArgs = request.getParameterValues('platform')
		def productArgs = request.getParameterValues('product')
		def formatArg = request.getParameter('format')

		def platformClause = new StringBuilder(" and h.platform in (from Platform as pf where pf.name in (")
		platformArgs.each {
			platformClause.append("'").append(it).append("',")
		}
		platformClause.deleteCharAt(platformClause.size() - 1) // remove the extra comma
		platformClause.append("))")

		def results = new ArrayList<HWString>();
		def stringArrays = new ArrayList<StringArray>();

		for (String productArg : productArgs)
		{
			System.out.println("Looking up product:" + productArg)
			results.addAll(HWString.findAll("from HWString as h where h.product=(from Product as p where p.name=?)"
					+ platformClause + " order by h.groupBy asc, h.label asc", [productArg]))
			
			// remove strings that belong to arrays from the list
			stringArrays.addAll(StringArray.findAll("from StringArray as h where h.product=(from Product as p where p.name=?)"
					+ platformClause + " order by name", [productArg]))
		}

		stringArrays.each {
			it.hwStrings.each { results.remove(it) }
		}

		if (formatArg.equals("JSON"))
		{
			def stringMap = new HashMap<String, String>()
			results.each { hwString ->
				stringMap.put(hwString.label, hwString.copy)
			}
			render stringMap as JSON

		} else
		{
			render(contentType: "text/text") {
				resources('xmlns:xliff': 'urn:oasis:names:tc:xliff:document:1.2') {
					String groupBy = null
					results.each { hwString ->
						if (!groupBy.equals(hwString.groupBy))
						{
							groupBy = hwString.groupBy
							mkp.comment groupBy
						}
						//string(name: hwString.label, hwString.copy)
						string(name: hwString.label, { mkp.yieldUnescaped(hwString.copy) })
					}
					stringArrays.each { stringArray ->
						'string-array'(name: stringArray.name) {
							def strings = stringArray.hwStrings.sort { it.aOrder }
							strings.each { str ->
								item({ mkp.yieldUnescaped(str.copy) })
							}
						}
					}
				}
			}
		}
	}

	def upload() {
		def f = request.getFile('myFile')
		if (f.empty) {
			flash.message = 'file cannot be empty'
			render(view: 'uploadForm')
			return
		}

		importExportService.upload(request)
		redirect(controller: "HWString")
	}
}
