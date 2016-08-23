package utils

import scala.io.Source

trait FileReader {
  def file(filePath: String) = Source.fromInputStream(getClass.getResourceAsStream(filePath)).mkString
}
