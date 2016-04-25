
import com.ppiotrow.units.UnitSupport
import org.scalatest._

class InvalidOperationsTest extends WordSpecLike with Matchers {
  import UnitSupport._

  "Physical units" must {

    "not allow addition of unrelated basic units" in {
      val v = 10.as[Meter]
      val t = 7.as[Second]

      "v + t" shouldNot compile
      "t + v" shouldNot compile
    }

    "not allow addition of unrelated complex units" in {
      val v = 10.as(Speed)
      val a = 7.as(Acceleration)

      "v + a" shouldNot compile
      "a + v" shouldNot compile
    }

    "not allow addition of unrelated complex unit and basic unit" in {
      val t = 10.as[Second]
      val a = 7.as(Acceleration)

      "t + a" shouldNot compile
      "a + t" shouldNot compile
    }

    "type check the result" in {
      val v = 10.as(Speed)
      val t = 2.as[Second]

      "val r: Speed = v * t" shouldNot typeCheck
      "val r: Time = v * t" shouldNot typeCheck
      "val r: Distance = v * t" should compile
    }

  }
}
