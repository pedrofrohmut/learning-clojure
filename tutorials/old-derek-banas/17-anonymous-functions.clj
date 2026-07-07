;; Namespace - ns
(ns tutorial.core
  (:require [clojure.string :as str])
  (:gen-class))

(use 'clojure.java.io)

;; Clojure - return a custom function
(defn custom-multiplier [mult-by]
  #(* %1 mult-by))

;; Define function using the Clojure
(def mult-by-3 (custom-multiplier 3))

;; defn - define function
;; & args - list of args - & means variable parameter
(defn main [& args]
  ;; Squares
  (println "Squares" (map (fn [x] (* x x)) (range 1 10)))
  ;; Triples
  (println "Triples" (map #(* %1 3) (range 1 10)))
  ;; Using clojure function
  (println "Mult By 3" (mult-by-3 111))
  ) ;; main

(main)
