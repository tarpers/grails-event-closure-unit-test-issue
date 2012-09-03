package test.issue



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(EventsUsingMethods)
class EventsUsingMethodsTests {

    void testDateSetOnInsert() {
        def testObj = new EventsUsingMethods(name: 'New').save(flush: true)

        assert testObj.dateSetOnInsert != null
    }

    void testDateSetOnUpdate() {
        def testObj = new EventsUsingMethods(name: 'New').save(flush: true)

        testObj.name = 'Updated'
        testObj.save(flush: true)

        assert testObj.dateSetOnUpdate != null
    }
}
