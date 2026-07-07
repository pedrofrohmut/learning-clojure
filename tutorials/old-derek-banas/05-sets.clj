;; Namespace - ns
(ns tutorial.core
    (:gen-class))

;; defn - define function
(defn main []
    (def my-set (set '(61 72 98 105)))
    (println "Print My Set" my-set)
    (println
        "How many elems in My Set?"
        (count my-set))
    (println
        "Returns a 'seq' of My Set"
        (seq my-set))
    (println
        "Are #{61 72 98 105} and MySet equal?"
        (= my-set #{61 72 98 105}))
    (println
        "Add elem 666 to My Set"
        (conj my-set 666))
    (println
        "My Set with 98 removed"
        (disj my-set 98))
    (println
        "Does My Set Contains 92?"
        (contains? my-set 92))
    (println
        "Get 72 of or nil"
        (get
            (set '(61 61 72 98))
            72))
    ) ;; main

(main)
