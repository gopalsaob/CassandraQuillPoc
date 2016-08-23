package persistence

import org.cassandraunit.dataset.cql.ClassPathCQLDataSet
import org.cassandraunit.utils.EmbeddedCassandraServerHelper
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures

import scala.concurrent.duration._
import wrapper.CassandraCqlUnitWrapper

/**
  * Common trait used to define specifications related to Cassandra access.
  */
trait CassandraSpec extends BeforeAndAfterAll with ScalaFutures {
  this: Suite ⇒

  implicit val patienceTimeout = org.scalatest.concurrent.PatienceConfiguration.Timeout(10.seconds)

  /**
    * Initialize the database by computing a schema from the table definition.
    */
  def initializeDatabase = {
    EmbeddedCassandraServerHelper.startEmbeddedCassandra("test_server.yaml", 60.seconds.toMillis)
    val cassandraCQLUnit = new CassandraCqlUnitWrapper(new ClassPathCQLDataSet("integration/db-scripts/ddl_v2.cql",false, false))
    cassandraCQLUnit.load()
    cassandraCQLUnit
  }

  override protected def afterAll(): Unit = {
    EmbeddedCassandraServerHelper.cleanEmbeddedCassandra()
    super.afterAll()
  }

}