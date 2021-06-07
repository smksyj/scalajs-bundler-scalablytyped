enablePlugins(ScalaJSPlugin)
enablePlugins(ScalablyTypedConverterPlugin)

name := "Scala.js Tutorial"
scalaVersion := "2.13.1" // or any other Scala version >= 2.11.12

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

Compile / npmDependencies ++= Seq(
    "react-router-dom" -> "5.1.2",
    "@types/react-router-dom" -> "5.1.2"
)

useYarn := true