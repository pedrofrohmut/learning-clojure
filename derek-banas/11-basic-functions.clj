;; Namespace - ns
(ns tutorial.core
  (:gen-class))

(defn say-hello [name]
  "Receive a name with 1 parameter and reponds"
  (println "Hello again" name)) ;; say-hello

(defn get-sum [x y]
  (+ x y))

(defn get-sum-more [x y z]
  (+ x y z))

(defn hello [name]
  (str "Hello, " name "!"))

(defn hello-all [& names]
  (map hello names))

;; defn - define function
(defn main []
  (say-hello "Bob")
  (println "31 + 11 = " (get-sum 31 11))
  (println "100 + 206 + 360 = " (get-sum-more 100 206 360))
  (println (hello "Programmer"))
  (println (hello-all "Doug" "Bob" "John" "Ana" "Paul"))
  ) ;; main

(main)
