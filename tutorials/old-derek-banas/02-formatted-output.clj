;; Namespace - ns
(ns tutorial.core
    (:gen-class))

;; defn - define function
(defn main []
    (def my-str "My_String")
    (println
        (format "This is a string:      [%s]" my-str))

    (def a-long 15)
    (println
        (format "Leading 5 spaces:      [%5d]" a-long))
    (println
        (format "Leading zeros:         [%04d]" a-long))
    (println
        (format "Left justified:        [%-4d]" a-long))

    (def a-double 3.14159265)
    (println
        (format "3 decimals:            [%.3f]" a-double)))

(main)
