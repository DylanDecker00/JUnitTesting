import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.promineo.TestDemo;

class TestDemoJUnitTest {

    private TestDemo testDemo;

    @BeforeEach
    void setUp() throws Exception {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
    public void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertEquals(expected, testDemo.addPositive(a, b));
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
            arguments(2, 4, 6, false),
            arguments(2, -4, 0, true),
            arguments(0, 4, 0, true),
            arguments(-2, -4, 0, true)
            // Add more argument sets as needed for thorough testing
        );
    }

    //@Test
    public void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
        // Add as many assertions as you want
        // Example:
        assertThat(testDemo.addPositive(10, 20)).isEqualTo(30);
        assertThat(testDemo.addPositive(7, 3)).isEqualTo(10);
    }
    
    //@Test
	public void assertThatNumberSquaredIsCorrect() {
    TestDemo mockDemo = spy(testDemo);

    // Make the mock return 5 when getRandomInt is called
    doReturn(5).when(mockDemo).getRandomInt();

    // Call the method randomNumberSquared on the mocked object
    int fiveSquared = mockDemo.randomNumberSquared();

    // Test that the value is indeed 5 squared
    assertThat(fiveSquared).isEqualTo(25);
}
}
