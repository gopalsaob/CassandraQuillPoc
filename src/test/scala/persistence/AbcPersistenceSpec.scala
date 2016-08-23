package persistence

import org.scalatest.FreeSpec
import utils.FileReader

class AbcPersistenceSpec extends FreeSpec with CassandraSpec with FileReader {
  val cqlUnit = initializeDatabase

  "Abc persistence should " in {
    cqlUnit.session.execute(file("/integration/db-scripts/dml/insert_sample1.cql"))
    val cut = new AbcPersistence(cqlUnit.session)
    val result = cut.foo("53829346332")
    println("Result = " + result)
  }
}
