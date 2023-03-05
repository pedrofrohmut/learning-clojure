;; Namespace - ns
(ns tutorial.core
  (:gen-class))


(defn one-to-n [n]
  (def i (atom 1))
  (while (<= @i n)
    (do
      (println "Counter:" @i)
      (swap! i inc))))


(defn dbl-to-n [n]
  (dotimes [i n]
    (println (* i 2))))


(defn triple-to-n [x y]
  (loop [i x]
    (when (< i y)
      (println (* i 3))
      (recur (+ i 1)))))


(defn print-list [& nums]
  (doseq [x nums]
    (println x)))


;; defn - define function
(defn main []
  (println "\none-to-n 5") (one-to-n 5)
  (println "\ndbl-to-n 5") (dbl-to-n 5)
  (println "\ntriple-to-n 1 5") (triple-to-n 1 5)
  (println "\nprint-list") (print-list 42 43 44 45)
  ) ;; main

(main)
