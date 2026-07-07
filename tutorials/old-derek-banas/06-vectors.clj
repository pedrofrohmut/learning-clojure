;; Namespace - ns
(ns tutorial.core
    (:gen-class))

;; defn - define function
(defn main []
    (def my-vec (vector 32 45 67 89))
    (println
        "Print                "
        my-vec)
    (println
        "How many elems       "
        (count my-vec))
    ;; Get and Nth are the same for Vectors
    (println
        "Get value of index 2 "
        (get my-vec 2)
        (nth my-vec 2))
    (println
        "Add 666 to end       "
        (conj my-vec 666))
    (println
        "Remove last elem     "
        (pop my-vec))
    ;; Peek and Last are the same for Vectors (peek more efficient)
    (println
        "Get last elem        "
        (peek my-vec)
        (last my-vec))
    (println
        "Seq                  "
        (seq my-vec))
    (println
        "Rseq (reverse)       "
        (rseq my-vec))
    (println
        "Is a vector?         "
        (vector? my-vec))
    (println
        "Subvec [0:2[         "
        (subvec my-vec 0 2))
    ) ;; main

(main)
