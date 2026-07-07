;; Namespace - ns
(ns tutorial.core
    (:gen-class))

;; defn - define function
(defn main []
    (def my-map (hash-map "name" "John" "age" 42))
    (def my-sorted-map (sorted-map 3 "foo" 1 "bar" 2 "baz"))
    (def my-extra-map (sorted-map 3 "EXTRA" 4 "vaz"))
    (println
        "Print hashed                        "
        my-map)
    (println
        "Print sorted                        "
        my-sorted-map)
    (println
        "Get by keys name and 3              "
        (get my-map "name")
        (get my-sorted-map 3))
    (println
        "Find key/value for age              "
        (find my-map "age"))
    (println
        "Contains 'profession'               "
        (contains? my-map "profession"))
    (println
        "Get keys list                       "
        (keys my-map)
        (keys my-sorted-map))
    (println
        "Get values list                     "
        (vals my-map)
        (vals my-sorted-map))
    (println
        "Is a map                            "
        (map? my-map)
        (map? my-sorted-map)
        (map?
            (list 1 2 3)))
    (println
        "Merged maps                         "
        (merge my-map my-sorted-map))
    (println
        "Merge to override values            "
        (merge my-sorted-map my-extra-map))
    ) ;; main

(main)
