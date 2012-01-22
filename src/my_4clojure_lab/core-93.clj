(ns ^{:doc "http://www.4clojure.com/problem/93#prob-title"}
  my-4clojure-lab.core-93
  (:use clojure.repl)
  (:use clojure.java.javadoc)
  (:use [midje.sweet])
  (:use [clojure.pprint :only [pprint]]))

(println "--------- BEGIN 93  ----------" (java.util.Date.))

;; Write a function which flattens any nested combination of sequential things (lists, vectors, etc.), but maintains the
;; lowest level sequential items. The result should be a sequence of sequences with only one level of nesting.

(defn pflatten "Partially flattens a sequence"
  [s]
  (if (some coll? s)
    (mapcat pflatten s)
    [s]))

(fact 
  (pflatten [["Do"] ["Nothing"]]) => [["Do"] ["Nothing"]]
  (pflatten [[[[:a :b]]] [[:c :d]] [:e :f]]) => [[:a :b] [:c :d] [:e :f]]
  (pflatten '((1 2)((3 4)((((5 6))))))) => '((1 2)(3 4)(5 6)))

(println "--------- END 93  ----------" (java.util.Date.))
