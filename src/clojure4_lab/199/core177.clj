(ns clojure4-lab.199.core177
  "http://www.4clojure.com/problem/177#prob-title"
  (:use [clojure.pprint :only [pp pprint]]
        [clojure.java.javadoc]
        [midje.sweet]))

;; Balancing Brackets

;; Difficulty:	Medium
;; Topics:	parsing

;; When parsing a snippet of code it's often a good idea to do a sanity check to see if all the brackets match up.
;; Write a function that takes in a string and returns truthy if all square [ ] round ( ) and curly { } brackets are properly paired and legally nested, or returns falsey otherwise.

(defn bb [s]
  (let [ms {\) \( \} \{ \] \[}]
    (loop [[h & t :as l]  s
           [c & r :as st] []]
      (if l
        (cond (#{\( \{ \[} h) (recur t (cons h st))
              (#{\) \} \]} h) (if (->> h (get ms) (not= c)) nil (recur t r))
              :else           (recur t st))
        (empty? st)))))

(fact (bb "This string has no brackets.") => truthy)

(fact (bb "class Test {

      public static void main(String[] args) {

        System.out.println(\"Hello world.\");

      }

    }") => truthy)

(fact (bb "(start, end]") => falsey)

(fact (bb "())") => falsey)

(fact (bb "[ { ] } ") => falsey)

(fact (bb "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))") => truthy)

(fact (bb "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))") => falsey)

(fact (bb "[") => falsey)
