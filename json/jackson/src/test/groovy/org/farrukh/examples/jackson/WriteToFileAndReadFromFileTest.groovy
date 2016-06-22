package org.farrukh.examples.jackson

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by Farrukhjon on 17-Sep-15.
 */
class WriteToFileAndReadFromFileTest extends BaseUnitTest {

    def 'exercise writing object to the file'() {
        given: 'a user as object'
        def user = new User(id: 1, login: 'user1', password: 'password1')

        and: 'subject under test'
        def mapper = new ObjectMapper()

        and: 'file for storing'
        def file = new File('resources/user.json')

        when: 'trying write to the file'
        mapper.writeValue(file, user)

        and: 'trying read from the file'
        def result = mapper.readValue(file, User)

        then: 'expected result is returned'
        result
        result.id == 1
        result.login == 'user1'
        result.password == 'password1'
    }
}
