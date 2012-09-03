package test.issue

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

    String toString() { "${this.getClass().simpleName} [name: $name, created: $dateSetOnInsert, updated: $dateSetOnUpdate]" }
}
