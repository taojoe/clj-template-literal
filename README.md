# clj-template-literal
clojure template literals as javascript. the idea is from [MDN Template literals ](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Template_literals)

![](https://clojars.org/com.github.taojoe/clj-template-literal/latest-version.svg)
# Usage

Template literals is the best way to do safe sql, it's more than that. the best usage please see the a similar library in javascript [SQL Template Strings](https://github.com/felixfbecker/node-sql-template-strings)

Please see the test file to know how to do it.

```clojure

(let [name "joe"] 
  (= (<<< str "hello from ~{name}, do math ~(+ 1 2)") "hello from joe, do math 3"))

(= (<<< sql "select * from user where name=~{name}") ["select * from user where name= ? " name])


```
