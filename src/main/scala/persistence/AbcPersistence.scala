package persistence

import com.datastax.driver.core.Session
import dto.A
import io.getquill._

class AbcPersistence(private[persistence] val session: Session) {
  val ctx = new CassandraSyncContext[SnakeCase]("ctx")

  def foo(id: String) = {
    import ctx._

    val q = quote {
      query[A].filter(_.id == lift(id))
    }
    ctx.run(q)

  }
}



