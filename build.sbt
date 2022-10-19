ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.0"

resolvers += "GitHub Package Registry" at "https://maven.pkg.github.com/austral-ingsis/chess-ui"
credentials += Credentials("GitHub Package Registry", "maven.pkg.github.com", sys.env.getOrElse("USERNAME", "RICK"), sys.env.getOrElse("GITHUB_TOKEN", "TE_LA_COMES"))

libraryDependencies += "edu.austral.dissis.chess" % "chess-ui" % "1.0.0"

lazy val root = (project in file("."))
  .settings(
    name := "new_chess"
  )
