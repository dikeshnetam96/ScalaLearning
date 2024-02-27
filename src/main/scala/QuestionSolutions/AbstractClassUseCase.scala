package QuestionSolutions

class AbstractClassUseCase extends App {

  /*  abstract class Calculate[A] {
      def method1(num1 : A, num2 : A) : A
    }
    */

  abstract class TestClass1 {
    def testClass1(): Unit
  }

  abstract class TestClass2 {
    def test2(): Unit
  }

  trait trait1 {
    def test1(): Unit
  }

  trait trait2 {
    def test2(): Unit
  }

  // Below is the code with error, where we are trying to do multiple inheritance
  /*
    class MainClass extends TestClass1 with TestClass2 {
      override def test2(): Unit = ???

      override def test1(): Unit = ???
    }
  */

  // Multiple Inheritance is possible with traits
  class MainClass2 extends TestClass1 with trait1 with trait2 {
    override def testClass1(): Unit = ???
    override def test1(): Unit = ???
    override def test2(): Unit = ???
  }

}
