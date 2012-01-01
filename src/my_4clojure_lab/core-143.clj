(ns ^{:doc "http://www.4clojure.com/problem/143#prob-title"}
  my-4clojure-lab.core-143
  (:use clojure.repl)
  (:use clojure.java.javadoc)
  (:use [midje.sweet])
  (:use [clojure.pprint :only [pprint]]))

(println "--------- BEGIN 143  ----------" (java.util.Date.))

;; Create a function that computes the dot product of two sequences.
;; You may assume that the vectors will have the same length.

(defn dot "Dot product"
  [s l]
  (reduce + (map * s l)))

(fact
  (dot [0 1 0] [1 0 0]) => 0
  (dot [1 1 1] [1 1 1]) => 3
  (dot [1 2 3] [4 5 6]) => 32
  (dot [2 5 6] [100 10 1]) => 256)

(println "--------- END 143  ----------" (java.util.Date.))
