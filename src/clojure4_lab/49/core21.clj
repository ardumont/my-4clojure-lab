(ns ^{:doc "http://www.4clojure.com/problem/21#prob-title"}
  clojure4-lab.49.core21
  (:use clojure.repl)
  (:use clojure.java.javadoc)
  (:use [midje.sweet]))



;; Write a function which returns the Nth element from a sequence.

(defn mnth "my nth method"
  [s n]
  (first (drop n s)))

(fact
  (mnth '(4 5 6 7) 2) => 6
  (mnth [:a :b :c] 0) => :a
  (mnth [1 2 3 4] 1) => 2
  (mnth '([1 2] [3 4] [5 6]) 2) => [5 6])
