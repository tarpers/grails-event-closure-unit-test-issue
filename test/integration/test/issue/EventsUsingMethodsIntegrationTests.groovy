package test.issue

class EventsUsingMethodsIntegrationTests {

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
