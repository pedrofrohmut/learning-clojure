;; Namespace - ns
(ns tutorial.core
    (:gen-class))

;; defn - define function
(defn main []
    (println
        (list "Dog" 1 3.14159265 true))
    (println
        (first
            (list 1 2 3 4)))
    (println
        (rest
            (list 1 2 3 4)))
    (println
        (nth
            (list 1 2 3 4)
            2))
    (println
        (list* 1 2 [3 4])) ;; Concat
    ) ;; main

(main)
