(ns ^{:doc "http://www.4clojure.com/problem/131#prob-title"}
  clojure4-lab.149.core131
  (:use clojure.repl)
  (:use clojure.java.javadoc)
  (:use [midje.sweet]))

;; Given a variable number of sets of integers, create a function which returns true iff all of the sets have a
;; non-empty subset with an equivalent summation.

(unfinished )

(defn subset "Compute all the subsets of a set except the empty one."
  [s]
  (set
   (remove #{#{}}
           (reduce
            (fn [p e]
              (into p (map #(conj % e) p)))
            #{#{}} s))))

(fact "subset"
  (subset #{1 2 3}) => #{#{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})

(defn equi-sum?
  "Given a variable number of sets of integers, create a function which returns true iff all of the sets
  have non-empty subset with an equivalent summation."
  [& s]
  (->> (map (fn [v] (set (map #(apply + %) (subset v)))) s)
       (apply clojure.set/intersection)
       (not= #{})))

(fact "equi-sum?"
  (equi-sum? :s1 :s2 :s3) => true
  (provided
    (subset :s1) => #{#{0 1} #{0 1 2}}
    (subset :s2) => #{#{1 2}}
    (subset :s3) => #{#{3} #{4 5 6} #{7}}))

(fact "equi-sum?"
  (equi-sum? :s1 :s2 :s3) => false
  (provided
    (subset :s1) => #{#{2}}
    (subset :s2) => #{#{1}}
    (subset :s3) => #{#{3}}))

(fact "OK"
  (equi-sum? #{-1 1 99}
             #{-2 2 888}
             #{-3 3 7777}) => true      ; ex. all sets have a subset which sums to zero
  (equi-sum? #{1}) => true
  (equi-sum? #{1 3 5}
             #{9 11 4}
             #{-3 12 3}
             #{-3 4 -2 10}) => true
  (equi-sum? #{1 3 5 7}
             #{2 4 6 8}) => true
  (equi-sum? #{-1 3 -5 7 -9 11 -13 15}
             #{1 -3 5 -7 9 -11 13 -15}
             #{1 -1 2 -2 4 -4 8 -8}) => true
  (equi-sum? #{-10 9 -8 7 -6 5 -4 3 -2 1}
             #{10 -9 8 -7 6 -5 4 -3 2 -1}) => true
  (equi-sum? #{1}
             #{2}
             #{3}
             #{4}) => false
  (equi-sum? #{1 -3 51 9}
             #{0}
             #{9 2 81 33}) => false
  (equi-sum? #{-1 -2 -3 -4 -5 -6}
             #{1 2 3 4 5 6 7 8 9})) => false
