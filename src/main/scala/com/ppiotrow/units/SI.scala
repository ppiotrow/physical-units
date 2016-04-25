package com.ppiotrow.units

import shapeless.{ HNil, :: }

private[units] trait SI {
  trait Ampere extends BasicUnit
  trait Kelvin extends BasicUnit
  trait Meter extends BasicUnit
  trait Kilogram extends BasicUnit
  trait Second extends BasicUnit

  type Current = Units[Ampere :: HNil, HNil]
  type Temperature = Units[Kelvin :: HNil, HNil]
  type Distance = Units[Meter :: HNil, HNil]
  type Mass = Units[Kilogram :: HNil, HNil]
  type Time = Units[Second :: HNil, HNil]
}

private[units] trait SIDerivedUnits extends SI {

  type Speed = Units[Meter :: HNil, Second :: HNil]
  object Speed extends ComplexUnit[Meter :: HNil, Second :: HNil]

  type Acceleration = Units[Meter :: HNil, Second :: Second :: HNil]
  object Acceleration extends ComplexUnit[Meter :: HNil, Second :: Second :: HNil]

  type Newton = Units[Kilogram :: Meter :: HNil, Second :: Second :: HNil]
  object Newton extends ComplexUnit[Kilogram :: Meter :: HNil, Second :: Second :: HNil]

  type Joule = Units[Kilogram :: Meter :: Meter :: HNil, Second :: Second :: HNil]
  object Joule extends ComplexUnit[Kilogram :: Meter :: Meter :: HNil, Second :: Second :: HNil]

  type Watt = Units[Kilogram :: Meter :: Meter :: HNil, Second :: Second :: Second :: HNil]
  object Watt extends ComplexUnit[Kilogram :: Meter :: Meter :: HNil, Second :: Second :: Second :: HNil]
}

