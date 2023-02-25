;; Namespace - ns
(ns tutorial.core
    (:require [clojure.string :as string])
    (:gen-class))

;; defn - define function
(defn main []
    (def str1 "This is my 2nd String")
    (println "Is blank?  " (string/blank? str1))
    (println "Includes?  " (string/includes? str1 "my"))
    (println "Index of:  " (string/index-of str1 "my"))
    (println "Split:     " (string/split str1 #" "))
    (println "Join:      " (string/join ", " [1 2 3 4]))
    (println "Replace:   " (string/replace "I am 42" #"42" "24"))
    ;; println auto add spaces between the arguments concatenated
    (println "Trim:     |" (string/trim "   Hello, World !   ") "|")
    (println "Uppercase: " (string/upper-case str1))
    (println "Lowercase: " (string/lower-case str1))
    ) ;; main

(main)
