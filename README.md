Event handlers within a domain class that are written using closures do not appear to get called when unit testing but do behave as expected when integration testing and running the application.

For example, given the following domain class:

class EventsUsingClosures {

    String name
    Date dateSetOnInsert
    Date dateSetOnUpdate

    static constraints = {
        dateSetOnInsert nullable: true
        dateSetOnUpdate nullable: true
    }

    def beforeInsert = {
        dateSetOnInsert = new Date()
    }

    def beforeUpdate = {
        dateSetOnUpdate = new Date()
    }
}

The following unit tests fails:

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

When implementing the event handlers as methods the test succeeds.

Also, the tests succeed when running the tests as integration tests.

Attached is an app that implements the event handlers as both closures and methods and includes both unit and integration tests.