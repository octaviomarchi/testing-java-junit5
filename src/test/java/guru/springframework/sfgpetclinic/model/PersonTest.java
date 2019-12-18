package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.ModelTests;

class PersonTest implements ModelTests {

	@Test
	void grouedAssertions() {
		// given
		Person person = new Person(1l, "Joe", "Buck");
		// then
		assertAll("Test Props Set", 
				() -> assertEquals(person.getFirstName(), "Joe"),
				() -> assertEquals(person.getLastName(), "Buck"));
	}
	
	@RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    @Test
    void myRepeatedTest() {
        //todo - impl
    }

}
