;; Namespace - ns
(ns tutorial.core
  (:require [clojure.string :as str])
  (:gen-class))

(use 'clojure.java.io)

(defn struct-map-ex []
  (defstruct Customer :Name :Phone)
  (def cust1 (struct Customer "Doug" 1234567))
  (def cust2 (struct-map Customer :Name "Sally" :Phone 5551212))
  (println "Customer1:" cust1)
  (println "Customer2 Name:" (:Name cust2)))

;; defn - define function
;; & args - list of args - & means variable parameter
(defn main [& args]
  (struct-map-ex)
  ) ;; main

(main)
