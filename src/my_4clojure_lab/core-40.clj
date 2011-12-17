(println "--------- END 40  ----------" (java.util.Date.))
(ns ^{:doc "http://www.4clojure.com/problem/40#prob-title"}
  my-4clojure-lab.core-40
  (:use clojure.repl)
  (:use clojure.java.javadoc)
  (:use [midje.sweet]))

(println "--------- BEGIN 40  ----------" (java.util.Date.))

;; Write a function which separates the items of a sequence by an arbitrary value.

(defn my-interpose "Interpose an element after each element of a prexistant sequence"
  [e s]
  (butlast (for [x s, y [x e]] y)))

(fact
  (my-interpose 0 [1 2 3]) => [1 0 2 0 3]
  (apply str (my-interpose ", " ["one" "two" "three"])) => "one, two, three"
  (my-interpose :z [:a :b :c :d]) => [:a :z :b :z :c :z :d])

(println "--------- END 40  ----------" (java.util.Date.))
