package test.issue



import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(EventsUsingClosures)
class EventsUsingClosuresTests {

    void testDateSetOnInsert() {
        def testObj = new EventsUsingClosures(name: 'New').save(flush: true)

        assert testObj.dateSetOnInsert != null
    }

    void testDateSetOnUpdate() {
        def testObj = new EventsUsingClosures(name: 'New').save(flush: true)

        testObj.name = 'Updated'
        testObj.save(flush: true)

        assert testObj.dateSetOnUpdate != null
    }
}
