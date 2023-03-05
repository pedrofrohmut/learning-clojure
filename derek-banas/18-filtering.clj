;; Namespace - ns
(ns tutorial.core
  (:require [clojure.string :as str])
  (:gen-class))

(use 'clojure.java.io)

;; defn - define function
;; & args - list of args - & means variable parameter
(defn main [& args]
  (def my-list [-4 -3 -2 -1 0 1 2 3 4])
  (println "Original:              " my-list)
  (println "Take 2:                " (take 2 my-list))
  (println "Drop 1:                " (drop 1 my-list))
  (println "Take while negative:   " (take-while neg? my-list))
  (println "Drop while negative:   " (drop-while neg? my-list))
  (println "Filter greater than 2: " (filter #(> % 2) my-list))
  ) ;; main

(main)
