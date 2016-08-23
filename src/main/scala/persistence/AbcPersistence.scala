package persistence

import com.datastax.driver.core.Session
import dto.A
import dto.B
import io.getquill._
import java.util.List

class AbcPersistence(private[persistence] val session: Session) {
  val ctx = new CassandraSyncContext[SnakeCase]("ctx")

  def foo(id: String) = {
    import ctx._
    implicit val bDecoder: Decoder[List[B]] =
      decoder[List[B]] {
        row => index =>
          row.getList(index, classOf[B])
      }
    implicit val bEncoder: Encoder[List[B]] =
      encoder[List[B]](row => (idx, bList) =>
        row.setList(idx, bList, classOf[B]))

    val q = quote {
      query[A].filter(_.id == lift(id))
    }
    ctx.run(q)

  }
}



