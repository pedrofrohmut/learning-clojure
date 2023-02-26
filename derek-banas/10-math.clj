;; Namespace - ns
(ns tutorial.core
    (:gen-class))

(defn math-stuff []
    ;; Basic
    (println "Addition       " (+ 1 2 3))
    (println "Subtraction    " (- 5 2))
    (println "Multiplication " (* 333 2))
    (println "Devision       " (/ 100 5))
    (println "Reminder       " (mod 13 5))
    ;; Inc Dec
    (println "Increment      " (inc 5))
    (println "Decrement      " (dec 5))
    ;; Math fn
    (println "Absolute       " (Math/abs -42))
    (println "Cube Root      " (Math/cbrt 8))
    (println "Sqr Root       " (Math/sqrt 16))
    (println "Round Up       " (Math/ceil 1.34))
    (println "Round Down     " (Math/floor 3.141592))
    (println "Exponentiation " (Math/exp 1))
    (println "Hypotenuse     " (Math/hypot 3 4))
    (println "Logarithm      " (Math/log 2.71828))
    (println "Base 10 Log    " (Math/log10 1000000))
    (println "To the Power of" (Math/pow 3 2))
    (println "Max            " (Math/max 42 666))
    (println "Min            " (Math/min 42 666))
    (println "PI             " (Math/PI))
    ;; Rand [0:20[
    (println "RandInt 0 to 20" (rand-int 20))
    ;; Operation in a collection
    (println "Perform reduce in a collection" (reduce + [1 2 3]))
    )

;; defn - define function
(defn main []
    (math-stuff)
    ) ;; main

(main)
