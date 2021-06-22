enablePlugins(ScalaJSPlugin)
enablePlugins(ScalablyTypedConverterPlugin)

name := "Scala.js Tutorial"
scalaVersion := "2.13.1" // or any other Scala version >= 2.11.12

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

Compile / npmDependencies ++= Seq(
    "webpack-merge" -> "5.8.0", // used in custom.webpack.config.js
    "react-router-dom" -> "5.1.2",
    "@types/react-router-dom" -> "5.1.2"
)

useYarn := true


// use custom webpack config to change output js filename
webpackConfigFile := Some(baseDirectory.value / "custom.webpack.config.js")

// crossTarget := baseDirectory.value / "dist"