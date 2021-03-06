(ns ^{:doc "http://www.4clojure.com/problem/99#prob-title"}
  clojure4-lab.99.core99
  (:use clojure.repl)
  (:use clojure.java.javadoc)
  (:use [midje.sweet]))



;; Write a function which multiplies two numbers and returns the result as a sequence of its digits.

(defn pdt "Function which multiplies two numbers and returns the result as a sequence of its digits."
  [& xv]
  (map (comp read-string str) (str (apply * xv))))

(fact
  (pdt 1 1) => [1]
  (pdt 99 9) => [8 9 1]
  (pdt 999 99) => [9 8 9 0 1])
