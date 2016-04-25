package com.ppiotrow.units

import shapeless.{ HList, HNil, ::, ops }
import ops.hlist.{ Prepend, Diff }

import scala.language.implicitConversions

object UnitSupport extends UnitConversions with SIDerivedUnits

trait BasicUnit
trait ComplexUnit[N, D]

case class Units[Nominator <: HList, Denominator <: HList](value: BigDecimal) {
  def +(other: Units[Nominator, Denominator]) = Units[Nominator, Denominator](this.value + other.value)

  def -(other: Units[Nominator, Denominator]) = Units[Nominator, Denominator](this.value - other.value)

  def *[N2 <: HList, D2 <: HList, SN <: HList, SD <: HList, CN <: HList, CD <: HList](other: Units[N2, D2])(
    implicit sumNominator: Prepend.Aux[Nominator, N2, SN],
    sumDenominator: Prepend.Aux[Denominator, D2, SD],
    cn: Diff.Aux[SN, SD, CN],
    cd: Diff.Aux[SD, SN, CD]): Units[CN, CD] = Units[CN, CD](this.value * other.value)

  def /[N2 <: HList, D2 <: HList, SN <: HList, SD <: HList, CN <: HList, CD <: HList](other: Units[N2, D2])(
    implicit sumNominator: Prepend.Aux[Nominator, D2, SN],
    sumDenominator: Prepend.Aux[Denominator, N2, SD],
    cn: Diff.Aux[SN, SD, CN],
    cd: Diff.Aux[SD, SN, CD]): Units[CN, CD] = Units[CN, CD](this.value / other.value)

}

private [units] class Unitable(val i: BigDecimal) extends AnyVal {
  def as[U <: BasicUnit] = new Units[U :: HNil, HNil](i)
  def as[N <: HList, D <: HList](b: ComplexUnit[N, D]) = new Units[N, D](i)
  def scalar = new Units[HNil, HNil](i)
}

private[units] trait UnitConversions {

  implicit def toUnit(i: BigDecimal): Unitable = new Unitable(i)
  implicit def toUnit(i: Int): Unitable = new Unitable(i)
  implicit def toUnit(i: Long): Unitable = new Unitable(i)
  implicit def toUnit(i: Double): Unitable = new Unitable(i)
}
