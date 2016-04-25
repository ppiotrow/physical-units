
import com.ppiotrow.units.UnitSupport
import org.scalatest._

/**
 * https://en.wikipedia.org/wiki/Trajectory_of_a_projectile
 */
class ProjectileMotionTest extends WordSpecLike with Matchers {
  import UnitSupport._
  import com.ppiotrow.units.Constants._

  "Projectile motion" must {

    "calculate distance" in {
      val v0 = 10.as(Speed)
      val angle: Int = 30

      val distance: Distance = v0 * v0 * Math.sin(Math.toRadians(2 * angle)).scalar / G_EARTH

      distance.value.doubleValue() shouldBe 8.83 +- 0.01
    }

    "calculate flight time" in {
      val v0 = 10.as(Speed)

      val t: Time = Math.sqrt(2).scalar * v0 / G_EARTH

      t.value.doubleValue shouldBe 1.44 +- 0.01
    }
  }
}
