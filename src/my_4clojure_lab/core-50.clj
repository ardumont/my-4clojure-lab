(ns ^{:doc "http://www.4clojure.com/problem/50#prob-title"}
  my-4clojure-lab.core-50
  (:use clojure.repl)
  (:use clojure.java.javadoc)
  (:use [midje.sweet])
  (:use [clojure.pprint :only [pprint]]))

(println "--------- BEGIN 50  ----------" (java.util.Date.))

;; Write a function which takes a sequence consisting of items with
;; different types and splits them up into a set of homogeneous
;; sub-sequences. The internal order of each sub-sequence should be
;; maintained, but the sub-sequences themselves can be returned in any
;; order (this is why 'set' is used in the test cases).

(defn split-by-type "Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous sub-sequences"
  [s]
  (let [k (filter keyword? s)
        t (filter string? s)
        c (filter coll? s)
        n (filter number? s)]
    (remove empty? (concat [k] [t] [c] [n]))))

(fact 
  (set (split-by-type [1 :a 2 :b 3 :c])) => #{[1 2 3] [:a :b :c]}
  (set (split-by-type [:a "foo" "bar" :b])) => #{[:a :b] ["foo" "bar"]}
  (set (split-by-type [[1 2] :a [3 4] 5 6 :b])) => #{[[1 2] [3 4]] [:a :b] [5 6]})

(println "--------- END 50  ----------" (java.util.Date.))
