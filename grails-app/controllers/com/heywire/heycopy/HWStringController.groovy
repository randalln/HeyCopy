package com.heywire.heycopy

class HWStringController
{
    static scaffold = HWString

    def index(Integer max) {
        params.max = Math.min(max ?: 50, 2000)
        
        if (params.sort == null || params.sort.equals('label')) {
            respond HWString.list(params), model:[HWStringInstanceCount: HWString.count()]

        } else
        {
            def c = HWString.withCriteria {
                and {
                    order(params.sort, params.order)
                    order('label', 'asc')
                }
                maxResults(params.max.toInteger())
                if (params.offset != null) {
                    firstResult(params.offset.toInteger())
                }
            }
            
            respond c, model:[HWStringInstanceCount: HWString.count()]
        }
    }
}
