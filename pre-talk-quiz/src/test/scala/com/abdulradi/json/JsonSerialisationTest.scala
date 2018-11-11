package com.abdulradi.json

import org.scalatest.{FunSuite, MustMatchers}

class JsonSerialisationTest extends FunSuite with MustMatchers {
  import JsonSerialisation._

  test("Serialise Null") {
    val json = JsonNull
    serialise(json) mustBe "null"
  }

  test("Serialise String") {
    val json = JsonString("hello world")
    serialise(json) mustBe "\"hello world\""
  }

  test("Serialise natural numbers") {
    val json = JsonNumber(42)
    serialise(json) mustBe "42"
  }

  test("Serialise flaoting points") {
    val json = JsonNumber(3.14)
    serialise(json) mustBe "3.14"
  }

  test("Serialise true") {
    val json = JsonBoolean(true)
    serialise(json) mustBe "true"
  }

  test("Serialise false") {
    val json = JsonBoolean(false)
    serialise(json) mustBe "false"
  }

  test("Serialise Array of strings") {
    val json = JsonArray(Seq(
      JsonString("foo"),
      JsonString("bar"),
      JsonString("baz")
    ))
    serialise(json) mustBe "[\"foo\",\"bar\",\"baz\"]"
  }

  test("Serialise Array of numbers") {
    val json = JsonArray(Seq(
      JsonNumber(1),
      JsonNumber(2),
      JsonNumber(3.14)
    ))
    serialise(json) mustBe "[1,2,3.14]"
  }

  test("Serialise Array of mixed json") {
    val json = JsonArray(Seq(
      JsonString("foo"),
      JsonBoolean(false),
      JsonNull,
      JsonNumber(3.14)
    ))
    serialise(json) mustBe "[\"foo\",false,null,3.14]"
  }

  test("Serialise Object of strings") {
    val json = JsonObject(Seq(
      "a" -> JsonString("foo"),
      "b" -> JsonString("bar"),
      "c" -> JsonString("baz")
    ))
    serialise(json) mustBe "{\"a\":\"foo\",\"b\":\"bar\",\"c\":\"baz\"}"
  }

  test("Serialise Object of numbers") {
    val json = JsonObject(Seq(
      "x" -> JsonNumber(1),
      "y" -> JsonNumber(2),
      "z" -> JsonNumber(3.14)
    ))
    serialise(json) mustBe "{\"x\":1,\"y\":2,\"z\":3.14}"
  }

  test("Serialise Object of mixed json") {
    val json = JsonObject(Seq(
      "a" -> JsonString("foo"),
      "b" -> JsonBoolean(false),
      "c" -> JsonNull,
      "d" -> JsonNumber(3.14)
    ))
    serialise(json) mustBe "{\"a\":\"foo\",\"b\":false,\"c\":null,\"d\":3.14}"
  }

  test("Serialise Object of arrays of objects of array of ...") {
    val json = JsonObject(Seq(
      "a" -> JsonArray(Seq(
        JsonObject(Seq(
          "x" -> JsonArray(Seq(JsonString("foo"), JsonString("bar"), JsonString("baz"))),
          "y" -> JsonArray(Seq(JsonBoolean(false), JsonBoolean(true))),
          "z" -> JsonArray(Seq(JsonNull, JsonNull, JsonNull))
        )),
        JsonObject(Seq(
          "foo" -> JsonArray(Seq(JsonString("foo"), JsonNumber(42))),
          "bar" -> JsonArray(Seq(JsonBoolean(false), JsonNull))
        ))
      )),
      "b" -> JsonArray(Seq.empty),
      "c" -> JsonArray(Seq(JsonArray(Seq(JsonArray(Seq(JsonNull)), JsonArray(Seq.empty)))))
    ))
    serialise(json) mustBe
      "{\"a\":[" +
        "{" +
          "\"x\":[\"foo\",\"bar\",\"baz\"]," +
          "\"y\":[false,true]," +
          "\"z\":[null,null,null]" +
        "},{" +
          "\"foo\":[\"foo\",42]," +
          "\"bar\":[false,null]" +
        "}]," +
      "\"b\":[]," +
      "\"c\":[[[null],[]]]}"
  }
}
