(ns ^{:doc "http://www.4clojure.com/problem/171#prob-title"}
  my-4clojure-lab.199.core171
  (:use [clojure.java.javadoc]
        [midje.sweet])
  (:require [clojure.tools.trace :as t]))

;; Write a function that takes a sequence of integers and returns a sequence of "intervals".
;; Each interval is a a vector of two integers, start and end, such that all integers between start and end (inclusive)
;; are contained in the input sequence.

(defn intervals
  [v]
  (let [[f & t] (sort v)]
    (if f
      (->> t
           (reduce
            (fn [[[a b] & r :as l] e]
              (cond
               (= b e)       l
               (= (+ 1 b) e) (cons [a e] r)
               :else         (cons [e e] l)))
            `([~f ~f]))
           reverse
           distinct)
      v)))

(fact (intervals [1 2 3]) => [[1 3]])

(fact (intervals [10 9 8 1 2 3]) => [[1 3] [8 10]])

(fact (intervals [1 1 1 1 1 1 1]) => [[1 1]])

(fact (intervals []) => [])

(fact (intervals [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11]) => [[1 4] [6 6] [9 11] [13 17] [19 19]])
