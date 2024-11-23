package com.promineotech;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class TestDemoJUnitTest {
  
  
  private TestDemo testDemo = new TestDemo();
  
  @Test
  void assertThatRandomNumberInRangeIsCorrect() {
    Random mockRandom = mock(Random.class);
    when(mockRandom.nextInt(11)).thenReturn(5);
    
    TestDemo testDemo = new TestDemo() {
      @Override
      public int getRandomNumberInRange(int min, int max) {
        return mockRandom.nextInt((max - min) +1) + min;
      }
    };
    
    assertEquals(15, testDemo.getRandomNumberInRange(10, 20));
  }
  
  @Test
  void assertThatNumberSquaredIsCorrect() {
    TestDemo mockDemo = spy(testDemo);
    doReturn(5).when(mockDemo).getRandomInt();
    int fiveSquared = mockDemo.randomNumberSquared();
    assertThat(fiveSquared).isEqualTo(25);
  }
  
  @Test
  void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
    assertEquals(9, testDemo.addPositive(4, 5));
    assertEquals(90, testDemo.addPositive(40, 50));
    assertEquals(10, testDemo.addPositive(8, 2));
    assertEquals(100, testDemo.addPositive(70, 30));
  }

  @BeforeEach
  void setUp() throws Exception {
    testDemo = new TestDemo();
  }
  
  static Stream<Arguments> argumentsForAddPositive() {
    return Stream.of(
        Arguments.arguments(2, 4, 6, false),
        Arguments.arguments(-2, 4, 0, true),
        Arguments.arguments(3, 5, 8, false),
        Arguments.arguments(0, 4, 0, true)
        );
  }

  @ParameterizedTest
  @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
  void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
    if(!expectException) {
      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected); 
  } else {
    assertThatThrownBy(() -> testDemo.addPositive(a, b))
    .isInstanceOf(IllegalArgumentException.class);
   
  }

}
}
