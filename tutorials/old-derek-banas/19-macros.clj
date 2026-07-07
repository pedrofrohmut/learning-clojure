;; Namespace - ns
(ns tutorial.core
  (:require [clojure.string :as str])
  (:gen-class))

(use 'clojure.java.io)

(defmacro discount
  ([cond dis1 dis2] (list `if cond dis1 dis2)))

(defmacro regular-math [calc]
  (list (second calc) (first calc) (nth calc 2)))

(defmacro do-more [cond & body]
  (list `if cond (cons 'do body)))

(defmacro do-more-2 [cond & body]
  `(if ~cond (do ~@body)))

;; defn - define function
;; & args - list of args - & means variable parameter
(defn main [& args]
  (def age 25)

  (println "Discount:"
           (discount (> age 65) "10% off" "Full price"))

  (println "Regular Math (2 + 5):"
           (regular-math (2 + 5)))

  (println "Do More:"
           (do-more (< 1 5) "Hello" "Hello Again"))

  (println "Do More 2:"
           (do-more-2 (< 1 5) "Yollo" "Not Yollo"))

  (println "Test"
           (if (< 3 15) "True" "False"))
  ) ;; main

(main)
