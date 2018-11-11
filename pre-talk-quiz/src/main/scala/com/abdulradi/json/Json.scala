package com.abdulradi.json

/**
  * Data structures that represents JSON in memory (http://json.org/)
  */
sealed trait Json
case object JsonNull extends Json
final case class JsonString(value: String) extends Json
final case class JsonNumber(value: BigDecimal) extends Json
final case class JsonBoolean(value: Boolean) extends Json
final case class JsonArray(values: Seq[Json]) extends Json
final case class JsonObject(values: Seq[(String, Json)]) extends Json

object JsonSerialisation {
  /**
    * Converts Json instance to it's string representation
    */
  def serialise(json: Json): String = json match {
    case JsonNull => "null"
    case JsonString(value) => ???
    case JsonNumber(value) => value.toString
    case JsonBoolean(value) => ???
    case JsonArray(values) => values.map(v => serialise(v)).mkString("[", ",", "]")
    case JsonObject(values) => ???
  }
}