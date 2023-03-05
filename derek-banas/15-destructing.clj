;; Namespace - ns
(ns tutorial.core
  (:require [clojure.string :as str])
  (:gen-class))

(use 'clojure.java.io)

(defn destruct []
  (def vec-vals [1 2 3 4])
  (let [[one two & the-rest] vec-vals]
    (println "One:" one ", Two:" two ", The Rest:" the-rest)))

;; defn - define function
;; & args - list of args - & means variable parameter
(defn main [& args]
  (destruct)
  ) ;; main

(main)
