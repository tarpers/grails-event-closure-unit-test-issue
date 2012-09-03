package test.issue

class EventsUsingClosuresIntegrationTests {
    void testDateSetOnInsert() {
        def testObj = new EventsUsingClosures(name: 'New').save(flush: true)

        assert testObj.dateSetOnInsert != null
    }

    void testDateSetOnUpdate() {
        def testObj = new EventsUsingMethods(name: 'New').save(flush: true)

        testObj.name = 'Updated'
        testObj.save(flush: true)

        assert testObj.dateSetOnUpdate != null
    }
}
