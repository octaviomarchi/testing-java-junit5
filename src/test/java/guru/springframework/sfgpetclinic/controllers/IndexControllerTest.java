package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class IndexControllerTest {

	IndexController controller;

	@BeforeEach
	void setUp() {
		controller = new IndexController();
	}

	@DisplayName("Test Proper View name is returned for index page")
	@Test
	void index() {
		assertEquals("index", controller.index());
		assertEquals("index", controller.index(), "Wrong View Returned");

		assertEquals("index", controller.index(), () -> "Another Expensive Message " + "Make me only if you have to");
	}

	@Test
	@DisplayName("Test exception")
	void oopsHandler() {
		assertThrows(ValueNotFoundException.class, () -> {
			controller.oopsHandler();
		});
	}

	@Disabled("Demo of timeout")
	@Test
	void testTimeOut() {

		assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(5000);

			System.out.println("I got here");
		});
	}

	@Disabled("Demo of timeout")
	@Test
	void testTimeOutPrempt() {

		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(5000);

			System.out.println("I got here 2342342342342");
		});
	}

	@Test
	void testAssumptionTrue() {

		assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
	}

	@Test
	void testAssumptionTrueAssumptionIsTrue() {

		assumeTrue("GURU".equalsIgnoreCase("GURU"));
	}

	@EnabledOnOs(OS.MAC)
	@Test
	void testMeOnMacOS() {
	}

	@EnabledOnOs(OS.WINDOWS)
	@Test
	void testMeOnWindows() {
	}

	@EnabledOnJre(JRE.JAVA_8)
	@Test
	void testMeOnJava8() {
	}

	@EnabledOnJre(JRE.JAVA_11)
	@Test
	void testMeOnJava11() {
	}

	@EnabledIfEnvironmentVariable(named = "USERNAME", matches = "ocmarchi")
	@Test
	void testIfUserOcmarchi() {
	}

	@EnabledIfEnvironmentVariable(named = "USERNAME", matches = "fred")
	@Test
	void testIfUserFred() {
	}
}
