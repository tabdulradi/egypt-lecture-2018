# Json Serialiser


## Installation
This project is written in Scala. It needs SBT to build and run. 
Please follow [SBT installation guide](https://www.scala-sbt.org/1.x/docs/Setup.html).

## Testing
```
sbt test
```
You should see output that ends with:
```
[info] Run completed in 331 milliseconds.
[info] Total number of tests run: 13
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 4, failed 9, canceled 0, ignored 0, pending 0
[info] *** 9 TESTS FAILED ***
[error] Failed tests:
[error] 	com.abdulradi.json.JsonSerialisationTest
[error] (Test / test) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 2 s, completed 11-Nov-2018 19:53:17
```
 
Currently the test-cases don't pass. 
You have exactly 3 occurrences of `???` in lines 20, 22, and 24 at file `src/main/scala/com/abdulradi/json/Json.scala`.
They are the reason you are getting "scala.NotImplementedError: an implementation is missing" error when running the tests.

## Solving the quiz 
Your task is to replace all 3 `???` with the suitable implementation that satisfies the test cases.
All the test cases are written in file `src/test/scala/com/abdulradi/json/JsonSerialisationTest.scala`.

### Tip
Use an IDE to help you with syntax and auto-completion. 
I recommend using [IntelliJ](https://www.jetbrains.com/idea/download/)

### How to know the quiz is solved correctly
When you run the tests, you get output that looks like:
```
[info] JsonSerialisationTest:
[info] - Serialise Null
[info] - Serialise String
[info] - Serialise natural numbers
[info] - Serialise flaoting points
[info] - Serialise true
[info] - Serialise false
[info] - Serialise Array of strings
[info] - Serialise Array of numbers
[info] - Serialise Array of mixed json
[info] - Serialise Object of strings
[info] - Serialise Object of numbers
[info] - Serialise Object of mixed json
[info] - Serialise Object of arrays of objects of array of ...
[info] Run completed in 169 milliseconds.
[info] Total number of tests run: 13
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 13, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 2 s, completed 11-Nov-2018 19:29:33
```

Note the word `[success]` at the end.
