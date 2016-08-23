name := "CassandraQuillPoc"

version := "1.0"

scalaVersion := "2.11.8"

val akkaVersion = "2.4.9-RC2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion
)

resolvers ++= Seq(
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  Resolver.url("Typesafe Ivy releases", url("https://repo.typesafe.com/typesafe/ivy-releases"))(Resolver.ivyStylePatterns)
)

// DEPENDENCIES FOR COMMON UTILS
val json4sVersion = "3.4.0"

libraryDependencies ++= Seq(
  // Test Dependencies
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  // Cassandra Dependencies
  "com.google.guava" % "guava" % "18.0" % "test",
  "com.datastax.cassandra" % "cassandra-driver-core" % "3.0.0",
  "org.cassandraunit" % "cassandra-unit" % "3.0.0.1" % "test",
  "io.getquill" %% "quill-cassandra" % "0.9.0"
)

fork in run := false