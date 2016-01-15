package com.heywire.heycopy

import grails.transaction.Transactional
import javax.servlet.http.HttpServletRequest

@Transactional
class ImportExportService
{
    def upload(HttpServletRequest request)
    {
        def platform = Platform.find(new Platform(name: 'All'))
        if (request.getParameter('platform') != null)
        {
            platform = Platform.find(new Platform(name: request.getParameter('platform')))
        }

        def product = Product.find(new Product(name: 'All'))
        if (request.getParameter('product') != null)
        {
            product = Product.find(new Product(name: request.getParameter('product')))
        }

        if (platform != null && product != null)
        {
            def f = request.getFile('myFile')
            def records = new XmlParser().parse(f.getInputStream())

            records.children().each
            {
                switch (it.name())
                {
                case "string":
                    boolean manual = false
                    if (it.breadthFirst().size() > 2)
                    {
                        log.error(it.toString())
                        manual = true
                    }
                    String copy = manual || it.text().length() == 0 ? 'ENTER MANUALLY' : it.text()

                    def newString = new HWString(label: it.@name, copy: copy)
					platform.addToHwStrings(newString)
					product.addToHwStrings(newString).save()
					if (!newString.validate()) {
						newString.errors.each {
							log.error(it)
						}
					}
					break
                case "string-array":
                    def arrayName = it.@name
                    def stringArray = new StringArray(name: arrayName)
					platform.addToStringArrays(stringArray)
					product.addToStringArrays(stringArray).save()

                    def i = 0
                    it.children().each
                    {
                        boolean manual = false
                        if (it.breadthFirst().size() > 2)
                        {
                            log.error(it.toString())
                            manual = true
                        }
                        String copy = it.text().length() == 0 ? 'ENTER MANUALLY' : it.text()

                        def newString = new HWString(aOrder: i, label: arrayName + "_" + i++, copy: copy)
						platform.addToHwStrings(newString)
						product.addToHwStrings(newString)
						stringArray.addToHwStrings(newString).save(flush:true)
                    }
                }
            }
        
            return true
        }
    }
}
