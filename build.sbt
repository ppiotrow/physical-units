
name := """physical-units"""

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "com.chuusai" %% "shapeless" % "2.3.0")

scalariformSettings
