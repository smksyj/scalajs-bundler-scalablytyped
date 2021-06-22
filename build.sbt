import sbt.`package`
import java.nio.file.Files


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

// copy web/index.html into target path
val copyHtml = taskKey[Unit]("Copy index.html from web to cross-version target directory")
copyHtml := {
    import Path._
    val index = new File("web/index.html")
    // TODO: use bundler build path for targetIndex
    val targetIndex = new File((Compile/crossTarget).value.toString() + "/scalajs-bundler/main/" + index.name)
    println(index.toPath(), targetIndex.toPath())

    Files.copy(index.toPath, targetIndex.toPath)
}
compile in Compile := {
    copyHtml.value
    (compile in Compile).value
}

// use custom webpack config to change output js filename
webpackConfigFile := Some(baseDirectory.value / "custom.webpack.config.js")

// crossTarget := baseDirectory.value / "dist"