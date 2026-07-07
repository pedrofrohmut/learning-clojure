;; Namespace - ns
(ns tutorial.core
  (:gen-class))

;; Equals     (= 4 5)
;; Not Equals (not= 4 5)
;; And        (and true false)
;; Or         (or true false)
;; Not        (not true)

(defn can-vote [age]
  (if (>= age 18) "You can vote" "You can't vote"))

(defn can-do-more [age]
  (if (< age 16)
    (do
      (print "You can't vote")
      (println " and You can't drive"))
    (if (< age 18)
      (do
        (print "You can drive")
        (println " and You can't vote"))
      (do
        (print "You can vote")
        (println " and You can drive")))))

(defn when-ex [test]
  (when test
    (println "test is true")))

(defn what-grade [age]
  (cond
    (< age 5)
      (println "Preeschool")
    (= age 5)
      (println "Kindergarden")
    (and (> age 5) (<= age 18))
      (println
        (format "Go to grade %d" (- age 5)))
    :else
      (println "Go to college")))

;; defn - define function
(defn main []
  (println "Can vote with 12? " (can-vote 12))
  (println "Can vote with 42? " (can-vote 42))

  (print "Age 12? ") (can-do-more 12)
  (print "Age 17? ") (can-do-more 17)
  (print "Age 22? ") (can-do-more 22)

  (print "When example: ") (when-ex true)

  (print "What grade 3? ") (what-grade 3)
  (print "What grade 5? ") (what-grade 5)
  (print "What grade 12? ") (what-grade 12)
  (print "What grade 19? ") (what-grade 19)
  ) ;; main

(main)
