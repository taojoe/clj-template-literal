(ns com.github.taojoe.clj-template-literal-test
  (:require [clojure.test :refer :all]
            [com.github.taojoe.clj-template-literal :refer :all]))

(defn sql [a & ls]
  (let [p2 (partition 2 ls)
        sql (clojure.string/join (apply concat [a](for [[_ s] p2] [" ? " s])))]
    (cons sql (map first p2))))

(deftest str-test
  (testing "test ~{} and ~() with str"
    (let [name "joe"
          result (<<< str "hello from ~{name}, do math ~(+ 1 2)")
          target "hello from joe, do math 3"]
      (is (= result target)))
    )
  (testing "work with sql"
    (let [name "joe"
          sql0 (<<< sql "select * from user where name=~{name}")
          target ["select * from user where name= ? " name]]
      (prn target)
      (is (= sql0 target)))))

