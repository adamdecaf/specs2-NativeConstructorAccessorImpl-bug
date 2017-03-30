val jacksonVersion         = "2.8.7"  // https://github.com/FasterXML/jackson-module-scala/releases
val specs2Version          = "3.8.8"  // https://github.com/etorreborre/specs2/releases

name := "specs2-native-constructor-bug"

scalaVersion := "2.11.8"
crossScalaVersions ++= Seq("2.10.6", "2.11.8")

resolvers += "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases"

scalacOptions ++= Seq(
  "-deprecation", "-feature", "-language:postfixOps", "-Xlint", "-Xlog-free-terms", "-Xlog-free-types",
  "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-language:postfixOps",
  "-Ywarn-dead-code", "-Ywarn-numeric-widen", "-Ywarn-inaccessible", "-unchecked"
)
libraryDependencies ++= Seq(
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion,
  "org.specs2" %% "specs2-core" % specs2Version % Test
)

scalacOptions in Test ++= Seq(
  "-language:reflectiveCalls"
)

releaseCrossBuild := true
