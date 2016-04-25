
import com.ppiotrow.units.UnitSupport
import org.scalatest._
import org.scalatest.time.Second

/**
 * https://en.wikipedia.org/wiki/Equations_of_motion#Uniform_acceleration
 */
class KinematicsTest extends WordSpecLike with Matchers {
  import UnitSupport._

  "Uniform acceleration" must {

    "calculate distance" in {
      val r0 = 7.as[Meter]
      val v0 = 2.as(Speed)
      val a = 1.as(Acceleration)
      val t = 15.as[Second]

      val distance: Distance = r0 + v0 * t + a * t * t / 2.scalar

      distance shouldBe 149.5.as[Meter]
    }

    "calculate acceleration" in {
      val v0 = 0.as(Speed)
      val v1 = 2.as(Speed)
      val t = 4.as[Second]

      val a: Acceleration = (v1 - v0) / t

      a shouldBe BigDecimal("0.5").as(Acceleration)
    }

    "calculate speed" in {
      val a = 10.as(Acceleration)
      val t = 3.as[Second]

      val v: Speed = a * t

      v shouldBe 30.as(Speed)
    }
    /*
    	A body under F=30N in 5s accelerates from 15m/s to 30m/s. What is it's mass.
     */
    "calculate mass" in {
      val F = 30.as(Newton)
      val v0 = 15.as(Speed)
      val v1 = 30.as(Speed)
      val t = 5.as[Second]

      val m: Mass = F * t / (v1 - v0)

      m shouldBe 10.as[Kilogram]
    }

  }

  "No acceleration" must {
    "calculate speed" in {
      val r = 10.as[Meter]
      val t = 5.as[Second]

      val v: Speed = r / t

      v shouldBe 2.as(Speed)
    }
  }
}
