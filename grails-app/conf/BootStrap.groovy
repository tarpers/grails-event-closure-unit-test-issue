import test.issue.EventsUsingClosures
import test.issue.EventsUsingMethods

class BootStrap {

    def init = { servletContext ->
        def closureObj = new EventsUsingClosures(name: 'Closure Object').save(flush: true)
        def methodObj = new EventsUsingMethods(name: 'Method Object').save(flush: true)

        closureObj.name = 'Events using closures'
        closureObj.save(flush: true)

        methodObj.name = 'Events using methods'
        methodObj.save(flush: true)
    }

    def destroy = {
    }
}
