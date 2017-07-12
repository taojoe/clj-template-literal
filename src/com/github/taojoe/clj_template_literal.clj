(ns com.github.taojoe.clj-template-literal
  (:require [clojure.core.strint :as s]))

(def ^:private interpolate (intern 'clojure.core.strint 'interpolate))

(defmacro <<<
  "Accepts one function and one string; treat the string data and evaluated expressions contained within that argument as an list, then invoke function with list.
  Evaluation is controlled using ~{} and ~() forms as described as https://github.com/clojure/core.incubator/blob/master/src/main/clojure/clojure/core/strint.clj "
  [fn str]
  `(~fn ~@(interpolate str)))
