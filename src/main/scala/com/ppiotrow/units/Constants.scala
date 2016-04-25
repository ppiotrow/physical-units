package com.ppiotrow.units

object Constants {
  import UnitSupport._

  val G_EARTH: Acceleration = BigDecimal("9.80655").as(Acceleration)
  val SPEED_OF_LIGHT = 299792458.as(Speed)
}
