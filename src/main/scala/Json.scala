package example

import scala.util.Try
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, PropertyNamingStrategy}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

object JsonUtils {
  val mapper = new ObjectMapper() with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
  mapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, true)
  mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)

  def fromJson[T](json: => String)(implicit m : Manifest[T]): Try[T] =
    Try(mapper.readValue[T](json))
}
